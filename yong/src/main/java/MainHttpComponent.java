import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Connection;

import java.io.IOException;
import java.util.*;

/**
 * Project : yong
 * Create by IntelliJ IDEA
 * User: otrodevym
 * Date: 2021/2/6/0006
 * Time: 오전 11:16:29
 */
public class MainHttpComponent {
    private static CloseableHttpClient closeableHttpClient;
    public static void main(String[] args) {
        closeableHttpClient = HttpClientBuilder.create().build();

        String url = "http://otrodevym.tistory.com/";
        Map<String, String> param = new HashMap<>();
        param.put("userID", "id");
        param.put("userPW", "pw");

        MainHttpComponent mainHttpComponent = new MainHttpComponent();
//        String string = mainHttpComponent.get(url, param);
////        System.out.println(string);

        String url2 = "http://otrodevym.tistory.com/movePage";
        Map<String, String> param2 = new HashMap<String, String>();
        param2.put("no", "1");
        String string2 = mainHttpComponent.get(url2, param2);
        System.out.println(string2);

        try {
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String post(String url, Map<String, String> params, String encoding) {

        try {
            HttpPost post = new HttpPost(url);
            System.out.println("================================");
            System.out.println("POST : " + post.getURI());
            System.out.println("================================");

            List<NameValuePair> paramList = convertParam(params);
            post.setEntity(new UrlEncodedFormEntity(paramList, encoding));

            ResponseHandler<String> rh = new BasicResponseHandler();

            String execute = closeableHttpClient.execute(post, rh);

            return execute;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //            client.close();
        }

        return "error";
    }

    public String post(String url, Map<String, String> params) {
        return post(url, params, "UTF-8");
    }


    private String get(String url, Map<String, String> param) {
        return get(url, param, "UTF-8");
    }

    private String get(String url, Map<String, String> param, String encoding) {
        try {
            List<NameValuePair> parameList = convertParam(param);
            HttpGet get = new HttpGet(url + "?" + URLEncodedUtils.format(parameList, encoding));
            System.out.println("==================");
            System.out.println("GET : " + get.getURI());
            System.out.println("==================");
            ResponseHandler<String> rh = new BasicResponseHandler();

            String execute = closeableHttpClient.execute(get, rh);
            return execute;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "error";
    }

    private List<NameValuePair> convertParam(Map<String, String> param) {
        List<NameValuePair> paramList = new ArrayList<>();
        for (String key :
                param.keySet()) {
            paramList.add(new BasicNameValuePair(key, param.get(key).toString()));
        }
        return paramList;
    }

}
