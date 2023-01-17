import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\90541\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all webelements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

        //capture text of all webelements into new(original ) list
        List<String> originalList=elementList.stream().map(s->s.getText()).collect(Collectors.toList());

        //sort on the original list of step -> sorted list
        List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));
        List<String> price;
       do {
           List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

           price= rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
           price.forEach(s-> System.out.println(s));
           if(price.size()<1){
               driver.findElement(By.cssSelector("a[aria-label='Next']")).click();

           }
       }while (price.size()<1);

    }
    public static String getPriceVeggie(WebElement s){
        String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
