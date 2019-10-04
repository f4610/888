package com.google.Pages;


import java.util.List;
import java.text.Normalizer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InputToolPage {
	
	WebDriver driver;
	
	public InputToolPage(WebDriver ldriver) {
		this.driver=ldriver;
	}

	@FindBy(how = How.ID, using = "demobox") WebElement text_put_out;
	@FindBy(how = How.CLASS_NAME, using = "vk-btn") private List<WebElement> keyboardButtons;
	
	public InputToolPage on_keyboard_type(String keys) 
	
	{	
		keys = normalize_string(keys);
		char[] chars = keys.toCharArray();
		for (char ch: chars) {
		  for(WebElement e: keyboardButtons) {
			  String s = String.valueOf(ch); 
			  if (e.getText().equals(s)) {
				e.click();  
			  }	
		  }
		}
		
		text_put_out.click();
		
		String selectAll = Keys.chord(Keys.COMMAND, "a");
		String coppyAll = Keys.chord(Keys.COMMAND, "c");		
		text_put_out.sendKeys(selectAll);
		text_put_out.sendKeys(coppyAll);
		driver.navigate().to("https://www.google.com");

		return new InputToolPage(driver);
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
