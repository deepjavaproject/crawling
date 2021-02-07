import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Project : yong
 * Create by IntelliJ IDEA
 * User: otrodevym
 * Date: 2021/2/5/0005
 * Time: 오후 12:50:17
 */
public class MainSelenium {
    public static void main(String[] args) {
        String DRIVER_ID = "webdriver.chrome.driver";
        String DRIVER_PATH = "src/main/resources/chromedriver.exe";
        System.setProperty(DRIVER_ID, DRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.google.com";
        try {
            // 접속
            driver.get(baseUrl);
            // 해당 페이지로 접속
            System.out.println(driver.getPageSource());
            // 태그 중 첫 번째
            WebElement webElement = driver.findElement(By.name("q"));
            // 키 체크
            webElement.sendKeys("날씨");
            // 웹으로 데이터 보내서 실행하기
            webElement.submit();
        } catch (Exception e ) {
            e.printStackTrace();
        }

    }
}
