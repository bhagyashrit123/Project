package Project.NewSelenium;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testconfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Properties per=new Properties();
			FileInputStream fi=new FileInputStream("C:\\Users\\SWATI\\eclipse-workspace\\NewSelenium\\src\\config.properties");
			per.load(fi);
			WebDriver driver=null;
			String browsername=per.getProperty("BROWSER");
			System.out.println("browsername-----------"+browsername);
			if(browsername.equalsIgnoreCase("ChromeBrowser"))
			{
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
			}else
				if(browsername.equalsIgnoreCase("EdgeDriver")){
					WebDriverManager.edgedriver().setup();
					driver= new EdgeDriver();
			}else {
				
			}
			String url=per.getProperty("URL");
			driver.get(url);
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			String woman_xpath=per.getProperty("woman_xpath");
			//System.out.println("woman_xpath----"+woman_xpath); 
			WebElement mainMenu = driver.findElement(By.xpath(woman_xpath));
			actions.moveToElement(mainMenu).perform();
			driver.manage().window().maximize();
			//Thread.sleep(4000);
			String top_linktext=per.getProperty("Top");
			WebElement top=driver.findElement(By.linkText(top_linktext));
			actions.moveToElement(top).perform();
			//Thread.sleep(4000);
			String jacket_linktext=per.getProperty("Jacket");
			WebElement jacket=driver.findElement(By.linkText(jacket_linktext));
			actions.moveToElement(jacket).click().build().perform();
	
			driver.manage().window().maximize();
			String img_link=per.getProperty("image_link");
			WebElement imglink=driver.findElement(By.xpath(img_link));
			imglink.click();
			
			String size=per.getProperty("size");
			WebElement size_id=driver.findElement(By.id(size));
			actions.moveToElement(size_id).click().build().perform();
			
			String colour=per.getProperty("colorid");
			WebElement color_id=driver.findElement(By.id(colour));
			actions.moveToElement(color_id).click().build().perform();
			
						
			String cart=per.getProperty("addtocart");
			WebElement cart_id=driver.findElement(By.id(cart));
			actions.moveToElement(cart_id).click().build().perform();
			
			driver.get("https://magento.softwaretestingboard.com/checkout/cart/");
			Thread.sleep(3000);
			
			String proceed=per.getProperty("proceed");
			WebElement proceed_xpath=driver.findElement(By.xpath(proceed));
			actions.moveToElement(proceed_xpath).click().build().perform();			
				
			
		}catch(Exception e)
		{
			e.printStackTrace();			}
	}

}
