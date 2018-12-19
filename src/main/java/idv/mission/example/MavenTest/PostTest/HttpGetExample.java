package idv.mission.example.MavenTest.PostTest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpGetExample {

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        // client.getParams().setParameter("http.protocol.content-charset", "UTF-8");
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=%E5%8F%B0%E7%81%A3%E5%8F%B0%E4%B8%AD%E5%B8%82%E5%A4%AA%E5%B9%B3%E5%8D%80%E5%BE%B7%E9%9A%86%E9%87%8C%E5%BE%B7%E9%9A%86%E8%B7%AF212%E8%99%9F&key=AIzaSyAtA1_r2rX4fwVAlepLeAaWhdbq9Z5b0K4";

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        String responseString = EntityUtils.toString(response.getEntity());
        System.out.println(responseString);

    }
}
