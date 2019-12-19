import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePlayPage {

    public WebDriver driver; // Инициализируем драйвер

    public GooglePlayPage(WebDriver driver) { // Создаем конструктор страницы и передаем в него вебдрайвер
        this.driver = driver;
    }
    GooglePlayPage googlePlayPage;

    //    Описываем локаторы страницы
    public By appRaitingGooglePlay = By.xpath("//div[@class='BHMmbe']");


    public String getTextWithRaitingGooglePlay(){
        return driver.findElement(appRaitingGooglePlay).getText();
    }

//    public void splitTextGP(String pageTextWithRaiting) {
//        String str = pageTextWithRaiting;
//        String[] subStr;
//        String delimeter = " "; // Разделитель
//        subStr = str.split(delimeter); // Разделения строки str с помощью метода split()
//        System.out.println(subStr[1]);
//    }










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
