package uk.ac.bbsrc.tgac.miso.webapp.integrationtest.page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

import uk.ac.bbsrc.tgac.miso.webapp.integrationtest.page.element.AbstractElement;

public abstract class AbstractPage extends AbstractElement {

  private static final ExpectedCondition<Boolean> pageLoaded = (driver) -> {
    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
  };

  protected AbstractPage(WebDriver driver) {
    super(driver);
  }

  protected static void waitExplicitly(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException("Thread interrupted during sleep", e);
    }
  }

  protected void waitForPageRefresh() {
    waitUntil(pageLoaded);
  }

  protected void waitForPageRefresh(long seconds) {
    waitUntil(pageLoaded, seconds);
  }

  protected void setText(String input, WebElement element) {
    element.click();
    element.clear();
    element.sendKeys(input);
    element.sendKeys(Keys.ESCAPE);
  }

  protected void setDropdown(String input, WebElement element) {
    element.click();
    Select select = new Select(element);
    select.selectByVisibleText(input);
    element.sendKeys(Keys.ESCAPE);
  }

  protected void setCheckbox(Boolean value, WebElement element) {
    // only change if given value and element value differ
    if (value && "false".equals(element.getAttribute("value"))) {
      element.click();
    }
    if (!value && "true".equals(element.getAttribute("value"))) {
      element.click();
    }
  }

  protected String getSelectedDropdownText(WebElement element) {
    Select dropdown = new Select(element);
    return dropdown.getFirstSelectedOption().getText();
  }

  private static final String MISO_URL = "%smiso/%s";
  private static final String MISO_STACKTRACE = "uk.ac.bbsrc";

  public static boolean checkForErrors(WebDriver driver, String baseUrl, String urlSlug) {
    String url = String.format(MISO_URL, baseUrl, urlSlug);
    driver.get(url);
    // confirm that page contains logo
    if (driver.findElements(By.id("misologo")).isEmpty())
      throw new IllegalArgumentException("Page at /miso/" + urlSlug + " is completely empty. Is resource correct?");

    List<WebElement> errors = driver.findElements(By.xpath("//li[contains(text(), '" + MISO_STACKTRACE + "')]"));
    if (errors.size() > 0) {
      errors.stream().map(item -> item.getText().trim()).collect(Collectors.toList()).toString();
      return true;
    } else {
      return false;
    }
  }

}
