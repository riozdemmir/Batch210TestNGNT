package techproed.tests.day20_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DependsOnMethods {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");

        //arama kutusunda selenium aratiniz
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("selenium"+ Keys.ENTER);
        Assert.assertTrue(false);
        /*
        DependsonMethod ozelligi sadece bagli olunan testin sonucu Pass olursa aktive olur
        fail olursa hic calismaz
         */
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //sonuc yazisinin selenium icerdigini test ediniz
        String resultText = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(resultText.contains("selenium"));
    }
}