import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomeGooglePage {

    public WebDriver driver; // Инициализируем драйвер

    public HomeGooglePage(WebDriver driver) { // Создаем конструктор страницы и передаем в него веб-драйвер
        this.driver = driver;
    }

//    Описываем локаторы страницы:

    private By searchField = By.xpath("//input[@name='q']");
    private By signInButton = By.xpath("//a[text()='Войти']");
    private By images = By.xpath("//a[text()='Картинки']");
    private By settings = By.xpath("//g-header-menu[@id='ab_options']/a[contains(text(), 'Настройки')]");
    private By searchOptions = By.xpath("//a[text()='Расширенный поиск']");
    private By imageSize = By.xpath("//div[@id='imgsz_button']");
    private By bigImageSize = By.xpath("//div[text()='большой']");
    private By findImages = By.xpath("//input[@value='Найти']");
    private By bigImageFilter = By.xpath("//div[text()='Большие']");
    private By linkIviInImages = By.xpath("//span[text()='ivi.ru']");
    private By previousPageButton = By.xpath("//span[text()='Предыдущая']");
    private By googlePlayLink = By.xpath("//cite[contains(text(), 'https://play.google.com')]");
    private By page5SearchResult = By.xpath("//a[@aria-label='Page 5']");
    private By appRaitingSearch = By.xpath("//div[contains(text(), 'Рейтинг')]");
    private By wikiLink = By.xpath("//cite[contains(text(), 'https://ru.wikipedia.org')]");


//    Методы по работе с веб-элементами:

    public void click(By locator) { // Общий метод по клику на локатор
        driver.findElement(locator).click();
    }

    public HomeGooglePage enterText(String testText) { // Вводим текст в поле и жмем Enter
        driver.findElement(searchField).sendKeys(testText);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return this;
    }

    public HomeGooglePage clickImages() { // Переходим в Картинки
        click(images);
        return this;
    }

    public HomeGooglePage clickSettings() { // Переходим в настройки
        click(settings);
        return this;
    }

    public HomeGooglePage clickSearchOptions() { // Переходим в настройки поиска картинок
        click(searchOptions);
        return this;
    }

    public HomeGooglePage clickImageSize() { // Переходим в выбор размера
        click(imageSize);
        return this;
    }

    public HomeGooglePage clickBigImageSize() { // Выбираем картинки большого размера
        click(bigImageSize);
        return this;
    }

    public HomeGooglePage clickFindImages() { // Применяем настройки
        driver.findElement(findImages).click();
        return this;
    }

// Общий метод по переходу в картинки и применению настроек поиска по размеру. Для удобного вызова в тестах:

    public HomeGooglePage findImagesWithBigSize() {
        clickImages();
        clickSettings();
        clickSearchOptions();
        clickImageSize();
        clickBigImageSize();
        clickFindImages();
        return this;
    }

    public HomeGooglePage clickPage5SearchResult() { // Клик на 5 страницу результатов поиска как точку отсчета для цикла
        driver.findElement(page5SearchResult).click();
        return this;
    }

    public HomeGooglePage clickPreviousPageButton() { // Переход на предыдущую страницу поиска
        driver.findElement(previousPageButton).click();
        return this;
    }

//    Методы по переходам на другие страницы:

    public GooglePlayPage clickGooglePlayLink() {
        click(googlePlayLink);
        return new GooglePlayPage(driver);
    }

    public WikipediaPage clickWikiLink() {
        click(wikiLink);
        return new WikipediaPage(driver);
    }


//    Извлекаем текст из атрибутов:

    public String getTextSignIn() { // Для проверки, зарегистрирован ли пользователь
        return driver.findElement(signInButton).getText();
    }

    public String getTextBigImageFilter() { // Для проверки примененного фильтра в результатах поиска
        return driver.findElement(bigImageFilter).getText();
    }

    public String getTextWithRaiting() { // Извлекаем текст из атрибута, содержащего инфо о рейтинге
        return driver.findElement(appRaitingSearch).getText();
    }

// Метод по разделению текста на массив элементов типа String. Нужно для проверки рейтингов:

    public String splitTextRaitingSearch() {
        String str = getTextWithRaiting();
        String[] subStr;
        String delimeter = " "; // Разделитель слов - пробел
        subStr = str.split(delimeter); // Разделение строки str с помощью метода split()
        String st = (subStr[1]); // Берем второй элемент массива (цифра с рейтингом)
        return st;
    }


//  Ищем Элементы на странице и получаем их количество:

    public int getLinkIviRuSize() { // Количество ссылок на оф. сайт ivi
        return driver.findElements(linkIviInImages).size();
    }

    public int getGooglePlayLinkSize() { // Количество ссылок на приложение ivi в Google Play
        return driver.findElements(googlePlayLink).size();
    }

    public int getWikiLinkSize() { // Количество ссылок на ivi в Википедии
        return driver.findElements(googlePlayLink).size();
    }


}
