package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
//write java code for web table to retrive the specific row col data
public class program5 {
    public static void main (String [] args)
    {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        int row=driver.findElements(By.xpath("//table[@name='BookTable']/tbody//tr")).size();
        int col = driver.findElements(By.xpath("//table[@name='BookTable']/tbody//th")).size();
                for(int i=1;i<row;i++)
                {
                    for(int j=1;j<col;j++)
                    {
                       String dataName= driver.findElement(By.xpath("//table[@name='BookTable']/tbody//tr["+(i+1)+"]/td["+j+"]")).getText();
                       if(dataName.equals("JAVA"))
                       System.out.println(i+" : "+j);

                    }

                }

    }
}
