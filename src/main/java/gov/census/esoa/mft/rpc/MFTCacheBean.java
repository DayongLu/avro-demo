package gov.census.esoa.mft.rpc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MFTCacheBean {

    private Map<FileTransferProfileKey, FileTransferProfileValue> fileTransferProfileMap = new ConcurrentHashMap<>();


    public Map<FileTransferProfileKey, FileTransferProfileValue> getFileTransferProfileMap() {

        return fileTransferProfileMap;
    }


}
