import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class WindowHandles {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\90541\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("http://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
        Set<String> windows = driver.getWindowHandles();//[parentid,childid]
        Iterator<String> iterators = windows.iterator();
        String parentId=iterators.next();
        String childId=iterators.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String[] arr =driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ");
        String mailAdress="";
        for (int i = 0; i <arr.length; i++) {
            if(arr[i].contains("@")){
                mailAdress=arr[i];
                System.out.println(mailAdress);
            }
            driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(mailAdress);
        driver.findElement(By.id(("password"))).sendKeys();


        }






    }
}
