package com.testing.pageObjects.pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/progress-bar")
public class ProgressbarPage extends WidgetsPage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By PROGRESS_BAR_TITLE = text("Progress Bar");
  public static By START_STOP_BUTTON = css("button[id=startStopButton");
  public static By PROGRESS_BAR = css("div[class*='progress-bar']");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(PROGRESS_BAR_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public void setElementValueTo(String elementName, String value){
    switch(elementName){
      case "PROGRESS_BAR":
        getElement(START_STOP_BUTTON).click();

        waitForCondition()
          .pollingEvery(Duration.ofMillis(1))
          .until(ExpectedConditions.attributeToBe(PROGRESS_BAR, "aria-valuenow", value));

        getElement(START_STOP_BUTTON).click();
        
        // Naive implementation
        // while (true) {
        //   if (Integer.valueOf(getElement(PROGRESS_BAR).getAttribute("aria-valuenow")) 
        //       >= Integer.valueOf(value)) {
        //     getElement(START_STOP_BUTTON).click();
        //     break;
        //   }
        // }

        break;
      default:
        super.setElementValueTo(elementName, value);
    }
  }

  public Boolean validateProgressBar(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      for (String key : map.keySet()) {
        if(snakify(key).equals("VALUE") && getElement(PROGRESS_BAR).getAttribute("aria-valuenow").equals(map.get(key))) return true;
      } 
    }
    return false;
  }
}
