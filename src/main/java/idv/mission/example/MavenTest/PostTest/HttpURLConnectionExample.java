package idv.mission.example.MavenTest.PostTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {
    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        HttpURLConnectionExample http = new HttpURLConnectionExample();
        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();
    }

    // HTTP GET request
    private void sendGet() throws Exception {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=%E5%8F%B0%E7%81%A3%E5%8F%B0%E4%B8%AD%E5%B8%82%E5%A4%AA%E5%B9%B3%E5%8D%80%E5%BE%B7%E9%9A%86%E9%87%8C%E5%BE%B7%E9%9A%86%E8%B7%AF212%E8%99%9F&key=AIzaSyAtA1_r2rX4fwVAlepLeAaWhdbq9Z5b0K4";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        // add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
        System.out.println(response.toString());

    }
}
