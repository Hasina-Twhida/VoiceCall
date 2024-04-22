package class_22_Locators;
import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
public class Locators_ScreenShort_Vedio_Asseration {
	public static void main(String[] args) throws InterruptedException {
	
	String chromePath="C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
	
	Playwright playwright;
	playwright= Playwright.create();
	
	Browser browser;
	browser=playwright.chromium()
			.launch(new BrowserType
			.LaunchOptions()
			.setHeadless(false)
			.setExecutablePath(Paths.get(chromePath)));
			
	Page page;
	page =browser.newPage();
	
	page.navigate("https://www.glendale.edu/");
	System.out.println(page.title());
	
	// Verify actual title match with expected title 
		String titleSms=page.textContent("//h1[text()='Glendale Community College']");
		if (titleSms.contains("Glendale Community College"))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
	
	page.locator("//a[text()='Canvas']").click();
	Thread.sleep(2000);
	page.getByPlaceholder("Search GCC site").fill("CLASS SCHEDULE");
	
	page.locator("//a[text()='Go']").click();
	
	//page.press("selector", "Enter");is not working 
	// make a Screenshot in files inside the src/test/resources
	page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./src/test/resources/files_2/screenshot.png")).setFullPage(true));
	// make a video for proof
	Thread.sleep(2000);
	BrowserContext context=browser
		.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos"))); 
		Page page1;
		page1 = context.newPage();
	
	Thread.sleep(2000);
	
	context.close();
	page.close();
	playwright.close();
	}

}
