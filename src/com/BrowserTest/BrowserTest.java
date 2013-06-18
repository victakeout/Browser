package com.BrowserTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.R.id;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.BrowserTest.By.TagName;

 
//@SuppressWarnings("rawtypes")
public class BrowserTest extends ActivityInstrumentationTestCase2 {
	private static final String TARGET_PACKAGE_ID="com.android.Browser";
	private static final String  LAUNCHER_ACTIVITY_FULL_CLASSNAME="com.android.browser.BrowserActivity";
 
	private static Class launcherActivityClass;
	private Solo solo;
	private WebView webview;
//http://blog.csdn.net/frdde/article/details/7460211
	//http://hi.baidu.com/hulijun168/item/3d3b5492412d1c1f924f414d
	static{
		
		try {
			launcherActivityClass=Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
			} catch (ClassNotFoundException e){ 
				throw new RuntimeException(e); 
			}
		}  
 
	@SuppressWarnings({ "unchecked", "deprecation" })
	public BrowserTest()throws ClassNotFoundException{
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	
	public void setUp()throws Exception{
		solo = new Solo(getInstrumentation(),getActivity());
		solo.sleep(3000);
		webview=solo.getCurrentViews(WebView.class).get(0);
		solo.sleep(2000);

		}
	public void testDomLocationSendToNew() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/location/change.html");
		  solo.sleep(3000);
		  solo.clickOnWebElement("Show current URL", 0, true);
		  solo.sleep(2000);
		  boolean actual_result=false;
		  actual_result=solo.waitForText("http://123.71.192.55:8001/Browser/DOM/location/change.html");                                                                                                                                                                                                                                                                  
		  solo.sleep(2000);
		  solo.clickOnText("OK");
		  solo.sleep(1000);
		  solo.clickOnWebElement("Change URL", 0, true);
		  solo.sleep(6000);
		  if(webview.getUrl().equals("http://wap.yahoo.com/")||webview.getUrl().equals("http://hk.yahoo.com/")||webview.getUrl().equals("http://hk.m.yahoo.com/")){
			  actual_result=true;
		  }
		 else{
			 actual_result=false;
		 }
		 assertEquals("Curren url is wrong", true, actual_result);
		  
	}
	 public void testDomFormRadioButton() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/radio.html");
		  solo.sleep(3000);
		  solo.clickOnWebElement("Internet Explorer", 0, true);
		  solo.sleep(3000);
		  boolean actual_result=false;
		  for(WebElement web:solo.getCurrentWebElements()){
			  if(web.getId().equals("answer"))
				  if(web.getvalue().equals("Internet Explorer"))
					  actual_result=true;
				  
		  }
		  assertEquals("Convert to upper false", true, actual_result);
		   
	} 
 
 public void testDomReturnReffer() throws Exception{
		   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/referrer.html");
		   solo.sleep(2000);
		   boolean actual_result=solo.waitForText("The referrer of this document is:");
		   solo.sleep(2000);
		   assertEquals("reffer url doesn't is", true, actual_result);
		  
	   }
 
  public void testDomImageChangeImageHeightAndWidth() throws Exception {
		  solo.sleep(3000);
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/image/height_width.html");  
		  solo.sleep(3000);
		  solo.takeScreenshot("HeightAndWidth");
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("HeightAndWidth_2");
		  boolean actual_result=false;
		  actual_result = solo.imageCompare("HeightAndWidth.jpg", "HeightAndWidth_2.jpg",0,0,99);
		  solo.sleep(1000);
		  assertEquals("Convert to upper false", true, actual_result);
		  
	}
 public void testDomFrameUpdateTwoFrame() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/frame/iframe_source.html");
		  solo.sleep(3000);
		  solo.takeScreenshot("UpdateTwoFrame");
		  solo.sleep(1000);
		  solo.clickOnWebElement("Change source of the two iframes", 0, true);
		  solo.sleep(3000);
		  solo.takeScreenshot("UpdateTwoFrame_2");
		  boolean actual_result=false;
		  actual_result = solo.imageCompare("UpdateTwoFrame.jpg", "UpdateTwoFrame_2.jpg",0,0,99);
		  solo.sleep(3000);
		  assertEquals("Convert to upper false", true, actual_result);
		 
	} 
	 public void testDomFrameChangeSrc() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/frame/source.html");
		  solo.sleep(3000);
		  solo.takeScreenshot("ChangeSrcBefore");
		  solo.sleep(3000);
		  solo.clickOnWebElement(new By.GetFrameItem("leftFrame","INPUT"));
		  solo.sleep(20000);
		  solo.takeScreenshot("ChangeSrcAfter");
		  boolean actual_result=false;
		  actual_result = solo.imageCompare("ChangeSrcBefore.jpg", "ChangeSrcAfter.jpg",webview.getWidth()-310,300,90);
		  solo.sleep(3000);
		  assertEquals("Convert to upper false", true, actual_result);
		 
		  
	} 
public void testDomFrameBreakOut() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/frame/breakout.html");
		  solo.sleep(3000);
		  solo.takeScreenshot("breakout");
		  solo.sleep(3000);
		  solo.clickOnWebElement(new By.GetFrameItem("leftFrame","INPUT"), 0);
		  //solo.clickOnWebElement("Break out of frame", 0, false);
		  solo.sleep(3000);
		  solo.takeScreenshot("breakout01");
		  solo.sleep(3000);
		  boolean actual_result=true;
		  actual_result = solo.imageCompare("breakout.jpg", "breakout01.jpg",webview.getWidth()-310,300,95);
		  solo.sleep(3000);
		  assertEquals("Convert to upper false", true, actual_result);
		  
		  
	}
 public void testDomFormSelectText() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/select_text.html");
		  solo.sleep(3000);
		  boolean actual_result = false;
		  solo.takeScreenshot("slectedtext");
		  solo.clickOnWebElement("Select text", 0, false);
		  solo.sleep(2000);
		  solo.takeScreenshot("slectedtext01");
		  solo.sleep(1000);
		  actual_result = solo.imageCompare("slectedtext.jpg", "slectedtext01.jpg", 0, 0, 96);
		  assertEquals("Submit false", true, actual_result);
		  
	}  
	
  public void testDomFormCheckboxInForm() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/checkbox_in_form.html");
		  solo.sleep(2000);
		  solo.takeScreenshot("sugar",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement("sugar", 0, true);
		  solo.sleep(1000);
		  solo.clickOnWebElement("Send order",0,true);
		  solo.sleep(1000);
		  solo.takeScreenshot("sugar_2",100);
		  solo.sleep(1000);
		  boolean actual_result=false;  
		 // for(WebElement web:solo.getCurrentWebElements()){
		  if(ImageCompare.compareImage("sugar.jpg", "sugar_2.jpg", 0,0,99)){
			  actual_result = true;
			  }
		  assertEquals("Convert to upper false", true, actual_result);
		   
	}  
