package practice_E;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitles.TestBase;

public class P19_Actions extends TestBase {
    @Test
    public void test01() {

        // -http://spicejet.com/ sayfasına gidelim
        driver.get("https://spicejet.com/");


        // -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement aboutUs=driver.findElement(By.xpath("//*[text()='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        driver.findElement(By.xpath("//*[text()='Fleet']")).click();


        // -Sayfa başlığının Fleet içerdiğini test edelim

    }
}
