package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*
assertTrue(True)--->Passed
assertTrue(False)--->Failed

assertFalse(False)--->Passed
assertFalse(True)--->Failed
 */

public class C07_Assertion {
   WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @After
    public void tearDown() {
        driver.close();
    }
    //https://www.amazon.com adresine gidin
    //Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //=> Sayfa başlığının “amazon” oldugunu test edin
    //=> Amazon resminin görüntülendiğini (isDisplayed()) test edin
    //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //wrongTitleTest  => Sayfa basliginin “amazon” olmadigini dogrulayin


    //=> Sayfa başlığının “Amazon” oldugunu test edin
    @Test
    public void test01(){

        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    //=> Amazon resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void test02(){
        WebElement sayfaResmi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }

    //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void test03(){
        WebElement searchBox=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    //wrongTitleTest  => Sayfa basliginin “amazon” olmadigini dogrulayin
    @Test
    public void test04(){
        String actualTitle=driver.getTitle();
        String expectedTitle="amazon"; //Küçük harf olduğu için yanlış
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

}
