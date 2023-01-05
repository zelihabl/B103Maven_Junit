package utilitles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class  TestBase {


    //TestBase i abstract yapmamızın sebebi bu sınıfın objesini olusturmak istemiyorum
    //TestBase testBase=new TestBase();=>Yapılmaz
    //Amacım bu sınıfı extend etmek ve içindeki hazır methodları kullanmak

    //driver objesini olustur. Driver ya public yada protected olmalı.Sebebi child class'lardan görünsün
    protected  static WebDriver driver;


   //setUp
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    //tearDown
    @After
    public void tearDown(){

       // driver.close();
    }
    //    MULTIPLE WINDOW
    //==> Bu method nedir??
    //1 parametre alır:Gecis yapmak istediğim sayfanın title'ı
    //Ornek:switchToWindow("New Window");==>eğer acık olan pencerelerde "new window" title olan yere otomatik geciş yapacak
    //switchToWindow("The Internet);
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
        //==>Bu meethod ne??
    }
    public static void switchToWindow2(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
}
    public static WebElement findId(String key){   //team de

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(key)));
        return element;
    }
    public static WebElement findCss(String key){  //team de

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(key)));
        return element;
    }

    public static WebElement findXPath(String key){ //team de

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(key)));
        return element;
}


}
