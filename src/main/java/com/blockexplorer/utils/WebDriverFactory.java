package com.blockexplorer.utils;

/**
 * @author shashanksanket
 * @Date 03/07/25
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class WebDriverFactory {
  private static WebDriver driver;
  private static Properties properties;

  static {
    try {
      properties = new Properties();
      FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
      properties.load(fis);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static WebDriver getDriver() {
    if (driver == null) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--headless");
      options.addArguments("--disable-gpu");
      options.addArguments("--window-size=1920,1080");
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-dev-shm-usage");

      driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}