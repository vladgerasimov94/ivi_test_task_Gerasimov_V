import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaPage {

    WebDriver driver; // �������������� �������

    public WikipediaPage(WebDriver driver) { // ������� ����������� �������� � �������� � ���� ����������
        this.driver = driver;
    }


    //    ��������� �������� ��������
    public By linkIviRu = By.xpath("//table[@class='infobox']//a[text()='ivi.ru']");    //   //a[text()='ivi.ru']


    public String getTextInLink(){
        return driver.findElement(linkIviRu).getText();
    }
}
