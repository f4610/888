package com.Spec888.Pages;

import java.text.Normalizer;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsPage {
	
	
WebDriver driver;
	
	public ResultsPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(how=How.ID, using="rcnt") WebElement container_results;
	@FindBy(how=How.CSS, using=".r") private List<WebElement> search_test;
	
	public boolean check_search_results_for(String search_key) 
	{
		boolean key_words = false;
		boolean content_loaded = false;
		boolean title_research = false;
			
			 content_loaded = driver.getPageSource().contains(search_key);
			 title_research = normalize_string(driver.getTitle()).contains(normalize_string(search_key));
			 if (content_loaded && title_research) {key_words = true;}

		return key_words; 
	}

	public boolean check_results_content_link(String search_key) 
	{
		boolean key_words = false;

		 for(WebElement e: search_test) {
			 
			 if (e.getText().length() != 0)
			 {
			 key_words = normalize_string(e.getText()).
					 contains(normalize_string(search_key));
			 } 
		 }
		return key_words; 
	}
	
	public String normalize_string(String s)
	{
		 s = s.toLowerCase();
		 s = Normalizer.normalize(s, Normalizer.Form.NFD);
		 s = s.replaceAll("[^\\p{ASCII}]", "");
		 System.out.println(s);
		
		return s;
	}

}
