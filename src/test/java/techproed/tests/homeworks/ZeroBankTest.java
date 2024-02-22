package techproed.tests.homeworks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.ZeroBankPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;

public class ZeroBankTest {
    //1."http://zero.webappsecurity.com/" Adresine gidin başlığın Personal içerdiğini test edin
//2. Sign in butonuna basin
//3. Login kutusuna "username" yazin
//4. Password kutusuna "password" yazin
//5. Sign in tusuna basin
//6. Online banking menusu icinde Pay Bills sayfasina gidin başlığın Zero içerdiğini test edin
//7. "Purchase Foreign Currency" tusuna basin
//8. "Currency" drop down menusunden Eurozone'u secin
//9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
//10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
//edin ("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
//(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
//(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
//(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
//(dollar)","Thailand (baht)")

    @Test
    public void test01() {
        //1."http://zero.webappsecurity.com/" Adresine gidin başlığın Personal içerdiğini test edin
        Driver.getDriver().get(ConfigReader.getProperty("zeroBankUrl"));
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(Driver.getDriver().getTitle().contains("Personal"));
        //2. Sign in butonuna basin
        ZeroBankPage zeroBankPage = new ZeroBankPage();
        zeroBankPage.signinButton.click();
        //3. Login kutusuna "username" yazin
        zeroBankPage.loginName.sendKeys(ConfigReader.getProperty("zeroBankUserName"));
        //4. Password kutusuna "password" yazin //5. Sign in tusuna basin
        zeroBankPage.password.sendKeys(ConfigReader.getProperty("zeroBankPassword"));
        zeroBankPage.signinSubmitButton.click();
        Driver.getDriver().navigate().back();
        //6. Online banking menusu icinde Pay Bills sayfasina gidin başlığın Zero içerdiğini test edin
        zeroBankPage.onlineBankingLink.click();
        zeroBankPage.payBillsLink.click();
        softAssert.assertTrue(Driver.getDriver().getTitle().contains("Zero"));
        //7. "Purchase Foreign Currency" tusuna basin
        zeroBankPage.purchaseForeignLink.click();
        //8. "Currency" drop down menusunden Eurozone'u secin
        WebElement dropDown = zeroBankPage.currencyDdm;
        ReusableMethods.ddmValue(dropDown,"EUR");
        //9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        Select select = new Select(zeroBankPage.currencyDdm);
        String actualSelectedOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSelectedOption,"Eurozone (euro)");
        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //edin ("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //(dollar)","Thailand (baht)")
        List<String> expectedOptions = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)",
                "Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)",
                "Sweden (krona)","Singapore (dollar)","Thailand (baht)");
        List<WebElement> allActualOptions = select.getOptions();
        for (int i = 0; i <expectedOptions.size() ; i++) {
            softAssert.assertEquals(allActualOptions.get(i).getText(),expectedOptions.get(i));
        }
        softAssert.assertAll();

    }
}