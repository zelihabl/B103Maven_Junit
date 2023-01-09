package practice_E.day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitles.TestBase;

import java.security.Key;

public class C01_Actions1 extends TestBase {
    @Test
    public void keyboardActions() {
        //relese()Basılı tuşu bırakır,Click and hold gibi actionlardan sonra  release.(mause) //Klavye keyUp

        //Create a method keyboardActions
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        WebElement aramaKutusu=driver.findElement(By.name("q"));
        //aramaKutusu.sendKeys("iphone x fiyatları"+ Keys.ENTER);

        Actions actions=new Actions(driver);
        actions
                .keyDown(aramaKutusu,Keys.SHIFT)//arama kutusunun ustunde Shift bas
                .sendKeys("iphone x fiyatlari")//shifte basiliyken yaz
                .keyUp(Keys.SHIFT)//shift'e basmayi birak
                .sendKeys(" cok pahali" + Keys.ENTER)//normal halde yaz ve Enter tusuna bas
                .build()//birden fazla işlem yapıldıysa
                .perform();

        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas
    }
}
