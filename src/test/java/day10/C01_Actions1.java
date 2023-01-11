package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitles.TestBase;

import javax.swing.*;

public class C01_Actions1 extends TestBase {
    /*
    INTERVIEW SORULARIII
    1- Actions nedir?
*Actions selenium dan gelen bir kütüphanedir. Mouse ve Keyboard
işlemlerini gerçekleştirmek icin kullandigimiz hazır bir
selenium kütüphanesidir. Ornegin, sag tiklqmqk(contextClick) ,
çift tıklamak(doub1eClick), elementin uzerine
gitmek(moveToElement) gibi mouse işlemlerini
gerçekleştirebiliriz. Ayni zamanda, shift, control, delete,
enter gibi keyboard tuşlar.inada actions yardımıyla basabiliriz.
Bu tur işlemlerde sendKeys metodu kullanilir
     */

            /*
         1.Adım: Actions class’ta bir object oluşturulur.
         Actions actions= new Actions(driver);

         2. Adım: Üzerinde çalışmak istediğiniz WebElement
         Öğesini bulunur.

         WebElement element = driver.findElement(locator);
         3.Adim : perform() kullanarak bu webelement üzerinde action gerçekleştirilir.
     */
     @Test
    public void rightClick(){
         //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //1.ADIM ACTİONS OBJESİ OLUSTUR
        Actions actions=new Actions(driver);

        //2.ADIM ELEMENT LOCAT EDELİM
        WebElement kutu =driver.findElement(By.id("hot-spot"));
        //Kutuya sag tıklayın
        actions.contextClick(kutu).perform();

         //Alert’te cikan yazinin “You selected a context menu” oldugunu

         //**object olusturmak wait durumlarda makuk
         Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
         //Tamam diyerek alert’i kapatın
         driver.switchTo().alert().accept();
         /*
         INTERVIEW SORULARIII
         2- Ne tür methodlar kullandin?
      Actions methodlari önemlidir. o yüzden ve tekrar kullanmam gerektiginden, Actions method lari iceren
     Reusable methodlari olusturdum ve gerektiginde bu Reusable metholdari kullaniyorum.
      örnegin; rightClick methodunu bir elemente saga tiklamak icin test classimda cagirabilirim

      3- Hangi methodlari kullandin ne ne ise yarar?
    Ornegin, sag tiklamak(contextClick), çift tıklamak(doubleClick), elementin uzerine gitmek(moveToElement)
    gibi mouse islemlerini gerçekleştirebiliriz. Ayni zamanda, shift, control, delete,
    enter gibi keyboard tuslarinada actions yardımıyla basabiliriz.
    Bu tur islemlerde sendKeys metodu kullaninir.
          */


    }
    }

