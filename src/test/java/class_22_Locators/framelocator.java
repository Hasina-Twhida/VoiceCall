package class_22_Locators;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class framelocator {

	public static void main(String[] args) {
		String chromePath= "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		Playwright playwright;
		playwright=Playwright.create();	
		Browser browser;
		browser = playwright
				.chromium()
				.launch(new BrowserType.LaunchOptions()
				.setHeadless(false)
				
				
				.setExecutablePath(Paths.get(chromePath)));
		Page page;
		page = browser.newPage();
		
		page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		page.frameLocator("//iframe[@name='iframeResult']").locator("body > button").click();
		page.locator("//a[@id='getwebsitebtn']").click();

	}

}
