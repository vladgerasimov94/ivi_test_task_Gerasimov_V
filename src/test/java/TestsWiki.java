import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsWiki extends TestBase {



//
//    @Test
//    public void wikiTests() {
//        homeGooglePage.enterText("ivi");
//        String textSignInButton = homeGooglePage.getTextsignIn();
//        Assert.assertEquals("Войти", textSignInButton);
//        homeGooglePage.clickPage5SearchResult();
//        searchLinksOnPages123();
//        GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
//        String getRaitingGP = googlePlayPage.getTextWithRaitingGooglePlay();
//        System.out.println("Адын " + getRaitingGP);
//        String split = homeGooglePage.splitTextRaitingSearch();
//        Assert.assertEquals(getRaitingGP, split);
//    }
//
//
//
//
//
//
//    private void searchLinksOnPages123() {
//        for (int i = 5; i >= 1; i--) { // сделал обратный переход по страницам, т.к. всяактуальная инфа всегда на первой, а цикл неплохо бы прогнать
//            int getWikiLinkSize = homeGooglePage.getWikiLinkSize();
//            if (getWikiLinkSize > 0) {
//                System.out.println("На странице " + i + " нашел " + getWikiLinkSize + " ссылку" );
//
//                homeGooglePage.wikiGooglePlayLink();
//            } else {
//                System.out.println("На странице " + i + " Не нашел ссылок" ); // Здесь надо сделать возврат на 1 страницу и переход в гугл плей!!!
//                JavascriptExecutor jsx = (JavascriptExecutor) driver;
//                jsx.executeScript("window.scrollBy(0, 3000)", "");
//                homeGooglePage.clickPreviousPageButton();
//            }
//        }
//    }
}
