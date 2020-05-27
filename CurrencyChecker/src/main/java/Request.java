import lombok.Data;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


abstract class Request {

    public String getCurrencies(String url, String requestMethod) throws IOException {

        java.net.URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod(requestMethod);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public void printHKDtoRUB(String html, String id) {
        Element element = Jsoup.parse(html).getElementById(id);
        System.out.println(element.child(2).text()
                + " " + element.child(1).text()
                + " = " + element.child(4).text()
                + " RUB");
    }
}
