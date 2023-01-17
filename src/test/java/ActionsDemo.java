import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\90541\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);
        WebElement move=driver.findElement(By.cssSelector("[id='nav-link-accountList']"));
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT ).sendKeys("hello kitty").doubleClick().build().perform();
            //right click
        action.moveToElement(move).contextClick().build().perform();
        action.moveToElement(move).clickAndHold().build().perform();

    }
}
