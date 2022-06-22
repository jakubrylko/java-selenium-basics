import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zad4 {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void getTitle() {
        driver.get("https://stackoverflow.com");
        System.out.println(driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
