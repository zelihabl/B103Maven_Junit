package practice_E;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitles.TestBase;

public class P17_Actions extends TestBase {
    /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */

    @Test
    public void test01() {

 //   http://uitestpractice.com/Students/Actions adresine gidelim
      driver.get(" http://uitestpractice.com/Students/Actions");
 //   Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement maviKutu=driver.findElement(By.xpath("//*[@id='div2']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(maviKutu).perform();
        waitFor(3);

 //   Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleClicked=driver.findElement(By.xpath("//*[@name='dblClick']"));
        actions.doubleClick(doubleClicked).perform();
        Assert.assertEquals( "Double Clicked !!",driver.switchTo().alert().getText());

        //   Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

 //   Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
       WebElement drag= driver.findElement(By.xpath("//*[text()='Drag me to my target']"));
       WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
       actions.dragAndDrop(drag,drop).release().perform();//release burda çok gerekli değil zaten draganddrop tutup bırakıyor
         Assert.assertEquals("Dropped!", drop.getText());
         //Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());==>hocanın kontrolü



    }
}
