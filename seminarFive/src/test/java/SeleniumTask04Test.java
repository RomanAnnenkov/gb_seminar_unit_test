import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SeleniumTask04Test {
    @Test
    public void browserTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ra/test_drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://google.com");
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        List<WebElement> searchResult = webDriver.findElements(By.cssSelector("div"));
        boolean isFind = false;
        for (WebElement element: searchResult) {
            if (element.getText().contains("selenium.dev")) {
                isFind = true;
                break;
            }
        }
        webDriver.quit();
        assertTrue(isFind);
    }
}
