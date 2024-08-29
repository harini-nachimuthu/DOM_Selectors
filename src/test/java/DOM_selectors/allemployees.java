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

public class allemployees {
	 protected String URL = "https://empdomm.netlify.app/";
	 WebDriver driver = null;
  @Test
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
