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
        searchLinksOnPages();
        GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
        String getRaitingGP = googlePlayPage.getTextWithRaitingGooglePlay();
        System.out.println("���� " + getRaitingGP);
    }




    private void searchLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // ������ �������� ������� �� ���������, �.�. ������������� ���� ������ �� ������, � ���� ������� �� ��������
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
            if (getGooglePlayLinkSize > 0) {
                System.out.println("�� �������� " + i + " ����� " + getGooglePlayLinkSize + " ������" );
                homeGooglePage.splitTextRaitingSearch();
                homeGooglePage.clickGooglePlayLink();
            } else {
                System.out.println("�� �������� " + i + " �� ����� ������" ); // ����� ���� ������� ������� �� 1 �������� � ������� � ���� ����!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }

}