import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaPage {

    WebDriver driver; // Инициализируем драйвер

    public WikipediaPage(WebDriver driver) { // Создаем конструктор страницы и передаем в него вебдрайвер
        this.driver = driver;
    }


    //    Описываем локаторы страницы
    public By linkIviRu = By.xpath("//table[@class='infobox']//a[text()='ivi.ru']");    //   //a[text()='ivi.ru']


    public String getTextInLink(){
        return driver.findElement(linkIviRu).getText();
    }
}
