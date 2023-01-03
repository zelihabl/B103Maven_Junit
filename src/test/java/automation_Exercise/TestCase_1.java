package automation_Exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase_1 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//Test Case 1: Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        driver.get("http://automationexercise.com");
        String actualTitle=driver.getTitle();
        if (actualTitle.equals("Automation Exercise")){
            System.out.println("Passed");
        }else System.out.println("Failed");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        if (driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed()) {
            System.out.println("Doğrudur Gördük");
        }else System.out.println("Nayır!!!Göremiyorum");

        //6. Enter name and email address
        //7. Click 'Signup' button
        WebElement nameButonu=driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        nameButonu.sendKeys("Zeliha", Keys.TAB,"zelihaa98@gmail.com",Keys.TAB,Keys.ENTER);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        if (driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed()) {
            System.out.println("Enter Account Görünür !");
        }else System.out.println("Enter Account Görünmedi !!!");
        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement cinsiyet=driver.findElement(By.id("id_gender2"));
        cinsiyet.sendKeys(Keys.SPACE,Keys.TAB,Keys.TAB,"1234",Keys.TAB,"30",Keys.TAB,"June",Keys.TAB,"1991",
                Keys.TAB,Keys.SPACE,Keys.TAB,Keys.SPACE);

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement adress=driver.findElement(By.xpath("//*[@name='first_name']"));
        adress.sendKeys("Zeliha",Keys.TAB,"Balık",Keys.TAB,"ZB",Keys.TAB,"Kırklareli",Keys.TAB,"Merkez");

        WebElement country=driver.findElement(By.xpath("//*[@id='country']"));
        Select ulke=new Select(country);
        ulke.selectByIndex(1);
        Thread.sleep(3000);

        //13. Click 'Create Account button'
        country.sendKeys( Keys.TAB,"Merkez",Keys.TAB,"Kayseri",Keys.TAB,"39000",Keys.TAB,"054647847",Keys.ENTER);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        if(driver.findElement(By.xpath("//*[@class='header-middle']")).isDisplayed()){
            System.out.println("ACCOUNT CREATED!");
        }else System.out.println("yanlışşşş");
//ALERTTTTT
        //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        //16. Verify that 'Logged in as username' is visible

        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue button
    }
}



