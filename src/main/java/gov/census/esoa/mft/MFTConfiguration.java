package gov.census.esoa.mft;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "mft")
public class MFTConfiguration {

    private int nettyServerPort;
    private String sourceFolder;
    private String destinationFolder;
    private String mftCacheFileLocation;


    public int getNettyServerPort() {

        return nettyServerPort;
    }


    public void setNettyServerPort(int nettyServerPort) {

        this.nettyServerPort = nettyServerPort;
    }


    public String getSourceFolder() {

        return sourceFolder;
    }


    public void setSourceFolder(String sourceFolder) {

        this.sourceFolder = sourceFolder;
    }


    public String getDestinationFolder() {

        return destinationFolder;
    }


    public void setDestinationFolder(String destinationFolder) {

        this.destinationFolder = destinationFolder;
    }


    public String getMftCacheFileLocation() {

        return mftCacheFileLocation;
    }


    public void setMftCacheFileLocation(String mftCacheFileLocation) {

        this.mftCacheFileLocation = mftCacheFileLocation;
    }
}
