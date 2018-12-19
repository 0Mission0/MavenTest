package idv.mission.example.MavenTest.PostTest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetExample4 {
    public static void main(String[] args) throws Exception {

        // String url = "https://216.58.200.234/maps/api/geocode/json?address=%E5%8F%B0%E7%81%A3%E5%8F%B0%E4%B8%AD%E5%B8%82%E5%A4%AA%E5%B9%B3%E5%8D%80%E5%BE%B7%E9%9A%86%E9%87%8C%E5%BE%B7%E9%9A%86%E8%B7%AF212%E8%99%9F&key=AIzaSyAtA1_r2rX4fwVAlepLeAaWhdbq9Z5b0K4";
        String url = "https://216.58.200.234/maps/api/geocode/json?address=%E5%8F%B0%E7%81%A3%E5%8F%B0%E4%B8%AD%E5%B8%82%E5%A4%AA%E5%B9%B3%E5%8D%80%E5%BE%B7%E9%9A%86%E9%87%8C%E5%BE%B7%E9%9A%86%E8%B7%AF212%E8%99%9F&key=AIzaSyCilmFsHE38SE1XrYcNBXmNC8oF0l2Ffno";

        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(
            builder.build(), SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(
            factory).build();

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            System.out.printf(EntityUtils.toString(entity));
        }
        finally {
            response.close();
        }
    }
}