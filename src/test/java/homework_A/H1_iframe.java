package homework_A;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

import java.util.List;


public class H1_iframe extends TestBase {

    @Test
    public void Test01() {


//        Bir class olusturun: IframeOdev
//        +https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

//        +sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframes.size() = " + iframes.size());

//        +Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String baslik=driver.findElement(By.xpath("//*[@class='example']//h3")).getText();
        Assert.assertTrue(baslik.contains("Editor"));
//        +Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement text=driver.findElement(By.xpath("//*[@id='tinymce']//p"));
        text.clear();
//        +Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        text.sendKeys("iframe içindeyim");
//        +Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().parentFrame();
        String yazi=driver.findElement(By.xpath("//*[@class='no-js']")).getText();
        Assert.assertTrue(yazi.contains("Elemental Selenium"));
//






    }
}


