import java.io.IOException;

public class Main  extends Request{
    public static void main(String[] args) {
        String URL = "http://www.cbr.ru/scripts/XML_daily.asp";
        String id = "R01200";
        String request = "GET";

        Request get = new Main();
        String html = null;
        try {
            html = get.getCurrencies(URL, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        get.printHKDtoRUB(html, id);
    }
}
