import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zad7 {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void wrongCredentials() {
        driver.get("https://opensource-demo.orangehrmlive.com");

        WebElement username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        username.sendKeys("WrongUsername");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        password.sendKeys("WrongPassword");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        loginButton.click();

        WebElement invalidCredentials = driver.findElement(By.xpath("//*[@id=\"spanMessage\"]"));
        String invalidCredentialsText = invalidCredentials.getText();

        Assertions.assertEquals("Invalid credentials", invalidCredentialsText);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
