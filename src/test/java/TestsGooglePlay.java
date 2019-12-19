import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsGooglePlay extends TestBase {


    @Test
    public void testGooglePlay() {
        homeGooglePage.enterText("ivi");
        String textSignInButton = homeGooglePage.getTextsignIn();
        Assert.assertEquals("Войти", textSignInButton);
        homeGooglePage.clickPage5SearchResult();
        searchLinksOnPages();
        GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
        String getRaitingGP = googlePlayPage.getTextWithRaitingGooglePlay();
        System.out.println("Адын " + getRaitingGP);
    }




    private void searchLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // сделал обратный переход по страницам, т.к. всяактуальная инфа всегда на первой, а цикл неплохо бы прогнать
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
            if (getGooglePlayLinkSize > 0) {
                System.out.println("На странице " + i + " нашел " + getGooglePlayLinkSize + " ссылку" );
                homeGooglePage.splitTextRaitingSearch();
                homeGooglePage.clickGooglePlayLink();
            } else {
                System.out.println("На странице " + i + " Не нашел ссылок" ); // Здесь надо сделать возврат на 1 страницу и переход в гугл плей!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }

}