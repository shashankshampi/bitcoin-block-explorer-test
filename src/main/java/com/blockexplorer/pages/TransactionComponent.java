package com.blockexplorer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TransactionComponent {
  private WebDriver driver;

  // Corrected locator for transaction inputs (vins)
  @FindBy(css = "div.vins div.vin")
  private List<WebElement> inputs;

  // Corrected locator for transaction outputs (vouts)
  @FindBy(css = "div.vouts div.vout")
  private List<WebElement> outputs;

  public TransactionComponent(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public int getInputCount() {
    return inputs.size();
  }

  public int getOutputCount() {
    return outputs.size();
  }

  public List<WebElement> getInputs() {
    return inputs;
  }

  public List<WebElement> getOutputs() {
    return outputs;
  }

  public void setRootElement(WebElement element) {
    PageFactory.initElements(element, this);
  }
}