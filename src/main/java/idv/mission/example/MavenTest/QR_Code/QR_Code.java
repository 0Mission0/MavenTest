package idv.mission.example.MavenTest.QR_Code;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import com.github.cloudecho.qrcode.ZxingCode;
import com.github.cloudecho.qrcode.ZxingEntry;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;

public class QR_Code {

    public static final String PATH = "C:\\workspace\\practice\\MavenTest\\src\\main\\java\\idv\\mission\\example\\MavenTest\\QR_Code";
    public static final String FILE_NAME = "qrcode";

    @Test
    public void createQrcode() throws WriterException, IOException {
        System.out.println("Start MavenTest.QR_Code.QR_Code.createQrcode");
        ZxingEntry zxing = new ZxingEntry();
        zxing.setContent("http://www.google.com.tw");
        zxing.setCharset("UTF-8");
        // zxing.setErrorCorrectionLevel(ErrorCorrectionLevel.H);
        zxing.setFormat("png");
        zxing.setMargin(0);
        zxing.setWidth(430);
        zxing.setHeight(430);
        zxing.setDir(PATH);
        zxing.setName(FILE_NAME);
        zxing.setLogoPath(PATH + "/logo.png");
        zxing.setLogoCornerRadius(16);

        // Generate QRCode
        ZxingCode code = new ZxingCode();
        code.encode(zxing);
        System.out.println("Create QRCode Success");
    }

    @Test
    public void decode() throws WriterException, IOException, NotFoundException {
        // 解析二維碼
        ZxingCode code = new ZxingCode();
        Result result = code.decode(PATH + File.separator + FILE_NAME + ".png", "utf-8");
        System.out.println("Result: " + result.getText());
        System.out.println("Decode Success");
    }

    public static void main(String[] args) {
        org.junit.runner.Result result = JUnitCore.runClasses(QR_Code.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