// below is  DOM  group
  public void testDomChangeImage() throws Exception{
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/change_action.html");
	   solo.sleep(3000);
	   solo.clickOnWebElement("Change action attribute and submit form", 0, true);
	   solo.sleep(1000);
	   solo.clickOnButton("OK");
	   solo.sleep(1000);
	   solo.clickOnButton("OK");
	   boolean acturl = solo.searchText("Your name is:");
	   assertEquals("Sohu doesn't displayed", true, acturl);
	   solo.sleep(1000);
	    //test
	 
}   
  public void testDomWriteText() throws Exception{
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/write_text.html");
	   boolean actual_result_writetext=solo.waitForText("Hello World");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result_writetext);
	  
	   
  }
  public void testDomWriteTextWithFormat() throws Exception {
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/text_with_format.html");
	   boolean actual_result_writetextwithFormat=solo.waitForText("This is a header");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result_writetextwithFormat);
	  
	    
  }
  public void testDomWriteTitle() throws Exception {
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/title.html");
	   boolean actual_result_writeTitle=solo.waitForText("My title");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result_writeTitle);
   
  }

  public void testDomReturnDomain() throws Exception{
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/domain.html");
		   boolean actual_result=solo.waitForText("123.71.192.55");
		   solo.sleep(2000);
		   assertEquals("Sohu doesn't displayed", true, actual_result);
		    
	  }
  public void testDomGetElementByID() throws Exception{
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/getelementbyid.html");
	   solo.sleep(3000);
	   solo.clickOnWebElement(new By.Id("myHeader"));
	   boolean actual_result=solo.waitForText("This is a header");
	   solo.clickOnButton("OK");
	   //solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result);
	  
}
  public void testDomGetElementName() throws Exception{
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/text_with_format.html");
	   solo.sleep(3000);
	   boolean actual_result=solo.waitForText("This is a header");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result);
	 
}  
  public void testDomAnchorOpenNewDocument() throws Exception{
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/open.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("Learning about the DOM is FUN!");
	  assertEquals("Learning about the DOM is FUN", true, actual_result);
	  
 }
  public void testDomAchorReturnNumberOfAnchor() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/number_of_anchors.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("3");
	  assertEquals("Number of Anchor", true, actual_result);
	   
 }
  public void testDomAchorReturnFirstAnchor() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/1st_anchor.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("First anchor", 2, 3000);
	  assertEquals("Number of First Anchor", true, actual_result);
	
	   
 }
  public void testDomAchorReturnNumberOfForms() throws Exception {
	webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/number_of_forms.html");
	solo.sleep(3000);
	boolean actual_result=solo.waitForText("3 forms");
	assertEquals("Number of forms", true, actual_result);
	
	 
}
  public void testDomAchorReturnAccessItemInCollection() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/access_item.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("The first form's name is: Form1", 2, 3000);
	  assertEquals("Number of forms", true, actual_result);
	
	  
 }
  public void testDomAchorReturnCountOfImage() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/number_of_images.html");
	  
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("2 images");
	  assertEquals("Number of forms", true, actual_result);

	  
 }  
 
  public void testDomFormCheckBox() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/checkbox.html");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Id("fname"), "aaa");
	  solo.sleep(2000);
	  solo.enterTextInWebElement(new By.Id("lname"), "bbb");
	  solo.sleep(2000);
	  solo.clickOnWebElement(new By.Name("checkbox"));
	  solo.sleep(4000);
	  boolean actual_result = false;
	  for(WebElement web:solo.getCurrentWebElements()){
		if(web.getId().equals("fname")&&web.getvalue().equals("AAA")){
			actual_result=true;
			 }
		  else if(web.getId().equals("lname")&&web.getvalue().equals("BBB"))
				  actual_result=true;
	   }
	  assertEquals("Convert to upper false", true, actual_result);
	   
}

  public void testDomFormResetForm() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/reset.html");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Name("name"), "aaa");
	  solo.sleep(2000);
	  solo.enterTextInWebElement(new By.Name("age"), "bbb");
	  solo.sleep(2000);
	  solo.clickOnWebElement("Reset", 0, true);
	  solo.sleep(4000);
	  boolean actual_result = false;
	  boolean actual_result_age = false;
	  for(WebElement web:solo.getCurrentWebElements()){
		  Log.e(web.getName()+"/"+web.getvalue(), "value1");
	  if(web.getName().equals("name")&&web.getvalue() ==null){
			actual_result=true;
	    }
	  if(web.getName().equals("age")&&web.getvalue() == null){
				actual_result_age=true;
	  }
		}
	  if(actual_result&actual_result_age)
		  actual_result = true;
	  assertEquals("Cannot reset form", true, actual_result);
	 
	  
}
  public void testDomFormSubmitForm() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/submit.html");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Name("firstname"), "aaa");
	  solo.sleep(2000);
	  solo.enterTextInWebElement(new By.Name("lastname"), "bbb");
	  solo.sleep(2000);
	  solo.clickOnWebElement("Submit", 0, true);
	  solo.sleep(2000);
	  boolean actual_result=webview.getUrl().equals("http://123.71.192.55:8001/Browser/DOM/form/js_form_action.php?firstname=aaa&lastname=bbb");
	  solo.sleep(2000);
	  assertEquals("Current URL is wrong ", true, actual_result);
	  
}  
  public void testDomFormValidateForm() throws Exception{
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/validate.html");
	  solo.sleep(3000);
	  boolean actual_result = false;
	  solo.clickOnWebElement("Submit", 0, true);
	  solo.sleep(3000);
	  actual_result = solo.waitForText("The age must be a number between 1 and 100");
	  solo.clickOnText("OK");
	  actual_result = solo.waitForText("Not a valid e-mail!");
	  solo.clickOnText("OK");
	  solo.enterTextInWebElement(new By.Id("fname"), "aaa");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Id("age"), "12");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Id("email"), "aaa@gmail.com");
	  solo.sleep(3000);
	  solo.clickOnWebElement("Submit", 0, true);
	  actual_result = solo.waitForText("our input has been submitted");
	  assertEquals("Submit false", true, actual_result);
	   
}

  public void testDomFormAnotherDropDown() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/dropdown2.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.Id("no"));
	  solo.sleep(2000);
	  solo.clickOnText("1");
	  solo.sleep(2000);
	  solo.clickOnWebElement("-->", 0, true);
	  solo.sleep(3000);
	  boolean actual_result = false;
	  for(WebElement web:solo.getCurrentWebElements()){
		  if(web.getId().equals("result")&&web.getvalue().equals("1"))
			  actual_result = true;

	  }
	  assertEquals("Cannot get Id, type, value information", true, actual_result);
}
  public void testDomFormSelectDropDownlist() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/dropdown_menu.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.Id("menu"));
	  solo.sleep(2000);
	  solo.clickOnText("Sina");
	  solo.sleep(5000);
	  boolean actual_result = webview.getUrl().equals("http://sina.cn/");
	  assertEquals("Convert to upper false", true, actual_result);
	  
	 
}   

  public void testDomLinkCharest() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/charset.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("Charset=ISO-8859-1");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
	   
}
  public void testDomLinkDisableStyle() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/disable.html");
	  solo.sleep(3000);
	  solo.takeScreenshot("linkDisable");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  solo.takeScreenshot("linkDisable01");
    solo.sleep(3000);
    boolean actual_result = solo.imageCompare("linkDisable.jpg", "linkDisable01.jpg", 0, 0, 37);
    solo.sleep(3000);
	  assertEquals("Convert to upper false", false, actual_result);
	   
}
  public void testDomLinkHref() throws Exception {
	  solo.sleep(2000);
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/href.html");
	  solo.sleep(3000);
	  solo.takeScreenshot("LinkHref");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  solo.takeScreenshot("LinkHref01");
    solo.sleep(3000);
    boolean actual_result = solo.imageCompare("LinkHref.jpg", "LinkHref01.jpg", 0, 0, 37);
    solo.sleep(3000);
	  assertEquals("Convert to upper false", false, actual_result);
	  
}
  public void testDomLinkHrefLang() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/hreflang.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("Language code=us-en");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
	  
}
  public void testDomLinkID() throws Exception{
	  solo.sleep(2000);
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/id.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("Id of link=style1");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
	  
}
  public void testDomLinkMedia() throws Exception {
	  solo.sleep(2000);
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/media.html");
	  solo.sleep(3000);
	  solo.takeScreenshot("LinkMedia");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  solo.takeScreenshot("LinkMedia01");
    solo.sleep(3000);
    boolean actual_result = solo.imageCompare("LinkMedia.jpg", "LinkMedia01.jpg", 0, 0, 37);
    solo.sleep(3000);
	  assertEquals("Convert to upper false", false, actual_result);
	 
}
  public void testDomLinkAlertID() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/name.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  boolean actual_result = solo.waitForText("undefined");
	  solo.clickOnText("OK");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
	  
}
  public void testDomLinkRel() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/rel.html");
	  boolean actual_result=solo.waitForText("Relationship: stylesheet");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
	 
}
  public void testDomLinkType() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/type.html");
	  boolean actual_result=solo.waitForText("MIME type: text/css");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
	   
}  
 
  public void testDomFrameChangeSourceOfTwoFrame() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/image/source.html");
	  solo.sleep(3000);
	  for(WebElement web:solo.getCurrentWebElements()){
		  Log.e(web.getTagName()+"/"+web.getText(), "value2");
			  
	  }
	  
} 

 

  public void testDomFrameScroll() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/frame/scroll.html");
		  solo.sleep(3000);
		  for(WebElement web:solo.getCurrentWebElements(new By.GetFrameItem("leftFrame","INPUT"))){
			  Log.e(web.getTagName()+"/"+web.getText(), "value2");
			  if(web.getvalue().equals("Scroll bars")){
				  solo.clickOnScreen(web.getLocationX(), web.getLocationY());
				  solo.sleep(3000);
			  
			  }
			  else
				  Log.e("Not found web item", "Webtest");
		  }
		  
	  }  
 /* public void testJavaScriptBasic_WriteText() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Write text with JavaScript");
	  boolean actual_result = solo.waitForText("Hello World!");
	  assertEquals("WriteText", true, actual_result);  
	 
  }
public void testJavaScriptBasic_WriteHTML() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Write HTML tags with JavaScript");
	  boolean actual_result = solo.waitForText("This is a header");
	  assertEquals("WriteHTML", true, actual_result);  
	   
  }
public void testJavaScriptBasic_InBody() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("JavaScript in body section");
	  boolean actual_result = solo.waitForText("This message is written by JavaScript");
	  assertEquals("InBody", true, actual_result);  
 
  }
public void testJavaScriptBasic_InHead() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("JavaScript in head section");
	  boolean actual_result  = false;
	  solo.waitForDialogToOpen(20);
	  if( solo.waitForText("This alert box was called with the onload event")){
		 solo.clickOnButton("OK");
		actual_result = true;
	  }
	  assertEquals("InHead", true, actual_result);
 
  }
public void testJavaScriptBasic_External() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	 // for(WebElement web:solo.getCurrentWebElements()){
		   if(solo.searchText("External JavaScript 1")){
			   solo.clickOnText("External JavaScript 1");
		 //  }
			   
		}
	//  solo.clickOnText("External JavaScript 1");
	  //boolean actual_result = solo.waitForText("This text was written by an external script!",true);
	  boolean actual_result = solo.searchText("This text was written by an external script!",true);
	  assertEquals("External", true, actual_result);  
	  solo.goBack();
  }
public void testJavaScriptBasic_External_2() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("External JavaScript 2");
	  boolean actual_result = solo.waitForText("The actual script is in an external script file called \"external.js\".");
	  assertEquals("External_2", true, actual_result);  
	  
  } 
public void testJavaScriptBasic_Statements() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("JavaScript statements");
	  boolean actual_result = solo.searchText("This is another paragraph");
	  assertEquals("Statements", true, actual_result);
	   
  }
public void testJavaScriptBasic_SingleLine() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Single line comments");
	  boolean actual_result = solo.searchText("This is another paragraph");
	  assertEquals("SingleLine", true, actual_result);
	 
  }
public void testJavaScriptBasic_MultipleLine() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Multiple line comments");
	  boolean actual_result = solo.searchText("This is another paragraph");
	  assertEquals("Multiple line", true, actual_result); 
	   
  }
public void testJavaScriptBasic_Prevent() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Single line comment to prevent execution");
	  boolean actual_result = solo.searchText("This is a paragraph");
	  assertEquals("prevent", true, actual_result);  
	   
  }
public void testJavaScriptBasic_MultiplePrevent() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Multiple lines comment to prevent execution");
	  boolean actual_result = solo.searchText("This is another paragraph");
	  assertEquals("MultiplePrevent", true, actual_result);  
	   
  } 
public void testJavaScriptBasic_Variables() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Declare a variable");
	  boolean actual_result = solo.searchText("The script above declares a variable");
	  assertEquals("Variables", true, actual_result);  
	   
  }

public void testJavaScriptBasic_Condition_if_else() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("If...else statement");
	  Date date = new Date();
	  boolean actual_result = false;
	  int hours = date.getHours();
	  if (hours < 10) 
	  {
	  solo.searchText("Good morning!");
	  actual_result = true;
	  }
	  else if (hours >=10 & hours <=12)
	  {
	  solo.searchText("Good noon!");
	  actual_result = true;
	  }
	  else if (hours >13 & hours <=17)
	  {
	  solo.searchText("Good afternoon!");
	  actual_result = true;
	  } 
	  else if (hours >17 & hours <=20)
	  {
	  solo.searchText("Good evening!");
	  actual_result = true;
	  }
	  else
	  {
	  solo.searchText("Good night!");
	  actual_result = true;
	  }
	  assertEquals("Variables", true, actual_result);
	  
  } 
public void testJavaScriptBasic_Switch() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Switch statement");
	  boolean actual_result = false;
	  Date date = new Date();
	  //date.getDay();
	  switch (date.getDay())
	  {
	  case 0:
		  solo.searchText("Today is Sunday");
		  actual_result = true;
	    break;
	  case 1:
		  solo.searchText("Today is Monday");
		  actual_result = true;
	    break;
	  case 2:
		  solo.searchText("Today is Tuesday");
		  actual_result = true;
	    break;
	  case 3:
		  solo.searchText("Today is Wednesday");
		  actual_result = true;
	    break;
	  case 4:
		  solo.searchText("Today is Thursday");
		  actual_result = true;
	    break;
	  case 5:
		  solo.searchText("Today is Friday");
		  actual_result = true;
	    break;
	  default:
		  solo.searchText("Today is Saturday");
		  actual_result = true;
	  }
	  assertEquals("Switch", true, actual_result);  
	  
  } 

public void testJavaScriptBasic_Function() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Call a function");
	  solo.sleep(1000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.waitForDialogToOpen(20);
	  boolean actual_result = solo.searchText("HELLO");
	  solo.clickOnButton("OK");
	  assertEquals("Function", true, actual_result);
	  
  }
public void testJavaScriptBasic_Function_argument() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Function with an argument");
	  solo.sleep(1000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.waitForDialogToOpen(20);
	  boolean actual_result = solo.searchText("Hello");
	  solo.clickOnButton("OK");
	  assertEquals("argument", true, actual_result);  
	 
  }
public void testJavaScriptBasic_Function_argument_2() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Function with an argument 2");
	  solo.sleep(1000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.waitForDialogToOpen(20);
	  boolean actual_result = solo.searchText("Good Morning!");
	  solo.clickOnButton("OK");
	  assertEquals("argument_2", true, actual_result); 
	 
  }
public void testJavaScriptBasic_Function_Return_value() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Function that returns a value");
	  solo.sleep(1000);
	  boolean actual_result = solo.searchText("Following text is return from function call: Hello, have a nice day!");
	  assertEquals("Return_value", true, actual_result);  
	  
  }
public void testJavaScriptBasic_Function_Return_value_argument() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("Function with arguments, that returns a value");
	  solo.sleep(1000);
	  boolean actual_result = solo.searchText("4*3= 12");
	  assertEquals("value_argument", true, actual_result); 
	   
  } 

public void testJavaScriptBasic_Array_Create_Array() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/array.html");
	  solo.sleep(3000);
	  solo.clickOnText("Create an array");
	  boolean actual_result = solo.searchText("BMW") && solo.searchText("Volvo")&& solo.searchText("Saab");
	  assertEquals("BMW", true, actual_result);  
	  
  }
public void testJavaScriptBasic_Array_Through_Array() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/array.html");
	  solo.sleep(3000);
	  solo.clickOnText("Use for to loop through an array");
	  boolean actual_result = solo.searchText("Saab") && solo.searchText("Volvo")&& solo.searchText("Saab");
	  assertEquals("BMW", true, actual_result);  
	  
  }
public void testJavaScriptBasic_Array_Concat_Array() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/array.html");
	  solo.sleep(3000);
	  solo.clickOnText("Join two arrays with concat()");
	  boolean actual_result = solo.searchText("Jani,Tove,Hege,John,Andy,Wendy");
	  assertEquals("concat", true, actual_result); 
 
  }
public void testJavaScriptBasic_Array_join_Array() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/array.html");
	  solo.sleep(3000);
	  solo.clickOnText("Put elements into a string with join()");
	  boolean actual_result = solo.searchText("Jani,Hege,Stale");
	  assertEquals("join", true, actual_result);  
	   
  }
public void testJavaScriptBasic_Array_sort_Array() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/array.html");
	  solo.sleep(3000);
	  solo.clickOnText("Literal array");
	  boolean actual_result = solo.searchText("After sort is: Borge,Hege,Jani,Kai Jim,Stale,Tove");
	  assertEquals("sort", true, actual_result);  
	   
  }
public void testJavaScriptBasic_Array_NumericSort_Array() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/array.html");
	  solo.sleep(3000);
	  solo.clickOnText("Numeric array - sort()");
	  boolean actual_result = solo.searchText("After sort is: 1,5,10,25,40,1000");
	  assertEquals("Numeric", true, actual_result);  
 
  }  
public void testJavaScriptBasic_Boolean() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/boolean/boolean.html");
	  solo.sleep(3000);
	  solo.clickOnText("Check Boolean value");
	  boolean actual_result = solo.searchText("0 is boolean false")&&solo.searchText("1 is boolean true")&&solo.searchText("An empty string is boolean false")&&solo.searchText("null is boolean false")&&solo.searchText("NaN is boolean false")&&solo.searchText("The string 'false' is boolean true");
	  assertEquals("Boolean", true, actual_result);  
	 
  } 
public void testJavaScriptBasic_Date() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/date.html");
	  solo.sleep(3000);
	  solo.clickOnText("Use Date()");
	  Calendar cl = Calendar.getInstance();
	  SimpleDateFormat sf = new SimpleDateFormat("dd yyyy HH:mm");
	  boolean actual_result = solo.searchText(sf.format( cl.getTime()));
	  assertEquals("Boolean", true, actual_result);  
	  
  } 
public void testJavaScriptBasic_Date_Since1970() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/date.html");
	  solo.sleep(3000);
	  solo.clickOnText("Use getTime()");		  
	  Calendar calendar=Calendar.getInstance();  
	  int year=calendar.get(Calendar.YEAR)-1970;  
	  String s = String.valueOf(year);
	  boolean actual_result = solo.searchText(s);
	  assertEquals("Boolean", true, actual_result);  
	  
  } 
public void testJavaScriptBasic_Date_FullYear() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/date.html");
	  solo.sleep(3000);
	  solo.clickOnText("Use setFullYear()");		  
	  boolean actual_result = solo.searchText("1992/11/3: Tue Nov 03 1992");
	  assertEquals("FullYear", true, actual_result); 
	   
  } 
public void testJavaScriptBasic_Date_toUTC() throws Exception {
	 //没有做完
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/date.html");
	  solo.sleep(3000);
	  solo.clickOnText("Use toUTCString()");		  
	  Date time=new Date(); 
	  Long timecode=time.UTC(time.getYear(), time.getMonth(), time.getDate(), time.getHours(), time.getMinutes(), time.getSeconds()); 
	 System.out.println(timecode);
	  //assertEquals("Boolean", true, actual_result);  
  }
public void testJavaScriptBasic_Date_week() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/date.html");
	  solo.sleep(3000);
	  solo.clickOnText("Use getDay()");		  
	  Calendar calendar=Calendar.getInstance();  
	  int a = calendar.get(Calendar.DAY_OF_WEEK);
	  if(a==1){
		  boolean actual_result = solo.searchText("Today it is Sunday");
		  assertEquals("FullYear", true, actual_result);  
	  }
	  if(a==2){
		  boolean actual_result = solo.searchText("Today it is Monday");
		  assertEquals("FullYear", true, actual_result);  
	  }
	  if(a==3){
		  boolean actual_result = solo.searchText("Today it is Tuesday");
		  assertEquals("FullYear", true, actual_result);  
	  }
	  if(a==4){
		  boolean actual_result = solo.searchText("Today it is Wednesday");
		  assertEquals("FullYear", true, actual_result);  
	  }
	  if(a==5){
		  boolean actual_result = solo.searchText("Today it is Thursday");
		  assertEquals("FullYear", true, actual_result);  
	  }
	  if(a==6){
		  boolean actual_result = solo.searchText("Today it is Friday");
		  assertEquals("FullYear", true, actual_result);  
	  }
	  if(a==7){
		  boolean actual_result = solo.searchText("Today it is Saturday");
		  assertEquals("FullYear", true, actual_result);  
	  }
	  
  }
public void testJavaScriptBasic_Date_clock() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/date.html");
	  solo.sleep(3000);
	  solo.clickOnText("Display a clock");	
	  Calendar calendar=Calendar.getInstance();  
	  int h = calendar.get(Calendar.HOUR);
	  int m = calendar.get(Calendar.MINUTE);
	  boolean actual_result = solo.searchText(h+":"+m);
	  assertEquals("FullYear", true, actual_result);  
	 
  } 
public void testJavaScriptBasic_Condition_if() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic.html");
	  solo.sleep(3000);
	  solo.clickOnText("If statement");
	   
	  boolean actual_result = false;
	  Date date = new Date();
	  SimpleDateFormat sf = new SimpleDateFormat("dd yyyy HH:mm");
	  @SuppressWarnings("deprecation")
	  int hours = date.getHours();
	  if(hours<10){
		  actual_result = solo.searchText("Good morning");
	  }else{
		  actual_result = solo.searchText(sf.format(date));
		  
	  }
	 
	  assertEquals("Variables", true, actual_result);  
	   
}  */
public void tearDown() throws Exception {
    
    try {
    	solo.finishOpenedActivities();
	        System.gc();
			solo.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    super.tearDown();
    solo = null;
	} 
}






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




