package com.testing.pageObjects.pages;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/slider")
public class SliderPage extends WidgetsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By SLIDER_TITLE = text("Slider");
  // Slider ball/ or sldier itself
  public static By SLIDER_BALL = css("input[class*='range-slider']");
  public static By SLIDER_VALUE = css("input[id=sliderValue]");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(SLIDER_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public void setElementValueTo(String elementName, String value) {
    switch(elementName){
      case "SLIDER_BALL":
        WebElementFacade e = getElement(elementName);

        // The difference betwen current position and target position
        // The sign of the difference defines the key to be pressed
        // The value of the difference defines iteration count
        int difference = Integer.valueOf(value) - Integer.valueOf(getElement(SLIDER_BALL).getValue());

        for (int i = Math.abs(difference); i > 0; i--) {
          if (difference > 0) 
            e.sendKeys(Keys.ARROW_RIGHT);
          else
            e.sendKeys(Keys.ARROW_LEFT);
        }

        break;

      default:
        super.setElementValueTo(elementName, value);
    }
  }

  public Boolean validateSliderValue(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {

      for (String key : map.keySet()) {
        if(snakify(key).equals("VALUE") && getElement(SLIDER_VALUE).getValue().equals(map.get(key)))
          return true;
      }

    }

    return false;
  }
}
