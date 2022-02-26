package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//input[@name='searchVal']")
	WebElement searchbox;

	@FindBy(xpath = "//button[@class='rilrtl-button']")
	WebElement searchbtn;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterProduct(String product)

	{
		searchbox.click();
		searchbox.sendKeys(product);
	}

	public void searchProduct() {
		searchbtn.click();
			}
}
