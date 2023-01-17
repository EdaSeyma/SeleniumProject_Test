import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Base{
    public static void main(String[] args) throws InterruptedException {



        System.setProperty("webdriver.chrome.driver","C:\\Users\\90541\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("http://rahulshettyacademy.com/seleniumPractise/");

        String[] nameArray = {"Cucumber","Brocolli","Beetroot"};
        Thread.sleep(3000);
        addItems(driver,nameArray);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement((By.cssSelector("button.promoBtn"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement((By.cssSelector("span.promoInfo"))).getText());
        //explicit wait


        }
        @Test
    public static void addItems(WebDriver driver, String[] nameArray) {
        int j=0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size() ; i++) {
            String name = products.get(i).getText().split("-")[0].trim();

            List nameList = Arrays.asList(nameArray);

            if (nameList.contains(name)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == nameArray.length)
                    break;
            }
        }
    }
}
