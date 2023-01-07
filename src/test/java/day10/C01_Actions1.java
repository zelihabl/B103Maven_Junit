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
         Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
         //Tamam diyerek alert’i kapatın
         driver.switchTo().alert().accept();


    }
    }

