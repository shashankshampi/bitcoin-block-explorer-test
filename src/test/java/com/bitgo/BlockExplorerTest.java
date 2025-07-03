package com.bitgo;

import com.blockexplorer.pages.BlockPage;
import com.blockexplorer.pages.TransactionComponent;
import com.blockexplorer.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

/**
 * @author shashanksanket
 * @Date 03/07/25
 */
public class BlockExplorerTest {
  private WebDriver driver;
  private BlockPage blockPage;

  @BeforeMethod
  public void setUp() {
    driver = WebDriverFactory.getDriver();
    String baseUrl = WebDriverFactory.getProperty("base.url");
    String blockHash = WebDriverFactory.getProperty("block.hash");
    driver.get(baseUrl + "/block/" + blockHash);
    blockPage = new BlockPage(driver);
  }

  @Test(priority = 1)
  public void testTransactionsHeading() {
    System.out.println("Starting test: Verifying transactions heading");

    // Get the actual heading text
    String actualHeading = blockPage.getTransactionsHeadingText();
    System.out.println("Actual heading text: " + actualHeading);

    // Verify it matches the expected pattern
    boolean matchesPattern = actualHeading.matches("\\d+ of \\d+ Transactions");
    System.out.println("Does heading match pattern? " + matchesPattern);

    // Extract the numbers from the heading
    String[] parts = actualHeading.split(" ");
    int displayedCount = Integer.parseInt(parts[0]);
    int totalCount = Integer.parseInt(parts[2]);
    System.out.println("Displayed transactions: " + displayedCount);
    System.out.println("Total transactions: " + totalCount);

    // Verify the pattern and that displayed count is <= total count
    Assert.assertTrue(matchesPattern,
        "Transactions heading format should be 'X of Y Transactions'");
    Assert.assertTrue(displayedCount <= totalCount,
        "Displayed transactions count should be less than or equal to total count");

    System.out.println("Test completed: Transactions heading verification passed");
  }

  @Test(priority = 2)
  public void findTransactionsWithOneInputAndTwoOutputs() {
    System.out.println("Transactions with exactly 1 input and 2 outputs:");

    List<WebElement> transactionElements = blockPage.getTransactionElements();
    int matchingCount = 0;

    for (WebElement element : transactionElements) {
      TransactionComponent transaction = new TransactionComponent(driver); // Updated to use driver
      transaction.setRootElement(element);

      int inputCount = transaction.getInputCount();
      int outputCount = transaction.getOutputCount();

      if (inputCount == 1 && outputCount == 2) {
        matchingCount++;
        // Get transaction hash from the header link
        String txHash = element.findElement(By.cssSelector("div.header a")).getAttribute("href")
            .replaceAll(".*/tx/", "");
        System.out.println("Found matching transaction: " + txHash);
      }
    }

    System.out.println("Total matching transactions found: " + matchingCount);
    Assert.assertTrue(matchingCount > 0, "Should find at least one transaction with 1 input and 2 outputs");
  }

  @AfterMethod
  public void tearDown() {
    WebDriverFactory.quitDriver();
  }
  public void setRootElement(WebElement element) {
    PageFactory.initElements(element, this);
  }
}