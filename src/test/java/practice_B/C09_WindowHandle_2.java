package practice_B;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilitles.TestBase;

public class C09_WindowHandle_2 extends TestBase {
    @Test
    public void Test01() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String handle1=driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String url= driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        // 4- title'in 'Best Buy' icerdigini test edelim
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Best Buy"));
        String handle2=driver.getWindowHandle();

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(handle1);
       WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
               aramaKutusu.sendKeys("java", Keys.ENTER);

        // 6- arama sonuclarının 'java' icerdigini test edelim
        String baslik=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(baslik.contains("java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(handle2);

        // 8- logonun gorundugunu test edelim
        WebElement logo=driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());









    }
}
