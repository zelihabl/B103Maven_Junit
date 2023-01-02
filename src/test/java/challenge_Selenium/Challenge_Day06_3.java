package challenge_Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Challenge_Day06_3 {
    /*Arkadaşlar yetişemiyoz diyince bu sefer soru paylaşmak yerine sadece kod paylaşıyorum.
    Kod okumak,localine çekip run etmekte önemli. Dileyenler okuyabilir yada localine alıp
    run edebilir.
     */
    static WebDriver driver;
    public static void attack(){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        String script="javascript: (function() {\n" +
                "    function callback() {\n" +
                "        gremlins.createHorde({\n" +
                "            species: [gremlins.species.clicker(),gremlins.species.toucher(),gremlins.species.formFiller(),gremlins.species.scroller(),gremlins.species.typer()],\n" +
                "            mogwais: [gremlins.mogwais.alert(),gremlins.mogwais.fps(),gremlins.mogwais.gizmo()],\n" +
                "            strategies: [gremlins.strategies.distribution(),gremlins.strategies.allTogether(),gremlins.strategies.bySpecies()]\n" +
                "        }).unleash();\n" +
                "    }\n" +
                "    var s = document.createElement(\"script\");\n" +
                "    s.src = \"https://unpkg.com/gremlins.js\";\n" +
                "    if (s.addEventListener) {\n" +
                "        s.addEventListener(\"load\", callback, false);\n" +
                "    } else if (s.readyState) {\n" +
                "        s.onreadystatechange = callback;\n" +
                "    }\n" +
                "    document.body.appendChild(s);\n" +
                "    })()";
        js.executeAsyncScript(script);
    }
    public static void main(String[] args) {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");
        attack();
    }
}

