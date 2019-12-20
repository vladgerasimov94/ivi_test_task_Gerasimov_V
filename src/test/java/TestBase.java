import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver; // �������������� �������
    public HomeGooglePage homeGooglePage; // ��������� ������ ���� HomeGooglePage

    private static String currentDate() { // ������������� ����������� + �������� ���� � ������� �������
        return new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm").format(Calendar.getInstance().getTime());
    }

    @BeforeMethod // ��������� ����� ������ @Test-�������
    public void setUp() {
        System.out.println("������, ������, �������� �������� ��: " + currentDate()); // ������� � ������� �����������
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe"); // ���� � ��������
        driver = new ChromeDriver(); // �������������� �������
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ������� ��������
        driver.manage().window().maximize(); // ��������� ������� �� ���� �����
        driver.get("https://www.google.com/"); //��������� �� ��������� ��������
        homeGooglePage = new HomeGooglePage(driver); // �������� �������
        homeGooglePage.enterText("ivi"); // ���� � ����� ����� "ivi"
        String textSignInButton = homeGooglePage.getTextSignIn(); // ��������� ����� �� ������ ��� ����������� � Google ��� �������� ����������� ������������
        Assert.assertEquals("�����", textSignInButton); // ���������, ��� ������������ �� ��������������� � Google
    }


    @AfterMethod  // ��������� ����� ������� @Test-������
    public void tearDown() { // ��������� �������
        driver.quit();
    }

// ���� �� ������ ������ �� ��������� 1:5 � �������� � Google Play:

    protected void searchAndGoGooglePlayLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // ��������� ���� �� �������� �� 5 �� 1 �������� �� ��������
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize(); // ���� ���-�� ������ �� Google Play �� ��������
            if (getGooglePlayLinkSize > 0) { // ���� ������� > 1, ��:
                System.out.println("�� �������� " + i + " ����� " + getGooglePlayLinkSize + " ������"); // ������� ���-�� ��������� ������ �� ��������� ��������
                String split = homeGooglePage.splitTextRaitingSearch(); // ��������  ����� �� ���������� ������ � ��������� �� ������ ��������� � �������� ������ �������
                homeGooglePage.clickGooglePlayLink(); // ��������� �� ��������� ������
                GooglePlayPage googlePlayPage = new GooglePlayPage(driver); // �������������� ������ ���� GooglePlayPage � �������� � ���� �������
                String getRaitingGP = googlePlayPage.getTextWithRaitingGooglePlay(); // �������� ������� ���������� �� Google Play
                System.out.println("������� �� GooglePlay " + getRaitingGP); // ������� � �������
                System.out.println("������� �� ��������� ������ Google " + split); // ������� � �������
                Assert.assertEquals(getRaitingGP, split); // ���������, ��� ������� ���������� �� ������� �������� �������� ��������� � ��������� ��� ��������
            } else {
                System.out.println("�� �������� " + i + " �� ����� ������"); // ����� ������� ���� ��������� �� ������ ��������
                JavascriptExecutor jsx = (JavascriptExecutor) driver; // �������� ��������� Javascript ��� ���������� ��������� �������� �� ������
                jsx.executeScript("window.scrollBy(0, 3000)", ""); // �������� �������� ����
                homeGooglePage.clickPreviousPageButton(); // ��������� �� ���������� �������� (i - 1)
            }
        }
    }

// ���� �� ������ ������ �� ��������� 1:5 � ������� �� ����:

    protected void searchAndGoWikiLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // ��������� ���� �� �������� �� 5 �� 1 �������� �� ��������
            int getWikiLinkSize = homeGooglePage.getWikiLinkSize(); // ���� ���-�� ������ �� ��������� �� ��������
            if (getWikiLinkSize > 0) { // ���� ������� > 1, ��:
                System.out.println("�� �������� " + i + " ����� " + getWikiLinkSize + " ������"); // ������� ���-�� ��������� ������ �� ��������� ��������
                homeGooglePage.clickWikiLink(); // ��������� �� ��������� ������
            } else {
                System.out.println("�� �������� " + i + " �� ����� ������"); // ����� ������� ���� ��������� �� ������ ��������
                JavascriptExecutor jsx = (JavascriptExecutor) driver; // �������� ��������� Javascript ��� ���������� ��������� �������� �� ������
                jsx.executeScript("window.scrollBy(0, 3000)", ""); // �������� �������� ����
                homeGooglePage.clickPreviousPageButton(); // ��������� �� ���������� �������� (i - 1)
            }
        }
    }
    /*
    ������ �������� ������� �� ���������, ������� � 5,
    �.�. ����� ���������� ���������� ������ �� 1 ���., + ������ �� ��. �������� ����� ����.
     */
}
