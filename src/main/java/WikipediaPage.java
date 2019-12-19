import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaPage {

    WebDriver driver; // Инициализируем драйвер

    public WikipediaPage(WebDriver driver) { // Создаем конструктор страницы и передаем в него вебдрайвер
        this.driver = driver;
    }

//    Описываем локаторы страницы:

    public By linkIviRu = By.xpath("//a[text()='ivi.ru']"); // Ссылка из Вики на оф. сайт ivi

//    Извлекаем ссылку из веб-элемента:

    public String getLinkIviRu(){
        return driver.findElement(linkIviRu).getAttribute("href"); // Получаем именно ссылку!
    }
}