import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
//	public WebDriver driver;
	public static void main(String[] args){

		WebDriver driver = new ChromeDriver();
        driver.get("https://orteil.dashnet.org/cookieclicker/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// wait for the page to load
			e.printStackTrace();
		}
		// select english after reaching page
		driver.findElement(By.cssSelector("div[id='langSelect-EN']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// wait for the page to load
			e.printStackTrace();
		}
		
		GamePage interactor = new GamePage(driver);
		while(true){
				interactor.clickCookie(1000);
				System.out.println(interactor.getProductPrice(0));
				interactor.BuyUpgrade(0);
				interactor.BuyStore(1);
				interactor.BuyStore(2);
				System.out.println(interactor.getOwnedCookies());
				
		}
		
		
		
		
		//TODO Have selenium set a goal for itself. weather its an upgrade or shop 
		
	}
}
