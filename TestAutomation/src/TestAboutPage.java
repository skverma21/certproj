
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestAboutPage {

	public static void main(String args[]) {
		// declaration and instantiation of objects/variables
		int exitCode = 1;
		if(args.length < 2 ) {
			System.out.println("Ps Enter 1. Chromedriver path and 2. the WebSite path as parameters");
			System.exit(exitCode);
		}
		System.setProperty(
				"webdriver.chrome.driver",
				args[0]);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("headless");
		WebDriver driver = new ChromeDriver(chromeOptions);
		// Launch website
		driver.navigate().to(args[1]);//"http://34.93.56.78/index.php";
		// Click on the search button
		driver.findElement(By.id("About Us")).click();
		String expectedAbtPageContent = "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

		String abtPageContent = driver.findElement(By.id("PID-ab2-pg"))
				.getText();
		if (abtPageContent.equals(expectedAbtPageContent)) {
			System.out.println("Test case passed");
			exitCode=0;
		} else {
			System.out.println("Test case failed");			
		}
		driver.close();
		driver.quit();
		System.exit(exitCode);
	}

}
