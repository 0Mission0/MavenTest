package idv.mission.example.MavenTest.PostTest;

import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpGetExample3 {
    public static void main(String[] args) throws Exception {
        String address = "台中市德隆里德隆路一段212號";
        HttpClient client = HttpClientBuilder.create().build();
        String addressEncode = URLEncoder.encode(address, "UTF-8");
        System.out.println(addressEncode);
        String url = "";

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        String responseString = EntityUtils.toString(response.getEntity());
        System.out.println(responseString);
    }
}
