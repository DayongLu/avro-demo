package gov.census.esoa.mft;

import java.io.Serializable;

/**
 * Created by Xiaolei on 2/12/17.
 */
public class FilePiece implements Serializable{

    private String fileName;

    private long startOffset;

    private String contentBase64;

    private long fileSize;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getStartOffset() {
        return startOffset;
    }

    public void setStartOffset(long startOffset) {
        this.startOffset = startOffset;
    }


    public String getContentBase64() {
        return contentBase64;
    }

    public void setContentBase64(String contentBase64) {
        this.contentBase64 = contentBase64;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
