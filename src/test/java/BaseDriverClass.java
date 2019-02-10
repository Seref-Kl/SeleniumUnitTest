import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriverClass {
    static WebDriver webDriver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seref\\Desktop\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.n11.com");

        Assert.assertEquals("n11.com - Alışverişin Uğurlu Adresi", webDriver.getTitle());
        System.out.println("Selenium Unit Test başarıyla başladı");
    }

    @After
    public void endTest() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }
}
