package techproed.tests.day22_pom;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.Driver;

public class C01_PageKullanimi {

    @Test(groups = "smoke")
    public void test01() {
        //amazon sayfasina gidelim
        Driver.getDriver().get("https://amazon.com");

        //arama kutusunda selenium aratalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("selenium", Keys.ENTER);

    }
/*
POM - Page Object Model
Page object model (POM), test otomasyon projelerinde kullanımı çok yaygın olan bir design pattern’ dır. (tasarım deseni)
POM sayesinde kod tekrarı yapmayız ve kod maintenance (bakım) çok daha kolay olur. Page object model ile her sayfayı,
bir page class’ı ile ilişkilendiririz. Bu page classında da o sayfaya ait olan web elementler ve yine o sayfaya ait
metodlar yer alır. Böylece, bu sayfada herhangi bir elementin locator’ında değişiklik olduğu zaman, bunu ortak bir
yerden yönetebiliriz. Bu sayfada işlem yapan her testimizde element locator’unu tek tek değiştirmek yerine, tek bir
class’ta yapmış olduğumuz değişiklik ile maintenance çok daha kolay hale gelir.
Page object model olmadan testlerimizi yönetmek istediğimiz zaman çok daha fazla iş gücü harcıyoruz.
Peki POM bize neler sağlar ?
:small_blue_diamond: Kod tekrarı yapmaktan alıkoyar.
:small_blue_diamond: Testlerimizin bulunduğu sınıf ve elemanlarımızın olduğu sınıf ayrıdır. Değişiklik olduğu zaman,
tekrar eden elemanlarımız olmadığı için kod yönetimimiz kolaylaşır ve değişikliklere çok daha kolay adapte olabiliriz.
:small_blue_diamond: Metod isimlerimiz kullanıcının arayüzde yaptığı işlem ile uyumlu olmalıdır. Böylece kodumuz daha
anlaşılır olur.
:small_blue_diamond: Kodu yeniden kullanılabilir hale getirir. Örneğin birden fazla test metodumuz aynı elemanları
kullanıyorsa her birinde bu elemanı tekrar tekrar elde etmemize gerek kalmaz, bir page class’ında bu elemanı
tanımladığımız için, ileride bu elemanı kullanacak test metodları içinde kolaylık sağlanmış olur.
Page Factory, page object model uygulamanın bir yoludur. Page Factory kullanmamız için selenium webdriver,
PageFactory class ını bizlere sunar ve böylece @FindBy anotasyonu dünyamıza girer. Page içerisinde bulunan her bir
web elementi bu anotasyon ile page classımızda belirtilir. @FindBy kullanarak, elemanları findElement/s ile bulmamıza
gerek kalmaz ki bu da bize sağladığı yararlardan biridir. Page Factory classının bizlere sağladığı bir diğer metod ise
initElements metodudur ki bu metod ile sayfada bulunan web elementleri initialize edilir. Eğer istenen web elementi
DOM üzerinde yoksa, noSuchElementException Selenium exception fırlatılır.
 */
}
