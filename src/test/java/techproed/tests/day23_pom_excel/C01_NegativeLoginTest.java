package techproed.tests.day23_pom_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_NegativeLoginTest {

    //Name:
    //US100208_Negative_Login
    //Description:
    //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
    //Acceptance Criteria
    //Customer email: fake@bluerentalcars.com
    //Customer password: fakepass
    //Error:
    //User with email fake@bluerentalcars.com not found

    @Test
    public void negativeTest() {

        //BlueRentalCar sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();

        //Properties dosyasındaki kullanımda olmayan email ve password bilgileri ile login olamadığını test edelim
        String fakeEmail = ConfigReader.getProperty("fakeEmail");
        String fakePassword = ConfigReader.getProperty("fakePassword");
        blueRentalPage.email.sendKeys(fakeEmail);
        blueRentalPage.password.sendKeys(fakePassword, Keys.ENTER);

        ReusableMethods.visibleWait(blueRentalPage.negativeloginVerify,15);
        Assert.assertTrue(blueRentalPage.negativeloginVerify.isDisplayed());

        //sayfayı kapatınız
        Driver.closeDriver();



    }




}