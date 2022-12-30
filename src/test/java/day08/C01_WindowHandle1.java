package day08;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilitles.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {
    @Test
    public void handleWindowTest() throws InterruptedException {

        //1.https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //ILK SAYFANIN ID'SINI ALALIM
        String window1Handle=driver.getWindowHandle();

        //2.Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String window1Test=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Test);//window1Test selenyumdan gelen gerçek değer

        //3.Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String window1title=driver.getTitle();
        Assert.assertEquals("The Internet",window1title);

        //4.Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        //==>BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECIS YAPMAK ISTIYORUM
        //==>BUNUN ICIN driver.etWindowHandles() ile TUM PENCERELERİN ID'LERİNİ ALALIM

        Set<String> allWindowHandles=driver.getWindowHandles();//{window1handle, window2handle}
        System.out.println(allWindowHandles);
        for(String eachHandle : allWindowHandles){  //=>eğer listedeki id window1 esit değilse,otomatik bir sonrakine esittir
            if(!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle);//buradaki eachHandle window2 handle'ına eşittir
                break;
            }
        }
                     //----->BU NOKTADA DRİVER 2. PENCEREDE


        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window",driver.getTitle());
//    Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3")).getText());

        String window2Handle=driver.getWindowHandle();

        //7.Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        Thread.sleep(3000);
        //1.windowa gecis yapıyorum
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());
        Thread.sleep(3000);
        //2.windowa tekrar gecelim
        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);
        //1.windowa tekrar gecelim
        driver.switchTo().window(window1Handle);

    }
}
