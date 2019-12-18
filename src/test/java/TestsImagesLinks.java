import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsImagesLinks extends TestBase {

// ���� ���� �������
//    @Test
//    public void googleStartPage() {
//        homeGooglePage.enterText("ivi");
//        String textSignInButton = homeGooglePage.getTextsignIn();
//        Assert.assertEquals("�����", textSignInButton); // ���������, ��� ������������ �� ��������������� � Google
//    }

//    @Test
//    public void searchBigImagesWithLinks() {
//        homeGooglePage.enterText("ivi");
//        String textSignInButton = homeGooglePage.getTextsignIn(); // �������� ����� �� ������ ��� ����������� ��� ��������, ������� - �� ������������
//        Assert.assertEquals("�����", textSignInButton); // ���������, ��� ������������ �� ��������������� � Google
//        homeGooglePage.findImagesWithBigSize(); // ��������� ����� �� ���������� ������� ��� ������ ������� ��������
//        String textLink = homeGooglePage.getTextbigImageFilter(); // ����� ����� �� �������������� ������� �� ������� ��������� ��� ���������� ��������
//        int getLinkIviRuSize = homeGooglePage.getLinkIviRuSize(); // �������� ����� �� ������ ��������� �� �������� � �������� �� ���-��
//        Assert.assertEquals(textLink, "�������"); // ���������, ��� � ������ ����������� �� ������� ��������� ���������� ������ "�������"
//        Assert.assertTrue(getLinkIviRuSize >= 3,"���������� ������ � ������� < 3"); // ��������� ���������� ������, ������� �� ���� �� ��������
//    }

    @Test
    public void searchBigImagesWithLinks() {
        homeGooglePage.enterText("ivi");
        String textSignInButton = homeGooglePage.getTextsignIn(); // �������� ����� �� ������ ��� ����������� ��� ��������, ������� - �� ������������
        Assert.assertEquals("�����", textSignInButton); // ���������, ��� ������������ �� ��������������� � Google
        homeGooglePage.findImagesWithBigSize(); // ��������� ����� �� ���������� ������� ��� ������ ������� ��������
        String textLink = homeGooglePage.getTextbigImageFilter(); // ����� ����� �� �������������� ������� �� ������� ��������� ��� ���������� ��������
        int getLinkSize = homeGooglePage.getLinkIviRuSize(); // �������� ����� �� ������ ��������� �� �������� � �������� �� ���-��
        Assert.assertEquals(textLink, "�������"); // ���������, ��� � ������ ����������� �� ������� ��������� ���������� ������ "�������"
        Assert.assertTrue(getLinkSize >= 3,"���������� ������ � ������� < 3"); // ��������� ���������� ������, ������� �� ���� �� ��������
        System.out.println("���������� ��������� ������: " + getLinkSize);
    }



}
