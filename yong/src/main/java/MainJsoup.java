import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Project : yong
 * Create by IntelliJ IDEA
 * User: otrodevym
 * Date: 2021/2/5/0005
 * Time: 오전 8:40:17
 */
public class MainJsoup {
    public static void main(String[] args) {
        try {
//            Document google1 = Jsoup.connect("http://www.google.com").get();
//            Document google2 = Jsoup.connect("http://www.google.com").post();
            Connection.Response res = Jsoup.connect("http://www.google.com")
                    .method(Connection.Method.GET)
                    .execute();
            Document google3 = res.parse();

            String html = google3.html();
            String text = google3.text();
//            System.out.println(html);
//            System.out.println("----------------");
//            System.out.println(text);

            Element btnk = google3.select("input[name=btnK]").first();
            String btnKValue = btnk.attr("value");
            System.out.println(btnKValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
