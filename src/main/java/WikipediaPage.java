import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaPage {

    WebDriver driver; // �������������� �������

    public WikipediaPage(WebDriver driver) { // ������� ����������� �������� � �������� � ���� ����������
        this.driver = driver;
    }

//    ��������� �������� ��������:

    public By linkIviRu = By.xpath("//a[text()='ivi.ru']"); // ������ �� ���� �� ��. ���� ivi

//    ��������� ������ �� ���-��������:

    public String getLinkIviRu(){
        return driver.findElement(linkIviRu).getAttribute("href"); // �������� ������ ������!
    }
}