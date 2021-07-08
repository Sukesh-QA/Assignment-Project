package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import configuration.Helper;

public class TransLinkTest extends Helper {
	
	
	@Test
	public void transLinkTestCase1() throws InterruptedException {
		transLinkPage.nextBusClick();
		transLinkPage.busRouteText("99");
		transLinkPage.findNextBusClick();
		transLinkPage.addFavClick();
		transLinkPage.editNameText("Translink Auto Homework");
		transLinkPage.addFavBtnClick();
		String link = transLinkPage.myFavBtnClick();
		Assert.assertEquals(link, "https://www.translink.ca/next-bus/results/#/text/route/99/" );
		Assert.assertTrue(true,link);
		transLinkPage.favUrlClick();
		String text = transLinkPage.favUrlText();
		Assert.assertEquals(text, "99 Commercial-Broadway / UBC (B-Line)");
		transLinkPage.commLinkClick();
		Thread.sleep(2000);
		transLinkPage.linkTextClick();
		Assert.assertEquals(transLinkPage.busStpNoText(), "Stop # 61935");
	}

}
