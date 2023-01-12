package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilitles.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {
    @Test
    public void fileDownloadTest() {
        //Class : FileDownloadTest Method : downloadTestExist
       //1)https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download ");

       //2)b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitFor(3);
        //driver.findElement(By.partialLinkText(""))
        String filePath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";

        //String filePath = System.getProperty("user.home")+"\\Downloads\\b10 all test cases, code.docx";==>üstteki çalışmazsa garanti

        //3)Dosyanın başarıyla indirilip indirilmediğini test edelim
        boolean indirildimi = Files.exists(Paths.get(filePath));
        Assert.assertTrue(indirildimi);

    }
}
