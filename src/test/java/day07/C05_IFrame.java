package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilitles.TestBase;

public class C05_IFrame extends TestBase {
    @Test
    public void iframeTest() {

        //Iframe nedir?
        //User Story:
        //Sinif : IFrame

        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String anaMetin=driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();

        //tag[.='metin'];Bana bu tagli metni ver
        //tag[text()='metin'];

        String expectedText="black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim==>bu iframe yani sayfa içinde sayfa ve bunlar xpat
        //Applications lists elementi içinde,iframe switch yapmam sart(not)
        driver.switchTo().frame(0);//index 0 dan başlar,İlk iframe'e giriyoruz

        String icMetin=driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText1="Applications lists";
        Assert.assertEquals(expectedText1,icMetin);
        //veya Assert.assertTrue(expectedText1.contains(icMetin)); kullanılabilir
        //veya Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());

        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        //ana sayfadaki Povered By yazısını test etmek istiyorum ama driver hala iframein icinde
        //Iframein disina cikmak icin driver.switchTo().defaultContent/parentFrame
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));

        /*
        INTERVIEV SORULARI
        **BİR SAYFADAKİ TOPLAM IFRAME SAYISINI NASIL BULURUZ?
        driver.findElements(By.tagName("iframe"));
        driver.findElements(By.xpath("//iframe"));
        ==>iframe ler iframe tagi kullanılarak olsturulur.Bu durumda find elements by frame locatorini
         kullanarak tum iframeleri bulurum

        **TEKRAR ANA SAYFAYA NASIL DONERSIN?
        2 farklı yol vardır.
        DefaultContend yada parentFrame'e switch(geciş) yapabiliriz.

        **DefaultContend yada parentFrame ARASINDAKI FARKLAR NELER?
        Oncelikle her ikiside framin dışına çıkmamızı sağlar.Ama defaultContend direkt ana sayfaya atlatır,
        parentFrame ise bir üst seviyeye atlatır.

        **BİR TEST CASEIN FAIL ETME SEBEPLERİ NELER OLABİLİR?
        1.yanlış locator          ==>çözüm:Tekrar elementi locate etmek.Değişken element var ise
                                     ona gore dynamıc bir xpath yazarız

       2.Wait/Syncronization     ==>Çözüm:implicit wait de yeterli sure oldugundan emin oluruz.
                                     O süreyi arttırabiliriz.30 saniye verilebilir.Explicit wait kullanılabilir.

       3.Iframe                   ==>Çözüm:switch to iframe
       4.Alert                    ==>Çözüm:switch to alert
       5.New window(yeni pencere) ==>Çözüm:switch to alert

         */





    }
}
