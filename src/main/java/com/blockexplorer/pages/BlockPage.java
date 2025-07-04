package com.blockexplorer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * @author shashanksanket
 * @Date 03/07/25
 */
public class BlockPage {
  private WebDriver driver;

  @FindBy(css = "div.transactions h3.font-h3")
  private WebElement transactionsHeading;

  @FindBy(css = "div.transactions div.transaction-box")
  private List<WebElement> transactionElements;

  public BlockPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public String getTransactionsHeadingText() {
    return transactionsHeading.getText();
  }

  public int getNumberOfVisibleTransactions() {
    return transactionElements.size();
  }

  public List<WebElement> getTransactionElements() {
    return transactionElements;
  }
}