import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver; // Инициализируем драйвер
    public HomeGooglePage homeGooglePage; // Объявляем объект типа HomeGooglePage

    private static String currentDate() { // Дружественное приветствие + указание даты и времени запуска
        return new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm").format(Calendar.getInstance().getTime());
    }

    @BeforeMethod // Запускаем перед каждым @Test-методом
    public void setUp() {
        System.out.println("Привет, хозяин, запускаю автотест от: " + currentDate()); // Выводим в консоль приветствие
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe"); // Путь к драйверу
        driver = new ChromeDriver(); // Инициализируем драйвер
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Неявное ожидание
        driver.manage().window().maximize(); // Открываем браузер на весь экран
        driver.get("https://www.google.com/"); //Переходим на стартовую страницу
        homeGooglePage = new HomeGooglePage(driver); // передаем драйвер
        homeGooglePage.enterText("ivi"); // Ищем в гугле текст "ivi"
        String textSignInButton = homeGooglePage.getTextSignIn(); // Извлекаем текст из кнопки для авторизации в Google для проверки регистрации пользователя
        Assert.assertEquals("Войти", textSignInButton); // Проверяем, что пользователь не зарегистрирован в Google
    }


    @AfterMethod  // Запускаем после каждого @Test-метода
    public void tearDown() { // Закрываем браузер
        driver.quit();
    }

// Цикл по поиску ссылок на страницах 1:5 и переходу в Google Play:

    protected void searchAndGoGooglePlayLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // Запускаем цикл по переходу от 5 до 1 страницы по убыванию
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize(); // Ищем кол-во ссылок на Google Play на странцие
            if (getGooglePlayLinkSize > 0) { // Если находим > 1, то:
                System.out.println("На странице " + i + " нашел " + getGooglePlayLinkSize + " ссылку"); // Выводим кол-во найденных ссылок на указанной странице
                String split = homeGooglePage.splitTextRaitingSearch(); // Вызываем  метод по разделению текста с рейтингом на массив элементов и выбираем только рейтинг
                homeGooglePage.clickGooglePlayLink(); // Переходим по найденной ссылке
                GooglePlayPage googlePlayPage = new GooglePlayPage(driver); // Инициализируем объект типа GooglePlayPage и передаем в него драйвер
                String getRaitingGP = googlePlayPage.getTextWithRaitingGooglePlay(); // Получаем рейтинг приложения из Google Play
                System.out.println("Рейтинг из GooglePlay " + getRaitingGP); // Выводим в консоль
                System.out.println("Рейтинг из странички поиска Google " + split); // Выводим в консоль
                Assert.assertEquals(getRaitingGP, split); // Проверяем, что рейтинг приложения на кратком контенте страницы совпадает с рейтингом при переходе
            } else {
                System.out.println("На странице " + i + " Не нашел ссылок"); // Иначе выводим инфо сообщение по каждой странице
                JavascriptExecutor jsx = (JavascriptExecutor) driver; // Вызываем интерфейс Javascript для выполнения драйвером действий на экране
                jsx.executeScript("window.scrollBy(0, 3000)", ""); // Скроллим страницу вниз
                homeGooglePage.clickPreviousPageButton(); // Переходим на предыдущую страницу (i - 1)
            }
        }
    }

// Цикл по поиску ссылок на страницах 1:5 и переход на Вики:

    protected void searchAndGoWikiLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // Запускаем цикл по переходу от 5 до 1 страницы по убыванию
            int getWikiLinkSize = homeGooglePage.getWikiLinkSize(); // Ищем кол-во ссылок на Википедию на странцие
            if (getWikiLinkSize > 0) { // Если находим > 1, то:
                System.out.println("На странице " + i + " нашел " + getWikiLinkSize + " ссылку"); // Выводим кол-во найденных ссылок на указанной странице
                homeGooglePage.clickWikiLink(); // Переходим по найденной ссылке
            } else {
                System.out.println("На странице " + i + " Не нашел ссылок"); // Иначе выводим инфо сообщение по каждой странице
                JavascriptExecutor jsx = (JavascriptExecutor) driver; // Вызываем интерфейс Javascript для выполнения драйвером действий на экране
                jsx.executeScript("window.scrollBy(0, 3000)", ""); // Скроллим страницу вниз
                homeGooglePage.clickPreviousPageButton(); // Переходим на предыдущую страницу (i - 1)
            }
        }
    }
    /*
    сделал обратный переход по страницам, начиная с 5,
    т.к. самые популярные результаты всегда на 1 стр., + ссылка на оф. источник будет одна.
     */
}
