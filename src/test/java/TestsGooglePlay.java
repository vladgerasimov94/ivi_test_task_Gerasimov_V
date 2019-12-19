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


//        String split = homeGooglePage.splitTextRaitingSearch();
//        System.out.println("2 " + split);



//                Assert.assertEquals(getRaitingGP, split);




//        String getRaitingS = homeGooglePage.splitTextRaitingSearch();
//        System.out.println("Дыва " + getRaitingS);


//        System.out.println(splitText(homeGooglePage.getTextWithRaiting()));
//        Assert.assertEquals();
//        GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
//        googlePlayPage.splitTextGP(googlePlayPage.getTextWithRaitingGooglePlay());


////        GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
//        googlePlayPage.getTextWithRaitingGooglePlay();
//        splitText(googlePlayPage.getTextWithRaitingGooglePlay());

    }







    private void searchLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // сделал обратный переход по страницам, т.к. всяактуальная инфа всегда на первой, а цикл неплохо бы прогнать
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
            if (getGooglePlayLinkSize > 0) {
                System.out.println("На странице " + i + " нашел " + getGooglePlayLinkSize + " ссылку" );
//                homeGooglePage.newString();



//                String spText = splitText(homeGooglePage.getTextWithRaiting());

//                homeGooglePage.getTextWithRaiting();
//                System.out.println("crafaf" + split);


                // Вывод результата на экран
//                for(int j = 0; i < subStr.length; i++) {
////                    System.out.println(subStr[i]);
//                }
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








    /*

        private void searchLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // можно сделать обратный переход по страницам, т.к. всяактуальная инфа всегда на первой
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
//            System.out.println("Количество найденных ссылок: " + getGooglePlayLinkSize);
            if (getGooglePlayLinkSize > 0) {
                System.out.println("На странице " + i + " нашел " + getGooglePlayLinkSize + " ссылку" );
                homeGooglePage.clickGooglePlayLink();
//                break;
            } else {
                System.out.println("На странице " + i + " Не нашел ссылок" ); // Здесь надо сделать возврат на 1 страницу и переход в гугл плей!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
//                homeGooglePage.clickNextPageButton();
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }

     */


    /*
        for (int i = 1; i <= 5; i++) { // можно сделать обратный переход по страницам, т.к. всяактуальная инфа всегда на первой
            if (getGooglePlayLinkSize > 0) {
                homeGooglePage.clickGooglePlayLink();
                break;
            } else {
                System.out.println("text"); // Здесь надо сделать возврат на 1 страницу и переход в гугл плей!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickNextPageButton();
            }
        }
*/


    /*
    private void searchLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // сделал обратный переход по страницам, т.к. всяактуальная инфа всегда на первой, а цикл неплохо бы прогнать
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
            if (getGooglePlayLinkSize > 0) {
                System.out.println("На странице " + i + " нашел " + getGooglePlayLinkSize + " ссылку" );
//                homeGooglePage.newString();

                String str = homeGooglePage.getTextWithRaiting();
                String[] subStr;
                String delimeter = " "; // Разделитель
                subStr = str.split(delimeter); // Разделения строки str с помощью метода split()
                System.out.println(subStr[1]);
                // Вывод результата на экран
//                for(int j = 0; i < subStr.length; i++) {
////                    System.out.println(subStr[i]);
//                }
                homeGooglePage.clickGooglePlayLink();
            } else {
                System.out.println("На странице " + i + " Не нашел ссылок" ); // Здесь надо сделать возврат на 1 страницу и переход в гугл плей!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }
     */

}