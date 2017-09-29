package com.gm.dlu.avro.test;

import gov.census.esoa.mft.rpc.MFTFileTransfer;
import gov.census.esoa.mft.rpc.MFTGetRequest;
import gov.census.esoa.mft.rpc.MFTGetResponse;
import gov.census.esoa.mft.rpc.MFTPushRequest;
import org.apache.avro.ipc.HttpTransceiver;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;

public class AvroRPCClient {

    public static void main(String[] args) throws IOException {

//        HttpTransceiver client = new HttpTransceiver(new URL("http", "192.168.57.129", 9090, "/"));

        NettyTransceiver client = new NettyTransceiver(new InetSocketAddress("localhost",9999));
        MFTFileTransfer proxy = SpecificRequestor.getClient(MFTFileTransfer.class, client);

        MFTGetRequest request = new MFTGetRequest();
        request.setClientId("This should be unique request ID");
        request.setFileName("fmw_08012016.tar");
        request.setOffset(0L);
        long startTime = System.currentTimeMillis();
        MFTGetResponse getResponse = proxy.get(request);
        System.out.println("get first package");
        while (getResponse.getRemainingSize() > 0) {
            System.out.println("push package");
            MFTPushRequest pushRequest = new MFTPushRequest();
            byte[] buffer = getResponse.getBody().array();
            pushRequest.setBody(getResponse.getBody());
            pushRequest.setClientId("This should be unique request ID");
            pushRequest.setFileName("fmw_08012016.tar");
            pushRequest.setOffset(getResponse.getOffset());
            pushRequest.setTotalSize(getResponse.getTotalSize());
            pushRequest.setRemainingSize(pushRequest.getTotalSize() - buffer.length);
            proxy.receive(pushRequest);

            request.setOffset(request.getOffset() + buffer.length);
            getResponse = proxy.get(request);
            System.out.println("get package");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - startTime);
        client.close();

    }

}
