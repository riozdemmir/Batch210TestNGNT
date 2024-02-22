package techproed.tests.day23_pom_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class C03_BlueRentalCarExcelTest {
    @Test
    public void test01() {

        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();

        //Excel dosyasındaki herhangi bir email ve password ile login olalım
        String dosyaYolu="src/test/java/techproed/resources/adminTestData.xlsx";
        String sayfaIsmi="customer_info";
        ExcelReader excelReader = new ExcelReader(dosyaYolu,sayfaIsmi);
        String email = excelReader.getCellData(2,0);
        String password = excelReader.getCellData(2,1);

        blueRentalPage.email.sendKeys(email);
        blueRentalPage.password.sendKeys(password, Keys.ENTER);

        //Girilen email ile giriş yapıldığını doğrulayın
        blueRentalPage.loginVerify.click();
        blueRentalPage.profile.click();

        String profileEmail=blueRentalPage.profileEmail.getText();
        Assert.assertEquals(profileEmail,email);

        //sayfayı kapatalım
        Driver.closeDriver();



    }
}