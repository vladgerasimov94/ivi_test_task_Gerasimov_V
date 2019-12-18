import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePlayPage {

    private WebDriver driver; // Инициализируем драйвер

    public GooglePlayPage(WebDriver driver) { // Создаем конструктор страницы и передаем в него вебдрайвер
        this.driver = driver;
    }

    //    Описываем локаторы страницы

//    private By nextPageButton = By.xpath("//span[text()='Следующая']");
//
//
//    //    Методы по работе с вебэлементами
//    public void click(By locator) { // Кликаем на локатор
//        driver.findElement(locator).click();
//    }
//
//        public GooglePlayPage clickNextPageButton () {
//            click(nextPageButton);
//            return this;
//        }


    }
