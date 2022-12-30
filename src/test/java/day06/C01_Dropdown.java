package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    WebDriver driver;

    //Eger test sınıfında birden fazla method oluşturulmuşsa,@Before kullanılır

    //before her methoddan önce ,befaore class sadece en başta kullanılır.

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown ");

    }

    @Test
    public void selectByIndexTest() {
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        // Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10


        //1. LOCATE DROPDOWN element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        //2.Select objesi olustur
        Select yearDropdown = new Select(year);

        //3.Select object'i kullanarak 3 farklı sekilde secim yapabilirim
        yearDropdown.selectByIndex(22);//SECENEK SIRASI 0'DAN BAŞLAR.2000 yılı 23.sırada

        //Ay secimi
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0"); //option in value degeri ile secim yapılabilir.January seceneğinin value si 0

        //Gun secimi selectByVisibleTest
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10");
    }

    @Test
    public void printAllTest() {


        // Tum eyalet isimlerini consola yazdır

        WebElement state = driver.findElement(By.xpath("//select[@id='state']")); //ilk locate al
        Select stateDropdown = new Select(state);//obje olustur
        List<WebElement> stateList = stateDropdown.getOptions();
        //tumStateList.stream().forEach(t-> System.out.println("t"+" ")); ==>lambda ile cozumu
        for (WebElement eachState : stateList) {
            System.out.println(eachState.getText());
        }
    }
    @Test
    public void getSelectOptionsTest(){
      //State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state =driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown=new Select(state);

        String varsayilanText =stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals("Select a State", varsayilanText);

    }
    @After
    public void tearDown(){
        driver.close();
    }








       /*
    1.What is dropdown? Dropdown nedir?
    Dropdown liste olıuşturmak icin kullanılır

    2.How to handle dropdown elements? Dropdown nasıl automate edilir?

    1.dropdown i locate ederim.8 locatorden biri
    2.select objesi i olustururum
    3.select objesi ile istediğim seceneği secerim
    selectByındex(int)==>çok tercih edilmez
    selectByValue("String")==>
    selectByVisible("string")==>genel tercih

***getOptions();tüm dropdown secenekleri List<WebElement> olarak return eder
***getFirstSelectOption() secili olan seceneği return eder


    NOT:select objesi olusturma nedenim, dropdownların Select classı ile olusturulması

    3.Tum dropdown seceneklerini nasıl print ederiz? How to print all dropdown options on the console?
    -tum dropdown elementlerini getOptions() methodu ile listeye koyarız
    -sonra secekleri loop ile yazdırabiliriz

    4.Bir seceneğin secili oldugunu otomate etmek icin ne yapılır?
    ORNEK:Gun olarak 10'ı sectik ama ya secilmediyse?
    getFirstSelectOption() secili olan seceneği return eder



       */
    }

