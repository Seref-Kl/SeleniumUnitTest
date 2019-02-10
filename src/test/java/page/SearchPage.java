package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//a[@href='https://www.n11.com/arama?q=Iphone&pg=2']")
    private WebElement page2ClickElement;
    @FindBy(css = "span[class = 'textImg followBtn']")
    private List<WebElement> addFavClickElementList;
    @FindBy(css = "span[class = 'textImg followBtn ok']")
    private List<WebElement> favElementList;
    @FindBy(linkText = "Hesabım")
    private WebElement we;
    @FindBy(xpath = "//a[@href = 'https://www.n11.com/hesabim/istek-listelerim']")
    private WebElement favAndReqClickElement;

    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void page2Click() throws InterruptedException {
        page2ClickElement.click();
        Thread.sleep(2000);
        Assert.assertEquals("https://www.n11.com/arama?q=Iphone&pg=2", webDriver.getCurrentUrl());
        System.out.println("Arama 2. sayfası işlemi testi başarıyla yapıldı.");
        Thread.sleep(3000);
    }
    public String addFavClick() throws InterruptedException {
        Assert.assertEquals("textImg followBtn", addFavClickElementList.get(2).getAttribute("class"));
        String temo = addFavClickElementList.get(2).getAttribute("data-productid");
        System.out.println(addFavClickElementList.get(2).getAttribute("data-productid"));
        addFavClickElementList.get(2).click();
        Thread.sleep(3000);

        Assert.assertEquals(temo, findList(temo).getAttribute("data-productid"));
        System.out.println("3. sıradaki ürün favoriye alma işlemi testi başarıyla yapıldı.");
        Thread.sleep(5000);
        return temo;
    }

    private WebElement findList(String productId){
        for (WebElement temp : favElementList){
            if (productId.equals(temp.getAttribute("data-productid"))){
                System.out.println(temp.getAttribute("data-productid"));
                return temp;
            }
        }
        return null;
    }
    public void getHesabimAction(){
        Actions action = new Actions(webDriver);
        action.moveToElement(we).build().perform();
    }
    public void favAndReqClick() throws InterruptedException {
        favAndReqClickElement.click();
        Assert.assertEquals("İstek Listelerim - n11.com", webDriver.getTitle());
        System.out.println("Favori/İstek listelerim sayfası testi başarıyla yapıldı.");
        Thread.sleep(2000);
    }
}
