package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;


public class Task2 {

    private WebDriver driver;

    private void setupDriver() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
    }

    private void clickCheckBox() {

        WebElement checkBox = driver.findElement(By.cssSelector("a[href='/checkboxes']"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkBox.click();

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox' and following-sibling::text()=' checkbox 1']"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        Task2 myTask = new Task2();

        try {
            myTask.setupDriver();
            myTask.clickCheckBox();

        } finally {
            myTask.teardownDriver();
            System.out.println("sup");
        }
    }
}

