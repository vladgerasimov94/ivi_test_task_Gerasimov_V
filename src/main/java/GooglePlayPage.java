import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePlayPage {

    public WebDriver driver; // �������������� �������

    public GooglePlayPage(WebDriver driver) { // ������� ����������� �������� � �������� � ���� ����������
        this.driver = driver;
    }
    GooglePlayPage googlePlayPage;

    //    ��������� �������� ��������
    public By appRaitingGooglePlay = By.xpath("//div[@class='BHMmbe']");


    public String getTextWithRaitingGooglePlay(){
        return driver.findElement(appRaitingGooglePlay).getText();
    }

//    public void splitTextGP(String pageTextWithRaiting) {
//        String str = pageTextWithRaiting;
//        String[] subStr;
//        String delimeter = " "; // �����������
//        subStr = str.split(delimeter); // ���������� ������ str � ������� ������ split()
//        System.out.println(subStr[1]);
//    }










//    private By nextPageButton = By.xpath("//span[text()='���������']");
//
//
//    //    ������ �� ������ � �������������
//    public void click(By locator) { // ������� �� �������
//        driver.findElement(locator).click();
//    }
//
//        public GooglePlayPage clickNextPageButton () {
//            click(nextPageButton);
//            return this;
//        }


    }
