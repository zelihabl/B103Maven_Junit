package practice_E;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilitles.TestBase;

public class P12_WindowHandle extends TestBase {
    @Test
    public void test01() {
        //Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindow=driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        String actualtitle=driver.getTitle();
        String arananKelimele="Amazon";
        Assert.assertTrue(actualtitle.contains(arananKelimele));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);//yeni bir sekme açmış olduk
        driver.get("https://techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitle1=driver.getTitle();
        String kelime="TECHPROEDUCATION";
        Assert.assertFalse(actualTitle1.contains(kelime));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");
        //Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitle2=driver.getTitle();
        String kelime2="Walmart";
        Assert.assertTrue(actualTitle2.contains(kelime2));
        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindow);
        String actualUrl=driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals("https://www.amazon.com/",actualUrl);


    }
}
