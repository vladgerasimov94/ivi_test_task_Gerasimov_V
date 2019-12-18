import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsGooglePlay extends TestBase {

    @Test
    public void searchBigImagesWithLinks() {
        homeGooglePage.enterText("ivi");
        String textSignInButton = homeGooglePage.getTextsignIn();
        Assert.assertEquals("Войти", textSignInButton);
        int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
        Assert.assertTrue(getGooglePlayLinkSize > 0,"Количество ссылок в раздаче < 3");
        System.out.println("Количество найденных ссылок: " + getGooglePlayLinkSize);

        for (int i = 1; i <= 5; i++) {
            if (getGooglePlayLinkSize > 0) {
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickNextPageButton();
            } else {
                System.out.println("text"); // Здесь надо сделать возврат на 1 страницу и переход в гугл плей!!!
            }
        }




    }


}
