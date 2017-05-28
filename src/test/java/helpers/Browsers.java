package helpers;

/**
 * Classe browser vai instanciar o driver e aplicar as configuracoes necessarias.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class Browsers {



    public static WebDriver setBrowser(String Browser) throws IOException, InterruptedException{

        // Testes feitos no Firefox e Chrome
        WebDriver driver = null;

        if(Browser.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\win64\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (Browser.equalsIgnoreCase("Firefox"))
        {

            System.setProperty("webdriver.gecko.driver","C:\\drivers\\win64\\geckodriver.exe");

            //Tratando os erros de log para marionette
            DesiredCapabilities caps = new FirefoxOptions()
                    .setProfile(new FirefoxProfile())
                    .addTo(DesiredCapabilities.firefox());
            caps.setCapability("acceptInsecureCerts", true);
            caps.setCapability("marionette", true);
            driver = new FirefoxDriver(caps);

        }

        else if (Browser.equalsIgnoreCase("IE"))
        {
            driver = new InternetExplorerDriver();
        }

        return driver;

    }


}
