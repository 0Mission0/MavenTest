package idv.mission.example.MavenTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.jpeg.JpegDirectory;

public class ImageOrientation {

    public static void main(String[] args) {
        try {
            // String fileName = "C:\\workspace\\practice\\MavenTest\\src\\main\\java\\idv\\mission\\example\\MavenTest\\pic1.jpg";
            // String fileName = "C:\\workspace\\practice\\MavenTest\\src\\main\\java\\idv\\mission\\example\\MavenTest\\pic2.jpg";
            String fileName = "C:\\workspace\\practice\\MavenTest\\src\\main\\java\\idv\\mission\\example\\MavenTest\\XWS2018103000151796_P47_1_0.png";
            // String fileName = "C:\\workspace\\practice\\MavenTest\\src\\main\\java\\idv\\mission\\example\\MavenTest\\tstar1.jpg";
            // String fileName = "C:\\workspace\\practice\\MavenTest\\src\\main\\java\\idv\\mission\\example\\MavenTest\\tstar2.jpg";
            // String fileName = "C:\\workspace\\practice\\MavenTest\\src\\main\\java\\idv\\mission\\example\\MavenTest\\tstar3.jpg";
            // String fileName = "C:\\workspace\\practice\\MavenTest\\src\\main\\java\\idv\\mission\\example\\MavenTest\\tstar4.jpg";
            // String fileName = "C:\\workspace\\practice\\MavenTest\\src\\main\\java\\idv\\mission\\example\\MavenTest\\8.jpg";
            // File file = new File("C:\\AP\\tsssdata\\formfileSign\\201801\\XWS2018010300141094\\XWS2018010300141094_R18_1_0.jpg");
            File file = new File(fileName);
            BufferedImage img = ImageIO.read(file);
            int width = img.getWidth();
            int height = img.getHeight();
            System.out.println("width = " + width);
            System.out.println("height = " + height);
            int orientation = getImageOrientation(file);
            System.out.println("orientation = " + orientation);
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static int getImageOrientation(File imageFile) throws IOException, MetadataException, ImageProcessingException {
        Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
        Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        int orientation = 0;
        try {
            if( directory != null ) {
                orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
            }
        }
        catch (MetadataException me) {
            System.out.println("Could not get orientation");
        }
        return orientation;
    }

    public static ImageInformation readImageInformation(File imageFile) throws IOException, MetadataException, ImageProcessingException {
        Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
        Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        JpegDirectory jpegDirectory = metadata.getFirstDirectoryOfType(JpegDirectory.class);

        int orientation = 0;
        try {
            orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
            System.out.println("orientation = " + orientation);
        }
        catch (MetadataException me) {
            System.out.println("Could not get orientation");
        }
        int width = jpegDirectory.getImageWidth();
        int height = jpegDirectory.getImageHeight();

        return new ImageInformation(orientation, width, height);
    }

}

class ImageInformation {
    public final int orientation;
    public final int width;
    public final int height;

    public ImageInformation(int orientation, int width, int height) {
        this.orientation = orientation;
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return String.format("%dx%d,%d", this.width, this.height, this.orientation);
    }
}