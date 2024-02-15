package techproed.tests.day20_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_Ignore {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");
        boolean excelDosyaYolu=false;
        if(excelDosyaYolu){
            System.out.println("testler calisir");
        }else {
            throw new SkipException("Excel dosyasi silinmis");
        }
    }
    /*
    Bu testte SkipException kullanarak testin calistirilmasini runt time da dynamic olarak durdurabiliriz
    SkipException firlattigimizda o test Skipped olarak isaretlenir
     */

    @Ignore
    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @Test(enabled = false)
    public void facebookTest() {
        driver.get("https://facebook.com");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}