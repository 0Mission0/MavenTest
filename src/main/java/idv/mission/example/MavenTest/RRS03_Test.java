package idv.mission.example.MavenTest;

import java.util.ArrayList;
import java.util.List;

public class RRS03_Test {
    public static void main(String[] args) {
        List<String> formIds = new ArrayList<String>();
        formIds.add("RRS03");
        formIds.add("RRS03");

        List<String> newList = new ArrayList<String>();

        for (int x = formIds.size() - 1; x >= 0; x--) {
            String tbFormId = formIds.get(x);
            if( "RRS03".equals(tbFormId) ) {
                formIds.remove(x);
                newList.add(tbFormId + "_a");
                newList.add(tbFormId + "_b");
            }
        }

        formIds.addAll(newList);

        System.out.println(formIds);
    }
}
