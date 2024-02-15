package techproed.tests.day20_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Priority {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test//Default olarak 0 (sifir) oldugu icin ikinci sirada calisti
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }
    @Test(priority = 2)//en yuksek priority oldugu icin en son bu calisti
    public void amazonTest() {
        driver.get("https://amazon.com");
    }
    @Test(priority = -1)//en dusuk priority oldugu icin ilk once bu calisti
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}