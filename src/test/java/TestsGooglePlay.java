import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsGooglePlay extends TestBase {


    @Test
    public void testGooglePlay() {
//        homeGooglePage.enterText("ivi"); // ���� � ����� ����� "ivi"
//        String textSignInButton = homeGooglePage.getTextsignIn(); // ��������� ����� �� ������ ��� ����������� � Google ��� �������� ����������� ������������
//        Assert.assertEquals("�����", textSignInButton); // ���������, ��� ������������ �� ��������������� � Google
        homeGooglePage.clickPage5SearchResult(); // ��������� �� 5 �������� ����������� ������. �������� ����� � ��� � ���� �� 1 ���.
        searchAndGoGooglePlayLinksOnPages(); // !�������� ������ �����! ���� �� ������ ������ �� ��������� 1:5 � ������� � GooglePlay. ����������� � TestBase
    }


}