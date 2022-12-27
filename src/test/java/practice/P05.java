package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {


        //BeforeClass ile driver ı olusturun ve
        //Maximize edin, 15 sn bekletin
        //http://www.google.com adresine gidin
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        //AfterClass ile kapatın


    //BeforeClass ile driver ı olusturun ve
    //Maximize edin, 15 sn bekletin
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //http://www.google.com adresine gidin
    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");

    }

    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin

    @Test
    public void test01() {
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("The God Father", Keys.ENTER);

    }
    @After
    public void tearDown(){
        String [] sonuc =driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println(sonuc[1]);


    }
}
