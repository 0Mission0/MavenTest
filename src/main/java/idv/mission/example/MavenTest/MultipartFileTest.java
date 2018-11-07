package idv.mission.example.MavenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileTest {

    public static void main(String[] args) {
        // String name = "XWS2018091800149841_RRP01_a_1_1.png";
        String name = "C.png";

        String contentType = "text/plain";
        String path = "C:\\AP\\tsssdata\\formfileSign\\201809\\XWS2018091800149841\\" + name;

        File file = new File(path);
        byte[] bytes = new byte[(int) file.length()];
        try {
            FileInputStream fis = new FileInputStream(file);
            fis.read(bytes); // read file into bytes[]
            fis.close();
            MultipartFile multipartFile = new MockMultipartFile(name, name, contentType, bytes);
            String result = DigestUtils.md5Hex(multipartFile.getBytes());
            System.out.println("result = " + result);
        }
        catch (final IOException e) {
            System.out.println(e.toString());
        }

    }

}