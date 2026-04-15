package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Program3 {
    //dynamic drop down

    public static  void main (String [] args) throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://vinothqaacademy.com/drop-down/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//span[@id='select2-simpleDropdown-container']")).click();
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("London");
        driver.findElement(By.xpath("//ul[@role='listbox']/li")).click();
        driver.findElement((By.id("select2-FromAccount-container"))).click();
        List<WebElement> lists =driver.findElements((By.xpath("//ul[@role='listbox']/li")));
        for(WebElement option:lists)
        {
            if (option.getText().equalsIgnoreCase("8400023 Bal - $2,100.35"))
            {
                option.click();
                break;
            }
        }
Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--multiple']")).click();
        List<WebElement> multilist=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for(WebElement option : multilist)
        {
           String name= option.getText();
           if(name.contains("PHP"))
           {
               System.out.println(name);
               option.click();
               break;
           }

        }


    }
}
