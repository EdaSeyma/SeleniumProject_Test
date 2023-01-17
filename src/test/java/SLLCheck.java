import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SLLCheck {
    public static void main(String[] args) {
        //  https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();
        Proxy proxy=new Proxy();
        proxy.setHttpProxy("ipadress:4444");
        options.setCapability("proxy",proxy );
        System.setProperty("webdriver.chrome.driver","C:\\Users\\90541\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}

