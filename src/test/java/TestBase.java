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

    public WebDriver driver;
    public HomeGooglePage homeGooglePage;

    private static String currentDate() {
        return new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm").format(Calendar.getInstance().getTime());
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("������ ������, ������� ��������� �������� ��: " + currentDate());
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //! ������� ��������
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        homeGooglePage = new HomeGooglePage(driver);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    protected void searchAndGoGooglePlayLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // ������ �������� ������� �� ���������, �.�. ������������� ���� ������ �� ������, � ���� ������� �� ��������
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
            if (getGooglePlayLinkSize > 0) {
                System.out.println("�� �������� " + i + " ����� " + getGooglePlayLinkSize + " ������" );
                String split = homeGooglePage.splitTextRaitingSearch();
                homeGooglePage.clickGooglePlayLink();
                GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
                String getRaitingGP = googlePlayPage.getTextWithRaitingGooglePlay();
                System.out.println("������� �� GooglePlay " + getRaitingGP);
                System.out.println("������� �� ��������� ������ Google " + split);
                Assert.assertEquals(getRaitingGP, split);
            } else {
                System.out.println("�� �������� " + i + " �� ����� ������" ); // ����� ���� ������� ������� �� 1 �������� � ������� � ���� ����!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }

    protected void searchAndGoWikiLinksOnPages() {
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
