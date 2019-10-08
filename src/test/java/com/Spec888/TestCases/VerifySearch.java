package com.Spec888.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Spec888.Pages.InputToolPage;
import com.Spec888.Pages.ResultsPage;
import com.Spec888.Pages.SearchPage;
import com.Spec888.helper.BrowserFactory;

public class VerifySearch {
	@Test
	public void checkSearchEngine() {
		
		WebDriver driver = BrowserFactory.startBrowser("firefox", "https://www.google.com");
		SearchPage google_search_page = PageFactory.initElements(driver, SearchPage.class);
		ResultsPage results_page = PageFactory.initElements(driver, ResultsPage.class);

		google_search_page.search_by_key("cagliari");

	    Assert.assertTrue(results_page.
	    		check_search_results_for("cagliari"), "no results found");
	}
	
	@Test
	public void checkVirtualKeyboardTool() {

		WebDriver driver = BrowserFactory.startBrowser("firefox", "https://www.google.com/inputtools/try/");
		ResultsPage results_page = PageFactory.initElements(driver, ResultsPage.class);
		InputToolPage google_virtual_keyboard_page = PageFactory.initElements(driver, InputToolPage.class);
		SearchPage google_search_page = PageFactory.initElements(driver, SearchPage.class);
		
		google_virtual_keyboard_page.on_keyboard_type("Cagliari");
		google_search_page.search_by_key();

	    Assert.assertTrue(results_page.
	    		check_search_results_for("Cagliari"), "no results found");

	}	
}

