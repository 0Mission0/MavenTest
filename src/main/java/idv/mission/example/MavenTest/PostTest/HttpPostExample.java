package idv.mission.example.MavenTest.PostTest;

import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpPostExample {
    public static void main(String[] args) throws Exception {
        String address = "台中市德隆里德隆路一段212號";
        HttpClient client = HttpClientBuilder.create().build();
        String addressEncode = URLEncoder.encode(address, "UTF-8");
        System.out.println(addressEncode);
        String url = "";

        HttpPost httpPost = new HttpPost(url);
        HttpResponse response = client.execute(httpPost);
        String responseString = EntityUtils.toString(response.getEntity());
        System.out.println(responseString);
    }
}
