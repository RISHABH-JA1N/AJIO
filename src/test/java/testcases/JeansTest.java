package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.JeansPage;

public class JeansTest extends BaseTest {
	HomePage hp ;
	JeansPage jp;

	@Test(priority=1, description="Step 1,2,3 and 4 of Assignment",groups={"sanity","regression"})
	public void findProduct() {
		 hp = new HomePage(driver);
		 jp = new JeansPage(driver);
		hp.enterProduct("Jeans");
		hp.searchProduct();
		System.out.println("===========OPENED AJIO WEBSITE, CLICKED ON SEARCH TEXTBOX, TYPED VALUE JEANS AND HIT SEARCH BUTTON============\n");
	}
	
	@Test(priority=2, description="Step 5 of Assignment",groups={"regression"})
	public void nameList(){
		System.out.println("===========NAME LIST:============");
		for(WebElement e:jp.jeansNames())
		{
			System.out.println(e.getText());
		}
	}
	
	@Test(priority=2, description="Step 5 of Assignment")
	public void discountedPriceList(){
		System.out.println("============DISCOUNTED PRICE LIST:============");
		for(WebElement e:jp.jeansDiscountedPrice())
		{
			System.out.println(e.getText());
		}
	}
	
	@Test(priority=2,description="Step 5 of Assignment")
	public void originalPriceList(){
		
		System.out.println("=============ORIGINAL PRICE LIST:=============");
		for(WebElement e:jp.jeansOriginalPrice())
		{		
			System.out.println(e.getText());			
		}
	}
	
	@Test(priority=3, description="Step 6 of Assignment")
	public void details(){
		System.out.println("===========FIRST SIX JEANS NAME, DISCOUNTED VALUE AND ORIGINAL VALUE ARE:============");
		for(WebElement element:jp.jeansDetails())
		{
		System.out.println("Jeans name is:"+element.findElement(By.className("nameCls")).getText());
		System.out.println("Jeans discounted price is:"+element.findElement(By.className("price")).getText());
		System.out.println("Jeans original price is:"+element.findElement(By.className("orginal-price")).getText()+"\n");
		
		}
	}
	
	@Test(priority=4, description="Step 7 of Assignment")
	public void highPriceJeans(){
		System.out.println("=============NAME AND ORIGINAL PRICE OF HIGHEST ORIGINAL PRICE JEANS:=============");
		int highestOrgPrice=0;
		String name=null;
		for(WebElement e:jp.jeansDetails())
		{			
			int orgPrice=Integer.parseInt(e.findElement(By.className("orginal-price")).getText().replace("₹","").replace(",",""));
			if(highestOrgPrice<orgPrice)
			{
				highestOrgPrice=orgPrice;
				name=e.findElement(By.className("nameCls")).getText();
			}
		}
		System.out.println("Name of the item whose Original value is highest:"+name);
		System.out.println("Original price of the item whose Original value is highest:"+highestOrgPrice+"\n");
	}

}

