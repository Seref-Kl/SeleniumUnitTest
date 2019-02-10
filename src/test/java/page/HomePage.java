package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver webDriver;

    @FindBy(className = "btnSignIn")
    private WebElement btnSignInElement;
    @FindBy(id = "searchData")
    private WebElement searchDataElement;
    @FindBy(className = "searchBtn")
    private WebElement searchButtonElement;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void signInButtonClick() throws InterruptedException {
        btnSignInElement.click();

        Assert.assertEquals("Giriş Yap - n11.com", webDriver.getTitle());
        System.out.println("Giriş yap sayfası yönlendirmesi testi yapıldı.");
        Thread.sleep(2000);
    }
    public void getSearchDataElement(){
        searchDataElement.sendKeys("Iphone");
    }
    public void searchButtonClick() throws InterruptedException {
        searchButtonElement.click();
        Assert.assertEquals("Iphone - n11.com", webDriver.getTitle());
        System.out.println("Arama işlemi testi yapıldı.");
        Thread.sleep(4000);
    }
}
