package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }

    @Test
    public void testCase01() throws InterruptedException{
        System.out.println("Start test case 01");
       driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
       Thread.sleep(5000);
       WebElement namefield = driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[1]"));
       namefield.click();
       namefield.sendKeys("Crio Learner");

       WebElement reason = driver.findElement(By.xpath("//textarea[@jsname='YPqjbf']"));
       reason.click();
       long epoch = System.currentTimeMillis();
       //String Reason = "I want to be the best QA Engineer!";
       reason.sendKeys("I want to be the best QA Engineer!"+epoch);

       WebElement radiobutton = driver.findElement(By.xpath("//div[@id='i13']"));
       radiobutton.click();

       Thread.sleep(2000);

       WebElement java =driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
       java.click();
       Thread.sleep(2000);

       WebElement selnium = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
       selnium.click();
       Thread.sleep(2000);
       WebElement testng = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]")); 
       testng.click();
       Thread.sleep(2000);

       WebElement dropdown1 = driver.findElement(By.xpath("(//div[@class='e2CuFe eU809d'])[1]"));
       dropdown1.click();
       Thread.sleep(1000);
       WebElement mrs = driver.findElement(By.xpath("(//span[contains(text(),'Mrs')])[2]"));
       mrs.click();
       Thread.sleep(1000);

       WebElement date = driver.findElement(By.xpath("//input[@aria-labelledby='i50']"));
       date.sendKeys("06/30/2024");
       Thread.sleep(1000);


       WebElement hour = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
       hour.sendKeys("07");
       Thread.sleep(1000);
       WebElement min = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
       min.sendKeys("30");
       Thread.sleep(1000);

       WebElement submit = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
       submit.click();
       Thread.sleep(3000);

       WebElement submitresponse = driver.findElement(By.xpath("//div[contains(text(),'Thanks for your response, Automation Wizard!')]"));
       String text = submitresponse.getText();
       System.out.println(text);
       System.out.println("Start test case 01");




       





    }
}

