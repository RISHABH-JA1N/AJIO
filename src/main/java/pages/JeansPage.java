package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JeansPage {
	WebDriver driver;

	@FindBy(xpath = "(//*[@class='contentHolder'])[position()<=6]")
	List<WebElement> jeans;

	@FindBy(xpath = "(//*[@class='nameCls'])[position()<=6]")
	List<WebElement> nameList;

	@FindBy(xpath = "(//*[normalize-space(@class)='price'])[position()<=6]")
	List<WebElement> discountedPriceList;

	@FindBy(xpath = "(//*[@class='orginal-price'])[position()<=6]")
	List<WebElement> originalPriceList;

	public JeansPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> jeansNames() {
		return nameList;
	}

	public List<WebElement> jeansDiscountedPrice() {
		return discountedPriceList;
	}

	public List<WebElement> jeansOriginalPrice() {
		return originalPriceList;
	}

	public List<WebElement> jeansDetails() {
		return jeans;
	}

}
