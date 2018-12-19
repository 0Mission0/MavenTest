package idv.mission.example.MavenTest;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>();
        list.remove(list.size() - 1);
        System.out.println(list);
    }
}
