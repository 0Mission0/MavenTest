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
        String url = "";

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        String responseString = EntityUtils.toString(response.getEntity());
        System.out.println(responseString);

    }
}
