import org.testng.annotations.Test;

public class TestsGooglePlay extends TestBase {

/*
 ейс 2:
неавторизованный пользователь заходит в https://www.google.com/
ищет ivi
на первых 5 страницах находит ссылки на приложение ivi в play.google.com
убеждаетс€, что рейтинг приложени€ на кратком контенте страницы совпадает с рейтингом при переходе
*/

    @Test
    public void testRaitingInSearchAndGooglePlay() {
        homeGooglePage.clickPage5SearchResult(); // ѕереходим на 5 страницу результатов поиска. Ќачинаем поиск с нее и идем до 1 стр.
        searchAndGoGooglePlayLinksOnPages(); // !ѕроверка внутри цикла! ÷икл по поиску ссылок на страницах 1:5 и переход в GooglePlay. ѕодробности в TestBase
    }


}