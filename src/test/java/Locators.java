import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    //ID
    //Xpath
    //CSS Selector
    //name
    //Class Name
    //Tag Name
    //Link Text
    //Partial Link Text
    //tagname

    // You should not have spaces with class names, remove the space and provide the dot
    /**CSS Selector-
    1-Class name -> tagname.classname -> Button.signInBtn -> p.error
    2-Id -> tagname#id -> input#inputUsername
    3-Tagname[attribute='value'] -> Input[placeholder='Username']
    4-//Tagname[@attribute='value']:nth-child(index)-> Input[placeholder='Username']
    5-.classname
    6- //parentTagname childTagname
    7- #classNamevalue
    8- input[type*='pass']
     **/

    /** Xpath
     //Tagname[@attribute='value'] -> input[@placeholder='Username']
     //Tagname[@attribute='value'][index] -> input[@placeholder='Username']
     //parentTagname/childTagname
     //button[contains(@class,'submit')] -regular expression
     //header/div/button[1]/following-sibling::button[1]
     //header/div/button[1]/parent::div
     -**/
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\90541\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Eda");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector(("p.error"))).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement((By.xpath("//input[@placeholder='Name']"))).sendKeys("edaa");
        driver.findElement((By.cssSelector("input[placeholder='Email']"))).sendKeys("eda@gmail.com");
        driver.findElement((By.xpath("//input[@type='text'][2]"))).clear();
        driver.findElement((By.cssSelector("input[type='text']:nth-child(3)"))).sendKeys("eda123@gmail.com");
        driver.findElement((By.xpath("//form/input[3]"))).sendKeys("454524524");
        driver.findElement((By.cssSelector(".reset-pwd-btn"))).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(("rahul"));
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(("rahulshettyacademy"));
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();

    }
}
