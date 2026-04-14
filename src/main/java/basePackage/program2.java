package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class program2 {
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
       driver.findElement(By.className("gLFyf")).sendKeys("accenture");
       // driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> list =driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));
       // List<WebElement> list =driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));
        for(WebElement name:list)
        {
            System.out.println(name.getText());
        }

        // Type into search box
     /*   WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("accenture");

        // Wait for suggestions to load
        Thread.sleep(2000);

        // Capture suggestion list
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));

        // Print each suggestion text
        for (WebElement suggestion : suggestions) {
            System.out.println(suggestion.getText());
        }*/
    }
}
