package techproed.tests.day24_dataprovider_xmlfiles;


import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] credentials() {
        return new Object[][]{
                {"ayhancan@bluerentalcars.com", "ayhan"},
                {"beyhancan@bluerentalcars.com", "beyhan"},
                {"johnson@bluerentalcars.com", "johnson"}
        };
    }

    @Test(dataProvider = "credentials")
    public void test01(String email,String password) {
        //       BlueRentalCar Sayfasına Gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //       Login butonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();

        //       Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
        blueRentalPage.email.sendKeys(email);
        blueRentalPage.password.sendKeys(password, Keys.ENTER);

        //       Sayfayı kapatalım
        Driver.closeDriver();

    }
}