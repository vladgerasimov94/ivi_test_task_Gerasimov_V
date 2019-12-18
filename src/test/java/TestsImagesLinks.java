import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsImagesLinks extends TestBase {

// Этот тест удалить
//    @Test
//    public void googleStartPage() {
//        homeGooglePage.enterText("ivi");
//        String textSignInButton = homeGooglePage.getTextsignIn();
//        Assert.assertEquals("Войти", textSignInButton); // Проверяем, что пользователь не зарегистрирован в Google
//    }

//    @Test
//    public void searchBigImagesWithLinks() {
//        homeGooglePage.enterText("ivi");
//        String textSignInButton = homeGooglePage.getTextsignIn(); // Получаем текст из кнопки для авторизации для проверки, зареган - ли пользователь
//        Assert.assertEquals("Войти", textSignInButton); // Проверяем, что пользователь не зарегистрирован в Google
//        homeGooglePage.findImagesWithBigSize(); // Выполняем метод по применению фильтра для поиска больших картинок
//        String textLink = homeGooglePage.getTextbigImageFilter(); // Берем текст из установленного фильтра по большим картинкам для дальнейшей проверки
//        int getLinkIviRuSize = homeGooglePage.getLinkIviRuSize(); // Вызываем метод по поиску элементов на странице и подсчету их кол-ва
//        Assert.assertEquals(textLink, "Большие"); // Проверяем, что в выдаче результатов по большим картинкам установлен фильтр "Большие"
//        Assert.assertTrue(getLinkIviRuSize >= 3,"Количество ссылок в раздаче < 3"); // Проверяем количество ссылок, ведущих на сайт на странице
//    }

    @Test
    public void searchBigImagesWithLinks() {
        homeGooglePage.enterText("ivi");
        String textSignInButton = homeGooglePage.getTextsignIn(); // Получаем текст из кнопки для авторизации для проверки, зареган - ли пользователь
        Assert.assertEquals("Войти", textSignInButton); // Проверяем, что пользователь не зарегистрирован в Google
        homeGooglePage.findImagesWithBigSize(); // Выполняем метод по применению фильтра для поиска больших картинок
        String textLink = homeGooglePage.getTextbigImageFilter(); // Берем текст из установленного фильтра по большим картинкам для дальнейшей проверки
        int getLinkSize = homeGooglePage.getLinkIviRuSize(); // Вызываем метод по поиску элементов на странице и подсчету их кол-ва
        Assert.assertEquals(textLink, "Большие"); // Проверяем, что в выдаче результатов по большим картинкам установлен фильтр "Большие"
        Assert.assertTrue(getLinkSize >= 3,"Количество ссылок в раздаче < 3"); // Проверяем количество ссылок, ведущих на сайт на странице
        System.out.println("Количество найденных ссылок: " + getLinkSize);
    }



}
