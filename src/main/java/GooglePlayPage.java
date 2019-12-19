import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePlayPage {

    public WebDriver driver; // �������������� �������

    public GooglePlayPage(WebDriver driver) { // ������� ����������� �������� � �������� � ���� ����������
        this.driver = driver;
    }

    //    ��������� �������� ��������
    public By appRaitingGooglePlay = By.xpath("//div[@class='BHMmbe']");

// ����� ����� ��������
    public String getTextWithRaitingGooglePlay(){
        return driver.findElement(appRaitingGooglePlay).getText();
    }



    }
