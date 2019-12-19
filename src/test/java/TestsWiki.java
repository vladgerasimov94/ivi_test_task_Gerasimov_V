import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsWiki extends TestBase {




    @Test
    public void wikiTests() {
        homeGooglePage.enterText("ivi");
        String textSignInButton = homeGooglePage.getTextsignIn();
        Assert.assertEquals("�����", textSignInButton);
        homeGooglePage.clickPage5SearchResult();
        searchLinksOnPages123();
        WikipediaPage wikipediaPage = new WikipediaPage(driver);

        String getLinkWiki = wikipediaPage.getTextInLink();
        Assert.assertEquals("ivi.ru", getLinkWiki);
        System.out.println("����� �� ���� ������ �� ����: " + getLinkWiki);
    }






    private void searchLinksOnPages123() {
        for (int i = 5; i >= 1; i--) { // ������ �������� ������� �� ���������, �.�. ������������� ���� ������ �� ������, � ���� ������� �� ��������
            int getWikiLinkSize = homeGooglePage.getWikiLinkSize();
            if (getWikiLinkSize > 0) {
                System.out.println("�� �������� " + i + " ����� " + getWikiLinkSize + " ������" );
                homeGooglePage.clickWikiLink();
            } else {
                System.out.println("�� �������� " + i + " �� ����� ������" ); // ����� ���� ������� ������� �� 1 �������� � ������� � ���� ����!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }
}
