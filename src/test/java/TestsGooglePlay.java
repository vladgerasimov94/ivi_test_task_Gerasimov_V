import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsGooglePlay extends TestBase {


    @Test
    public void testGooglePlay() {
        homeGooglePage.enterText("ivi");
        String textSignInButton = homeGooglePage.getTextsignIn();
        Assert.assertEquals("�����", textSignInButton);
        homeGooglePage.clickPage5SearchResult();
        searchAndGoGooglePlayLinksOnPages(); // �������� ��������� ������ ������ �����
    }


}