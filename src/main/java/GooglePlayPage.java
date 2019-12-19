import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePlayPage {

    public WebDriver driver; // Инициализируем драйвер

    public GooglePlayPage(WebDriver driver) { // Создаем конструктор страницы и передаем в него вебдрайвер
        this.driver = driver;
    }

    //    Описываем локаторы страницы
    public By appRaitingGooglePlay = By.xpath("//div[@class='BHMmbe']");

// Берем текст атрибута
    public String getTextWithRaitingGooglePlay(){
        return driver.findElement(appRaitingGooglePlay).getText();
    }



    }
