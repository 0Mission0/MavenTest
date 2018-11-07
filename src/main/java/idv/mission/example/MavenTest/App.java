package idv.mission.example.MavenTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class App {
	public static void main(String[] args) {
		JSONObject parent = new JSONObject();
		JSONObject child = new JSONObject();
		JSONObject grandChild = new JSONObject();
		child.put("key1", "value1");

		grandChild.put("key2", "value2");
		child.put("key2", grandChild);
		
		parent.put("child", child);
		String str = parent.toString(4);
		System.out.println(str);
		
		
		Set<String> strSet = new HashSet();
		strSet.add("1");
		strSet.add("2");
		strSet.add("3");
		
		String second = "2";
		strSet.remove(second);
		System.out.println(strSet);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("Key1", "Value1");
		map.put("Key2", "Value2");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(map);
		Set<String> allKeySet = new HashSet<String>();
		for(int i = 0; i < jsonArray.size(); i++) {
			Map<String, String> tempMap = (Map<String, String>) jsonArray.get(i);
			Set<String> keySet = tempMap.keySet();
			allKeySet.addAll(keySet);
		}
		
		System.out.println(allKeySet);
		
	}
}
