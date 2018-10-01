package alfaforex.lkoffice.crm.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

  private WebElement calElement;
  private WebDriver driver;

  public Calendar(WebElement calElement, WebDriver driver) {
    this.calElement = calElement;
    this.driver = driver;
  }

  public List<WebElement> getRows() {
    List<WebElement> rows = calElement.findElements(By.xpath(".//tr"));
    rows.remove(0);
    rows.remove(1);
    return rows;
  }

  public List<WebElement> getHeadings() {
    WebElement headingRows = calElement.findElement(By.xpath(".//tr[1]"));
    List<WebElement>  headingColumns = headingRows.findElements(By.xpath(".//th"));
    return headingColumns;
  }

  public List<List<WebElement>> getRowsWithColumns() {
    List<WebElement> rows = getRows();
    List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
    for (WebElement row : rows) {
      List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
      rowsWithColumns.add(rowWithColumns);
    }
    return rowsWithColumns;
  }

  public WebElement getVaueFromCell (int rowNumber, int columnNumber) {
    List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
    WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
    return cell;
  }

}