/*	 public void testWindowDisplayAlertbox() {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
	  solo.sleep(5000);
	  solo.clickOnText("Display alert box");
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(1000);
	  boolean actual = solo.waitForText("I am an alert box!!");
	  boolean expected = true;
	  assertEquals("isfound?",expected,actual);
	  solo.clickOnButton("OK");
	  solo.sleep(3000);
 
 
	}
  public void testWindowAlertboxwithline_breaks() {

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Alert box with line-breaks");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(5000);

		  boolean actual = solo.waitForText("Hello again! This is how we" + '\n' + "add line breaks to an alert box!");
		  boolean expected = true;
		  assertEquals("isfound?",expected,actual);
		  solo.clickOnButton("OK");
		  solo.sleep(3000);
	 
		
	}
  public void testWindowDisplay_confirm_box(){
	     webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.clickOnText("Display confirm box");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(5000);
		  solo.clickOnView(solo.getView(id.button1));
		  
		  for(WebElement web:solo.getCurrentWebElements()){
			   if(web.getvalue().equals("OK")){
				   solo.clickOnText("OK");
			   }
				   
			}
		  boolean expected_cancel = true;
		  boolean Button_Cancel = solo.waitForText("You pressed OK!");
		  assertEquals("isfound?",expected_cancel,Button_Cancel);
		  solo.sleep(3000);
		 
	 }
  public void testWindowPrompt_box(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Display prompt box");
		  solo.sleep(2000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  
		  solo.waitForDialogToOpen(10000);  //
		 
		  solo.enterText(0, "TCL Mobile");
		  solo.clickOnView(solo.getView(id.button1));
		  boolean actual= solo.waitForText("Hello TCL Mobile! How are you today?");
		  boolean expected = true;
		  assertEquals("hi",expected,actual);
		 
	 }
  public void testWindowWriteTextInStatusbar(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Write text in status bar");
		  boolean actual = solo.searchText("Look at the text in the statusbar."); 
		  boolean expected = true;
		  assertEquals("write",expected,actual);
		  solo.sleep(5000);
		  
	}
  public void testScreen(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(5000);
			  solo.clickOnText("Screen");
			  solo.sleep(5000);
			  DisplayMetrics dm = new DisplayMetrics();
			  getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
			  String h =  dm.heightPixels +"";
			  String w =  dm.widthPixels +"";
			  
			  System.out.println("The device width is :"+ w+ "and heigh is :" + h);
			  boolean expected = true;
			  boolean pi = solo.searchText(w) && solo.searchText(h);
			  
			  assertEquals("pixle",expected,pi);
			  
		}
  public void testTableInnerHTMLOfACell(){
	
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("InnerHTML of a cell");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean row = solo.searchText("Cell 1");
		  boolean expect = true;
		  assertEquals("InnerHTML",expect,row);
		  solo.clickOnButton("OK");
		 
	} 
  public void testTableCreateCaption(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Create caption");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean row = solo.searchText("My table caption");
		  boolean expect = true;
		  assertEquals("InnerHTML",expect,row);
		  solo.sendKey(KeyEvent.KEYCODE_BACK);
		 
	}
  public void testTableDeleteRows(){
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Delete rows");
		  for (int i =0;i<3;i++){
			  solo.clickOnWebElement(new By.TagName("INPUT"));
		  }
		  boolean button = solo.searchText("Delete");
		  boolean  actual = false;
		  assertEquals("delete",actual,button);
		  solo.sendKey(KeyEvent.KEYCODE_BACK);
		 
	}
  public void testTableAddRows(){
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Add rows");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  
		  boolean button = solo.searchText("NEW CELL1");
		  boolean button2 = solo.searchText("NEW CELL2");
		  
		  assertEquals("delete",button,button2);
		  solo.sendKey(KeyEvent.KEYCODE_BACK);
		  
	}
  public void testTableAddCells(){
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Add cells");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  
		  boolean button = solo.searchText("Peter");
		  boolean button2 = solo.searchText("John");
		  
		  assertEquals("delete",button,button2);
		  solo.sendKey(KeyEvent.KEYCODE_BACK);
		 
	} 
  public void testTableChangeContentOfCell(){
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Change content of cell");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean button = true;
		  boolean button2 = solo.searchText("NEW CONTENT");
		  
		  assertEquals("delete",button,button2);
		  solo.sendKey(KeyEvent.KEYCODE_BACK);
	 
		  
	} 
  public void testWindowOpen_multiple_windows(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Open multiple windows");
		  solo.sleep(2000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(4000);
	}
  public void testWindowSimpleTiming(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Simple timing");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean actually= solo.waitForDialogToOpen(7000);
		  boolean expected = true;
		  assertEquals("dialog",expected,actually);
		  solo.sleep(4000);
		  if(solo.searchText("5 seconds!")){
			  solo.clickOnButton("OK");
		  }
		  solo.sleep(2000);
	}
  public void testWindowAnotherSimpleTiming(){
			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Another simple timing");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(10000);
		  boolean actual = false;
		  for(WebElement web:solo.getCurrentWebElements()){
			  if(web.getvalue().equals("6 seconds!")){
				 actual = true;
				
				 Log.e("thanks","Giving day");
			  }  
		  }assertEquals("searchTxt",true,actual);
		  solo.goBack();
	}	
  public void testWindowTimingEventInInfiniteLoop(){
			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Timing event in infinite loop");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(10000);
		  boolean actual = false;
		  for(WebElement web:solo.getCurrentWebElements()){
			  if(web.getvalue().equals("7") || web.getvalue().equals("9") || web.getvalue().equals("8")){
				 actual = true;
				
				 Log.e("thanks","Giving day");
			  }  
		  }assertEquals("searchNum",true,actual);
		  solo.goBack();
	}	
  public void testWindowTimingEventInInfiniteLoopWithStopButton(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnWebElement(new By.Text("Timing event in infinite loop with Stop button"));
		  //solo.clickOnText("Timing event in infinite loop with Stop button");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  //solo.sleep(3000);
		  //solo.clickOnWebElement(new By.Id("txt"));
		  solo.sleep(5000);
		  boolean actual = false;
		  for(WebElement web:solo.getCurrentWebElements()){
			if(web.getvalue().equals("Stop count!")){
				solo.clickOnWebElement(web);
				solo.sleep(2000);
			  
		} 
	} 
		  for(WebElement web:solo.getCurrentWebElements()){
			  if(web.getvalue().equals("4") || web.getvalue().equals("5") || web.getvalue().equals("6")){
				 actual = true;
				
				 Log.e("thanks","Giving day");
			  }  
		  }assertEquals("searchNum",true,actual);
		  solo.goBack();
	}	
  public void testWindowClock(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Clock");
		  Calendar ca = Calendar.getInstance();
		  int minute =ca.get(Calendar.MINUTE); 
		  int hour =ca.get(Calendar.HOUR_OF_DAY); 
		  String time = hour+":"+ minute;
		   Log.e("time",time);
		  boolean actual = solo.searchText(time);
		  boolean expected = true;
		  assertEquals("compart the current time",expected,actual);
	}
  public void testWindowPopUp(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Pop-up");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(5000);
		  solo.goBack();
	} 
  public void testTableInnerHTMLOfARow(){
			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("InnerHTML of a row");
		  solo.clickOnWebElement(new By.Id("myTable"));
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean row = solo.searchText("<td>Row1 cell1</td>");
		  boolean row1 = solo.searchText("<td>Row1 cell2</td>");
		  assertEquals("InnerHTML",row1,row);
		  solo.clickOnButton("OK");
		  solo.goBack();
	} 
	 public void testStyleBackgroundImageFix(){
		//No effect
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundImage fix");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_5",100);
		  	} 
  public void testStyleLayoutDisplay(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("display");
		   
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean actual = true;
		  boolean expected = true;
		  if(solo.searchText("This is some text. This is some text.")){
			  actual = false;;
			  
		  }
 
		  assertEquals("display",expected,actual); 	
		  solo.goBack();
	} 
  public void testStyleStandardDir(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Standard");
		  solo.clickOnText("dir");
		  solo.sleep(1000);
		 
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(solo.searchText("Text direction: rtl") & solo.searchText( "An alternate way: rtl")){
			  listStyleNow = true;
			  }
		  assertEquals("zIndex",expected,listStyleNow);
		  solo.goBack();
	} 
  public void testStyleStandardLang(){
	  	webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Standard");
		  solo.clickOnText("lang");
		  solo.sleep(1000);
		 
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(solo.searchText("Body language: en-us") & solo.searchText( "An alternate way: en-us")){
			  listStyleNow = true;
			  }
		  assertEquals("lang",expected,listStyleNow);
		  solo.goBack();
	} 
  public void testStyleStandardTitle(){
	 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Standard");
		  solo.clickOnText("title");
		  solo.sleep(1000);
		 
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(solo.searchText("Body title: mytitle") & solo.searchText( "An alternate way: mytitle")){
			  listStyleNow = true;
			  }
		  assertEquals("title",expected,listStyleNow);
		  solo.goBack();
	} 
  public void testStyleTableBorderSpacing(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Table");
		  solo.clickOnText("borderSpacing");
		  solo.sleep(1000);
		  solo.takeScreenshot("borderSpacing",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderSpacing_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("borderSpacing.jpg", "borderSpacing_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("borderSpacing",expected,listStyleNow);
		  solo.goBack();
	} 
  public void testStyleTableEmptyCells(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Table");
		  solo.clickOnText("emptyCells");
		  solo.sleep(1000);
		  solo.takeScreenshot("emptyCells",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("emptyCells_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("emptyCells.jpg", "emptyCells_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("emptyCells",expected,listStyleNow);
		  solo.goBack();
	} 
  public void testStyleFont() throws Exception{
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.sleep(1000);
		  solo.clickOnText("font");
		  solo.sleep(1000); 
		  solo.takeScreenshot("font",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("font_1",100);
		  solo.sleep(1000);
		   
		  boolean expected = true;
		  boolean listStyleNow = false;
		if(ImageCompare.compareImage("font.jpg", "font_1.jpg", 0,0,99)){
				  listStyleNow = true;
			 }
			  assertEquals("tableLayout",expected,listStyleNow);
			  solo.goBack();
		} 
  public void testStyleTextLineHeight(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("lineHeight");
		  solo.sleep(1000);
		  solo.takeScreenshot("lineHeight",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("lineHeight_2",100);
		 
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("lineHeight.jpg", "lineHeight_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("lineHeight",expected,Height); 	
		  solo.goBack();
	}
  public void testStyleTextTextAlign(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("textAlign");
		  solo.sleep(1000);
		  solo.takeScreenshot("textAlign",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("textAlign_2",100);
		 
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("textAlign.jpg", "textAlign_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("textAlign",expected,Height); 	
		  solo.goBack();
	}
  public void testOptionGetNumberOfOptionsInDropdownList(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Option");
		  solo.clickOnText("Get number of options in dropdown list");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean number = solo.searchText("4");
		  boolean actual = true;
		  assertEquals ("Equals number",number,actual);
		  solo.clickOnButton("OK");
		  solo.goBack();
	} 
  public void testOptionSelectMultipleOptionsInDropdownList(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Option");
		  solo.clickOnText("Select multiple options in dropdown list");
		  solo.clickOnWebElement(new By.Id("mySelect"));
		  solo.clickOnText("Pear");
		  boolean banana = solo.searchText("Banana");
		  boolean single = false;
		  assertEquals("single",single,banana);
		  
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.clickOnWebElement(new By.Id("mySelect"));
		  solo.clickOnToggleButton("Orange");
		  solo.clickOnToggleButton("Banana");
		  if(solo.isTextChecked("Orange")){
			  boolean check = solo.isTextChecked("Orange") & solo.isTextChecked("Banana");
			  boolean expected = true;
			  assertEquals("Chekbox",expected,check);
			  solo.clickOnButton("OK");
			  solo.sleep(3000);  
		  		}
		  solo.goBack();
			} 
  public void testOptionAlertOptionSelectedInDropdownList(){
		 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Option");
		  solo.clickOnText("Alert option selected in dropdown list");
		  solo.clickOnWebElement(new By.Id("mySelect"));
		  solo.clickInList(2);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean search = solo.searchText("Banana");
		  boolean expect = true;
		  assertEquals("check",expect,search);
		  solo.clickOnButton("OK");
		  solo.goBack();
			} 
  public void testOptionAlertIndexOfSelectedOptionInDropdownList(){	
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Option");
		  solo.clickOnText("Alert index of selected option in dropdown list");
		  for (int i =1;i<5;i++){
			  int x = 0;
			  solo.clickOnWebElement(new By.Id("mySelect3"));
			  solo.clickInList(i);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.searchText(x+"");
			  solo.clickOnButton("OK");
			  x++;
		  		} 
		  
		}
  public void testOptionChangeTextOfOptionSelected(){	
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Option");
			  solo.clickOnText("Change text of option selected");
			  for (int i =1;i<5;i++){
				   
				  solo.clickOnWebElement(new By.Id("mySelect"));
				  solo.clickInList(i);
				  solo.clickOnWebElement(new By.TagName("INPUT"));
			 
				  
			  		}
			  solo.clickOnWebElement(new By.Id("mySelect"));
			  boolean water = solo.searchText("Melon");
			  boolean expect = true;
			  assertEquals("water",expect,water);
			  solo.clickOnText("Melon");
			  solo.goBack();
			}
  public void testNavigatorAlertUserDependingOnBrowser(){
		
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");//http://blog.sina.com.cn/s/blog_45d0b2cb0100nqif.html
		  solo.sleep(2000);
		  solo.clickOnText("Navigator");
		  solo.clickOnText("Alert user depending on browser");
		  solo.sleep(1000);
		  
		 
		  solo.sleep(1000);
		  solo.takeScreenshot("AlertUser", 100);
		  solo.sleep(2000);
		  if(solo.searchText("Your browser is good enough!")){
			  solo.clickOnButton("OK");
			  solo.sleep(1000);
			  solo.sendKey(KeyEvent.KEYCODE_BACK);
		  }
		  solo.sleep(1000);
		  solo.goBack();
	}
  public void testNavigatorDetectVisitor(){
		//为了兼容性而考虑的
		//appVersion Must return either the string "4.0" or a string representing the version of the browser in detail, e.g. "1.0 (VMS; en-US) Mellblomenator/9000".
		//appName Must return either the string "Netscape" or the full name of the browser, e.g. "Mellblom Browsernator".



		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");//http://blog.sina.com.cn/s/blog_45d0b2cb0100nqif.html
		  solo.sleep(2000);
		  solo.clickOnText("Navigator");
		  solo.clickOnText("Detect visitor browser and version");
		  solo.sleep(1000);
		  WebSettings settings = webview.getSettings();
		  settings.getUserAgentString();
		  //StringBuffer buffer = new StringBuffer();                  
		  String name = "Browser name: Netscape";
		  // final int idd = Build.VERSION_CODES;
			 WebSettings settings1 = webview.getSettings();
			 String uas = settings1.getUserAgentString();
			 String UASs = "Browser version: "+uas.substring(8,9);
			 
			 boolean actual = false;
			  if(solo.searchText(name)& solo.searchText(UASs)){
				    actual = true;
			  }
			  assertEquals("browser",true,actual);
		 

		              StringBuffer buffer = new StringBuffer();
		                    // Add version
		              //final String version = Build.VERSION.RELEASE;
		              if ("REL".equals(Build.VERSION.CODENAME)) {
		            	            final String model = Build.MODEL;
		            	           if (model.length() > 0) {
		            	                 buffer.append(" ");
		            	                  buffer.append(model);
		            	                  System.out.println("中华人民共和国:"+buffer);
		            	              }
		            	         }	
		              solo.goBack();
}
  public void testStyleTextFontSize(){
		 
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Style");
			  solo.clickOnText("Text");
			  solo.clickOnText("fontSize");
			  solo.sleep(1000);
			  solo.takeScreenshot("fontSize",100);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("fontSize_2",100);
			 
			  boolean expected = true;
			  boolean Height = false;
			  if(ImageCompare.compareImage("fontSize.jpg", "fontSize_2.jpg", 300,300,99)){
				  Height = true;
				  }
			  assertEquals("fontSize",expected,Height); 
			  solo.goBack();
		}   
  public void testStyleTextFontVariant(){
		
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Style");
			  solo.clickOnText("Text");
			  solo.clickOnText("fontVariant");
			  solo.sleep(1000);
			  solo.takeScreenshot("fontVariant",100);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("fontVariant_2",100);
			 solo.sleep(1000);
			 
			  boolean actual = false;
			 if (solo.searchText("This is an example paragraph.")) {
				 actual = true;
				  }
			 assertEquals("fontSize",true,actual); 
			 solo.goBack();

	} 
  public void testStyleTextLetterSpacing(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("letterSpacing");
		  solo.sleep(1000);
		  solo.takeScreenshot("letterSpacing",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("letterSpacing_2",100);
		 
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("letterSpacing.jpg", "letterSpacing_2.jpg", 300,300,99)){
			  Height = true;
			  }
		  assertEquals("letterSpacing",expected,Height); 
		  solo.goBack();
	}  
  public void testStyleTextTextDecoration(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("textDecoration");
		  solo.sleep(1000);
		  solo.takeScreenshot("textDecoration",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("textDecoration_2",100);
		 
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("textDecoration.jpg", "textDecoration_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("textDecoration",expected,Height);
		  solo.goBack();
	} 
  public void testStyleTextWordSpacing(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("wordSpacing");
		  solo.sleep(1000);
		  solo.takeScreenshot("wordSpacing",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("wordSpacing_2",100);

		  boolean actual = false;
			 if (solo.searchText("example"+" "+"paragraph")) { 
				 //+"\t"+ "an"+"\t"+ "example"+"\t"+ "paragraph."
				 actual = true;
				  }
			 assertEquals("fontSize",true,actual); 	
			 solo.goBack();
	} 
  public void testStyleTextFontFamily(){
		 //xiangsi  100%,放大图片看相素,一样
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Style");
			  solo.clickOnText("Text");
			  solo.clickOnText("fontFamily");
			  solo.sleep(1000);
			  solo.takeScreenshot("fontFamily",100);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("fontFamily_2",100);
			 
			  boolean expected = true;
			  boolean Height = false;
			  if(ImageCompare.compareImage("fontFamily.jpg", "fontFamily_2.jpg", 300,300,99)){
				  Height = true;
				  }
			  assertEquals("fontFamily",expected,Height); 	
			  solo.goBack();
		}  
  public void testStyleTableCaptionSide(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Table");
		  solo.clickOnText("captionSide");
		  solo.sleep(1000);
		  solo.takeScreenshot("CaptionSide",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("CaptionSide_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("CaptionSide.jpg", "CaptionSide_2.jpg", 300,300,100)){
			  listStyleNow = true;
			  }
		  assertEquals("CaptionSide",expected,listStyleNow);
		   
	}  
  public void testStyleTableBorderCollapse(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Table");
		  solo.clickOnText("borderCollapse");
		  solo.sleep(1000);
		  solo.takeScreenshot("borderCollapse",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderCollapse_2",100);
		  
		  boolean actual = false;
			 if (solo.searchText("100")) { 
				 //+"\t"+ "an"+"\t"+ "example"+"\t"+ "paragraph."
				 actual = true;
				  }
			 assertEquals("fontSize",true,actual); 	
			 solo.goBack();
	} 
  public void testStyleLayoutMaxWidth(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("maxWidth");
		  solo.sleep(1000);
		   solo.takeScreenshot("maxWidth",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("maxWidth_2",100);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("maxWidth.jpg", "maxWidth_2.jpg", 300,300,99)){
			  Height = true;
			  }
		  assertEquals("maxWidth",expected,Height); 
		   
	} 
  public void testStyleLayoutMinHeight(){
		 
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Style");
			  solo.clickOnText("Layout");
			  solo.clickOnText("minHeight");
			  solo.sleep(1000);
			  solo.takeScreenshot("minHeight",100);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("minHeight_2",100);
			 
			  boolean expected = true;
			  boolean Height = false;
			  if(ImageCompare.compareImage("minHeight.jpg", "minHeight_2.jpg", 300,300,99)){
				  Height = true;
				  }
			  assertEquals("minHeight",expected,Height); 
			  solo.goBack();
		}  
  public void testStyleLayoutOverFlow(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("overflow");
		  solo.sleep(1000);
		   solo.takeScreenshot("overflow",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("overflow_2",100);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("overflow.jpg", "overflow_2.jpg", 300,300,99)){
			  Height = true;
			  }
		  assertEquals("overflow",expected,Height); 	
		   
	} 
  public void testStyleLayoutVerticalAlign(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("verticalAlign");
		  solo.sleep(1000);
		   solo.takeScreenshot("LayoutverticalAlign",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("LayoutverticalAlign_2",100);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("LayoutverticalAlign.jpg", "LayoutverticalAlign_2.jpg", 300,300,99)){
			  Height = true;
			  }
		  assertEquals("LayoutverticalAlign",expected,Height); 	
		   
	} 
  public void testStyleLayoutMaxHeight(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("maxHeight");
		  solo.sleep(1000);
		   solo.takeScreenshot("MaxHeight",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("MaxHeight_2",100);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("MaxHeight.jpg", "MaxHeight_2.jpg", 300,300,99)){
			  Height = true;
			  }
		  assertEquals("MaxHeight",expected,Height); 	
		   
	}  
  public void testStyleLayoutCursor(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("cursor");
		  solo.sleep(1000);
		  solo.takeScreenshot("cursor",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("cursor_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("cursor.jpg", "cursor_2.jpg", 300,300,100)){
			  listStyleNow = true;
			  }
		  assertEquals("cursor",expected,listStyleNow);
		  
	}  
  public void testStyleBackgroundpaddingBottom(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("paddingBottom");
		  solo.sleep(1000);
		  solo.takeScreenshot("paddingBottom",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("paddingBottom_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("paddingBottom.jpg", "paddingBottom_2.jpg", 0,0,109)){
			  Border = true;
			  }
		  assertEquals("paddingBottom",expected,Border);
		  
			} 
  public void testStyleBackgroundpaddingRight(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("paddingRight");
		  solo.sleep(1000);
		  solo.takeScreenshot("paddingRight",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("paddingRight_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("paddingRight.jpg", "paddingRight_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("paddingRight",expected,Border);
		 
			} 
  public void testStyleBackgroundBorderLeftStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderLeftStyle");
		  solo.sleep(1000);
		  solo.takeScreenshot("borderLeftStyle",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderLeftStyle_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("borderLeftStyle.jpg", "borderLeftStyle_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("borderLeftStyle",expected,Border);
	 
			} 
  public void testStyleListStyle(){
		
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("List");
		  solo.clickOnText("listStyle");
		  solo.sleep(1000);
		  solo.takeScreenshot("ListStyle",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("ListStyle_2",100);
		  
		  boolean actual = false;
			 if (solo.searchText("1.")) { 
				 //+"\t"+ "an"+"\t"+ "example"+"\t"+ "paragraph."
				 actual = true;
				  }
			 assertEquals("ListStyle",true,actual); 
			  
	} 
  public void testStyleListStyleImage(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("List");
		  solo.clickOnText("listStyleImage");
		  solo.sleep(1000);
		  solo.takeScreenshot("ListStyleImage",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("ListStyleImage_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("listStyleImage.jpg", "ListStyleImage_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("ListStyleImage",expected,listStyleNow);
		   
	}  
  public void testStyleListStyleType(){
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("List");
		  solo.clickOnText("listStyleType");
		  solo.sleep(1000);
		  solo.takeScreenshot("listStyleType",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("listStyleType_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("listStyleType.jpg", "listStyleType_2.jpg", 100,100,99)){
			  listStyleNow = true;
			  }
		  assertEquals("listStyleType",expected,listStyleNow);
		  
	}  
  public void testStylePositionposition(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("positions");
		  solo.sleep(1000);
		  solo.takeScreenshot("positions",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("positions_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("positions.jpg", "positions_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("positions",expected,listStyleNow);
		   
	} 
  public void testOptionDisableAndEnableDropdownList(){
		
		  	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Option");
			  solo.clickOnText("Disable and enable dropdown list");
			  solo.clickOnWebElement(new TagName("INPUT"));
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.Id("mySelect"));
			  solo.sleep(1000);
			  boolean actual = false;
			  for(WebElement web:solo.getCurrentWebElements()){
					if(web.getvalue().equals("Disable list")){
						solo.clickOnScreen(web.getLocationX(),web.getLocationY());
						solo.sleep(5000);
					}
			  }
			 solo.clickOnWebElement(new By.Id("mySelect"));
			 for(WebElement webs:solo.getCurrentWebElements()){
					if(webs.getvalue().equals("Enable list")){
						solo.clickOnScreen(webs.getLocationX(),webs.getLocationY());
			  
				}  
					solo.sleep(2000);
			 }
			
			 for (int i = 1;i<5;i++){
				 
				 solo.clickOnWebElement(new By.Id("mySelect"));
				 solo.clickInList(i);
				 solo.sleep(2000);
				  
				  
			 }
				 
				 for(WebElement web:solo.getCurrentWebElements()){
						if(web.getvalue().equals("Orange")){
						 
							solo.clickOnScreen(web.getLocationX(),web.getLocationY());
							actual = true;
						}}		 
				 assertEquals("Droplist",true,actual);
				 
			} 
  public void testOptionGetIdOfFormThatContainsdropdownList(){
		  	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Option");
			  solo.clickOnText("Get id of form that contains dropdown list");
			  boolean actual =false;
			  for (int i = 1;i<5;i++){
					 solo.clickOnWebElement(new By.Id("mySelect"));
					 solo.clickInList(i);
					 solo.sleep(1000);
					  
				 }
			  solo.clickOnWebElement(new By.Id("mySelect"));
			   
					if(solo.searchText("Orange")){
				 
						actual = true;
			  	}
			  assertEquals("orange",true,actual);
			  
			  }  
  public void testOptionTurnDropdownListIntoMultiplelineList(){
		 
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
	  solo.sleep(2000);
	  solo.clickOnText("Option");
	  solo.clickOnText("Turn dropdown list into multipleline list");
	  solo.sleep(1000);
	  solo.takeScreenshot("TurnDropdown", 100);
	  solo.sleep(1000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(1000);
	  solo.takeScreenshot("TurnDropdown_2", 100);
	  boolean actual =false;
	 
	   
	  if(ImageCompare.compareImage("TurnDropdown.jpg", "TurnDropdown_2.jpg", 300,300,99)){
		  actual = true;
		  }
	  assertEquals("TurnDropdown",true,actual);
	  
 
	} 	 
  public void testSpecifyFramesg(){		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Specify frames");
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("Specify_frames", 100);
		  solo.sleep(2000);
		  for(WebElement web:solo.getCurrentWebElements()){
				if(web.getvalue().equals("Show below frames")){
					solo.clickOnWebElement(web);
					solo.sleep(2000);
			} 
		  }
		  solo.takeScreenshot("Specify_frames_2", 100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("Specify_frames.jpg", "Specify_frames_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("Specify frames",expected,Border);
		   
	}
  public void testWindowScrollWindow(){
	 
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(4000);
		  solo.clickOnText("Scroll window");
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  
		  
			  }
  public void testWindowScrollWindowToSpecifiedPosition(){
		 
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
			  solo.sleep(2000);
			  solo.clickOnText("Scroll window to specified position");
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  
		} 
  public void testStyleStandardTitleOfAreaInMap(){
	 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Standard");
		  solo.clickOnText("title of area in map");
		  solo.sleep(1000);
		  
		  solo.takeScreenshot("AreaInMap",100);
 
		  for(WebElement web:solo.getCurrentWebElements()){
			  if(web.getId().equals("venus")){
				  solo.clickOnWebElement(web);
				  Log.e("canyoufouch it", "canyoufound it");
			  }
		  }
		 
		  for(WebElement web:solo.getCurrentWebElements(new By.GetTitle("Venus"))){
		 
			  if(web.equals("Venus")){
				  Log.e("kandedaobu", "whether can get title");
				  solo.clickOnWebElement(web);
				  
			  }
			 // solo.clickOnScreen(web.getLocationX(), web.getLocationY());
			  
			 
			  }
		  solo.sleep(5000);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("AreaInMap.jpg", "AreaInMap_2.jpg", 300,300,98)){
			  listStyleNow = true;
			  }
		  assertEquals("AreaInMap",expected,listStyleNow);
		  
		}  
  public void testAlertButton() throws Exception{
		    webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/anchor/attribute.html");
		    solo.sleep(3000);
		    solo.clickOnWebElement(new By.TagName("INPUT"));
		    boolean actual_result=solo.waitForText("Yahoo");
		    solo.sleep(2000);
			assertEquals("Sohu doesn't displayed", true, actual_result);
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			} 
  public void testReturnUrl() throws Exception{
		   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/url.html");
		   boolean actual_result_returnUrl=solo.waitForText("http://123.71.192.55:8001/Browser/DOM/document/url.html");
		   solo.sleep(2000);
		   assertEquals("Sohu doesn't displayed", true, actual_result_returnUrl);
		   solo.sleep(3000);
		  

	   }
  public void testgetElementsByName() throws Exception {
		   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/getelementsbyname.html");
		   solo.sleep(3000);
		   solo.clickOnWebElement("How many elements named 'myInput'?", 0, true);
		   

	  }
  public void testFormChangeURL() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/change_action.html");
		  solo.sleep(3000);
		  solo.clickOnWebElement("Change action attribute and submit form", 0, true);
		  solo.sleep(2000);
		  solo.clickOnText("OK");
		  solo.sleep(2000);
		  solo.clickOnText("OK");
		  solo.sleep(2000);
		  boolean actual_result=webview.getUrl().equals("http://123.71.192.55:8001/Browser/DOM/form/default.php");
		  solo.sleep(2000);
		  assertEquals("Current url is not the expected", true, actual_result);
		  solo.sleep(2000);
		  
	  }
  public void testFormViewMethod() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/show_method.html");
		  solo.sleep(3000);
		  solo.clickOnWebElement("Show method", 0, true);
		  boolean actual_result=solo.waitForText("post");
		  assertEquals("Number of forms", true, actual_result);
		  solo.clickOnText("OK", 0, true);
		  solo.sleep(2000);
		  
	  }
  public void testFormAlertIdNameValue() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/alert_disable.html");
		  solo.sleep(3000);
		  solo.clickOnWebElement("Click me!", 0, true);
		  boolean actual_result=solo.waitForText("Id: myButton, type: button, value: Click me");
		  assertEquals("Cannot get Id, type, value information", true, actual_result);
		  solo.clickOnText("OK");
		  solo.sleep(2000);
		  
	  }
  public void testFormCheckBox() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/check_uncheck.html");
		  boolean actual_result=false;
		  solo.clickOnWebElement("Check Checkbox", 0, true);
		  solo.sleep(2000);
		  WebElement webelement=solo.getCurrentWebElements(new By.CheckBox("myCheck")).get(0);
		  if(webelement.getvalue().equals("true")){
			  actual_result=true;
			  Log.e(webelement.getvalue(),"value1");
		  }
		  assertEquals("The check box is not checked",actual_result,true);
		  solo.sleep(3000);
		  solo.clickOnWebElement("Uncheck Checkbox", 0, true);
		  solo.sleep(2000);
		  
	  }
  public void testWindowSendToNewLocation(){
		 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Send to new location");
		  solo.sleep(2000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
	 
		  boolean actual = solo.waitForText("http://123.71.192.55:8001/Browser/DOM/window/location.html");
		  boolean expected = true; 
		  assertEquals("uri",expected,actual);
		  solo.clickOnButton("OK");
		  solo.clickOnWebElement("Change URL",0,true);
		  solo.sleep(6000);
		  boolean actual1 = false;
		  if( actual1 = webview.getUrl().equals("http://hk.m.yahoo.com/")){
			  actual1 = true;
			  assertEquals("check url",true,actual1);
		  }
		   
		}   
  public void testWindowReloadAPage(){
		 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Reload a page");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(5000);
		  boolean actual1 = false;
		  if( actual1 = webview.getUrl().equals("http://123.71.192.55:8001/Browser/DOM/window/reload.html")){
			  actual1 = true;
			  assertEquals("check url",true,actual1);
		  }
		  
	}  
  public void testFormDropDown() throws Exception {
		  boolean actual_result=false;
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/dropdown.html");
		  solo.sleep(3000);
		  solo.clickOnWebElement(new By.Id("myList"));
		  solo.sleep(3000);
		  solo.clickOnText("Netscape");
		  solo.sleep(3000);
		  for(WebElement web:solo.getCurrentWebElements()){
			  if(web.getId().equals("favorite"))
				  if(web.getvalue().equals("Netscape"))
					  actual_result=true;	  
			  }
		  assertEquals("The check box is not checked",actual_result,true);
		  solo.sleep(2000);

		 
		 
	  }
  public void testNavigatorAllDetails(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");//http://blog.sina.com.cn/s/blog_45d0b2cb0100nqif.html
		  solo.sleep(2000);
		  solo.clickOnText("Navigator");
		  solo.clickOnText("All details about visitor browser");
		  solo.sleep(2000);
		  solo.takeScreenshot("BrowserDetails", 100);
		  solo.sleep(2000);
		  WebSettings settings = webview.getSettings();

		  String ua = settings.getUserAgentString();//UA返回的string对象分为两部分，第一部分显示的是ua信息，第二部分显示的webkit版本信息。
		  String uaaa = ua.substring(0,38);
		  String uas = settings.getUserAgentString();
		  
		  String UAS = uas.substring(8,38);
		  String UA ="UA="+uaaa;
		  String Version= "Version="+UAS;
		  String Platforms ="Platform="+System.getProperty("os.name")+" "+System.getProperty("os.arch");//http://developer.android.com/reference/java/lang/System.html
		  Log.i("UA",UA);
		  Log.i("Version",Version);
		  Log.i("Versions",Platforms);
		  String uaa = settings.getUserAgentString().substring(0, 7);
		  String CodeName ="CodeName="+uaa;
		  Log.i("test",CodeName);
		  System.out.println(CodeName);
		  System.out.println(Version);
		  System.out.println(Platforms);
		  System.out.println(UA);
		  
		 
		  boolean actual = false;
		  if(solo.searchText(CodeName)& solo.searchText(Version)&solo.searchText(UA)& solo.searchText(Platforms)){
			  // solo.searchText(CodeName)& solo.searchText(Version) & solo.searchText(Platforms) & solo.searchText(UA)
			  actual = true;
		  }
		  assertEquals("browser",true,actual);
		  
	} 
  public void testWindowOpenNewWindowWhenClickingButton(){
		 
	 	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Open new window when clicking button");
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		 //solo.clickOnWebElement("Open Window", 0, true);
		  solo.sleep(2000);	
		  webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		  boolean actual =false;
		 // webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  for(WebElement web:solo.getCurrentWebElements()){
				if(web.getvalue().equals("Open Window")){
					webview.getSettings().setJavaScriptEnabled(true);
					
					if( webview.getSettings().getJavaScriptCanOpenWindowsAutomatically()){
						solo.clickOnWebElement(web);
						//solo.clickLongOnText("Open Window");
						//solo.click(new By.TagName("INPUT"));
						solo.clickOnWebElement("Open Window", 0, true);
						System.out.println("没悲剧:"+webview.getSettings().getJavaScriptCanOpenWindowsAutomatically());
						
						solo.clickOnScreen(22, 128);
						solo.sleep(2000);
					}else{
						System.out.println("悲剧鸟:"+webview.getSettings().getJavaScriptCanOpenWindowsAutomatically());
					}
					
					
					
			} 
	 
		  }
		  
		  solo.sleep(6000);
		  
		 if(webview.getUrl().equals("http://wap.yahoo.com")){
		    actual = true;
		  	
		 	  
		 }	assertEquals("check url",true,actual);
		  
		 }  
  public void testWindowOpenNewWindowAndControlAppearance(){
			//调用的是预加载js中的方法，这里的button点击后页面不跳转
		 	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
			  solo.sleep(2000);
			  solo.clickOnText("Open new window and control appearance");
			  
			  solo.sleep(2000);
			  
			  boolean actual = false;
			   
			 solo.clickOnWebElement(new By.TagName("INPUT"));
			 
			  solo.sleep(2000);
			  
			 if(solo.waitForText("http://wap.yahoo.com/")){
				  actual = true;
			 }
			assertEquals("jump",true,actual);
			
			  solo.sleep(4000);
		} 
  public void testOptionRemoveOptionsFromDropdownList(){
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Option");
			 solo.clickOnText("Remove options from dropdown list");
			  solo.clickOnWebElement(new By.Id("mySelect"));
			  solo.sleep(1000);
			  solo.clickOnText("Banana");
			  solo.sleep(1000);
			  for(WebElement web:solo.getCurrentWebElements()){
				  if(web.getvalue().equals("Remove selected option")){
					  solo.clickOnWebElement(web);
				  
				  }
			  }
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.Id("mySelect"));
			  boolean actual = solo.searchText("Banana");
			  assertEquals("CHeckRemove",false,actual);
			  
			  } 
  public void testNavigatorMoreDetails(){
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");//http://blog.sina.com.cn/s/blog_45d0b2cb0100nqif.html
			  solo.sleep(2000);
			  solo.clickOnText("Navigator");
			  solo.clickOnText("More details about visitor browser");
			  solo.sleep(1000);
			  solo.takeScreenshot("moredetail", 100);
			  solo.sleep(1000);
			  WebSettings settings = webview.getSettings();
			  settings.getUserAgentString();              
			  String name = "Browser: Netscape";
			  String Platforms ="Platform: "+System.getProperty("os.name")+" "+System.getProperty("os.arch");
			  String uas = settings.getUserAgentString();
			  String UAS = uas.substring(8,31);
			  String Version= "Browserversion:"+UAS;
			  Log.i("platform",Platforms);
			  Log.i("name",name);
			  Log.i("version",Version);
				 boolean actual = false;
				  if(solo.searchText(UAS)&solo.searchText(name)& solo.searchText(Platforms)){
					    actual = true;
				  }
				  assertEquals("browser",true,actual);
			 
				 
				  
	} 
 
	 	
	  public void tearDown() throws Exception {
	        solo.finishOpenedActivities();
	  }    
 public void testStyleTextColor() throws Exception{
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("color");
		  if(solo.searchText("This is an example paragraph.")){
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			  solo.takeScreenshot("After",100);
			  solo.sleep(1000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/After.jpg");		  
			 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

			  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
			  int  red =0; int  green =0;int blue = 0;
			   boolean actual = false;
			  for(int i = 0; i < pixels.length; i++){
		             	int clr = pixels[i];
		             	 red   = (clr & 0x00ff0000) >> 16;   
			  			 green = (clr & 0x0000ff00) >> 8;  
			  			 blue  =  clr & 0x000000ff;  
			  		
			  				 if(red==208 & green == 120 & blue == 192){
			  					   System.out.println("Yes,image contain red elements!");
			  					   actual = true;
			  				 }

			  			 } 
			  
			  assertEquals("compare",true,actual);
		  }
		  solo.goBack();
		  } 
	
	 public void testStyleBackground(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("Backgrounds");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_1",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/Background_1.jpg");		  
	 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;  
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  				 if(red==255 & green == 200 & blue == 128){
		  					   //System.out.println("Yes,image contain orange elements!");
		  					   actual = true;
		  				 }

		  			 } 
		  
		  assertEquals("compare",true,actual);
		  
		  solo.goBack();
		  	} 
	public void testStyleBackgroundColorHex(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundColor hex");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_2",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/Background_2.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;  
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  				 if(red==255 & green == 200 & blue == 128){
		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 
	public void testStyleBackgroundColorName(){

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundColor name");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_3",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/Background_3.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==255 & green == 0 & blue == 0){
	
		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 
	public void testStyleBackgroundImage(){

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundImage");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_4",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/Background_4.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		  boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;  
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  				 if(red==208 & green == 168 & blue == 128){
	
		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	}
 
public void testStyleBorderAndMarginBorder(){
 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
	  solo.sleep(2000);
	  solo.clickOnText("Style");
	  solo.clickOnText("Border and margin");
	  solo.sleep(1000);
	  solo.clickOnText("borders");
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(2000);
	  solo.takeScreenshot("BorderAndMargin_1",100);
	  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_1.jpg");		  

	 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

	  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
	  int  red =0; int  green =0;int blue = 0;
	   boolean actual =false;
	  for(int i = 0; i < pixels.length; i++){
            	int clr = pixels[i];
            	 red   = (clr & 0x00ff0000) >> 16;   
	  			 green = (clr & 0x0000ff00) >> 8;  
	  			 blue  =  clr & 0x000000ff;  
	  			System.out.println("r="+red+",g="+green+",b="+blue);
	  		 
	  				 if(red==0 & green == 0& blue == 255){

	  					   actual = true;
	  				 }

	  			 } 
	  assertEquals("compare",true,actual);
 
	  	} 

	public void testStyleBorderAndMarginBorderBottom(){

	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
	  solo.sleep(2000);
	  solo.clickOnText("Style");
	  solo.clickOnText("Border and margin");
	  solo.sleep(1000);
	  solo.clickOnText("borderBottom");
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(2000);
	  solo.takeScreenshot("BorderAndMargin_2",100);
	  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_2.jpg");		  
	  
	 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

	  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
	  int  red =0; int  green =0;int blue = 0;
	   boolean actual =false;
	  for(int i = 0; i < pixels.length; i++){
            	int clr = pixels[i];
            	 red   = (clr & 0x00ff0000) >> 16;   
	  			 green = (clr & 0x0000ff00) >> 8;  
	  			 blue  =  clr & 0x000000ff; 
	  		 
	  				 if(red==0 & green == 0& blue == 255){

	  					   actual = true;
	  				 }

	  			 } 
	  assertEquals("compare",true,actual);
 
	  	} 
	public void testStyleBorderAndMarginBorderBottomColor(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderBottomColor");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_3",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_3.jpg");		  

		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff; 
		  				 if(red==0 & green == 0& blue == 255){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 
	
	public void testStyleBorderAndMarginBorderBottomWidth(){
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderBottomWidth");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_5",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_5.jpg");		  
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual =false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  				 if(red==255 & green == 0& blue == 0){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 

	public void testStyleBorderAndMarginBorderColor(){
	  
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
	  solo.sleep(2000);
	  solo.clickOnText("Style");
	  solo.clickOnText("Border and margin");
	  solo.sleep(1000);
	  solo.clickOnText("borderColor");
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(2000);
	  solo.takeScreenshot("BorderAndMargin_6",100);
	  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_6.jpg");		  
	  
	 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

	  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
	  int  red =0; int  green =0;int blue = 0;
	   boolean actual = false;
	  for(int i = 0; i < pixels.length; i++){
            	int clr = pixels[i];
            	 red   = (clr & 0x00ff0000) >> 16;   
	  			 green = (clr & 0x0000ff00) >> 8;  
	  			 blue  =  clr & 0x000000ff;  
	  			System.out.println("r="+red+",g="+green+",b="+blue);
	  		 
	  				 if(red==0 & green == 0& blue == 255){

	  					   actual = true;
	  				 }

	  			 } 
	  assertEquals("compare",true,actual);
 
	  	} 


	public void testStyleBorderAndMarginBorderLeft(){

	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
	  solo.sleep(2000);
	  solo.clickOnText("Style");
	  solo.clickOnText("Border and margin");
	  solo.sleep(1000);
	  solo.clickOnText("borderLeft");
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(2000);
	  solo.takeScreenshot("BorderAndMargin_7",100);
	  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_7.jpg");		  
	 
	 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

	  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
	  int  red =0; int  green =0;int blue = 0;
	   boolean actual = false;
	  for(int i = 0; i < pixels.length; i++){
            	int clr = pixels[i];
            	 red   = (clr & 0x00ff0000) >> 16;   
	  			 green = (clr & 0x0000ff00) >> 8;  
	  			 blue  =  clr & 0x000000ff;  
	  			System.out.println("r="+red+",g="+green+",b="+blue);
	  		 
	  				 if(red==0 & green == 0& blue == 255){

	  					   actual = true;
	  				 }

	  			 } 
	  assertEquals("compare",true,actual);
 
	  	} 
	public void testStyleBorderAndMarginBorderLeftColor(){

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderLeftColor");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_8",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_8.jpg");		  
	   
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==0 & green == 0& blue == 255){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 
	public void testStyleBorderAndMarginBorderLeftWidth(){

		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderLeftWidth");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_10",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_10.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff; 
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==255 & green == 0& blue == 0){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
		  	} 
	public void testStyleBorderAndMarginBorderRight(){
 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderRight");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_11",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_11.jpg");		  
		
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==0 & green == 0& blue == 255){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 
	public void testStyleBorderAndMarginBorderRightColor(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderRightColor");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_12",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_12.jpg");		  
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8; 
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==0 & green == 0& blue == 255){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 
	public void testStyleBorderAndMarginBorderRightWidth(){
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderRightWidth");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_14",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_14.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==255 & green == 0& blue == 0){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 
	public void testStyleBorderAndMarginBorderTop(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderTop");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_16",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_16.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;  
		  			 green = (clr & 0x0000ff00) >> 8; 
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==0 & green == 0& blue == 255){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 
	public void testStyleBorderAndMarginBorderTopColor(){

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderTopColor");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_17",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_17.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff; 
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==0 & green == 0& blue == 255){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
}
	public void testStyleBorderAndMarginBorderTopWidth(){

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderTopWidth");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_19",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_19.jpg");		  
		    
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8; 
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==255 & green == 0& blue == 0){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 
	public void testStyleABorderAndMarginBorderWidth(){
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderWidth");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_20",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_20.jpg");		  
		 	
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;  
		  			 green = (clr & 0x0000ff00) >> 8; 
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==255 & green == 0& blue == 0){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
		  	} 

	public void testStyleABorderAndMarginOutline(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("outline");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_26",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_26.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==255 & green == 0& blue == 0){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",false,actual);
		  	} 
	public void testStyleABorderAndMarginOutlineColor(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("outlineColor");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_28",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_28.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  			System.out.println("r="+red+",g="+green+",b="+blue);
		  		 
		  				 if(red==255 & green == 0& blue == 0){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",false,actual);
 
		  	} 
	public void testStyleABorderAndMarginOutlineWidth(){
		solo.sleep(2000);
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("outlineWidth");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_29",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_29.jpg");		  	  
		  int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 
		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		  boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  				 if(red==255 & green == 0& blue == 0){
		  					   actual = true;
		  				 }
		  			 } 
		  assertEquals("compare",false,actual);
 
		  	}
	 public void testStyleBackgroundRepeat(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundRepeat");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_8",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/Background_8.jpg");		  
		  
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 

		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		   boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff; 
		  		 
		  				 if(red==208 & green == 168 & blue == 128){

		  					   actual = true;
		  				 }

		  			 } 
		  assertEquals("compare",true,actual);
 
	} 
	public void testStyleTextFontWeight(){
		 
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("fontWeight");
		  solo.sleep(1000);
		  solo.takeScreenshot("fontWeight",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("fontWeight_2",100);
		 solo.sleep(1000);
		 Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/fontWeight_2.jpg");		  
		 
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 
		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		  boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
			
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  			// System.out.println(red + "\t" + green + "\t" + blue);
		  				 if(red==0 & green == 0 & blue == 0){
		  					   actual = true;
		  				 }
		  				 
		  			 } 
		  assertEquals("compare",true,actual);
 
		  	}
	public void testStyleTableTableLayout(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Table");
		  solo.clickOnText("tableLayout");
		  solo.sleep(1000);
		  solo.takeScreenshot("tableLayout",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("tableLayout_2",100);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/tableLayout_2.jpg");		  
			 
			 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 
			  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
			  int  red =0; int  green =0;int blue = 0;
			  boolean actual = false;
			  for(int i = 0; i < pixels.length; i++){
				
		             	int clr = pixels[i];
		             	 red   = (clr & 0x00ff0000) >> 16;   
			  			 green = (clr & 0x0000ff00) >> 8;  
			  			 blue  =  clr & 0x000000ff;  
			  				 if(red==0 & green == 8 & blue == 0){
			  					   actual = true;
			  				 }
			  				 
			  			 } 
			  assertEquals("compare",true,actual);
 
			  	} 
	public void testStyleBackgroundBorderRightStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderRightStyle");
		  solo.sleep(1000);
		  solo.takeScreenshot("borderRightStyle",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderRightStyle_2",100);
		 // boolean expected = true;
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/borderRightStyle_2.jpg");		   
			 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 
			  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
			  int  red =0; int  green =0;int blue = 0;
			  boolean actual = false;
			  for(int i = 0; i < pixels.length; i++){
				
		             	int clr = pixels[i];
		             	 red   = (clr & 0x00ff0000) >> 16;   
			  			 green = (clr & 0x0000ff00) >> 8;  
			  			 blue  =  clr & 0x000000ff;  
			  			 System.out.println(red+";"+green+";"+blue);
			  				 if(red==145 & green == 45 & blue == 45){
			  					   actual = true;
			  				 }
			  				 
			  			 } 
			  assertEquals("compare",true,actual);
 
			  	}   
    public void testStyleLayoutMinWidth(){
		 //xiangsi  100%,界面没改变
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Style");
			  solo.clickOnText("Layout");
			  solo.clickOnText("minWidth");
			  solo.sleep(1000);
			  solo.takeScreenshot("minWidth",100);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("minWidth_2",100);
			 
			  boolean expected = true;
			  boolean Height = false;
			  if(ImageCompare.compareImage("minWidth.jpg", "minWidth_2.jpg", 300,300,99)){
				  Height = true;
				  }
			  assertEquals("minWidth",expected,Height); 
 
		}  
    public void testStyleTextFontSizeAdjust(){
		 //点击后文字大小不会改变,手机电脑现象一样
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Style");
			  solo.clickOnText("Text");
			  solo.clickOnText("fontSizeAdjust");
			  solo.sleep(1000);
			  solo.takeScreenshot("fontSizeAdjust",100);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("fontSizeAdjust_2",100);
			 
			  boolean expected = true;
			  boolean Height = false;
			  if(ImageCompare.compareImage("fontSizeAdjust.jpg", "fontSizeAdjust_2.jpg", 300,300,99)){
				  Height = true;
				  }
			  assertEquals("fontSizeAdjust",expected,Height); 	
 
		}  
 	public void testStyleTextFontStretch(){
		 //点击后文字大小不会改变,手机电脑现象一样
 				webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Style");
			  solo.clickOnText("Text");
			  solo.clickOnText("fontStretch");
			  solo.sleep(1000);
			  solo.takeScreenshot("fontStretch",100);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("fontStretch_2",100);
			 
			  boolean expected = true;
			  boolean Height = false;
			  if(ImageCompare.compareImage("fontStretch.jpg", "fontStretch_2.jpg", 300,300,99)){
				  Height = true;
				  }
			  assertEquals("fontStretch",expected,Height); 
 
		}  
 	public void testStyleTextFontStyle(){
		 //xiangsi  99%, 
 			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Style");
			  solo.clickOnText("Text");
			  solo.clickOnText("fontStyle");
			  solo.sleep(1000);
			  solo.takeScreenshot("fontStyle",100);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("fontStyle_2",100);
			 
			  boolean expected = true;
			  boolean Height = false;
			  if(ImageCompare.compareImage("fontStyle.jpg", "fontStyle_2.jpg", 300,300,99)){
				  Height = true;
				  }
			  assertEquals("fontStyle",expected,Height); 	
 
		}  
 	public void testWindowBreakoutOfAFrame(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(5000);
		  solo.clickOnText("Break out of a frame");
		  solo.takeScreenshot("breakout");
		  solo.sleep(3000);
		  solo.clickOnWebElement(new By.GetFrameItem( "leftFrame","frame"));
		  
		  solo.sleep(3000);
		  solo.takeScreenshot("breakout01");
		  solo.sleep(3000);
		  boolean actual_result=true;
		  actual_result = solo.imageCompare("breakout.jpg", "breakout01.jpg",150,300,95);
		  assertEquals("Convert to upper false", false, actual_result);
		  
	  }
 	public void testChangeWidthOfBorder(){		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Change width of border");
		  solo.takeScreenshot("WidthOfBorder", 100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("WidthOfBorder_2", 100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("WidthOfBorder.jpg", "WidthOfBorder_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("bottom",expected,Border);
 
	}
	public void testChangeCellPaddingAndCellSpacing(){		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Change cellPadding and cellSpacing");
		  solo.takeScreenshot("PaddingAndCellSpacing", 100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("PaddingAndCellSpacing_2", 100);
		  solo.sleep(1000);
		  for(WebElement web:solo.getCurrentWebElements()){
				if(web.getvalue().equals("Change Cellspacing")){
					solo.clickOnWebElement(web);
					solo.sleep(2000);
			} 
				solo.goBack();
		  }
		  solo.takeScreenshot("PaddingAndCellSpacing_3", 100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("PaddingAndCellSpacing_2.jpg", "PaddingAndCellSpacing_3.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("PaddingAndCellSpacing_3",expected,Border);
	 
	} 
	
	public void testSpecifyRules(){		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Specify rules");
		  solo.sleep(1000);
		  solo.takeScreenshot("SpecifyRules", 100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("SpecifyRules_1", 100);
		  solo.sleep(2000);
		  for(WebElement web:solo.getCurrentWebElements()){
				if(web.getvalue().equals("Show only col borders")){
					solo.clickOnWebElement(web);
					solo.sleep(2000);
			} 
		  }
		  solo.takeScreenshot("SpecifyRules_3", 100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("SpecifyRules.jpg", "SpecifyRules_1.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("SpecifyRules",expected,Border);
	 
	}
	public void testTableAlignCellContentInRow()throws Exception{
		 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Align cell content in row");
		  solo.takeScreenshot("InOneRow",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.takeScreenshot("InOneRow_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("InOneRow.jpg", "InOneRow_2.jpg", 0,0,98)){
			  Border = true;
			  }
		  assertEquals("InOneRow",expected,Border);
		  
			}
	public void testTableVerticalAlignCellContentInRow(){ 
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Vertical align cell content in row");
		  solo.takeScreenshot("VerticalAlign",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.takeScreenshot("VerticalAlign_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("VerticalAlign.jpg", "VerticalAlign_2.jpg", 0,0,98)){
			  Border = true;
			  }
		  assertEquals("VerticalAlign",expected,Border);
		 
			}
	public void testTableAlignCellContentInCell(){ 
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Align cell content in cell");
		  solo.takeScreenshot("AlignCell",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.takeScreenshot("AlignCell_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("AlignCell.jpg", "AlignCell_2.jpg", 0,0,98)){
			  Border = true;
			  }
		  assertEquals("AlignCell",expected,Border);
		 
			}
	public void testTableVerticalAlignCellContentInCell(){ 
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Vertical align cell content in cell");
		  solo.takeScreenshot("VerticalAlignCell",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.takeScreenshot("VerticalAlignCell_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("VerticalAlignCell.jpg", "VerticalAlignCell_2.jpg", 0,0,98)){
			  Border = true;
			  }
		  assertEquals("VerticalAlignCell",expected,Border);
	 
			}
		  
	public void testTableChangeColspanOfRow(){ 
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("Change colspan of row");
		  solo.takeScreenshot("ColspanOfRow",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.takeScreenshot("ColspanOfRow_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("ColspanOfRow.jpg", "ColspanOfRow_2.jpg", 0,0,98)){
			  Border = true;
			  }
		  assertEquals("ColspanOfRow",expected,Border);
		 
			}
	public void testStyleBackgroundPositionX(){

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundPositionX");
		  solo.sleep(1000);
		  solo.takeScreenshot("PositionX", 100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("PositionX_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("PositionX.jpg", "PositionX_2.jpg", 0,0,85)){
			  Border = true;
			  }
		  assertEquals("PositionX",expected,Border);
	 
			}
	public void testStyleBackgroundPositionY(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundPositionY");
		  solo.sleep(1000);
		  solo.takeScreenshot("Background_7",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("Background_7_2",100);
		  solo.sleep(1000);
		  
		  boolean expected = true;
		  boolean now = false ;
		   if( ImageCompare.compareImage("Background_7.jpg", "Background_7_2.jpg", 0,0,85)){
			    now = true;
			  
		   }
		 
		   assertEquals("fuck",expected,now);
		   
	}
	
	public void testStyleBackgroundBorderBottomStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderBottomStyle");
		  solo.sleep(1000);
		  solo.takeScreenshot("borderBottomStyle",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderBottomStyle_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("borderBottomStyle.jpg", "borderBottomStyle_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("PositionX",expected,Border);
	 
			}
	
	public void testStyleBackgroundBorderStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderStyle");
		  solo.sleep(1000);
		  solo.takeScreenshot("borderStyle",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderStyle_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("borderStyle.jpg", "borderStyle_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("borderStyle",expected,Border);
 
			}
	public void testStyleBackgroundBorderTopStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderTopStyle");
		  solo.sleep(1000);
		  solo.takeScreenshot("borderTopStyle",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderTopStyle_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("borderTopStyle.jpg", "borderTopStyle_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("borderTopStyle",expected,Border);
	 
			}
	public void testStyleBackgroundmargins(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("margins");
		  solo.sleep(1000);
		  solo.takeScreenshot("margins",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("margins_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("margins.jpg", "margins_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("margins",expected,Border);
	 
			}
	public void testStyleBackgroundMarginBottom(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("marginBottom");
		  solo.sleep(1000);
		  solo.takeScreenshot("marginBottom",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("marginBottom_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("marginBottom.jpg", "marginBottom_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("marginBottom",expected,Border);
	 
			}
	public void testStyleBackgroundMarginLeft(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("marginLeft");
		  solo.sleep(1000);
		  solo.takeScreenshot("marginLeft",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("marginLeft_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("marginLeft.jpg", "marginLeft_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("marginLeft",expected,Border);
 
			}
	public void testStyleBackgroundMarginRight(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("marginRight");
		  solo.sleep(1000);
		  solo.takeScreenshot("marginRight",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("marginRight_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("marginRight.jpg", "marginRight_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("marginRight",expected,Border);
	 
			}
	public void testStyleBackgroundMarginTop(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("marginTop");
		  solo.sleep(1000);
		  solo.takeScreenshot("marginTop",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("marginTop_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("marginTop.jpg", "marginTop_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("marginTop",expected,Border);
	 
			}
	public void testStyleBackgroundOutlineStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("outlineStyle");
		  solo.sleep(1000);
		  solo.takeScreenshot("outlineStyle",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("outlineStyle_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("outlineStyle.jpg", "outlineStyle_2.jpg", 0,0,97)){
			  Border = true;
			  }
		  assertEquals("outlineStyle",expected,Border);
	 
			}
	public void testStyleBackgroundpadding(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("padding");
		  solo.sleep(1000);
		  solo.takeScreenshot("padding",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("padding_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("padding.jpg", "padding_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("padding",expected,Border);
	 
			}
	
	public void testStyleBackgroundpaddingLeft(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("paddingLeft");
		  solo.sleep(1000);
		  solo.takeScreenshot("paddingLeft",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("paddingLeft_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("paddingLeft.jpg", "paddingLeft_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("paddingLeft",expected,Border);
 
			}

	public void testStyleBackgroundpaddingTop(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("paddingTop");
		  solo.sleep(1000);
		  solo.takeScreenshot("paddingTop",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("paddingTop_2",100);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("paddingTop.jpg", "paddingTop_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("paddingTop",expected,Border);
	 
			}
	public void testStyleLayoutClear(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("clear");
		  solo.sleep(1000);
		  solo.takeScreenshot("LayoutClear",100);

		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("LayoutClear_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("LayoutClear.jpg", "LayoutClear_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("tableLayout",expected,listStyleNow);
	 
	} 
	public void testStyleLayoutClip(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("clip");
		  solo.sleep(1000);
		  solo.takeScreenshot("LayoutClip",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("LayoutClip_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("LayoutClip.jpg", "LayoutClip_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("clip",expected,listStyleNow);
	 
	} 
	public void testStyleLayoutCssFloat(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("cssFloat");
		  solo.sleep(1000);
		  solo.takeScreenshot("cssFloat",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("cssFloat_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("cssFloat.jpg", "cssFloat_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("cssFloat",expected,listStyleNow);
		 
	}  
	
	public void testStyleALayoutDirection(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("direction");
		  solo.sleep(1000);
		  solo.takeScreenshot("direction",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("direction_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("direction.jpg", "direction_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("direction",expected,listStyleNow); 	
	 
	} 
	public void testStyleALayoutHeight(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("height");
		  solo.sleep(1000);
		   solo.takeScreenshot("height",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("height_2",100);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("height.jpg", "height_2.jpg", 300,300,99)){
			  Height = true;
			  }
		  assertEquals("direction",expected,Height); 	
		 
	} 

	
	
	
	public void testStyleALayoutVisibility(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("visibility");
		  solo.sleep(1000);
		  solo.takeScreenshot("visibility",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("visibility_2",100);
		 
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("visibility.jpg", "visibility_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("visibility",expected,Height); 	
		  
	}  
	public void testStyleALayoutWidth(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("width");
		  solo.sleep(1000);
		  solo.takeScreenshot("LayoutWidth",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("LayoutWidth_2",100);
		 
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("LayoutWidth.jpg", "LayoutWidth_2.jpg", 300,300,99)){
			  Height = true;
			  }
		  assertEquals("LayoutWidth",expected,Height); 	
		 
	}  
	
	
	public void testStyleAListStylePosition(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("List");
		  solo.clickOnText("listStylePosition");
		  solo.sleep(1000);
		  solo.takeScreenshot("listStylePosition",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("listStylePosition_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("listStylePosition.jpg", "listStylePosition_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("ListStyleImage",expected,listStyleNow);
		   
	} 

	public void testStyleAPositioning(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("bottom");
		  solo.sleep(1000);
		  solo.takeScreenshot("bottom",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("bottom_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("bottom.jpg", "bottom_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("bottom",expected,listStyleNow);
		   
	}
	public void testStyleALeft(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("left");
		  solo.sleep(1000);
		  solo.takeScreenshot("left",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("left_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("left.jpg", "left_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("left",expected,listStyleNow);
		 
	}
	public void testStyleAPositionzIndex(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("zIndex");
		  solo.sleep(1000);
		  solo.takeScreenshot("zIndex",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("zIndex_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("zIndex.jpg", "zIndex_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("zIndex",expected,listStyleNow);
		   
	}
	public void testStyleAPositionRight(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("right");
		  solo.sleep(1000);
		  solo.takeScreenshot("Right",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Right_2",100);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("Right.jpg", "Right_2.jpg", 300,300,99)){
			  listStyleNow = true;
			  }
		  assertEquals("Right",expected,listStyleNow);
		  
	}
	public void testStyleATextTextIndent(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("textIndent");
		  solo.sleep(1000);
		  solo.takeScreenshot("textIndent",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("textIndent_2",100);
		 
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("textIndent.jpg", "textIndent_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("textIndent",expected,Height); 	
 
	}
	public void testStyleATextTextTransform(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("textTransform");
		  solo.sleep(1000);
		  solo.takeScreenshot("textTransform",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("textTransform_2",100);
		 
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("textTransform.jpg", "textTransform_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("textTransform",expected,Height);
 
	}
	public void testStyleATextWhiteSpace(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("whiteSpace");
		  solo.sleep(1000);
		  solo.takeScreenshot("whiteSpace",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("whiteSpace_2",100);
		 
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("whiteSpace.jpg", "whiteSpace_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("whiteSpace",expected,Height); 	
 
	} */
//}