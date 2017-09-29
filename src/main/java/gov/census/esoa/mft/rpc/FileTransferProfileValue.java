package gov.census.esoa.mft.rpc;

public class FileTransferProfileValue {

    private long fileSize;
    private long offset;
    private long remainingSize;
    private long consumedSize;


    public long getFileSize() {

        return fileSize;
    }


    public void setFileSize(long fileSize) {

        this.fileSize = fileSize;
    }


    public long getOffset() {

        return offset;
    }


    public void setOffset(long offset) {

        this.offset = offset;
    }


    public long getRemainingSize() {

        return remainingSize;
    }


    public void setRemainingSize(long remainingSize) {

        this.remainingSize = remainingSize;
    }





    public long getConsumedSize() {

        return consumedSize;
    }


    public void setConsumedSize(long consumedSize) {

        this.consumedSize = consumedSize;
    }
}
