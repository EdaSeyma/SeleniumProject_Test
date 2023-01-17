import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class e2e {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\90541\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='COK']")).click();
       // Calismiyor driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        driver.findElement(By.id("familyandfriend")).click();
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 0; i <4 ; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        //driver.findElement(By.id("btnclosepaxoption")).click();
        driver.findElement(By.id("divpaxinfo")).click();

        // driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
        //driver.findElement(By.cssSelector("input[value='Search']")).click();
        // driver.findElement(By.xpath("//input[@value='Search']")).click();
        // driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }
}
