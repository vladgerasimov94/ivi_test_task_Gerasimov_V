import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleImagesPage {

    private WebDriver driver; // Инициализируем драйвер

    public GoogleImagesPage(WebDriver driver) { // Создаем конструктор страницы и передаем в него вебдрайвер
        this.driver = driver;
    }

    //    Описываем локаторы страницы
    private By phoneOrEmailField = By.xpath("//input[@name='emailOrPhone']");
    private By fullNameField = By.xpath("//input[@name='fullName']");
    private By userNameField = By.xpath("//input[@name='username']");

//    Методы по работе с вебэлементами


}
