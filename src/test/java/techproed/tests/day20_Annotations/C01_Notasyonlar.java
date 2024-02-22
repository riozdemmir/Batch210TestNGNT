package techproed.tests.day20_Annotations;

import org.testng.annotations.*;

public class C01_Notasyonlar {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Herseyden önce BeforeSuite notasyonuna sahip olan method 1 kez calisir");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Herseyden sonra AfterSuite notasyonuna sahip olan method 1 kez calisir");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Testlerden önce BeforeTest notasyonuna sahip olan method 1 kez calisir");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Testlerden sonra AfterTest notasyonuna sahip olan method 1 kez calisir");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Her classtan önce BeforeClass notasyonuna sahip olan method 1 kez calisir");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Her classtan sonra AfterClass notasyonuna sahip olan method 1 kez calisir");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod notasyonuna sahip bir method her test methodundan once 1 kez calisir");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("AfterMethod notasyonuna sahip bir method her test methodundan sonra 1 kez calisir");
    }

    @Test(groups = "smoke")
    public void test01() {
        System.out.println("test01 test methodu calisti");
    }
    @Test
    public void test02() {
        System.out.println("test02 test methodu calisti");
    }
    @Test
    public void test03() {
        System.out.println("test03 test methodu calisti");
    }

}