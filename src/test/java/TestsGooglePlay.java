import org.testng.annotations.Test;

public class TestsGooglePlay extends TestBase {

/*
���� 2:
���������������� ������������ ������� � https://www.google.com/
���� ivi
�� ������ 5 ��������� ������� ������ �� ���������� ivi � play.google.com
����������, ��� ������� ���������� �� ������� �������� �������� ��������� � ��������� ��� ��������
*/

    @Test
    public void testRaitingInSearchAndGooglePlay() {
        homeGooglePage.clickPage5SearchResult(); // ��������� �� 5 �������� ����������� ������. �������� ����� � ��� � ���� �� 1 ���.
        searchAndGoGooglePlayLinksOnPages(); // !�������� ������ �����! ���� �� ������ ������ �� ��������� 1:5 � ������� � GooglePlay. ����������� � TestBase
    }


}