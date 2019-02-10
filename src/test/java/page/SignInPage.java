package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver webDriver;
    @FindBy(id = "email")
    private WebElement emailElement;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "loginButton")
    private WebElement loginButtonElement;

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void getEmailAndPassword(){
        emailElement.sendKeys("serefkilic.bm1@gmail.com");
        password.sendKeys("123seref");
    }
    public void loginButtonClick() throws InterruptedException {
        loginButtonElement.click();
        Assert.assertEquals("n11.com - Alışverişin Uğurlu Adresi", webDriver.getTitle());
        System.out.println("Login işlem testi başarıyla yapıldı.");
        Thread.sleep(2000);
    }
}
