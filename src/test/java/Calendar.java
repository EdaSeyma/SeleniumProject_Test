import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\90541\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
        while (!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("April")){
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
            Thread.sleep(1000L);
        }

        List<WebElement> listOfDate=driver.findElements(By.className("flatpickr-day"));
        int count=driver.findElements(By.className("flatpickr-day")).size();

        for (int i = 0; i <count ; i++) {
            String text=driver.findElements(By.className("flatpickr-day")).get(i).getText();
            if(text.equalsIgnoreCase("26")){
                driver.findElements(By.className("flatpickr-day")).get(i).click();
                break;
            }


        }
    }
}
