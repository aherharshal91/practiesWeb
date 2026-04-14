package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class program1 {
    public static void main (String [] args) throws InterruptedException {
        String name="aher";
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.getTitle();
        System.out.println(driver.getTitle());
        driver.findElement(By.id("inputUsername")).sendKeys(name);

        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        //driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
        //driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
        //driver.findElement(By.cssSelector(".logout-btn")).click();
        //driver.findElement(By.className("logout-btn")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Log Out')]")).click();
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.className("signInBtn")).click();
        driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Reset Login')]")).click();

        String a=driver.findElement(By.cssSelector("p.infoMsg")).getText();
        String [] s=a.split("'");
        String pwd = s[1].trim();
        System.out.println(pwd);
        //driver.findElement(By.linkText("Go to Login")).click();
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Pass')]")).sendKeys(pwd);
        Thread.sleep(3000);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.name("chkboxTwo")).click();
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+name+",");
        driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals( driver.findElement(By.xpath("//p")).getText(),"You are successfully logged in.");
        driver.quit();

    }
}
