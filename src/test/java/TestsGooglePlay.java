import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsGooglePlay extends TestBase {


    @Test
    public void testGooglePlay() {
        homeGooglePage.enterText("ivi");
        String textSignInButton = homeGooglePage.getTextsignIn();
        Assert.assertEquals("�����", textSignInButton);
        homeGooglePage.clickPage5SearchResult();
        searchLinksOnPages();
        GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
        String getRaitingGP = googlePlayPage.getTextWithRaitingGooglePlay();
        System.out.println("���� " + getRaitingGP);


//        String split = homeGooglePage.splitTextRaitingSearch();
//        System.out.println("2 " + split);



//                Assert.assertEquals(getRaitingGP, split);




//        String getRaitingS = homeGooglePage.splitTextRaitingSearch();
//        System.out.println("���� " + getRaitingS);


//        System.out.println(splitText(homeGooglePage.getTextWithRaiting()));
//        Assert.assertEquals();
//        GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
//        googlePlayPage.splitTextGP(googlePlayPage.getTextWithRaitingGooglePlay());


////        GooglePlayPage googlePlayPage = new GooglePlayPage(driver);
//        googlePlayPage.getTextWithRaitingGooglePlay();
//        splitText(googlePlayPage.getTextWithRaitingGooglePlay());

    }







    private void searchLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // ������ �������� ������� �� ���������, �.�. ������������� ���� ������ �� ������, � ���� ������� �� ��������
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
            if (getGooglePlayLinkSize > 0) {
                System.out.println("�� �������� " + i + " ����� " + getGooglePlayLinkSize + " ������" );
//                homeGooglePage.newString();



//                String spText = splitText(homeGooglePage.getTextWithRaiting());

//                homeGooglePage.getTextWithRaiting();
//                System.out.println("crafaf" + split);


                // ����� ���������� �� �����
//                for(int j = 0; i < subStr.length; i++) {
////                    System.out.println(subStr[i]);
//                }
                homeGooglePage.splitTextRaitingSearch();
                homeGooglePage.clickGooglePlayLink();
            } else {
                System.out.println("�� �������� " + i + " �� ����� ������" ); // ����� ���� ������� ������� �� 1 �������� � ������� � ���� ����!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }








    /*

        private void searchLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // ����� ������� �������� ������� �� ���������, �.�. ������������� ���� ������ �� ������
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
//            System.out.println("���������� ��������� ������: " + getGooglePlayLinkSize);
            if (getGooglePlayLinkSize > 0) {
                System.out.println("�� �������� " + i + " ����� " + getGooglePlayLinkSize + " ������" );
                homeGooglePage.clickGooglePlayLink();
//                break;
            } else {
                System.out.println("�� �������� " + i + " �� ����� ������" ); // ����� ���� ������� ������� �� 1 �������� � ������� � ���� ����!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
//                homeGooglePage.clickNextPageButton();
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }

     */


    /*
        for (int i = 1; i <= 5; i++) { // ����� ������� �������� ������� �� ���������, �.�. ������������� ���� ������ �� ������
            if (getGooglePlayLinkSize > 0) {
                homeGooglePage.clickGooglePlayLink();
                break;
            } else {
                System.out.println("text"); // ����� ���� ������� ������� �� 1 �������� � ������� � ���� ����!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickNextPageButton();
            }
        }
*/


    /*
    private void searchLinksOnPages() {
        for (int i = 5; i >= 1; i--) { // ������ �������� ������� �� ���������, �.�. ������������� ���� ������ �� ������, � ���� ������� �� ��������
            int getGooglePlayLinkSize = homeGooglePage.getGooglePlayLinkSize();
            if (getGooglePlayLinkSize > 0) {
                System.out.println("�� �������� " + i + " ����� " + getGooglePlayLinkSize + " ������" );
//                homeGooglePage.newString();

                String str = homeGooglePage.getTextWithRaiting();
                String[] subStr;
                String delimeter = " "; // �����������
                subStr = str.split(delimeter); // ���������� ������ str � ������� ������ split()
                System.out.println(subStr[1]);
                // ����� ���������� �� �����
//                for(int j = 0; i < subStr.length; i++) {
////                    System.out.println(subStr[i]);
//                }
                homeGooglePage.clickGooglePlayLink();
            } else {
                System.out.println("�� �������� " + i + " �� ����� ������" ); // ����� ���� ������� ������� �� 1 �������� � ������� � ���� ����!!!
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                jsx.executeScript("window.scrollBy(0, 3000)", "");
                homeGooglePage.clickPreviousPageButton();
            }
        }
    }
     */

}