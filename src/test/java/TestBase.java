import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public HomeGooglePage homeGooglePage;
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //! Неявное ожидание
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        homeGooglePage = new HomeGooglePage(driver);

    }


//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
