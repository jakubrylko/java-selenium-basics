import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zad9 {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void javaSearch() {
        driver.get("https://google.com");

        WebElement agreement = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
        agreement.click();

        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchBar.sendKeys("Java");

        WebElement googleSearch = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
        googleSearch.submit();

        List<WebElement> allLinks = driver.findElements(By.tagName("cite"));
        System.out.println("Links number: " + allLinks.size());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
