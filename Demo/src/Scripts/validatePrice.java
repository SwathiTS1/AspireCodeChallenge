package Scripts;

import org.testng.annotations.Test;
import Generic.BaseTest;
import POM.homePage;


public class validatePrice extends BaseTest {

	@Test
	public void Pricebetween100And200() 
	{
		
		homePage hp = new homePage(driver);

		hp.selectCategory();	//Step 2: Select category is Electronics on Search field
		hp.TC1searchForIphone14(); //Step 3: Search item iPhone 14 
		hp.clickSubmit();

		// scroll down to select Featured Brands and Price
		hp.scrollToBelkinBrand();
		hp.TC1chooseBelkinBrand();   //Step 4: Select Featured Brands as Belkin
		hp.enterMinValue();		 //Step 5 : Input Price min as 100$, max as 2000$	
		hp.enterMaxValue();
		hp.clickSubmitValue();
		hp.TC1validatePrice();      //Step 6 : Validate price of each item
	}
}
