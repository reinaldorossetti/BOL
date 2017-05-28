package pages;

import helpers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class AbstractPage {

    protected static WebDriver driver;

    public AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
    }

    public WebDriver navigateToWebSite() throws IOException {

        BasePage config = new BasePage();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to(config.getConfig("website"));
        driver.manage().deleteAllCookies();
        return driver;
    }

    public void closeDriver(){

        try {
            // function to close the browser
            driver.close();
            driver.quit();

        } catch (UnreachableBrowserException e) {
            System.out.println("cannot close browser: unreachable browser");
        }

    }

}