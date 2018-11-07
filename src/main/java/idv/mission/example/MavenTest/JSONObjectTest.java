package idv.mission.example.MavenTest;

import net.sf.json.JSONObject;

public class JSONObjectTest {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("success", true);
        System.out.println(obj.toString());
    }
}
