package idv.mission.example.MavenTest;

public class FinallyTest {
    public static void main(String[] args) throws Exception {
        try {
            Integer.parseInt(null);
        }
        catch (Exception ex) {
            throw ex;
        }
        finally {
            System.out.println("Finally");
        }
    }
}
