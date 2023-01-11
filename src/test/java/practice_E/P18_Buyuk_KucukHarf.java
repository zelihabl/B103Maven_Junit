package practice_E;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

public class P18_Buyuk_KucukHarf extends TestBase {
    @Test
    public void name() {
        //google sayfasina gidelim
        driver.get("https://www.google.com");
        WebElement searchBox=driver.findElement(By.name("q"));
        //Buyuk kucuk harf olucak sekilde "HeLlO" yazdiralim
        searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);

    }
}
