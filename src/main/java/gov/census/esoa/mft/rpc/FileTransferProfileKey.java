package gov.census.esoa.mft.rpc;

public class FileTransferProfileKey {

    private String clientId;
    private String fileName;
    private String direction;


    public String getClientId() {

        return clientId;
    }


    public void setClientId(String clientId) {

        this.clientId = clientId;
    }


    public String getFileName() {

        return fileName;
    }


    public void setFileName(String fileName) {

        this.fileName = fileName;
    }


    @Override
    public int hashCode() {

        int i = 17;
        return i * clientId.hashCode() + i * fileName.hashCode();
    }


    @Override
    public boolean equals(Object obj) {

        if (obj instanceof FileTransferProfileKey) {
            if (((FileTransferProfileKey) obj).getFileName().equals(this.fileName) && ((FileTransferProfileKey) obj)
              .getClientId().equals(this.clientId) && ((FileTransferProfileKey) obj).getDirection()
              .equals(this.direction)) {
                return true;
            }
        }
        return false;
    }


    public String getDirection() {

        return direction;
    }


    public void setDirection(String direction) {

        this.direction = direction;
    }
}
