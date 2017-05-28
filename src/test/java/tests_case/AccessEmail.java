package tests_case;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


public class AccessEmail {

	public static void main(String[] args) throws InterruptedException {
		
		LocalDateTime now = LocalDateTime.now();

		int timeout = 5000;

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.bol.com.br/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


		WebElement myUser = (new WebDriverWait(driver, timeout))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.name("user")));
		System.out.println(myUser.getText());
		myUser.sendKeys("ccatalani");

		WebElement myPassword = (new WebDriverWait(driver, timeout))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));

		myPassword.sendKeys("Mudar$123");

		WebElement lgnBtn = (new WebDriverWait(driver, timeout))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.mod-header-login-button")));
		lgnBtn.click();


		WebElement btnEscrever = (new WebDriverWait(driver, timeout))
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("bt-write")));
		btnEscrever.click();


		WebElement mailTo = (new WebDriverWait(driver, timeout))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("fake_input__field-to")));
		mailTo.sendKeys("ccatalani@bol.com.br");

		WebElement fldSbj = (new WebDriverWait(driver, timeout))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("field-subject")));
		fldSbj.sendKeys("Teste de Envio "+ now);


		WebElement button_send = (new WebDriverWait(driver, timeout))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("menu.bt-compose-send.highlight span")));
		System.out.println(button_send.getText());
		button_send.click();


		driver.close();
			  
	  
		
	}

}
