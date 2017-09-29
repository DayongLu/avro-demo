package gov.census.esoa.mft.rpc;


import gov.census.esoa.mft.MFTConfiguration;
import org.apache.avro.ipc.HttpServer;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificResponder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.InetSocketAddress;

@Component
public class AvroNettyServerStarter {

    @Autowired
    MFTFileTransferImpl mftFileTransfer;

    @Autowired
    MFTConfiguration mftConfiguration;

    NettyServer server;


    @PostConstruct
    private void startNettyServer() throws IOException {

//        Server server = new HttpServer(new SpecificResponder(MFTFileTransfer.class, mftFileTransfer),
//          mftConfiguration.getNettyServerPort());
//        server.start();

                server = new NettyServer(new SpecificResponder(MFTFileTransfer.class, mftFileTransfer),
                  new InetSocketAddress(mftConfiguration.getNettyServerPort()));

    }


    @PreDestroy
    private void stopNettyServer() {

        server.close();
    }

}
