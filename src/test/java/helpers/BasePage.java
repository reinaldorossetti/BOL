package helpers;
/**
 * Classe BasePage vai conter as funcoes genericas e o tratamento delas.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage{

    WebDriver driver;

    public boolean sendKeys(WebDriver driver, String locator, String text) throws InterruptedException{

        Boolean test = false;
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try{

            WebElement myDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
            myDynamicElement.sendKeys(text);
            test = true;

        }catch (Exception e){
            System.out.println(e);
            System.out.println("Element not found!");

        }
        return test;

    }

    public Boolean clickElement(WebDriver driver, String locator) throws InterruptedException{

        Boolean test = false;
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try{

            WebElement myDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
            myDynamicElement.click();
            test = true;

        }catch (Exception e){
            System.out.println(e);
            System.out.println("Element not found!");

        }
        return test;

    }







}