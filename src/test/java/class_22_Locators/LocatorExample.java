package class_22_Locators;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;//Import every step after assertion we have to wright 

public class LocatorExample {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		// playwright declaration and creation
		Playwright playwright;
		playwright = Playwright.create();

		LaunchOptions launchOptions;
		launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath));

		Browser browser;
		browser = playwright.chromium().launch(launchOptions);

		Page page;
		page = browser.newPage();

		page.navigate("https://it.microtechlimited.com");

		//Thread.sleep(3000);
		//Landing Page Assertion
		assertThat(page).hasTitle("MicroTech NA");
		
		//Login Page Assertion
		// page.locator("// a[@href='elogin.php']").click();
		

		//Thread.sleep(2000);
		//page.goBack();
		page.close();
		playwright.close();

	}

}
