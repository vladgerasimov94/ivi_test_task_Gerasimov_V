import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsWiki extends TestBase {



    @Test
    public void wikiTests() {
        homeGooglePage.enterText("ivi");
        String textSignInButton = homeGooglePage.getTextsignIn();
        Assert.assertEquals("Войти", textSignInButton);
        homeGooglePage.clickPage5SearchResult();
        searchAndGoWikiLinksOnPages();
        WikipediaPage wikipediaPage = new WikipediaPage(driver);
        String getLinkWiki = wikipediaPage.getTextInLink();
        Assert.assertEquals("ivi.ru", getLinkWiki);
        System.out.println("Нашел на Вики ссылку на сайт: " + getLinkWiki);
    }


}
