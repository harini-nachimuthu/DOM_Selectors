package DOM_selectors;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class maleemployees {
    protected String URL = "https://empdomm.netlify.app/";
    WebDriver driver = null;
    
    @Test
    public void test2() throws InterruptedException {
        System.out.println("=================Male Employees=================");

        WebElement maleemployees = driver.findElement(By.id("male-emp-btn"));
        maleemployees.click();

        List<WebElement> columncount = driver.findElements(By.xpath("//body//section//table//tbody//tr[1]//td"));
        System.out.println("Column count in single row: " + columncount.size());

        List<WebElement> rowcount = driver.findElements(By.xpath("//body//section//table//tbody//tr"));
        System.out.println("Row count in single column: " + rowcount.size());

        WebElement table = driver.findElement(By.xpath("//table[@class=\"table table-striped table-bordered\"]"));

        WebElement thead = table.findElement(By.tagName("thead"));
        List<WebElement> thead_datas = thead.findElements(By.tagName("tr"));
//        for (WebElement thead_data : thead_datas) {
//            System.out.print(thead_data.getText() + " ");
//        }
//
          WebElement tbody = table.findElement(By.xpath("//tbody[@id=\"table-body\"]"));
          List<WebElement> rowsdatas = tbody.findElements(By.tagName("tr"));
//        System.out.println("rowsdatas: " + rowsdatas.size());
//        for (WebElement rowdata : rowsdatas) {
//            List<WebElement> columnsdatas = rowdata.findElements(By.tagName("td"));
//            for (WebElement columndata : columnsdatas) {
//                System.out.print(columndata.getText() + " ");
//            }
//            System.out.println();
//            System.out.println();
//        }

        System.out.println("Using search bar to find person is there in the male list or not");
        WebElement searchbox = driver.findElement(By.id("search-box"));
        searchbox.clear();
        searchbox.sendKeys("babu");

        // Wait for the table to update (you may need to adjust the wait time or use an explicit wait)
        Thread.sleep(1000);

        // Refetch the tbody and row elements after the table has been updated
        tbody = driver.findElement(By.xpath("//tbody[@id=\"table-body\"]"));
        List<WebElement> updatedRowsdatas = tbody.findElements(By.tagName("tr"));
        
        if (updatedRowsdatas.size() == rowsdatas.size()) {
            System.out.println("No Employee named with this name");
        } else {
            for (WebElement row : updatedRowsdatas) {
                List<WebElement> columnsdatas = row.findElements(By.tagName("td"));
                for (WebElement cell : columnsdatas) {
                    System.out.print(cell.getText() + " ");
                }
                System.out.println();
            }
        }
    }


    @BeforeSuite
    public void suitebefore() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @BeforeClass
    public void classbefore() {
        driver.get(URL);
    }

    @AfterSuite
    public void suiteafter() {
        if (driver != null) {
            driver.close();
        }
    }
}
