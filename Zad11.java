import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zad11 {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchJob() throws Exception {
        driver.get("https://www.praca.pl");

        WebElement searchJob = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/form/div[1]/div/input"));
        searchJob.sendKeys("Tester");

        WebElement searchCity = driver.findElement(By.xpath("//*[@id=\"placeParent\"]/input"));
        searchCity.sendKeys("Warszawa");

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/form/button"));
        searchButton.submit();

        List<WebElement> offersList = driver.findElements(By.className("listing__item"));

        for(int i=0; i<offersList.size(); i++){
            String jobTitle = offersList.get(i).findElement(By.className("listing__title")).getText();
            String employerName = offersList.get(i).findElement(By.cssSelector("a.listing__employer-name")).getText();
            System.out.println(i + ". " + employerName + " - " +  jobTitle);
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
