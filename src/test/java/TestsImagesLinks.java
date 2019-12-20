import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsImagesLinks extends TestBase {

/*
���� 1:
���������������� ������������ ������� � https://www.google.com/
���� ivi
��������� � ��������
�������� �������
����������, ��� �� ����� 3 �������� � ������ ����� �� ���� ivi.ru
*/

    @Test
    public void searchBigImagesWithLinks() {
        homeGooglePage.findImagesWithBigSize(); // ��������� ����� �� ���������� ������� ��� ������ ������� ��������
        String textLink = homeGooglePage.getTextBigImageFilter(); // �� ��������� �������� ����� ����� �� �������������� ������� �� ������� ���������
        int getLinkSize = homeGooglePage.getLinkIviRuSize(); // �������� ����� �� ������ ������ ivi � ��������� �� ������ � ������� �� ���-��
        Assert.assertEquals(textLink, "�������"); // ���������, ��� � ������ ����������� �� ������� ��������� ���������� ������ "�������"
        Assert.assertTrue(getLinkSize >= 3, "���������� ������ � ������� < 3"); // ��������� ���������� ������, ������� �� ���� �� ��������. ���� ������ 3, ������� �����
        System.out.println("���������� ��������� ������: " + getLinkSize); // ������� � ������� ���-�� ��������� ������
    }
}
