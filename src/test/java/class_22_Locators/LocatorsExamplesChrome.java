package class_22_Locators;
import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
public class LocatorsExamplesChrome {


	public static void main(String[] args) throws InterruptedException {

		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

		Playwright playwright;
		playwright = Playwright.create();

		Browser browser;
		browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath)));

		Page page;
		page = browser.newPage();

		page.navigate("file://C:/java/html-form-page.html");
		System.out.println(page.title());
		Thread.sleep(2000);
		// Verify actual title match with expected title
		String titleMassege = page.textContent("//*[@id='forms']/header/h2");
		if (titleMassege.contains("Form elements"))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		//Fill in Blank Input fields
		page.locator("#input__text").fill("Playwright");// CSS only use # with value, no quotation and its for only id
		//page.getByPlaceholder("Type your Password").fill("5678");// only use value, no quotation
		page.getByPlaceholder("https://yoursite.com").fill("https://youtube.com");
		page.locator("//input[@placeholder='name@email.com']").fill("atwhida@gmail.com");
		page.locator("//input[@id='input__phone']").fill("1818-482-3651");
		page.locator("//input[@id='input__search']").fill("Glendale");
		page.locator("//input[@id='input__text2']").fill("3");
		Thread.sleep(2000);
		page.locator("//input[@id='input__file']").setInputFiles(Paths.get("./src/test/resources/files/pic.jpg"));
		Thread.sleep(2000);
		// fine element for Select Menus
		SelectOption sp;
		sp = new SelectOption();
		// page.selectOption ("select", sp.setLabel("Option Three"));
		page.selectOption("select", sp.setIndex(2));
		Thread.sleep(2000);
		
		// find element for Check boxes or toggle
		//page.locator("//label[@for='checkbox3']").click();// here is another way to do for all of the check at a time
		Locator checkboxs = page.locator("[type='checkbox']");// here we use attribute as a CSS selector
		for (int i = 1; i < checkboxs.count(); i++) {// here we use method which name is count()
			checkboxs.nth(i).click();// here nth as a method which help to count all index number or value
		}
		Thread.sleep(2000);
		// find element for Radio buttons
		page.locator("//input[@id='radio2']").click();
		page.locator("//textarea[@id='textarea']").fill(
				"Hello everyone! Greetings from Hasina. Wishing all my wonderful classmates a fantastic day filled with laughter and learning.");
		Thread.sleep(2000);

		// color assertion
		/*String expectedColor="rgb(0, 0, 0)";
		if(actualColor.equals(expectedColor)) {
		System.out.println("Color is as expected: "+actualColor);
		}else {
		System.out.println("Color is no as expected: "+actualColor);
		}*/
		
		Thread.sleep(2000);
		page.locator("//input[@id='in']").fill("3");
		Thread.sleep(2000);
		// find element for-----------Range input
		page.locator("//input[@id='ir']").click();
		Thread.sleep(2000);

		// Find element Date ,month & week
		page.locator("//input[@id='idd']").fill("2023-11-06");
		page.locator("//input[@id='idm']").fill("2023-11");
		page.locator("//input[@id='idw']").fill("2023-W01");
		page.locator("//input[@id='idt']").fill("2023-11-06T00:00:00Z");
		// date & time local
		page.locator("//input[@id='idtl']").fill("2023-11-06T00:00");
		
		// Select option from Datalist example 2
		String inputSelector = "//input[@id='idl']";
		page.fill(inputSelector, "Example #2");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./src/test/resources/files/screenshot.png"))
				.setFullPage(true));
		Thread.sleep(2000);
		page.locator("//*[@id=\"forms__action\"]/p[1]/input[1]").click();
		
		
	page.close();
	Thread.sleep(2000);
	browser.close();
	Thread.sleep(2000);
	playwright.close();

	}

}
