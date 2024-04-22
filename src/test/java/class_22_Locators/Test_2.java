package class_22_Locators;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class Test_2 {

	public static void main(String[] args) throws InterruptedException {
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
		
		page.navigate("C:\\java\\html-all-tags-v1.html");
		
		System.out.println(page.title());
		String addressExpected = "              Written by <a href=\"mailto:webmaster@example.com\">Jon Doe</a>.<br>\r\n" + 
				"              Visit us at:<br>\r\n" + 
				"              Example.com<br>\r\n" + 
				"              Box 564, Disneyland<br>\r\n" + 
				"              USA" +
				"              ";
		String actualAddress = page.locator("//address").innerHTML();
	if (addressExpected.equals(actualAddress)) 
		System.out.println("Address is accurate - Pass");
	else
		System.out.println("Address is not accurate - FAILED");
	
//		//String expectedAddress=page.textContent("      Box 564, Disneyland");
//		//if (expectedAddress.contains("Box 564, Disneyland")) {
//		String expectedAddress=page.textContent("//a[text()='Jon Doe']");	
//		if (expectedAddress.contains("Written by Jon Doe.\r\n" + 
//				"Visit us at:\r\n" + 
//				"Example.com\r\n" + 
//				"Box 564, Disneyland\r\n" + 
//				"USA")) {
//			System.out.println("Test pass");
//		}else {
//			System.out.println("Test fail");
		
		//View what do we have in Horizontal rules
		page.locator("//a[text()='Horizontal rules']").click();
		
		//find Tabular data
		page.locator("//a[text()='Tabular data']").click();
		Thread.sleep(2000);
		
		//click inline element 
		page.locator("//a[text()='Inline elements']").click();
		
		//Expect 3 !=  Actual 2
		//We assert here that expected value is equal to actual value
		//This process is called Assertion
		//Assertion process find out the Test is Passed or Failed 
		String s = page.locator("//mark").innerText();
		System.out.println(s);
		assertThat(page.locator("//mark")).hasText("mark element");
	
	
		// click 1st pic
		page.locator("//*[@id=\"embedded__images\"]/div/p/img").click();
		Thread.sleep(2000);
		page.locator("//*[@id=\"embedded__audio\"]/div/audio").click();
		page.goBack();
		//playwright.close();
		page.close();	
		
	
	}

	}

