package challenge_Selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

public class Challenge_Day03 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();

       //  3. Login alanine  "username" yazdirin
       driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username");
       // Password alanine "password" yazdirin
       driver.findElement(By.cssSelector("input[id='user_password']")).sendKeys("password");

       // 5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
        waitFor(3);
        driver.navigate().back();

       // 6. Online Banking menusunden Pay Bills sayfasina gidin
       driver.findElement(By.cssSelector("a[id='online-banking']")).click();

       driver.findElement(By.cssSelector("span[id='pay_bills_link']")).click();

       // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
       driver.findElement(By.cssSelector("input[id='sp_amount']")).sendKeys("1000");
       waitFor(3);

       // 8. tarih kismina "2020-09-10" yazdirin
       driver.findElement(By.cssSelector("input[id='sp_date']")).sendKeys("2020-09-10");
       waitFor(3);

       // 9. Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
       waitFor(3);

        //10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
        assert driver.findElement(By.cssSelector("div[class='alert alert-success hide']")).isDisplayed();
    }
       }





    /*
    Day03_Challenge(cssSelector ile çözünüz.)

1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine  "username" yazdirin
4. Password alanine "password" yazdirin
5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
6. Online Banking menusunden Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina "2020-09-10" yazdirin
9. Pay buttonuna tiklayin
10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
*/


