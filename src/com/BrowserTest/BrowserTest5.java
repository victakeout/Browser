package com.BrowserTest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

	public class BrowserTest5 extends ActivityInstrumentationTestCase2 {
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
		public BrowserTest5()throws ClassNotFoundException{
			super(TARGET_PACKAGE_ID,launcherActivityClass);
		}
		
		public void setUp()throws Exception{
			solo = new Solo(getInstrumentation(),getActivity());
			solo.sleep(3000);
			webview=solo.getCurrentViews(WebView.class).get(0);
			solo.sleep(2000);

			}
	// below is  DOM  group
		 public void testStyleTextFontSizeAdjust(){
			 //点击后文字大小不会改变,手机电脑现象一样
	 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/fontsizeadjust.html");
				  solo.sleep(2000);
/*				  solo.clickOnText("Style");
				  solo.clickOnText("Text");
				  solo.clickOnText("fontSizeAdjust");*/
				  solo.sleep(1000);
				  solo.takeScreenshot("fontSizeAdjust",50);
				  solo.sleep(1000);
				  solo.clickOnWebElement(new By.TagName("INPUT"));
				  solo.sleep(1000);
				  solo.takeScreenshot("fontSizeAdjust_2",50);
				  solo.sleep(1000);
				  boolean expected = true;
				  boolean Height = false;
				  if(ImageCompare.compareImage("fontSizeAdjust.jpg", "fontSizeAdjust_2.jpg", 0,0,99)){
					  Height = true;
					  }
				  assertEquals("fontSizeAdjust",expected,Height); 	
	 
			}  
		 public void testTableAlignCellContentInCell(){ 
			  
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/align_header.html");
			  solo.sleep(2000);
/*			  solo.clickOnText("Table");
			  solo.clickOnText("Align cell content in cell");*/
			  solo.takeScreenshot("AlignCell",100);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.takeScreenshot("AlignCell_2",100);
			  boolean expected = true;
			  boolean Border = false;
			  if(ImageCompare.compareImage("AlignCell.jpg", "AlignCell_2.jpg", 300,300,99)){
				  Border = true;
				  }
			  assertEquals("AlignCell",expected,Border);
			 
				}
		public void testWindowSendToNewLocation(){
			 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/location.html");
			  solo.sleep(5000);
			  //solo.clickOnText("Send to new location");
			  solo.sleep(2000);
			  solo.clickOnWebElement(new By.TagName("INPUT")); 
			  boolean actual = solo.waitForText("http://123.71.192.55:8001/Browser/DOM/window/location.html");
			  boolean expected = true; 
			  assertEquals("uri",expected,actual);
			  solo.clickOnButton("OK");
			  solo.clickOnWebElement("Change URL",0,true);
			  solo.sleep(6000);
			  boolean actual1 = false;
			  if( actual1 = webview.getUrl().equals("http://wap.yahoo.com")){
				  actual1 = true;
				  assertEquals("check url",true,actual1);
			  }
			   
			}   
	

			
	  public void testStyleBorderAndMarginBorder(){
			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borders.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borders");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_1",100);
		  solo.sleep(1000);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_1.jpg");		  
		  solo.sleep(1000);
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

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderbottom.html");
		  solo.sleep(5000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderBottom");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_2",100);
		  solo.sleep(1000);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_2.jpg");		  
		  solo.sleep(1000);
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
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderbottomcolor.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderBottomColor")*/;
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_3",100);
			  solo.sleep(1000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_3.jpg");		  
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
			  				 if(red==0 & green == 0& blue == 255){

			  					   actual = true;
			  				 }

			  			 } 
			  assertEquals("compare",true,actual);
	 
			  	} 
		
		public void testStyleBorderAndMarginBorderBottomWidth(){
			  
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderbottomwidth.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderBottomWidth");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_5",100);
			  solo.sleep(1000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_5.jpg");		  
			 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 
			  solo.sleep(1000);
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
		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/bordercolor.html");
		  solo.sleep(5000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderColor");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_6",100);
		  solo.sleep(1000);
		  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_6.jpg");		  
		  solo.sleep(1000);
		 int[] pixels = new int[bm.getWidth()*bm.getHeight()]; 
		 solo.sleep(1000);
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

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderleft.html");
		  solo.sleep(5000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderLeft");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("BorderAndMargin_7",100);
		  solo.sleep(1000);
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

			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderleftcolor.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderLeftColor");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_8",100);
			  solo.sleep(1000);
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

			  
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderleftwidth.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderLeftWidth");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_10",100);
			  solo.sleep(1000);
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
	 
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderright.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderRight");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_11",100);
			  solo.sleep(2000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_11.jpg");		  
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
			  		 
			  				 if(red==0 & green == 0& blue == 255){

			  					   actual = true;
			  				 }

			  			 } 
			  assertEquals("compare",true,actual);
	 
			  	} 
		public void testStyleBorderAndMarginBorderRightColor(){
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderrightcolor.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderRightColor");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_12",100);
			  solo.sleep(1000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_12.jpg");
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
			  		 
			  				 if(red==0 & green == 0& blue == 255){

			  					   actual = true;
			  				 }

			  			 } 
			  assertEquals("compare",true,actual);
	 
			  	} 
		public void testStyleBorderAndMarginBorderRightWidth(){
			  
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderrightwidth.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderRightWidth");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_14",100);
			  solo.sleep(1000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_14.jpg");		  
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
		public void testStyleBorderAndMarginBorderTop(){
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/bordertop.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderTop");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_16",100);
			  solo.sleep(1000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_16.jpg");		  
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
			  		 
			  				 if(red==0 & green == 0& blue == 255){

			  					   actual = true;
			  				 }

			  			 } 
			  assertEquals("compare",true,actual);
	 
			  	} 
		public void testStyleBorderAndMarginBorderTopColor(){

			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/bordertopcolor.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderTopColor");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_17",100);
			  solo.sleep(1000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_17.jpg");		  
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
			  		 
			  				 if(red==0 & green == 0& blue == 255){

			  					   actual = true;
			  				 }

			  			 } 
			  assertEquals("compare",true,actual);
	 
	}
		public void testStyleBorderAndMarginBorderTopWidth(){

			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/bordertopwidth.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Border and margin");
			  solo.sleep(1000);
			  solo.clickOnText("borderTopWidth");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("BorderAndMargin_19",100);
			  solo.sleep(1000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/BorderAndMargin_19.jpg");		  
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
	
		public void testStyleLayoutClear(){
			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/clear.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Layout");
			  solo.clickOnText("clear");*/
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
			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/clip.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Layout");
			  solo.clickOnText("clip");*/
			  solo.sleep(1000);
			  solo.takeScreenshot("LayoutClip",50);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("LayoutClip_2",50);
			  boolean expected = true;
			  boolean listStyleNow = false;
			  if(ImageCompare.compareImage("LayoutClip.jpg", "LayoutClip_2.jpg", 300,300,99)){
				  listStyleNow = true;
				  }
			  assertEquals("clip",expected,listStyleNow);
		 
		} 
		public void testStyleLayoutCssFloat(){
			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/cssfloat.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Layout");
			  solo.clickOnText("cssFloat");*/
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
		public void testStyleLayoutMinWidth(){
			 //xiangsi  100%,界面没改变
	 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/minwidth.html");
				  solo.sleep(5000);
/*				  solo.clickOnText("Style");
				  solo.clickOnText("Layout");
				  solo.clickOnText("minWidth");*/
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
		public void testStyleTableTableLayout(){
	 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/table/tablelayout.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Table");
			  solo.clickOnText("tableLayout");*/
			  solo.sleep(1000);
			  solo.takeScreenshot("tableLayout",100);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("tableLayout_2",100);
			  solo.sleep(2000);
			  Bitmap bm = BitmapFactory.decodeFile("/sdcard/BrowserTestFolder/tableLayout_2.jpg");		  
			  solo.sleep(2000);
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
		public void testStyleTextFontWeight(){
			 
			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/fontweight.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Text");
			  solo.clickOnText("fontWeight");*/
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
		
	 	public void testStyleTextFontStretch(){
			 //点击后文字大小不会改变,手机电脑现象一样
	 				webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/fontstretch.html");
				  solo.sleep(2000);
/*				  solo.clickOnText("Style");
				  solo.clickOnText("Text");
				  solo.clickOnText("fontStretch");*/
				  solo.sleep(1000);
				  solo.takeScreenshot("fontStretch",50);
				  solo.sleep(1000);
				  solo.clickOnWebElement(new By.TagName("INPUT"));
				  solo.sleep(1000);
				 solo.takeScreenshot("fontStretch_2",50);
				 solo.sleep(1000);
				  boolean expected = true;
				  boolean Height = false;
				  if(ImageCompare.compareImage("fontStretch.jpg", "fontStretch_2.jpg", 0,0,99)){
					  Height = true;
					  }
				  assertEquals("fontStretch",expected,Height); 
	 
			}  
	 	public void testStyleTextFontStyle(){
			 //xiangsi  99%, 
	 			webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/fontstyle.html");
				  solo.sleep(5000);
/*				  solo.clickOnText("Style");
				  solo.clickOnText("Text");
				  solo.clickOnText("fontStyle");*/
				  solo.sleep(1000);
				  solo.takeScreenshot("fontStyle",50);
				  solo.sleep(1000);
				  solo.clickOnWebElement(new By.TagName("INPUT"));
				  solo.sleep(1000);
				 solo.takeScreenshot("fontStyle_2",50);
				 solo.sleep(1000);
				  boolean expected = true;
				  boolean Height = false;
				  if(ImageCompare.compareImage("fontStyle.jpg", "fontStyle_2.jpg", 0,0,99)){
					  Height = true;
					  }
				  assertEquals("fontStyle",expected,Height); 	
	 
			}  
	 	public void testTableAlignCellContentInRow()throws Exception{
			 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/align_header.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Table");
			  solo.clickOnText("Align cell content in row");*/
			  solo.takeScreenshot("InOneRow",50);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.takeScreenshot("InOneRow_2",50);
			  solo.sleep(1000);
			  boolean expected = true;
			  boolean Border = false;
			  if(ImageCompare.compareImage("InOneRow.jpg", "InOneRow_2.jpg", 0,0,99)){
				  Border = true;
				  }
			  assertEquals("InOneRow",expected,Border);
			  
				}
		public void testTableVerticalAlignCellContentInRow(){ 
			  
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/valign_row.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Table");
			  solo.clickOnText("Vertical align cell content in row");*/
			  solo.takeScreenshot("VerticalAlign",50);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.takeScreenshot("VerticalAlign_2",50);
			  solo.sleep(1000);
			  boolean expected = true;
			  boolean Border = false;
			  if(ImageCompare.compareImage("VerticalAlign.jpg", "VerticalAlign_2.jpg", 0,0,99)){
				  Border = true;
				  }
			  assertEquals("VerticalAlign",expected,Border);
			 
				}
		
		public void testTableVerticalAlignCellContentInCell(){ 
			  
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/valign_cell.html");
			  solo.sleep(5000);
	/*		  solo.clickOnText("Table");
			  solo.clickOnText("Vertical align cell content in cell");*/
			  solo.takeScreenshot("VerticalAlignCell",50);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.takeScreenshot("VerticalAlignCell_2",50);
			  solo.sleep(1000);
			  boolean expected = true;
			  boolean Border = false;
			  if(ImageCompare.compareImage("VerticalAlignCell.jpg", "VerticalAlignCell_2.jpg", 0,0,99)){
				  Border = true;
				  }
			  assertEquals("VerticalAlignCell",expected,Border);
		 
				}
			  
		public void testTableChangeColspanOfRow(){ 

			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/change_colspan.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Table");
			  solo.clickOnText("Change colspan of row");*/
			  solo.takeScreenshot("ColspanOfRow",50);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.takeScreenshot("ColspanOfRow_2",50);
			  solo.sleep(1000);
			  boolean expected = true;
			  boolean Border = false;
			  if(ImageCompare.compareImage("ColspanOfRow.jpg", "ColspanOfRow_2.jpg", 0,0,99)){
				  Border = true;
				  }
			  assertEquals("ColspanOfRow",expected,Border);
			 
				}
		/*public void testWindowBreakoutOfAFrame(){

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
			  actual_result = solo.imageCompare("breakout.jpg", "breakout01.jpg",0,0,99);
			  assertEquals("Convert to upper false", false, actual_result);
			  
		  
			   
			}    */
		
		  public void testTableCreateCaption(){
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/caption.html");
			  solo.sleep(5000);
/*			  solo.clickOnText("Table");
			  solo.clickOnText("Create caption");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  boolean row = solo.searchText("My table caption");
	 
			  assertEquals("InnerHTML",true,row);
			  solo.sendKey(KeyEvent.KEYCODE_BACK);
			 
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

