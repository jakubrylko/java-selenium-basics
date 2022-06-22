import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Zad8 {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void findElements() {
        driver.get("https://www.bbc.com");

        List<WebElement> allImages = driver.findElements(By.tagName("img"));
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("Images number: " + allImages.size());
        System.out.println("Links number: " + allLinks.size());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
