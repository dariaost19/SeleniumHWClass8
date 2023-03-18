package Homework7;
//1.goto http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
//username=Admin
//password=Hum@nhrm123
//2. click on PIM option
//3. from the table select Any  value of id and click the check box associated with it
//make sure that ur code is dynamic i.e
//changing the id doesnt effect the logic or xpath

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
//      //  enter the password
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='Submit']"));
        loginButton.click();
        WebElement pim = driver.findElement(By.xpath("//b[text()='PIM']"));
        pim.click();
        List<WebElement> column=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
        for (int i = 0; i < column.size(); i++) {
            String text = column.get(i).getText();

            if (text.equalsIgnoreCase("4813474")) {
                System.out.println(text);
                System.out.println("index for row with selected ID is : "+(i+1));
                driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+(i+1)+"]/td[1]")).click();
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}

