package com.Spec888.Pages;

import java.text.Normalizer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(how=How.NAME, using="q") WebElement googleSearchBox;
	
	public SearchPage search_by_key(String keyword) 
	{
		googleSearchBox.sendKeys(keyword);
		googleSearchBox.sendKeys(Keys.RETURN);
		sleep(5000);
		return new SearchPage(driver);

	}
	
	public SearchPage search_by_key() 
	{
		String pasteAll = Keys.chord(Keys.COMMAND, "v");
		String goSearch = Keys.chord(Keys.RETURN);
		googleSearchBox.sendKeys(pasteAll);
		googleSearchBox.sendKeys(goSearch);
		sleep(5000);
		return new SearchPage(driver);
	}
	
	public String normalize_string(String s)
	{
		 s = s.toLowerCase();
		 s = Normalizer.normalize(s, Normalizer.Form.NFD);
		 s = s.replaceAll("[^\\p{ASCII}]", "");
		 System.out.println(s);
		
		return s;
	}
	
	public void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}