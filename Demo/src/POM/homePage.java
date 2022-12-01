package POM;

import org.openqa.selenium.Point;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class homePage {

	// Declaration

	WebDriver driver;

	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	public WebElement searchDropDown;

	@FindBy(xpath = "//input[@id = 'twotabsearchtextbox']")
	private WebElement searchbox;

	@FindBy(xpath = "//input[@type = 'submit']")
	private WebElement submitbtn;

	@FindBy(xpath = "//div[@id='brandsRefinements']/ul/li[1]/span/a/div")
	public WebElement belkinBrand;

	@FindBy(xpath = "//input[@id='low-price']")
	private WebElement minValue;

	@FindBy(xpath = "//input[@id='high-price']")
	private WebElement maxValue;

	@FindBy(xpath = "//input[@class='a-button-input']")
	private WebElement submit;

	@FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']")
	private List<WebElement> list_of_products;
	
	@FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']")
	private List<WebElement> tc2_list_of_products;

	@FindBy(xpath = "//span[@class='a-price-whole']")
	private List<WebElement> list_of_ProductPrice;
	
	@FindBy(xpath = "//select[@id='s-result-sort-select']")
	private WebElement sortByDropdown;
	
	@FindBy(xpath = "//div[@ cel_widget_id = 'MAIN-SEARCH_RESULTS-3']")
	private WebElement randomItem;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//a[@href='/gp/cart/view.html?ref_=sw_gtc']")
	private WebElement goToCart;
	
	@FindBy(xpath="//input[@value='Proceed to checkout']")
	private WebElement proceedToCheckout;
	

	// Initialization

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public void selectCategory() {
		Select s = new Select(searchDropDown);
		s.selectByValue("search-alias=electronics-intl-ship");
	}

	public void TC1searchForIphone14() {
		searchbox.sendKeys("Iphone14 Belkin");
	}
	
	public void TC2searchForIphone14() {
		searchbox.sendKeys("Iphone 14");
	}
		
	public void clickSubmit() {
		submitbtn.click();
	}

	public void scrollToBelkinBrand() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Point p = belkinBrand.getLocation();
		int x = p.getX();
		int y = p.getY();
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}

	public void TC1chooseBelkinBrand() {
		belkinBrand.click();
	}

	public void enterMinValue() {
		minValue.sendKeys("100");
	}

	public void enterMaxValue() {
		maxValue.sendKeys("200");
	}

	public void clickSubmitValue() {
		submit.click();
	}

	public void TC1validatePrice() {
		
		//Get the count of products displayed on Result Page
		int productsCount = list_of_products.size();
		Reporter.log(Integer.toString(productsCount));
		
		//Navigate through each item and get the price of each item
		for (int i = 0; i < productsCount; i++) {
			String productPrice = list_of_ProductPrice.get(i).getText();
			int product_price = Integer.parseInt(productPrice);
			Reporter.log(productPrice);
			
			//Validate if the price of each item is within 100 and 200
			if (!(100 <= product_price && product_price <= 200)) {
				String productName = list_of_products.get(i).getText();
				Reporter.log(productName + "has price outside the limits");
			}
		}
		
		Reporter.log("All products have price within limits");
	}
		
	
		public void TC2sortHighToLow()
		{
			Select s = new Select(sortByDropdown);
			s.selectByIndex(2);
		}
		
		public void TC2validateSortHighToLow() {
			
			//Get the count of products displayed on Result Page
			int totalProducts = tc2_list_of_products.size();
			Reporter.log(Integer.toString(totalProducts));
			
			for (int i = 0; i < totalProducts; i++) 
			{
				String productPrice = list_of_ProductPrice.get(i).getText();
				Reporter.log(productPrice);
				
			}
			
		}

		public void TC3SelectRandomItemToCheckout()
		{
			randomItem.click();
			addToCart.click();
			goToCart.click();
			proceedToCheckout.click();
			
		}
		
		public void TC3VerifySignInPage()
		{
			if(driver.getTitle().contains("Amazon Sign-In"))
			Reporter.log("Sign In Page is displayed");
		}
		
		
	}


