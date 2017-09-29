package com.gm.dlu.avro.test;

import gov.census.esoa.mft.FilePiece;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import static java.nio.ByteBuffer.wrap;

public class RestClient {


    public static void main(String[] args) throws IOException {


        final String uri = "http://localhost:8080/mft-consumer/uploadBase64";
        RestTemplate restTemplate = new RestTemplate();
        File file = new File("D:\\software\\fmw_08012016.tar");
        long fileSize = file.length();

        String fileName = file.getName();

        InputStream in = new FileInputStream(file);

        byte[] buffer = new byte[4096 * 1024];
        int size = 0;
        long offset = 0L;
        while ((size = in.read(buffer)) != -1) {
            FilePiece filePiece = new FilePiece();
            filePiece.setFileName(fileName);
            filePiece.setFileSize(fileSize);
            filePiece.setStartOffset(offset);
            filePiece.setContentBase64(Base64.getEncoder().encodeToString(wrap(buffer, 0, size).array()));
            ResponseEntity entity = restTemplate.postForObject(uri, filePiece, ResponseEntity.class);
//            System.out.println(entity.getStatusCodeValue());
            offset+=size;
        }


        in.close();

    }

}
