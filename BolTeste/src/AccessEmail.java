import java.time.LocalDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccessEmail {

	public static void main(String[] args) throws InterruptedException {
		
		LocalDateTime now = LocalDateTime.now(); 
		
		//Com o selenium 3.4.X o firefox abre somente com o geckodriver.exe e tem que adicionar a variável ao path do windows
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Cinthia\\Documents\\APRENDIZADO AUTOMAÇÃO TESTE\\SELENIUM\\geckodriver.exe");

		//Tratando os erros de log para marionette
		DesiredCapabilities caps = new FirefoxOptions()
				.setProfile(new FirefoxProfile())
				.addTo(DesiredCapabilities.firefox());
			caps.setCapability("acceptInsecureCerts", true);
			caps.setCapability("marionette", true);
		
			//Execução do teste bol
			WebDriver driver = new FirefoxDriver(caps);
	        driver.get("http://www.bol.com.br/");
	        
	        WebElement myUser = (new WebDriverWait(driver, 300))
	        		  .until(ExpectedConditions.presenceOfElementLocated(By.name("user")));
	        myUser.sendKeys("ccatalani");
	        
	        WebElement myPassword = (new WebDriverWait(driver, 30))
	        		  .until(ExpectedConditions.presenceOfElementLocated(By.name("pass")));
	        myPassword.sendKeys("Mudar$123");
	        
	        WebElement lgnBtn = (new WebDriverWait(driver, 300))
	        		  .until(ExpectedConditions.presenceOfElementLocated(By.className("mod-header-login-button")));
	        lgnBtn.click();
	        
			  // Ele demora para carregar a pagina e nunca acha o botao, mesmo assim eu resolvi procurar por classe
			  // Por classe ficou melhor essa classe bt-write garante um nível de assertividade maior
			  Thread.sleep(13000);

			  WebElement btnEscrever = driver.findElement(By.className("bt-write"));
			  btnEscrever.click();
		      Thread.sleep(3000);

		        WebElement mailTo = (new WebDriverWait(driver, 3000))
		        		  .until(ExpectedConditions.presenceOfElementLocated(By.id("fake_input__field-to")));
		        mailTo.sendKeys("ccatalani@bol.com.br");  
		      
		        WebElement fldSbj = (new WebDriverWait(driver, 3000))
		        		  .until(ExpectedConditions.presenceOfElementLocated(By.id("field-subject")));
		        fldSbj.sendKeys("Teste de Envio "+ now);  
			  
/*		        driver.findElement(By.id("field-subject")).sendKeys("Teste de Envio "+ now);*/
			 
			  Thread.sleep(15000);
			  			  driver.findElement(By.cssSelector(".bt-compose-send")).click();			  
			  Thread.sleep(6000);
			  
			 /* driver.findElement(By.className("bt-compose-send highlight")).click();*/
			  // depois troca o Thread Sleeo por Waits Implicitos que fica melhor, segundo reinal, melhor usar explicit, pois é o tempo por objeto e não precisa determinar tempo
			  
			  
			  /*  WebElement element= driver.findElement(By.cssSelector(".bt-write.btn-color-1.ng-scope"));

			// Configure the Action
			Actions action = new Actions(driver);

			//Focus to element
			action.moveToElement(element).perform();

			// To click on the element
			action.moveToElement(element).click().perform();
			  
					  
			  /*  WebElement menuButton = driver.findElement(By
	                    .className("onComposeNew($event)"));
	            menuButton.click();*/
			  
			
			
			  /*driver.findElement(By.cssSelector("bt-write btn-color-1 ng-scope")).click();
			  driver.findElement(By.className("bt-write btn-color-1 ng-scope")).click();*/

			 
			  
			/*  driver.close();*/
			  
	  
		
	}

}
