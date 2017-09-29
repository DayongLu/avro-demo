package gov.census.esoa.mft.util;

import gov.census.esoa.mft.exception.MFTFileCompletedException;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Xiaolei on 2/13/17.
 */
public class MFTRandomAccessFileWriter {

    public static class Factory {
        private static Map<String, MFTRandomAccessFileWriter> cache = new HashMap<String, MFTRandomAccessFileWriter>();

        private static ReentrantLock lock = new ReentrantLock();
        public  static MFTRandomAccessFileWriter getInstance(String fileName, long fileSize) throws IOException, MFTFileCompletedException {
            lock.lock();
            try {
                if (cache.containsKey(fileName)) {
                    return cache.get(fileName);
                } else {
                    MFTRandomAccessFileWriter instance = new MFTRandomAccessFileWriter(fileName, fileSize);
                    cache.put(fileName, instance);
                    return instance;
                }
            }finally {
                lock.unlock();
            }



        }

    }

    private ReentrantLock lock = new ReentrantLock();

    private long currentWritingSize = 0L;

    private RandomAccessFile randomAccessFile;

    private String fileName;

    private long fileSize;

    public MFTRandomAccessFileWriter(String fileName, long fileSize) throws IOException, MFTFileCompletedException {
        if (currentWritingSize == fileSize) {
            throw new MFTFileCompletedException("File " + fileName + " already completed.");
        }

        this.fileName = fileName;
        this.fileSize = fileSize;

        File file = new File(fileName);
        this.randomAccessFile = new RandomAccessFile(file, "rw");
        if (!file.exists() || !file.isFile()) {
            this.randomAccessFile.setLength(this.fileSize);
        }

    }

    public  void writeBytes(byte[] content, long startOffset) throws IOException, MFTFileCompletedException {
        lock.lock();
        try {
            randomAccessFile.seek(startOffset);
            randomAccessFile.write(content);

            currentWritingSize += content.length;
        } catch (IOException e) {
            throw e;
        }

        System.out.println("Current Writing Size : "+ currentWritingSize);
        if (currentWritingSize == this.fileSize) {
            throw new MFTFileCompletedException("File " + this.fileName + " Complete");
        }
        lock.unlock();

    }

    public void close() throws IOException {
        lock.lock();
        System.out.println("File Transfer Complete! Close!");
        if (this.randomAccessFile != null) {
            this.randomAccessFile.close();
            Factory.cache.remove(this.fileName);
        }
        lock.unlock();
    }

}
