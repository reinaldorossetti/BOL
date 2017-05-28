package helpers;

/**
 * Created by reiload on 28/05/2017.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.AbstractPage;

import java.io.IOException;

public class Browsers extends AbstractPage {


    public Browsers(WebDriver driver) {
        super(driver);
    }


    public static WebDriver setBrowser(String Browser) throws IOException, InterruptedException{

        // Testes feitos no Firefox e Chrome

        if(Browser.equalsIgnoreCase("Chrome"))
        {
            driver = new ChromeDriver();

        } else if (Browser.equalsIgnoreCase("Firefox"))
        {

            driver = new FirefoxDriver();

        }

        else if (Browser.equalsIgnoreCase("IE"))
        {
            driver = new InternetExplorerDriver();
        }

        AbstractPage landingPage = new AbstractPage(driver);
        landingPage.navigateToWebSite();
        return driver;

    }


}