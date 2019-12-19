import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsWiki extends TestBase {


/*
Кейс 3:
неавторизованный пользователь заходит в https://www.google.com/
ищет ivi
на первых 5 страницах находит ссылку на статью в wikipedia об ivi
убеждается, что в статье есть ссылка на официальный сайт ivi.ru
*/

    @Test
    public void testSearchLinksInWiki() {
        homeGooglePage.clickPage5SearchResult(); // Переходим на 5 страницу результатов поиска. Начинаем поиск с нее и идем до 1 стр.
        searchAndGoWikiLinksOnPages(); // Цикл по поиску ссылок на страницах 1:5 и переход на Вики. Подробности в TestBase
        WikipediaPage wikipediaPage = new WikipediaPage(driver); // Передаем драйвер на страницу Википедии
        String getLinkWiki = wikipediaPage.getLinkIviRu(); // Ищем в статье Википедии ссылки на оф. сайт ivi
        Assert.assertEquals(getLinkWiki, "https://www.ivi.ru/"); // Проверяем корректность ссылки
        System.out.println("Нашел на Вики ссылку на сайт: " + getLinkWiki); // Выводим в консоль найденную ссылку
    }


}
