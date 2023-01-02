package challenge_Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Challenge_Day05 {
    public static void main(String[] args) {

        // ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        //    ~ click on Phones & PDAs

        //    ~ get the brandName of phones
        //    ~ click on add to button for all elements
        //    ~ click on black total added cart button
        //    ~ get the names of list from the cart
        //    ~ compare the names from displaying list and cart list
        //     */

    /*

Not:soruyu methodlar olusturarak yaparsaniz daha guzel olur..
clickAllElements
getName
compareTwoList
     */
    }
}
