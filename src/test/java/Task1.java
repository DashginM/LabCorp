import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


public class Task1 {
    @Test
    public void test () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.labcorp.com");
        driver.manage().window().maximize();

        WebElement careers = driver.findElement(By.xpath("//div[@id='login-container']//a[@class='no-ext ext']"));
        careers.click();



        String mainWindow = driver.getWindowHandle();
        Set <String> allWindows = driver.getWindowHandles();
        ArrayList <String> tabs= new ArrayList<>(allWindows);
        Iterator<String> iterator=allWindows.iterator();
        String parentWindow = iterator.next();
        String childWindow= iterator.next();


        for (String child: allWindows){
            if(!mainWindow.equalsIgnoreCase(child)){
                driver.switchTo().window(child);
            }
        }

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='typehead'])[2]")));
        searchBox.sendKeys("QA Test Automation Developer");
        searchBox.sendKeys(Keys.ENTER);

        WebElement qaManager = driver.findElement(By.xpath("//div[@class='job-title']//span[contains(text(),'QA Test Automation Developer')]"));
        qaManager.click();

        String jobTitle=driver.getTitle();
        boolean title=jobTitle.contains("QA Test Automation Developer");
        Assert.assertTrue(title);

        String jobLocation = driver.findElement(By.xpath("//span[@class='au-target job-location']")).getText();
        boolean data1 = jobLocation.contains("Durham, North Carolina, United States of America");
        Assert.assertTrue(data1);

        String jobID = driver.findElement(By.xpath("//span[@class='au-target jobId']")).getText();
        boolean data2= jobID.contains("Job Id : 21-90223_RM");
        Assert.assertTrue(data2);

        String confirm1 = driver.findElement(By.xpath("//div[@class='jd-info au-target']")).getText();
        boolean data3=confirm1.contains("The right candidate for this role will participate in the test automation technology development and best practice models.");
        Assert.assertTrue(data3);

        boolean data4=confirm1.contains("Prepare test plans, budgets, and schedules.");
        Assert.assertTrue(data4);


        boolean data5=confirm1.contains("5+ years of experience in QA automation development and scripting.");
        Assert.assertTrue(data5);

        WebElement applyNow = driver.findElement(By.xpath("//a[@aria-label='Apply Now for COVAGLOBAL2190223RMEXTERNALENGLOBAL']"));
        applyNow.click();


        driver.switchTo().window(tabs.get(1));

        WebElement back = driver.findElement(By.xpath("//ppc-content[contains(text(),'Back to search results')]"));
        back.click();


    }
}

