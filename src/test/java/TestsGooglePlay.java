import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsGooglePlay extends TestBase {


    @Test
    public void testGooglePlay() {
//        homeGooglePage.enterText("ivi"); // Ищем в гугле текст "ivi"
//        String textSignInButton = homeGooglePage.getTextsignIn(); // Извлекаем текст из кнопки для авторизации в Google для проверки регистрации пользователя
//        Assert.assertEquals("Войти", textSignInButton); // Проверяем, что пользователь не зарегистрирован в Google
        homeGooglePage.clickPage5SearchResult(); // Переходим на 5 страницу результатов поиска. Начинаем поиск с нее и идем до 1 стр.
        searchAndGoGooglePlayLinksOnPages(); // !Проверка внутри цикла! Цикл по поиску ссылок на страницах 1:5 и переход в GooglePlay. Подробности в TestBase
    }


}