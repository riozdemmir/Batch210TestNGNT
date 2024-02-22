package techproed.tests.day23_pom_excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C02_ExcelTest {
    @Test
    public void test01() {

        String dosyaYolu="src/test/java/techproed/resources/adminTestData.xlsx";
        String sayfaIsmi="customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);
        String email = reader.getCellData(0,0);
        String password = reader.getCellData(0,1);
        System.out.println("email = " + email);
        System.out.println("password = " + password);


    }
}
