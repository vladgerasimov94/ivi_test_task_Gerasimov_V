import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomeGooglePage {

    private WebDriver driver; // Инициализируем драйвер

    public HomeGooglePage(WebDriver driver) { // Создаем конструктор страницы и передаем в него вебдрайвер
        this.driver = driver;
    }

//    Описываем локаторы страницы
    private By searchField = By.xpath("//input[@name='q']");
    private By signInButton = By.xpath("//a[text()='Войти']");
    private By images = By.xpath("//a[text()='Картинки']");
    private By settings = By.xpath("//g-header-menu[@id='ab_options']/a[contains(text(), 'Настройки')]");   // ИЛИ //a[@id='abar_button_opt']
    private By searchOptions = By.xpath("//a[text()='Расширенный поиск']");
    private By imageSize = By.xpath("//div[@id='imgsz_button']");
    private By bigImageSize = By.xpath("//div[text()='большой']"); // Если не сработает, то //div[text()='большой']/..
    private By findImages = By.xpath("//input[@value='Найти']");
    private By bigImageFilter = By.xpath("//div[text()='Большие']"); // попробовать объединить с bigImageSize
    private By spanText = By.xpath("//span[text()='ivi.ru']"); // Нужен для проверки кол-ва картинок со ссылками на ivi
    private By nextPageButton = By.xpath("//span[text()='Следующая']"); // дубль из гуглплейпейдж. удалить где-то
    private By googlePlayLink = By.xpath("//cite[contains(text(), 'https://play.google.com')]");


//    Методы по работе с вебэлементами

public void click(By locator) { // Кликаем на локатор
    driver.findElement(locator).click();
}

    public HomeGooglePage enterText(String testText){
        driver.findElement(searchField).sendKeys(testText);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return this;
    }

    public HomeGooglePage clickImages(){ // Переходим в Картинки
        click(images);
        return this;
    }

    public HomeGooglePage clickSettings(){ // Переходим в настройки
        click(settings);
        return this;
    }

    public HomeGooglePage clickSearchOptions(){ // Переходим в настройки поиска картинок
        click(searchOptions);
        return this;
    }

    public HomeGooglePage clickImageSize(){ // Переходим в выбор размера
        click(imageSize);
        return this;
    }

    public HomeGooglePage clickBigImageSize(){ // Переходим в выбор размера
        click(bigImageSize);
        return this;
    }

    public HomeGooglePage clickFindImages(){ // Применяем настройки
        driver.findElement(findImages).click();
        return this;
    }




    public HomeGooglePage findImagesWithBigSize(){ // Применяем настройки
        clickImages();
        clickSettings();
        clickSearchOptions();
        clickImageSize();
        clickBigImageSize();
        clickFindImages();
        return this;
    }

    public HomeGooglePage clickNextPageButton () {
        click(nextPageButton);
        return this;
    }



    //    Получаем текст атрибутов

    public String getTextsignIn(){
        return driver.findElement(signInButton).getText();
    }

    public String getTextbigImageFilter(){
        return driver.findElement(bigImageFilter).getText();
    }


    //  Ищем Элементы на странице и получаем их количество

    public int getLinkIviRuSize(){
        return driver.findElements(spanText).size();
    }

    public int getGooglePlayLinkSize(){
        return driver.findElements(googlePlayLink).size();
    }



}
