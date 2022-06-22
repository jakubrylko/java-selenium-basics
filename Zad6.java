import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zad6 {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com");

        WebElement username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();

        Assertions.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/dashboard", currentUrl);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
