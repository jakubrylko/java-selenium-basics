import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zad12 {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addEmployee() {
        driver.get(" https://opensource-demo.orangehrmlive.com");

        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        usernameField.sendKeys("Admin");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        passwordField.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        loginButton.click();

        WebElement pimTab = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
        pimTab.click();

        WebElement addEmployeeButton = driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]"));
        addEmployeeButton.click();

        WebElement firstNameField = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstNameField.sendKeys("Keanu");

        WebElement middleNameField = driver.findElement(By.xpath("//*[@id=\"middleName\"]"));
        middleNameField.sendKeys("Charles");

        WebElement lastNameField = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastNameField.sendKeys("Reeves");

        WebElement employeeIdField = driver.findElement(By.xpath("//*[@id=\"employeeId\"]"));
        employeeIdField.clear();
        employeeIdField.sendKeys("680");

        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
        saveButton.submit();

        WebElement personalDetails = driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1"));
        String personalDetailsString = personalDetails.getText();

        WebElement userFirstName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"));
        WebElement userMiddleName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpMiddleName\"]"));
        WebElement userLastName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpLastName\"]"));

        Assertions.assertEquals("Personal Details", personalDetailsString);
        Assertions.assertEquals("Keanu", userFirstName.getAttribute("value"));
        Assertions.assertEquals("Charles", userMiddleName.getAttribute("value"));
        Assertions.assertEquals("Reeves", userLastName.getAttribute("value"));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}