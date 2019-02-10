package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavPage {
    private WebDriver webDriver;
    private String productId;

    @FindBy(className = "deleteProFromFavorites")
    private List<WebElement> delFavClickElement;
    @FindBy(css = "span[class='btn btnGrey commonBtn addToBasketBtn']")
    private List<WebElement> delItemList;
    @FindBy(css = "span[class ='btn btnBlack confirm']")
    private WebElement okButtonElement;
    @FindBy(xpath = "//a[@href='https://www.n11.com/cikis-yap']")
    private WebElement logOutButtonClickElement;

    public FavPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void delFavClick() throws InterruptedException {
        delFavClickElement.get(findInList(productId)).click();
        Thread.sleep(2000);
    }

    public void okButtonClick() throws InterruptedException {
        okButtonElement.click();
        Assert.assertEquals("Favorilerim - n11.com", webDriver.getTitle());
        System.out.println("Favori silme testi başarıyla yapıldı.");
        Thread.sleep(5000);
        Assert.assertEquals(-1, findInList(productId));
        System.out.println(productId + " id'li ürün favorilerden başarıyla kaldırıldı.");
    }

    public void logOutClick() throws InterruptedException {
        logOutButtonClickElement.click();
        Assert.assertEquals("Giriş Yap - n11.com", webDriver.getTitle());
        System.out.println("Çıkış işlemi testi başarıyla tamamlandı");
        Thread.sleep(5000);
    }

    private int findInList(String productId) {
        int i = 0;
        for (WebElement temp : delItemList) {
            System.out.println("temp pid: " + temp.getAttribute("data-pid") + "   productid: " + productId);
            if (productId.equals(temp.getAttribute("data-pid"))) {
                System.out.println(temp.getAttribute("data-pid"));
                return i;
            }
            i++;
        }
        return -1;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
