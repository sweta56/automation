package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;



public class Task {

    private WebDriver driver;

    private void setupDriver() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private void clickBasicAuthLink() {
        driver.get("https://the-internet.herokuapp.com");

        WebElement basicAuthLink = driver.findElement(By.cssSelector("a[href='/basic_auth']"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basicAuthLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("admin");
        alert.sendKeys("\t");
        alert.sendKeys("admin");
        alert.accept();
    }

    private void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        Task myTask = new Task();

        try {
            myTask.setupDriver();

            myTask.clickBasicAuthLink();

        } finally {
            myTask.teardownDriver();
            System.out.println("sup");
        }
    }
}

