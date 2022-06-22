import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zad10 {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkAcademyPosition() {
        driver.get("https://google.com");

        WebElement agreement = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
        agreement.click();

        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchBar.sendKeys("Software Development Academy", Keys.ENTER);

        List<WebElement> allLinks = driver.findElements(By.tagName("cite"));
        String firstResult = allLinks.get(0).getText();
        System.out.println("First result: " + firstResult);

        Assertions.assertEquals("https://sdacademy.pl", firstResult);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}