package idv.mission.example.MavenTest;

import org.apache.commons.lang.ObjectUtils;

public class ObjectUtilsTest {
    public static void main(String[] args) {

        String outputStr1 = ObjectUtils.toString(null);
        System.out.println(outputStr1);
        String outputStr2 = String.format("%s", null);
        System.out.println(outputStr2);
    }
}
