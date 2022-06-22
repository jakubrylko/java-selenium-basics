import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zad5 {

    WebDriver driver;

    @Before
    public void setUp () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void getTitleAssertion() {
        driver.get("https://stackoverflow.com");
        String getTitle = driver.getTitle();

        Assertions.assertEquals("Stack Overflow - Where Developers Learn, Share, & Build Careers", getTitle);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
