package Scripts;

import org.testng.annotations.Test;
import Generic.BaseTest;
import POM.homePage;


public class sortHighToLow extends BaseTest {

	@Test
	public void sortPrice() 
	{
	
		homePage hp = new homePage(driver);

		hp.selectCategory();	//Step 2: Select category is Electronics on Search field
		hp.TC2searchForIphone14(); //Step 3: Search item iPhone 14 
		hp.clickSubmit();

		// scroll down to select Featured Brands and Price
		hp.scrollToBelkinBrand();
		hp.enterMinValue();		 //Step 4 : Input Price min as 100$, max as 2000$	
		hp.enterMaxValue();
		hp.clickSubmitValue();
		hp.TC2sortHighToLow();
		hp.TC2validateSortHighToLow();     
	}
}
