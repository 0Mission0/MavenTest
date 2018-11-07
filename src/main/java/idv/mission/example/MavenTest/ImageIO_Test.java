package idv.mission.example.MavenTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageIO_Test {
    public static void main(String[] args) throws IOException {

        // long startTime = System.currentTimeMillis();
        // File file = new File("C:\\workspace\\practice\\Test\\imageIoTest\\RRS03_1b.png");
        // byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        // String image = new String(encoded, StandardCharsets.US_ASCII);
        // long endTime = System.currentTimeMillis();
        // System.out.println(image);
        // System.out.println(endTime - startTime);

        // long startTime = System.currentTimeMillis();
        // File file = new File("C:\\AP\\tsssdata\\formfileSign\\201801\\XWS2018010300141094\\XWS2018010300141094_R18_1_0.jpg");
        // BufferedImage bufferedImage = ImageIO.read(file);
        // java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        // ImageIO.write(bufferedImage, "png", outputStream);
        // byte[] data = outputStream.toByteArray();
        // outputStream.close();
        // String image = Base64.encodeBase64String(data);
        // long endTime = System.currentTimeMillis();
        // System.out.println(image);
        // System.out.println(endTime - startTime);

        // File file = new File("C:\\AP\\tsssdata\\formfileSign\\201801\\XWS2018010300141094\\XWS2018010300141094_R18_1_0.jpg");
        // BufferedImage img = ImageIO.read(file);
        // int width = img.getWidth();
        // int height = img.getHeight();
        // System.out.println("width = " + width);
        // System.out.println("height = " + height);

        File file = new File("C:\\AP\\tsssdata\\formfileSign\\201801\\XWS2018010300141094\\6.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon image = new ImageIcon(file.getPath());
        FileOutputStream outputStream = new FileOutputStream("C:\\AP\\tsssdata\\formfileSign\\201801\\XWS2018010300141094\\test.png");
        ImageIO.write(bufferedImage, "png", outputStream);
        System.out.println("End");
    }
}