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
        searchGooglePlayLinksOnPages();
        GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
//        String getRaitingGP = googlePlayPage.getTextWithRaitingGooglePlay();
//        System.out.println("Рейтинг из GooglePlay " + getRaitingGP);
//        System.out.println(homeGooglePage.splitTextRaitingSearch()); Не работает!!!
    }




    private void searchGooglePlayLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // сделал обратный переход по страницам, т.к. всяактуальная инфа всегда на первой, а цикл неплохо бы прогнать
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
            if (getGooglePlayLinkSize > 0) {
                System.out.println("На странице " + i + " нашел " + getGooglePlayLinkSize + " ссылку" );
                String split = homeGooglePage.splitTextRaitingSearch();
                homeGooglePage.clickGooglePlayLink();
                GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
                String getRaitingGP = googlePlayPage.getTextWithRaitingGooglePlay();
                System.out.println("Рейтинг из GooglePlay " + getRaitingGP);
                System.out.println("Рейтинг из странички поиска Google " + split);
                Assert.assertEquals(getRaitingGP, split);
            } else {
                System.out.println("На странице " + i + " Не нашел ссылок" ); // Здесь надо сделать возврат на 1 страницу и переход в гугл плей!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }

}