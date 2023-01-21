import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GamePage {

	private WebDriver d;
	@FindBy(css = "#cookies")
	private WebElement ownedCookies;

	@FindBy(css = "button[id='bigCookie']")
	private WebElement cookie;

//	@FindBy(css = "div[id='sectionRight'] div[id='store'] div[id='products'] div['onmouseout']")
//	WebElement shops;

	List<WebElement> store = new ArrayList<WebElement>();
	List<WebElement> upgrades = new ArrayList<WebElement>();
	
	
	public GamePage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(this.d, this);

		// collect all the buyable stores on the page
		this.store = new ArrayList<WebElement>();
		for (int i = 0; i < 19; i++) {
			store.add(d.findElement(By.cssSelector("#product" + i)));
		}
		this.upgrades = d.findElements(By.cssSelector("div[id='upgrades'] div"));
//		assert Assert.assertEquals(d.findElement(By.cssSelector("button[id='bigCookie']")), cookie);  
	}

	public void clickCookie(int times) {
		cookie.click();

		// function to click the cookie for a specified amount of time
		for (int i = 0; i < times; i++) {
			cookie.click();
		}
	}

	public void BuyStore(int index) {
		// function to Buy Stores by index or the order they are sorted in, from top to
		// bottom in the shop, starting at 0
		this.store.get(index).click();

	}

	public String getOwnedCookies() {
		// function to check amount of cookies owned

		return ownedCookies.getText();

	}

	public void BuyUpgrade(int index) {
		//function to check amount of cookies owned
		try {
			this.upgrades = d.findElements(By.cssSelector("div[id='upgrades'] div"));
			upgrades.get(index).click();
		} catch (IndexOutOfBoundsException e) {
			// wait for the page to load
			e.printStackTrace();
		}
	}

		

	public String getProductPrice(int index) {
			//function to check amount of cookies owned
		
			try {
				return store.get(index).findElement(By.cssSelector("div[id='products'] div[id*='product'] div[class='content'] span[class='price']")).getText();
			} catch (IndexOutOfBoundsException e) {
				// wait for the page to load
				e.printStackTrace();
			return "couldnt get price";
			
			
	}
}
}
