package gov.census.esoa.mft.rpc;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import gov.census.esoa.mft.MFTConfiguration;
import org.apache.avro.AvroRemoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;


@Component
@EnableConfigurationProperties
public class MFTFileTransferImpl implements MFTFileTransfer {

    @Autowired
    private MFTConfiguration mftConfiguration;

    private MFTCacheBean mftCacheBean;


    @PostConstruct
    private void initial() {

        try {
            File cacheFile = new File(mftConfiguration.getMftCacheFileLocation());
            if (cacheFile.isFile() && cacheFile.exists() && cacheFile.length() > 0) {

                Gson gson = new Gson();
                JsonReader jsonReader = new JsonReader(new FileReader(cacheFile.getName()));
                mftCacheBean = gson.fromJson(jsonReader, MFTCacheBean.class);
                jsonReader.close();
            } else {
                mftCacheBean = new MFTCacheBean();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @PreDestroy
    private void close() {

        try {
            File cacheFile = new File(mftConfiguration.getMftCacheFileLocation());
            if (cacheFile.isFile() && cacheFile.exists()) {
                cacheFile.delete();
            }
            Gson gson = new Gson();
            String cacheJsonString = gson.toJson(mftCacheBean);
            FileOutputStream fileOutputStream =
              new FileOutputStream(new File(mftConfiguration.getMftCacheFileLocation()));
            fileOutputStream.write(cacheJsonString.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public MFTPushResponse receive(MFTPushRequest mftPushRequest) throws AvroRemoteException {

        System.out.println("Calling receive method");
        String clientId = mftPushRequest.getClientId().toString();
        String fileName = mftPushRequest.getFileName().toString();
        FileTransferProfileKey key = new FileTransferProfileKey();
        key.setClientId(clientId);
        key.setFileName(fileName);
        key.setDirection("GET");
        FileTransferProfileValue value = null;
        if (mftCacheBean.getFileTransferProfileMap().containsKey(key)) {
            value = mftCacheBean.getFileTransferProfileMap().get(key);
        } else {
            value = new FileTransferProfileValue();
            value.setFileSize(mftPushRequest.getTotalSize());
            value.setConsumedSize(0L);
            value.setRemainingSize(mftPushRequest.getTotalSize());
            mftCacheBean.getFileTransferProfileMap().put(key, value);
        }
        value.setOffset(mftPushRequest.getOffset());

        MFTPushResponse response = new MFTPushResponse();
        response.setClientId(clientId);
        response.setFileName(fileName);
        response.setStatusCode(400);


        try {
            RandomAccessFile randomAccessFile =
              new RandomAccessFile(mftConfiguration.getDestinationFolder() + File.separator + fileName, "rw");
            randomAccessFile.seek(mftPushRequest.getOffset());
            byte[] buffer = mftPushRequest.getBody().array();
            randomAccessFile.write(buffer);
            randomAccessFile.close();
            value.setRemainingSize(value.getRemainingSize() - buffer.length);
            value.setConsumedSize(value.getConsumedSize() + buffer.length);
            response.setConsumedLength(value.getConsumedSize());
            response.setStatusCode(201);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            response.setStatusCode(400);

        } catch (IOException e) {
            e.printStackTrace();
            response.setStatusCode(400);
        }

        return response;
    }


    @Override
    public MFTGetResponse get(MFTGetRequest mftGetRequest) throws AvroRemoteException {
        System.out.println("Calling get method");
        String clientId = mftGetRequest.getClientId().toString();
        String fileName = mftGetRequest.getFileName().toString();
        FileTransferProfileKey key = new FileTransferProfileKey();
        key.setClientId(clientId);
        key.setFileName(fileName);
        key.setDirection("POST");
        FileTransferProfileValue value = null;
        if (mftCacheBean.getFileTransferProfileMap().containsKey(key)) {
            value = mftCacheBean.getFileTransferProfileMap().get(key);
        } else {
            value = new FileTransferProfileValue();
            File file = new File(mftConfiguration.getSourceFolder() + File.separator + fileName);
            if (file.isFile() && file.exists()) {
                value.setFileSize(file.length());
                value.setRemainingSize(file.length());
                value.setConsumedSize(0L);
            }
            mftCacheBean.getFileTransferProfileMap().put(key, value);
        }
        value.setOffset(mftGetRequest.getOffset());
        MFTGetResponse mftGetResponse = new MFTGetResponse();
        mftGetResponse.setClientId(clientId);
        mftGetResponse.setFileName(fileName);
        mftGetResponse.setOffset(value.getOffset());
        mftGetResponse.setTotalSize(value.getFileSize());
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile =
              new RandomAccessFile(mftConfiguration.getSourceFolder() + File.separator + fileName, "r");
            randomAccessFile.seek(mftGetRequest.getOffset());

            byte[] buffer = null;
            long remainLength = value.getFileSize() - mftGetRequest.getOffset();
            if (remainLength < 1024 * 4096) {
                buffer = new byte[(int) remainLength];
            } else {
                buffer = new byte[1024 * 4096];
            }
            randomAccessFile.read(buffer);
            randomAccessFile.close();
            mftGetResponse.setBody(ByteBuffer.wrap(buffer));
            value.setConsumedSize(value.getConsumedSize() + buffer.length);
            mftGetResponse.setRemainingSize(value.getFileSize() - value.getConsumedSize());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new AvroRemoteException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AvroRemoteException(e);
        }

        return mftGetResponse;
    }
}
