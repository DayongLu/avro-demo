package gov.census.esoa.mft;

import ch.qos.logback.classic.Logger;
import gov.census.esoa.mft.exception.MFTFileCompletedException;
import gov.census.esoa.mft.util.MFTRandomAccessFileWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

/**
 * Created by Xiaolei on 2/12/17.
 */

@RestController
public class MFTConsumerController {



    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity sendFilePartial(@RequestBody MultipartFile file, @RequestBody String fileName, @RequestBody long startOffset) {
        ResponseEntity entity = new ResponseEntity(HttpStatus.OK);
        return entity;

    }

    @RequestMapping(value = "/uploadBase64", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendFileBase64(@RequestBody FilePiece filePiece) {
        byte[] bytes = Base64.getDecoder().decode(filePiece.getContentBase64());

        System.out.println("received size : "+bytes.length + ", startOffset is : " + filePiece.getStartOffset());
        MFTRandomAccessFileWriter fileWriter = null;
        try {
            fileWriter = MFTRandomAccessFileWriter.Factory.getInstance(filePiece.getFileName(), filePiece.getFileSize());
        } catch (MFTFileCompletedException e) {
            return ResponseEntity.status(444).build();
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
        if (fileWriter != null) {
            try {
                fileWriter.writeBytes(bytes, filePiece.getStartOffset());
            } catch (MFTFileCompletedException e) {
                //TODO Handle file transfer completed
                try {
                    fileWriter.close();
                } catch (IOException e1) {
                    return ResponseEntity.status(444).build();
                }
                e.printStackTrace();
                return ResponseEntity.status(444).build();
            } catch (IOException e) {

                e.printStackTrace();
                return ResponseEntity.status(500).build();
            }
        }


        ResponseEntity entity = new ResponseEntity(HttpStatus.OK);
        return entity;
    }
}
