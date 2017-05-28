package tests_case;

import helpers.BasePage;
import helpers.Browsers;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class AccessEmail {

    public static void main(String[] args) throws InterruptedException, IOException {

        LocalDateTime now = LocalDateTime.now();
        BasePage base = new BasePage();
        Browsers browser = new Browsers();
        WebDriver driver = null;
        driver = Browsers.setBrowser("chrome");

        driver.get("http://www.bol.com.br/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.switchTo().defaultContent();

        base.sendKeys(driver, ".mod-header-login-user", "ccatalani");

        base.sendKeys(driver, ".mod-header-login-pass", "Mudar$123");

        base.clickElement(driver, "button.mod-header-login-button");

        base.clickElement(driver, ".bt-write");

        base.sendKeys(driver, "#fake_input__field-to", "ccatalani@bol.com.br");

        base.sendKeys(driver, "#field-subject", "Teste de Envio "+ now);

        base.clickElement(driver, "menu.bt-compose-send.highlight span");

        driver.close();

    }
}
