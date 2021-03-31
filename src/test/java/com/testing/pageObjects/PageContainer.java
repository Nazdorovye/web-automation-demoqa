package com.testing.pageObjects;

import java.util.HashMap;
import java.util.Map;

import net.thucydides.core.annotations.DefaultUrl;

import com.testing.pageObjects.pages.*;

import static support.StringEditing.snakify;
import static org.junit.Assert.fail;

public class PageContainer{
  private HashMap<String, BasePage> pages;

  public PageContainer(){
    pages = new HashMap<String, BasePage>();

    pages.put("BASE_PAGE", new BasePage());
    pages.put("HOME_PAGE", new HomePage());
    pages.put("ELEMENTS_PAGE", new ElementsPage());
    pages.put("TEXT_BOX_PAGE", new TextBoxPage());
    pages.put("CHECK_BOX_PAGE", new CheckBoxPage());
    pages.put("RADIO_BUTTON_PAGE", new RadioButtonPage());
    pages.put("WEB_TABLES_PAGE", new WebTablesPage());
    pages.put("BUTTONS_PAGE", new ButtonsPage());
    pages.put("FORMS_PAGE", new FormsPage());
    pages.put("PRACTICE_FORMS_PAGE", new PracticeFormsPage());
    pages.put("ALERTS_FRAME_AND_WINDOWS_PAGE", new AlertsFrameAndWindowsPage());
    pages.put("BROWSER_WINDOWS_PAGE", new BrowserWindowsPage());
    pages.put("SAMPLE_PAGE", new SamplePage());
    pages.put("ALERTS_PAGE", new AlertsPage());
    pages.put("WIDGETS_PAGE", new WidgetsPage());
    pages.put("ACCORDIAN_PAGE", new AccordianPage());
    pages.put("AUTO_COMPLETE_PAGE", new AutoCompletePage());
    pages.put("DATE_PICKER_PAGE", new DatePickerPage());
    pages.put("SLIDER_PAGE", new SliderPage());
    pages.put("PROGRESS_BAR_PAGE", new ProgressbarPage());
    pages.put("TABS_PAGE", new TabsPage());
    pages.put("TOOL_TIPS_PAGE", new ToolTipsPage());
    pages.put("MENU_PAGE", new MenuPage());
    pages.put("SELECT_MENU", new SelectMenuPage());
    pages.put("BROKEN_LINKS-IMAGES_PAGE", new BrokenLinksImagesPage());
  }

  public BasePage getPage(String page){
    BasePage pageObject = pages.get(snakify(page));
    if(pageObject == null) fail("Given page is undefined: " + snakify(page));
    return pageObject;
  }

  public BasePage getCurrentPage(){
    String[] url = getPage("BASE_PAGE").getDriver().getCurrentUrl().split(".com/");
    BasePage page = null;
    String annotationUrl;

    if(url.length == 1){
      page = getPage("HOME_PAGE");
    } else {
      url[1] = "/" + url[1];
      for (Map.Entry<String, BasePage> entry : pages.entrySet()) {
        if(entry.getValue().getClass().getAnnotation(DefaultUrl.class) == null) continue;

        annotationUrl = entry.getValue().getClass().getAnnotation(DefaultUrl.class).value();
        if(annotationUrl.length() <= 1) continue;
        if(url[1].contains(annotationUrl)){
          page = pages.get(entry.getKey());
          break;
        }
      }
    }
    if(page == null) fail("Given page is undefined: " + url[1]); else page.waitForPageToLoad();
    return page;
  }
}
