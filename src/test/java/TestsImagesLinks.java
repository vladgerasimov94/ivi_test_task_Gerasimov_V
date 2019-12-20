import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsImagesLinks extends TestBase {

/*
Кейс 1:
неавторизованный пользователь заходит в https://www.google.com/
ищет ivi
переходит в картинки
выбирает большие
убеждается, что не менее 3 картинок в выдаче ведут на сайт ivi.ru
*/

    @Test
    public void searchBigImagesWithLinks() {
        homeGooglePage.findImagesWithBigSize(); // Выполняем метод по применению фильтра для поиска больших картинок
        String textLink = homeGooglePage.getTextBigImageFilter(); // На поисковой странице берем текст из установленного фильтра по большим картинкам
        int getLinkSize = homeGooglePage.getLinkIviRuSize(); // Вызываем метод по поиску ссылок ivi в картинках из выдачи и считаем их кол-во
        Assert.assertEquals(textLink, "Большие"); // Проверяем, что в выдаче результатов по большим картинкам установлен фильтр "Большие"
        Assert.assertTrue(getLinkSize >= 3, "Количество ссылок в раздаче < 3"); // Проверяем количество ссылок, ведущих на сайт на странице. Если меньше 3, выводим текст
        System.out.println("Количество найденных ссылок: " + getLinkSize); // Выводим в консоль кол-во найденных ссылок
    }
}
