import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public HomeGooglePage homeGooglePage;


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //! ������� ��������
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        homeGooglePage = new HomeGooglePage(driver);
    }



//    public String splitText(String pageTextWithRaiting) {
//        String str = pageTextWithRaiting;
//        String[] subStr;
//        String delimeter = " "; // �����������
//        subStr = str.split(delimeter); // ���������� ������ str � ������� ������ split()
//        String st = (subStr[1]);
//        System.out.println(st);
//        return st;
//    }


//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
