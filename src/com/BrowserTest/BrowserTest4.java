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

 
@SuppressWarnings("rawtypes")
public class BrowserTest4 extends ActivityInstrumentationTestCase2 {
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
	public BrowserTest4()throws ClassNotFoundException{
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	
	public void setUp()throws Exception{
		solo = new Solo(getInstrumentation(),getActivity());
		solo.sleep(3000);
		webview=solo.getCurrentViews(WebView.class).get(0);
		solo.sleep(2000);

		}
	 /*public void testStyleAListStylePosition(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("List");
		  solo.clickOnText("listStylePosition");
		  solo.sleep(1000);
		  solo.takeScreenshot("listStylePosition",10);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("listStylePosition_2",10);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("listStylePosition.jpg", "listStylePosition_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("ListStyleImage",expected,listStyleNow);
		   
	}  
	 public void testStyleATextTextTransform(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("textTransform");
		  solo.sleep(1000);
		  solo.takeScreenshot("textTransform",70);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("textTransform_2",70);
		 solo.sleep(1000);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("textTransform.jpg", "textTransform_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("textTransform",expected,Height);

	} */
	 public void testStyleBackgroundmargins(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/margin.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("margins");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("margins",50);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("margins_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("margins.jpg", "margins_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("margins",expected,Border);
	 
			}
	public void testStyleBackgroundpadding(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/padding.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("padding");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("padding",50);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("padding_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("padding.jpg", "padding_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("padding",expected,Border);
	 
			} 
// below is  DOM  group
	 public void testStyleBackgroundpaddingLeft(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/paddingleft.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("paddingLeft");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("paddingLeft",50);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("paddingLeft_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("paddingLeft.jpg", "paddingLeft_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("paddingLeft",expected,Border);

			}

	public void testStyleBackgroundpaddingTop(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/paddingtop.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("paddingTop");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("paddingTop",50);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("paddingTop_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("paddingTop.jpg", "paddingTop_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("paddingTop",expected,Border);
	 
			}
	 public void testStyleBackgroundMarginRight(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/marginright.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("marginRight");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("marginRight",50);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("marginRight_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("marginRight.jpg", "marginRight_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("marginRight",expected,Border);
	 
			}
	public void testStyleBackgroundMarginTop(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/margintop.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("marginTop");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("marginTop",50);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("marginTop_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("marginTop.jpg", "marginTop_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("marginTop",expected,Border);
	 
			} 
	 public void testStyleBackgroundMarginLeft(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/marginleft.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("marginLeft");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("marginLeft",50);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("marginLeft_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("marginLeft.jpg", "marginLeft_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("marginLeft",expected,Border);

			} 
	 public void testStyleBackgroundMarginBottom(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/marginbottom.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("marginBottom");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("marginBottom",50);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("marginBottom_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("marginBottom.jpg", "marginBottom_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("marginBottom",expected,Border);
	 
			} 
	 public void testStyleBackgroundBorderRightStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderrightstyle.html");
		  solo.sleep(4000);
		  solo.takeScreenshot("borderRightStyle",50);
		  solo.sleep(1000);
		  //solo.clickOnText("Style");
/*		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderRightStyle");
		  solo.sleep(1000);*/
		  
		
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderRightStyle_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("borderRightStyle.jpg", "borderRightStyle_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("textTransform",expected,Height);

	} 
  
	 
	
	 public void testStyleALayoutVisibility(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/visibility.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("visibility");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("visibility",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("visibility_2",50);
		 solo.sleep(1000);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("visibility.jpg", "visibility_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("visibility",expected,Height); 	
		  
	}   
	 public void testStyleALayoutDirection(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/direction.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("direction");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("direction",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("direction_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("direction.jpg", "direction_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("direction",expected,listStyleNow); 	
	 
	}  
	 public void testSpecifyRules(){		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/rule.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Table");
		  solo.clickOnText("Specify rules");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("SpecifyRules", 50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("SpecifyRules_1", 50);
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
	 public void testStyleBackground(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/background/Backgrounds.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("Backgrounds");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_1",100);
		  solo.sleep(1000);
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/background/backgroundcolor_hex.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundColor hex");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_2",100);
		  solo.sleep(1000);
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/background/backgroundcolor_name.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundColor name");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_3",100);
		  solo.sleep(1000);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/Background_3.jpg");		  
		  solo.sleep(1000);
		  int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 
		  bm.getPixels(pixels,0,bm.getWidth(),0,0,bm.getWidth(),bm.getHeight());
		  int  red =0; int  green =0;int blue = 0;
		  boolean actual = false;
		  for(int i = 0; i < pixels.length; i++){
	             	int clr = pixels[i];
	             	 red   = (clr & 0x00ff0000) >> 16;   
		  			 green = (clr & 0x0000ff00) >> 8;  
		  			 blue  =  clr & 0x000000ff;  
		  			//System.out.println("r="+red+",g="+green+",b="+blue); 		 
		  				 if(red==255 & green == 0 & blue == 0){
		  					   actual = true;
		  				 }
		  			 } 
		  assertEquals("compare",true,actual);
		  	} 
	public void testStyleBackgroundImage(){

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/background/backgroundimage.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundImage");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_4",100);
		  solo.sleep(1000);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/Background_4.jpg");		  
		  solo.sleep(1000);
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

	public void testStyleABorderAndMarginBorderWidth(){
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderwidth.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderWidth");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_20",100);
		  solo.sleep(1000);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_20.jpg");		  
		  solo.sleep(1000);
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/outline.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("outline");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_26",100);
		  solo.sleep(1000);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_26.jpg");		  
		  solo.sleep(1000);
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/outlinecolor.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("outlineColor");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_28",100);
		  solo.sleep(1000);
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/outlinewidth.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("outlineWidth");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_29",100);
		  solo.sleep(1000);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_29.jpg");
		  solo.sleep(1000);
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/background/backgroundrepeat.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundRepeat");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_8",100);
		  solo.sleep(1000);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/Background_8.jpg");		  
		  solo.sleep(1000);
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
	
	
   
 	
 	public void testChangeWidthOfBorder(){		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/border.html");
		  solo.sleep(4000);
		  solo.takeScreenshot("WidthOfBorder", 100);
/*		  solo.clickOnText("Table");
		  solo.clickOnText("Change width of border");
		  */
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("WidthOfBorder_2", 100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("WidthOfBorder.jpg", "WidthOfBorder_2.jpg", 0,0,99)){
			  	  Border = true;
			  }
		  assertEquals("bottom",expected,Border);
	}
	public void testChangeCellPaddingAndCellSpacing(){		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/cellpadding.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Table");
		  solo.clickOnText("Change cellPadding and cellSpacing");*/
		  solo.takeScreenshot("PaddingAndCellSpacing", 50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("PaddingAndCellSpacing_2", 50);
		  solo.sleep(1000);
		  for(WebElement web:solo.getCurrentWebElements()){
				if(web.getvalue().equals("Change Cellspacing")){
					solo.clickOnWebElement(web);
					solo.sleep(2000);
			} 
				 
		  }
		  solo.takeScreenshot("PaddingAndCellSpacing_3", 50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("PaddingAndCellSpacing_2.jpg", "PaddingAndCellSpacing_3.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("PaddingAndCellSpacing_3",expected,Border);
	 
	} 
	
	
	
	public void testStyleBackgroundPositionX(){

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/background/backgroundpositionx.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundPositionX");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("PositionX", 100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("PositionX_2",100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("PositionX.jpg", "PositionX_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("PositionX",expected,Border);
	 
			}
	public void testStyleBackgroundPositionY(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/background/backgroundpositiony.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundPositionY");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("Background_7",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("Background_7_2",100);
		  solo.sleep(1000);
		  
		  boolean expected = true;
		  boolean now = false ;
		   if( ImageCompare.compareImage("Background_7.jpg", "Background_7_2.jpg", 0,0,99)){
			    now = true;
			  
		   }
		 
		   assertEquals("fuck",expected,now);
		   
	}
	
	public void testStyleBackgroundBorderBottomStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderbottomstyle.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderBottomStyle");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("borderBottomStyle",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderBottomStyle_2",100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("borderBottomStyle.jpg", "borderBottomStyle_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("PositionX",expected,Border);
	 
			}
	
	public void testStyleBackgroundBorderStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderstyle.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderStyle");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("borderStyle",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderStyle_2",100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("borderStyle.jpg", "borderStyle_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("borderStyle",expected,Border);
 
			}
	public void testStyleBackgroundBorderTopStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/bordertopstyle.html");
		  solo.sleep(4000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderTopStyle");*/
		  //solo.sleep(1000);
		  solo.takeScreenshot("borderTopStyle",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderTopStyle_2",50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("borderTopStyle.jpg", "borderTopStyle_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("borderTopStyle",expected,Border);
	 
			}
	
	
	
	
	public void testStyleBackgroundOutlineStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/outlinestyle.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("outlineStyle");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("outlineStyle",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("outlineStyle_2",100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("outlineStyle.jpg", "outlineStyle_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("outlineStyle",expected,Border);
	 
			}
	
	
	
	
	
	public void testStyleALayoutHeight(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/height.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("height");*/
		  solo.sleep(1000);
		   solo.takeScreenshot("height",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("height_2",100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("height.jpg", "height_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("direction",expected,Height); 	
		 
	} 

	
	
	
	
	public void testStyleALayoutWidth(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/width.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("width");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("LayoutWidth",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("LayoutWidth_2",100);
		 solo.sleep(1000);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("LayoutWidth.jpg", "LayoutWidth_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("LayoutWidth",expected,Height); 	
		 
	}  
	
	
	
	public void testStyleAPositioning(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/positioning/bottom.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("bottom");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("bottom",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("bottom_2",100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("bottom.jpg", "bottom_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("bottom",expected,listStyleNow);
		   
	}
	public void testStyleALeft(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/positioning/left.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("left");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("left",100);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("left_2",100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("left.jpg", "left_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("left",expected,listStyleNow);
		 
	}
	public void testStyleAPositionzIndex(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/positioning/zindex.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("zIndex");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("zIndex",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("zIndex_2",100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("zIndex.jpg", "zIndex_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("zIndex",expected,listStyleNow);
		   
	}
	public void testStyleAPositionRight(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/positioning/right.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("right");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("Right",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Right_2",100);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("Right.jpg", "Right_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("Right",expected,listStyleNow);
		  
	}
	public void testStyleATextTextIndent(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/textindent.html");
		  solo.sleep(4000);
		  solo.takeScreenshot("textIndent",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("textIndent_2",50);
		 solo.sleep(1000);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("textIndent.jpg", "textIndent_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("textIndent",expected,Height); 	
 
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
		 solo.sleep(1000);
		  boolean expected = true;
		  boolean Height = false;
		  if(ImageCompare.compareImage("whiteSpace.jpg", "whiteSpace_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("whiteSpace",expected,Height); 	
 
	}    
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