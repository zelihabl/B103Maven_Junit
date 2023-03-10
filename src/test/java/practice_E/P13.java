package practice_E;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilitles.TestBase;

public class P13 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String ilkWindow=driver.getWindowHandle();
        //    - youtube videosunu çalıştırınız
        WebElement iframe=driver.findElement(By.xpath("//*[@class=\"render\"]/iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();
        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //    - iphone aratınız
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String[] aramaSonucu=driver.findElement
                (By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ");
        System.out.println("Arama Sonuc Sayısı= " +aramaSonucu[2]);
        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkWindow);
        System.out.println("ilk window url = " + driver.getCurrentUrl());
        //    - ilk sekmeyi kapatalım
        driver.close();
        //    - Sonra diğer sekmeyide kapatalım
        //==>TestBase'deki @After notasyonu çalışacak bu kısımda

    }
}
