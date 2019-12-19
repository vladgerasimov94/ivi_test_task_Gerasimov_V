import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomeGooglePage {

    public WebDriver driver; // Инициализируем драйвер

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
    private By previousPageButton = By.xpath("//span[text()='Предыдущая']");
    private By googlePlayLink = By.xpath("//cite[contains(text(), 'https://play.google.com')]");
    private By page5SearchResult = By.xpath("//a[@aria-label='Page 5']");
    private By appRaitingSearch = By.xpath("//div[contains(text(), 'Рейтинг')]"); // //div[@class='slp f']
    private By wikiLink = By.xpath("//cite[contains(text(), 'https://ru.wikipedia.org')]");


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



    public HomeGooglePage clickPage5SearchResult(){
        driver.findElement(page5SearchResult).click();
        return this;
    }

    public HomeGooglePage clickPreviousPageButton(){ // Переход на предыдущую страницу поиска
        driver.findElement(previousPageButton).click();
        return this;
    }

    //    Методы по переходам на другие страницы сайта

    public GooglePlayPage clickGooglePlayLink () {
        click(googlePlayLink);
        return new GooglePlayPage(driver);
    }

    public WikipediaPage clickWikiLink () {
        click(wikiLink);
        return new WikipediaPage(driver);
    }



    //    Получаем текст атрибутов

    public String getTextsignIn(){
        return driver.findElement(signInButton).getText();
    }

    public String getTextbigImageFilter(){
        return driver.findElement(bigImageFilter).getText();
    }

    public String getTextWithRaiting(){
        return driver.findElement(appRaitingSearch).getText();
    }




    public String splitTextRaitingSearch() {
        String str = getTextWithRaiting();
        String[] subStr;
        String delimeter = " "; // Разделитель
        subStr = str.split(delimeter); // Разделения строки str с помощью метода split()
        String st = (subStr[1]);
        return st;
    }


    //  Ищем Элементы на странице и получаем их количество

    public int getLinkIviRuSize(){
        return driver.findElements(spanText).size();
    }

    public int getGooglePlayLinkSize(){
        return driver.findElements(googlePlayLink).size();
    }

    public int getWikiLinkSize(){
        return driver.findElements(googlePlayLink).size();
    }


}
