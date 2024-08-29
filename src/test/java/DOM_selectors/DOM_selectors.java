package DOM_selectors;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DOM_selectors {
    protected String URL = "https://empdomm.netlify.app/";
    WebDriver driver = null;

    @Test(priority = 1)
    public void test1() throws InterruptedException {
        System.out.println("Title of the page : " + driver.getTitle());
        System.out.println("URL of the current page: " + driver.getCurrentUrl());

        System.out.println("=================All Employees=================");

        WebElement allemployees = driver.findElement(By.id("all-emp-btn"));
        allemployees.click();

        List<WebElement> columncount = driver.findElements(By.xpath("//body//section//table//tbody//tr[1]//td"));
        System.out.println("Column count in single row: " + columncount.size());

        List<WebElement> rowcount = driver.findElements(By.xpath("//body//section//table//tbody//tr"));
        System.out.println("Row count in single column: " + rowcount.size());

        WebElement table = driver.findElement(By.xpath("//table[@class=\"table table-striped table-bordered\"]"));

        WebElement thead = table.findElement(By.tagName("thead"));
        List<WebElement> thead_datas = thead.findElements(By.tagName("tr"));
        for (WebElement thead_data : thead_datas) {
            System.out.print(thead_data.getText() + " ");
        }

        WebElement tbody = table.findElement(By.xpath("//tbody[@id=\"table-body\"]"));
        List<WebElement> rowsdatas = tbody.findElements(By.tagName("tr"));
        System.out.println("rowsdatas: " + rowsdatas.size());

        for (WebElement rowdata : rowsdatas) {
            List<WebElement> columnsdatas = rowdata.findElements(By.tagName("td"));
            for (WebElement columndata : columnsdatas) {
                System.out.print(columndata.getText() + " ");
            }
            System.out.println();
            System.out.println();
        }

        int checkingcolumnindex = 4;
        String gender = "male";
        System.out.println("Getting male employee details alone here.............");
        for (WebElement row : rowsdatas) {
            WebElement gendercell = (row.findElements(By.tagName("td"))).get(checkingcolumnindex);
            if (gendercell.getText().equalsIgnoreCase(gender)) {
                for (WebElement cell : row.findElements(By.tagName("td"))) {
                    System.out.print(cell.getText() + " ");
                }
                System.out.println();
            }
        }

        int checkingcolumnindex1 = 4;
        String gender1 = "female";
        System.out.println("Getting female employee details alone here.............");
        for (WebElement row : rowsdatas) {
            WebElement gendercell = (row.findElements(By.tagName("td"))).get(checkingcolumnindex1);
            if (gendercell.getText().equalsIgnoreCase(gender1)) {
                for (WebElement cell : row.findElements(By.tagName("td"))) {
                    System.out.print(cell.getText() + " ");
                }
                System.out.println();
            }
        }
        Thread.sleep(1000);
    }

    @Test(priority = 2)
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
        for (WebElement thead_data : thead_datas) {
            System.out.print(thead_data.getText() + " ");
        }

        WebElement tbody = table.findElement(By.xpath("//tbody[@id=\"table-body\"]"));
        List<WebElement> rowsdatas = tbody.findElements(By.tagName("tr"));
        System.out.println("rowsdatas: " + rowsdatas.size());
        for (WebElement rowdata : rowsdatas) {
            List<WebElement> columnsdatas = rowdata.findElements(By.tagName("td"));
            for (WebElement columndata : columnsdatas) {
                System.out.print(columndata.getText() + " ");
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("Using search bar to find person is there in the male list or not");
        WebElement searchbox = driver.findElement(By.id("search-box"));
        searchbox.clear();
        searchbox.sendKeys("babu");
//        Actions act = new Actions(driver);
//        act.sendKeys(Keys.ENTER).perform();
        
        List<WebElement> updatedRowsdatas = tbody.findElements(By.tagName("tr"));
        if(updatedRowsdatas.size()==rowsdatas.size()) {
        	System.out.println("No Employee named with this name");
        }else {
        	for (WebElement row : updatedRowsdatas) {
                List<WebElement> columnsdatas = row.findElements(By.tagName("td"));
                for (WebElement cell : columnsdatas) {
                    System.out.print(cell.getText() + " ");
                }
                System.out.println();
            }
        }
        
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void test3() throws InterruptedException {
        System.out.println("=================Female Employees=================");

        WebElement femaleemployees = driver.findElement(By.id("female-emp-btn"));
        femaleemployees.click();

        List<WebElement> columncount = driver.findElements(By.xpath("//body//section//table//tbody//tr[1]//td"));
        System.out.println("Column count in single row: " + columncount.size());

        List<WebElement> rowcount = driver.findElements(By.xpath("//body//section//table//tbody//tr"));
        System.out.println("Row count in single column: " + rowcount.size());

        WebElement table = driver.findElement(By.xpath("//table[@class=\"table table-striped table-bordered\"]"));

        WebElement thead = table.findElement(By.tagName("thead"));
        List<WebElement> thead_datas = thead.findElements(By.tagName("tr"));
        for (WebElement thead_data : thead_datas) {
            System.out.print(thead_data.getText() + " ");
        }

        WebElement tbody = table.findElement(By.xpath("//tbody[@id=\"table-body\"]"));
        List<WebElement> rowsdatas = tbody.findElements(By.tagName("tr"));
        System.out.println("rowsdatas: " + rowsdatas.size());
        for (WebElement rowdata : rowsdatas) {
            List<WebElement> columnsdatas = rowdata.findElements(By.tagName("td"));
            for (WebElement columndata : columnsdatas) {
                System.out.print(columndata.getText() + " ");
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("Using search bar to find person is there in the female list or not");
        WebElement searchbox = driver.findElement(By.id("search-box"));
        searchbox.clear();
        String name = "harini";

        searchbox.sendKeys(name);
//        Actions act1 = new Actions(driver);
//        act1.sendKeys(Keys.ENTER).perform();

        List<WebElement> updatedRowsdatas = tbody.findElements(By.tagName("tr"));
        for (WebElement row : updatedRowsdatas) {
            List<WebElement> columnsdatas = row.findElements(By.tagName("td"));
            for (WebElement cell : columnsdatas) {
                System.out.print(cell.getText() + " ");
            }
            System.out.println();
        }
        Thread.sleep(1000);
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
