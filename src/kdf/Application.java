package kdf;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import utils.GenericMsg;


public class Application {
	@Test
	public void invalidLoginTest() throws IOException {
		String data[][]= GenericMsg.getData("C:\\Users\\mmmta\\Desktop\\Qa Selenium\\Lab\\Selenium.xlsx", "Sheet2");
		Method mtd =  new Method();
		for (int i = 1; i < data.length; i++) {
			switch(data[i][3]) {
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser": 
				mtd.maxBrowser();
				break;
			case "implicitWait":
				mtd.implicitWait();
				break;
			case "navigateToApplication":
				mtd.navigateToApplication(data[i][6]);
				break;
			case "enterUserId":
				mtd.invalidUserId(data[i][5], data[i][6]);
				break;
			case "enterPassword":
				mtd.enterPasswd(data[i][5], data[i][6]);
				break;
			case "clickButton":
				mtd.clickBtn(data[i][4], data[i][5]);
				break;
				
			case "verifyErrMsg":
				String actualMsg = mtd.verifyErrMsg(data[i][4], data[i][5]);

				String expectedMsg = data[i][6];
				Assert.assertEquals(expectedMsg, actualMsg);
				break;
				
			case "closeApplication":
				mtd.closebrowser();
				break;
			}

		}
	}
}
