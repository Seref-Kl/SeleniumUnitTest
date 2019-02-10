package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavAndReqPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//a[@href='https://www.n11.com/hesabim/favorilerim']")
    private WebElement favClickElement;

    public FavAndReqPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void favPageClick() throws InterruptedException {
        favClickElement.click();
        Assert.assertEquals("Favorilerim - n11.com", webDriver.getTitle());
        System.out.println("Favori sayfası yönlendirilmesi testi başarıyla yapıldı.");

        Thread.sleep(2000);
    }
}
