package AutomationLabCodenBoxFinal.AutomationLabCodenBoxFinal;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	WebDriver driver = new EdgeDriver();
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	@BeforeTest
	public void Setup() {
		String URL = "https://codenboxautomationlab.com/practice/";
		driver.manage().window().maximize();
		driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test (priority = 1, enabled = false)
	public void TestRadioBtnSelection() {
		List<WebElement> RadioBtns = driver.findElements(By.className("radioButton"));
		
		for (int i = 0; i < RadioBtns.size(); i++) {
			RadioBtns.get(i).click();
		}
		
//		for (WebElement radio : RadioBtns) {
//			radio.click();
//		}
		
		
	}
	
	@Test (priority = 2, enabled = false)
	public void TestDynamicDDL() {
		WebElement DynamicDDL = driver.findElement(By.id("autocomplete"));
		DynamicDDL.sendKeys("Jor");
		
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li.ui-menu-item")));
		
		List<WebElement> Suggestions = driver.findElements(By.cssSelector("li.ui-menu-item"));
		
		
		for (WebElement suggestion : Suggestions) {
			String text = suggestion.getText();
            System.out.println("Suggestion: " + text);
			
			if (text.equalsIgnoreCase("Jordan")) {
				suggestion.click();
				break;
			}
		}
	}
	
	@Test (priority = 3, enabled = false)
	public void TestStaticDDL() {
		WebElement StaticDDL = driver.findElement(By.id("dropdown-class-example"));
		//StaticDDL.click();
		
		Select select = new Select(StaticDDL);
		
		// loop to select all list items
//	    List<WebElement> options = select.getOptions();
//	    for (int i = 0; i < options.size(); i++ ) {
//	    	select.selectByIndex(i);
//	    	
//	    	select.getFirstSelectedOption().getText();
//	    } 
	    
	    //select by item
        //select.selectByVisibleText("Selenium"); // Select  by visible text
        select.selectByValue("option2"); // Select  by value
        //select.selectByIndex(3); // Select "API" by index        
        select.getFirstSelectedOption().getText();
        
	}
	
	@Test (priority = 4, enabled = false)
	public void TestCheckbox() {
		// Get all checkboxes inside the checkbox example section
		List<WebElement> CheckBoxes = driver.findElements(By.cssSelector("#checkbox-example input[type='checkbox']"));
		for (WebElement checkBox : CheckBoxes) {
			if (!checkBox.isSelected()) {
				checkBox.click();
			}
		}
		
		//uncheck option2
		WebElement Option2 = driver.findElement(By.id("checkBoxOption2"));
		Option2.click();
		
	}	
	
	@Test (priority = 5, enabled = false)
	public void TestSwitchWindow() {
		String MainWindowHandle = driver.getWindowHandle();
		
		driver.findElement(By.id("openwindow")).click();
		
		Set <String> AllWindowsHandle = driver.getWindowHandles();
		
		for (String handle : AllWindowsHandle) {
			if (!handle.equals(MainWindowHandle)) {
				
				driver.switchTo().window(handle);
				
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				
				driver.close();
				
				driver.switchTo().window(MainWindowHandle);
				break;
				
			}
		}
	}
	@Test (priority = 6, enabled = false)
	public void TestSwitchTab() {
		String originalTab = driver.getWindowHandle();
		
		driver.findElement(By.id("opentab")).click();
		
		Set <String> AllTabs = driver.getWindowHandles();
		
		for (String tab : AllTabs) {
			if (!tab.equals(originalTab)) {
				
				driver.switchTo().window(tab);
				
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				
				driver.close();
				
				driver.switchTo().window(originalTab);
				break;
				
			}
		}
	}
	
	@Test (priority = 7, enabled = false)
	public void TestSwitchToAlert() {
		WebElement TxtBox = driver.findElement(By.id("name"));
		TxtBox.sendKeys("AFannoun");
		WebElement AlertBtn = driver.findElement(By.id("alertbtn"));
		AlertBtn.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		
		
		//WebElement ConfirmBtn = driver.findElement(By.id("confirmbtn"));
		//ConfirmBtn.click();
	}
	
	@Test (priority = 8, enabled = false)
	public void TestSwitchToConfirm() {
		WebElement TxtBox = driver.findElement(By.id("name"));
		TxtBox.sendKeys("Test");
		WebElement ConfirmBtn = driver.findElement(By.id("confirmbtn"));
		ConfirmBtn.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.dismiss();
		
		
		
	}
	@Test(priority = 9, enabled = false)
	public void TableTest() {

		// to prirnt all the rows

//		WebElement theTable = driver.findElement(By.id("product"));
//
//		List<WebElement> AllRows = theTable.findElements(By.tagName("tr"));
//		List<WebElement> AllData = theTable.findElements(By.tagName("td"));
//
//		// this is the logic to print random row
//
////	int randomRow = 	rand.nextInt(AllRows.size());
////		System.out.println(AllRows.get(randomRow).getText());
//
//		// to print all the rows
////		for (int i = 0; i < AllRows.size(); i++) {
////
////			System.out.println(AllRows.get(i).getText());
////		}
//		
//		for (int i = 0; i < AllData.size(); i++) {
//
//			System.out.println(AllData.get(i).getText());
//		}
		
	    List<WebElement> rows = driver.findElements(By.cssSelector("#product tbody tr"));

	    for (int i = 1; i < rows.size(); i++) { 
	        List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
	        
	        System.out.println(columns.get(2).getText()); //0 = Instructor, 1 = Course, 2 = Price
	    }		
		
	}
	@Test(priority = 10, enabled = false)
	public void ElementDisplayedTest() {
		
		js.executeScript("window.scroll(0,1500)");
		
		WebElement HideBtn = driver.findElement(By.id("hide-textbox"));
		HideBtn.click();
		
		WebElement ShowBtn = driver.findElement(By.id("show-textbox"));
		ShowBtn.click();
		
		WebElement InputField = driver.findElement(By.id("displayed-text"));
		InputField.sendKeys("Test123!");
	}
	
	@Test(priority = 11, enabled = false)
	public void MouseHoverTest() throws InterruptedException {
		js.executeScript("window.scroll(0,1800)");
		WebElement MouseHover = driver.findElement(By.id("mousehover"));
		
		Actions action = new Actions(driver);
		action.moveToElement(MouseHover).click().perform();
		Thread.sleep(1000);
		
		WebElement Top = driver.findElement(By.linkText("Top"));
		Top.click();
		
		Thread.sleep(2000);

		
		
		js.executeScript("window.scroll(0,1800)");
		action.moveToElement(MouseHover).click().perform();
		WebElement Reload = driver.findElement(By.partialLinkText("Relo")); // partial link
		Reload.click();
	}
	
	@Test (priority = 12, enabled = false)
	public void IFrameTest() throws InterruptedException {
		js.executeScript("window.scroll(0,2000)");
		
		Thread.sleep(2000);
		driver.switchTo().frame("iframe-name");
		Thread.sleep(2000);
		WebElement BurgerMenu = driver.findElement(By.cssSelector(".ct-mobile-meta-item.btn-nav-mobile.open-menu"));
		BurgerMenu.click();
		
		Set<String> handles = driver.getWindowHandles();

		List<String> TabList = new ArrayList<>(handles);

		driver.switchTo().window(TabList.get(0));
		Thread.sleep(2000);

		WebElement CalenderTab = driver.findElement(By.linkText("Booking Calendar"));
		CalenderTab.click();
		Thread.sleep(2000);

		Set<String> handles2 = driver.getWindowHandles();

		List<String> TabList2 = new ArrayList<>(handles2);

		driver.switchTo().window(TabList2.get(1));
		
		System.out.println(driver.getTitle());

		
		
		Thread.sleep(2000);

	}
	
	@Test(priority = 15)
	public void DownloadApp() {
		WebElement DownloadButton = driver.findElement(By.linkText("Download Apk files"));
				DownloadButton.click();
	}
	

}
