package Encore_collections;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class web_Flow_Imp {
	static String url = "https://encorecollections-test.senseitech.com/#/signin";

	static String BMuser = "sachinBM";
	static String opsuser = "operational";

	public static void main(String[] args) throws Exception {
		webworkflow();
	}

	public static void webworkflow() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// URL
		driver.get(url);
		driver.manage().window().maximize();
		// Enter User name
		driver.findElement(By.name("username")).sendKeys(BMuser);
		// Enter Password
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath("//*[text()='Sign In Securely']")).click();

		// click on expand
//		driver.findElement(By.xpath("//*[@id='sidenav']/div/div/button/span[1]/mat-icon")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//============================================================================================================       
//BATCHES

		// click on Batches
		driver.findElement(By.xpath("//*[text()='BATCHES']")).click();

		int j = 1; // How many times you want to run

		// click on 1st receipt

		for (int i = 1; i <= j; i++) {

			driver.findElement(By.xpath("(//*[text()='Receipts'])[" + i + "]")).click();

//Select the check box all

			driver.findElement(By.xpath("(//*[@role='columnheader'])[1]")).click();

			// click on Acknowledge
			WebElement Ack = driver.findElement(By.xpath("//*[text()='Acknowledge']"));

			if (Ack.isEnabled() == true) {
				Ack.click();
				// To confirm the pop-up
				driver.findElement(By.xpath("//*[@id='yes-button']")).click();

				System.out.println("BATCH_ACKNOWLEDGED Successfully");
			}
//Click on Back button
			driver.findElement(By.xpath("//*[@title='Close']")).click();
		}

//=========================================================================================================       

		// RECEIPTS
		// Click on Receipts tab
		driver.findElement(By.xpath("//*[text()='RECEIPTS']")).click();

		// To open Filter
		// driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav-content/div[1]/div/button[1]")).click();

		//

		// To close the expand button
		driver.findElement(By.xpath("//*[@title='Collapse']")).click();

		for (int a = 1; a <= 3; a++) {
			// To select Radio Button's
			driver.findElement(By.xpath("(//*[@class='mat-radio-label'])[" + a + "]")).click();

			// To select All check Box
			// driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav-content/table/thead/tr/th[1]")).click();
			Thread.sleep(3000);

			// TO select required no.of check box's
			for (int i = 1; i <= j; i++) {
				driver.findElement(By.xpath("(//*[@role='row' and contains(@class,'element')])[" + i + "]")).click();

			}

			// click on Add to DEP Slip
			WebElement Add_DEP = driver.findElement(By.xpath("//*[text()='Add To Dep Slip']"));
			String b = "";

			if (Add_DEP.isEnabled() == true) {
				Add_DEP.click();

				// To select the Bank Account
				driver.findElement(By.xpath("//*[@name='id']")).click();

				// To select HDFC
				driver.findElement(By.xpath("(//*[@role='option'])[1]")).click(); // Change to 2 if axis required

				// Click on Save
				driver.findElement(By.xpath("//*[text()='Save']")).click();

				if (a == 1) {
					b = "Cash";
				} else if (a == 2) {
					b = "Cheque";
				} else if (a == 3) {
					b = "DD";
				}

				System.out.println(b + "  Recipts Successfully");
			} else {
				System.out.println(b + "  No Receipts to create");
			}

		}

//=====================================================================================       

//DEPOSIT SLIP

		// Click on Deposit tab
		driver.findElement(By.xpath("//*[text()='DEPOSIT SLIPS']")).click();

		// To close the expand button
		driver.findElement(By.xpath("//*[@title='Collapse']")).click();

		// To click on All check box's
//    driver.findElement(By.xpath("//*[@role='columnheader']/mat-checkbox")).click();

		driver.findElement(By.xpath("(//*[@role='row' and contains(@class,'element')])[1]")).click();

		// Click on Submit Dep Slip
		WebElement Su_dep = driver.findElement(By.xpath("//*[text()='Submit Dep Slip']"));
		if (Su_dep.isEnabled() == true) {
			Su_dep.click();
			System.out.println("============ Successfully Deposit_slip_submitted ============");
		} else {
			System.out.println("No Deposite slip to submitted");
		}

		// =====================================================================================
		Thread.sleep(5000);
		// Sign Out menu
		driver.findElement(By.xpath("//*[text()='more_vert']")).click();

		// Sign Out
		driver.findElement(By.xpath("//*[text()='Sign Out']")).click();

		System.out.println("============ Successfully signed out ============");

//=====================================================================================    
//OPS  

		// Enter User name
		driver.findElement(By.name("username")).sendKeys(opsuser);
		// Enter Password
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath("//*[text()='Sign In Securely']")).click();

		
//      CASH/CHEQUE RECON	
		
		
		// click on Cash Recon tab
		driver.findElement(By.xpath("//*[text()=' playlist_add_check']")).click();
		driver.findElement(By.xpath("")).click();
		
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
		
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//      CASH/CHEQUE RECON
		int d = 7; // (for only cash change d=7 and c=7, for both cash&cheque d=7,c=8 )
		int c = 8; // (for only cheque d=8 and c=8)
		// CASH/Cheque RECON
		ArrayList<String> Recon = new ArrayList<String>();
		Recon.add("cash");
		Recon.add("cheque");

		for (int b = d; b <= c; b++) {
			// click on Cash/Cheque Recon tab
			driver.findElement(By.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[" + b
					+ "]/app-side-nav-list/a/div")).click();

			// To close the expand button
//			driver.findElement(By.xpath("//*[@id='sidenav']/div/div/button")).click();
			Thread.sleep(3000);

			if ((Recon.get(b - 7)).equals("cheque")) {
				// click on filter
				driver.findElement(By.xpath(
						"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/div[1]/div/button[1]"))
						.click();
				Thread.sleep(3000);
				// cancel the filter
				driver.findElement(By.xpath(
						"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/div[1]/form/mat-form-field[3]/div/div[1]/div[2]/button"))
						.click();
				Thread.sleep(3000);
			}

			// To select All check box's
//      driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cash-deposit/table/thead/tr/th[1]")).click();

			// To select required no.of check box's
			for (int i = 1; i <= j; i += 2) {
				driver.findElement(
						By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-"
								+ Recon.get(b - 7) + "-deposit/table/tbody/tr[" + i + "]/td[1]"))
						.click();

				// "/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cash-deposit/table/tbody/tr["+i+"]/td[1]")).click();
				Thread.sleep(3000);

				// Click on Cleared in Bank
				WebElement ClearedInBank = driver.findElement(
						By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-"
								+ Recon.get(b - 7) + "-deposit/div[2]/button[1]"));

				if (ClearedInBank.isEnabled() == true) {
					ClearedInBank.click();
					System.out.println(
							"================" + Recon.get(b - 7) + " Successfully Cleared in Bank ================");
				} else {
					System.out.println("No " + Recon.get(b - 7) + "  receipts selected");
				}

				// Click on Reject
//    WebElement RejectInBank = driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-"+a1.get(b-7)+"-deposit/div[2]/button[2]"));
//			
//			if(RejectInBank.isEnabled()==true) {
//				RejectInBank.click();
//			
//			// System.out.println("================"+Recon.get(b-7)+" Successfully Rejected
//			// ================");
//			}
//			else {
//				System.out.println("No "+Recon.get(b-7)+" receipts selected");
//			}
			}
		}

		driver.close();
		System.out.println("============ WEB Workflow is Completed ====================");
	}
}