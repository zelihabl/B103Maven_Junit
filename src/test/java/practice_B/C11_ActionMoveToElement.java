package practice_B;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilitles.TestBase;

public class C11_ActionMoveToElement extends TestBase {
    @Test
    public void Test01() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com ");

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='icp-nav-flyout']"))).perform();

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[@class='icp-mkt-change-lnk'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement dropmenu=driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select=new Select(dropmenu);
        select.selectByVisibleText("Turkey (Türkiye)");
        driver.findElement(By.xpath("//*[text()='Changing country/region website']")).click();

        // Go to website butonuna tiklayiniz
       driver.findElement(By.xpath("//*[@class='a-button-input']")).click(); // boş bir yere click yaptık dropdown kapansın diye


        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        String title=driver.getTitle();
        Assert.assertFalse(title.contains("Elektronik "));
    }
}
