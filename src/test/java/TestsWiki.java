import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsWiki extends TestBase {


/*
���� 3:
���������������� ������������ ������� � https://www.google.com/
���� ivi
�� ������ 5 ��������� ������� ������ �� ������ � wikipedia �� ivi
����������, ��� � ������ ���� ������ �� ����������� ���� ivi.ru
*/

    @Test
    public void testSearchLinksInWiki() {
        homeGooglePage.clickPage5SearchResult(); // ��������� �� 5 �������� ����������� ������. �������� ����� � ��� � ���� �� 1 ���.
        searchAndGoWikiLinksOnPages(); // ���� �� ������ ������ �� ��������� 1:5 � ������� �� ����. ����������� � TestBase
        WikipediaPage wikipediaPage = new WikipediaPage(driver); // �������� ������� �� �������� ���������
        String getLinkWiki = wikipediaPage.getLinkIviRu(); // ���� � ������ ��������� ������ �� ��. ���� ivi
        Assert.assertEquals(getLinkWiki, "https://www.ivi.ru/"); // ��������� ������������ ������
        System.out.println("����� �� ���� ������ �� ����: " + getLinkWiki); // ������� � ������� ��������� ������
    }


}
