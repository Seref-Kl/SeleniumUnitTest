import org.junit.*;
import page.*;

public class TestSeleniumJUnit extends BaseDriverClass {

    @Test
    public void testCase() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        SignInPage signInPage = new SignInPage(webDriver);
        SearchPage searchPage = new SearchPage(webDriver);
        FavAndReqPage favAndReqPage = new FavAndReqPage(webDriver);
        FavPage favPage = new FavPage(webDriver);

        homePage.signInButtonClick();

        signInPage.getEmailAndPassword();
        signInPage.loginButtonClick();
        homePage.getSearchDataElement();
        homePage.searchButtonClick();

        searchPage.page2Click();
        favPage.setProductId(searchPage.addFavClick());
        searchPage.getHesabimAction();
        searchPage.favAndReqClick();

        favAndReqPage.favPageClick();

        favPage.delFavClick();
        favPage.okButtonClick();
        searchPage.getHesabimAction();
        favPage.logOutClick();
    }
}
