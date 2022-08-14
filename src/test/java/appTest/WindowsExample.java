package appTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS); 
		
		String ParentWin = driver.getWindowHandle();
		System.out.println("Before clicking tab button: " + ParentWin);
		
		WebElement Tab = driver.findElement(By.id("tabButton"));
		Tab.click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		
		while(itr.hasNext()) {
			
			String currentHandel = itr.next();
			System.out.println(currentHandel);
			
			if(!currentHandel.equals(ParentWin)) {
				
				driver.switchTo().window(currentHandel);
				break;
			}
		}
		
		WebElement ChildWinElem = driver.findElement(By.tagName("h1"));
		System.out.println("Text on new window is " + ChildWinElem.getText() );
		driver.close();
		
		driver.switchTo().window(ParentWin);
		System.out.println("Back to PAranet window");
		driver.close();

	}

}
