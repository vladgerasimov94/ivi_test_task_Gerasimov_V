import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsWiki extends TestBase {


    @Test
    public void wikiTests() {
//        homeGooglePage.enterText("ivi"); // ���� � ����� ����� "ivi"
//        String textSignInButton = homeGooglePage.getTextsignIn(); // ��������� ����� �� ������ ��� ����������� � Google ��� �������� ����������� ������������
//        Assert.assertEquals("�����", textSignInButton); // ���������, ��� ������������ �� ��������������� � Google
        homeGooglePage.clickPage5SearchResult(); // ��������� �� 5 �������� ����������� ������. �������� ����� � ��� � ���� �� 1 ���.
        searchAndGoWikiLinksOnPages(); // ���� �� ������ ������ �� ��������� 1:5 � ������� �� ����. ����������� � TestBase
        WikipediaPage wikipediaPage = new WikipediaPage(driver); // �������� ������� �� �������� ���������
        String getLinkWiki = wikipediaPage.getLinkIviRu(); // ���� � ������ ��������� ������ �� ��. ���� ivi
        Assert.assertEquals(getLinkWiki, "https://www.ivi.ru/"); // ��������� ������������ ������
        System.out.println("����� �� ���� ������ �� ����: " + getLinkWiki); // ������� � ������� ��������� ������
    }


}
