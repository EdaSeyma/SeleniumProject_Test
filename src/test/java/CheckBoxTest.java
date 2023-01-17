import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CheckBoxTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\90541\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Count of check boxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        List<WebElement> options = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement option:options) {
                if(!option.isSelected()) {
                    option.click();
                    Assert.assertTrue(option.isSelected());
                    Thread.sleep(1000);
                    if(option.isSelected()){
                        option.click();
                        Assert.assertFalse(option.isSelected());
                    }
                }
        }
    }
}
