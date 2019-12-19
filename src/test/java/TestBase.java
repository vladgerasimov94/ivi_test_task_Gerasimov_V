import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
//        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        System.out.println("Привет хозяин, пытаюсь запустить автотест от: " + currentDate());
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //! Неявное ожидание
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        homeGooglePage = new HomeGooglePage(driver);
    }



//    public String splitText(String pageTextWithRaiting) {
//        String str = pageTextWithRaiting;
//        String[] subStr;
//        String delimeter = " "; // Разделитель
//        subStr = str.split(delimeter); // Разделения строки str с помощью метода split()
//        String st = (subStr[1]);
//        System.out.println(st);
//        return st;
//    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
