package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class progarm4 {
    public static void main(String[] args) {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("Aher");
        driver.findElement(By.xpath("//input[@placeholder='Enter EMail']")).sendKeys("abc@gamil.com");
        driver.findElement((By.xpath("//input[@placeholder='Enter Phone']"))).sendKeys("134252626");
        driver.findElement(By.id("textarea")).sendKeys("Pune");
        driver.findElement(By.id("male")).click();
        //count all checkbox
        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='form-group']//input[@type='checkbox']"));
        System.out.println(checkboxes.size());
        for (WebElement check : checkboxes) {
            String value = check.getAttribute("value");
            if (value.equalsIgnoreCase("Monday")) {
                check.click();
                break;
            }
        }
        // drop down list
        WebElement Cddl = driver.findElement(By.id("country"));
        Select ddl = new Select(Cddl);
        ddl.selectByIndex(2);

        WebElement clo = driver.findElement(By.id("colors"));
        Select c = new Select(clo);
        c.selectByValue("yellow");

        //calendar

        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        driver.findElement(By.xpath("//a[text()='16']")).click();

        //manually enter value in calendar
        WebElement date = driver.findElement(By.id("txtDate"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('readonly')", date);
        // Set the date value
        date.sendKeys("21/09/2026");
        //calendar with drop down

        WebElement date1 = driver.findElement(By.id("start-date"));
        date1.sendKeys("16-4-2026");
        driver.findElement(By.id("end-date")).sendKeys("20-4-2026");
        driver.findElement(By.className("submit-btn")).click();

        //upload single file
        driver.findElement(By.id("singleFileInput")).sendKeys("C://Users//Gayatri//Downloads//Harshal_SDET.docx");
       /* WebElement file= driver.findElement(By.id("multipleFilesForm"));
        String filePath1 = "C:\\Users\\Gayatri\\Downloads\\Harshal_SDET.docx";
        String filePath2 = "C:\\Users\\Gayatri\\Downloads\\Harshal_Ramkrushna_Aher.docx";

        file.sendKeys(filePath1 + "\n" + filePath2 + "\n");
        driver.findElement(By.xpath("//button[text()='Upload Multiple Files']")).click();

        */

        js.executeScript("window.scrollBy(0,800)");
        driver.findElement(By.name("BookTable"));

        //dynamic table
        int rowcount = driver.findElements(By.xpath("//table[@id='taskTable']//tr")).size();
        int colcount = driver.findElements(By.xpath("//table[@id='taskTable']//th")).size();
        String word = driver.findElement(By.xpath("//div[@class='display-values']/child::p[1]")).getText();
        String[] verifydata1 = word.split(":");
        String chromeProcess = verifydata1[1].trim();
        for (int i = 2; i < rowcount; i++) {
            for (int j = 1; j < colcount; j++) {
                String actualdata = driver.findElement(By.xpath("//table[@id='taskTable']//tr[" + i + "]//td[" + j + "]")).getText();
                if (actualdata.trim().equals(chromeProcess)) {
                    System.out.println("CPU load of Chrome process: " + actualdata);
                }

                
        }
    }
}




    }
