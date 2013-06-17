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
public class BrowserTest3 extends ActivityInstrumentationTestCase2 {
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
	public BrowserTest3()throws ClassNotFoundException{
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	
	public void setUp()throws Exception{
		solo = new Solo(getInstrumentation(),getActivity());
		solo.sleep(3000);
		webview=solo.getCurrentViews(WebView.class).get(0);
		solo.sleep(2000);

		}
	/* public void testWindowOpenNewWindowWhenClickingButton(){
		 
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
		  
		  solo.sleep(2000);
		  
		 if(webview.getUrl().equals("http://wap.yahoo.com")){
		    actual = true;
		  	
		 	  
		 }	assertEquals("check url",true,actual);
		  
		 }  */
	/*public void testWindowScrollWindow(){
		 
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(4000);
		  solo.clickOnText("Scroll window");
		  solo.sleep(1000);
		 // solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.clickOnWebElement("Scroll",0,true);
		  solo.sleep(4000);
		  
			  }
  public void testWindowScrollWindowToSpecifiedPosition(){
		 
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
			  solo.sleep(2000);
			  solo.clickOnText("Scroll window to specified position");
			  solo.sleep(1000);
			 // solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.clickOnWebElement("Scroll",0,true);
			  solo.sleep(4000);
			  
		} */
// below is  DOM  group
	
 /*public void testWindowOpenNewWindowAndControlAppearance(){
		//调用的是预加载js中的方法，这里的button点击后页面不跳转
	 	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/window.html");
		  solo.sleep(2000);
		  solo.clickOnText("Open new window and control appearance");
		  
		  solo.sleep(2000);
		  
		  boolean actual = false;
		   
		 solo.clickOnWebElement("Open Window",100,true);
		 
		  solo.sleep(7000);
		  
		 if(solo.waitForText("http://wap.yahoo.com/")){
			  actual = true;
		 }
		assertEquals("jump",true,actual);
		
		  solo.sleep(4000);
	} */
	  public void testStyleTextLetterSpacing(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/letterspacing.html");
		  solo.sleep(2000);
		  solo.sleep(1000);
		  solo.takeScreenshot("letterSpacing",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("letterSpacing_2",50);
		 solo.sleep(2000);
		  boolean Height = false;
		  if(solo.searchText("This is another example paragraph.")){//(ImageCompare.compareImage("letterSpacing.jpg", "letterSpacing_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("letterSpacing",true,Height); 
		 
	}  
	 /*public void testStyleTextFontFamily(){
		 //xiangsi  100%,放大图片看相素,一样
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
			  solo.sleep(2000);
			  solo.clickOnText("Style");
			  solo.clickOnText("Text");
			  solo.clickOnText("fontFamily");
			  solo.sleep(1000);
			  solo.takeScreenshot("fontFamily",20);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("fontFamily_2",20);
			 solo.sleep(2000);
			  boolean Height = false;
			  if(ImageCompare.compareImage("fontFamily.jpg", "fontFamily_2.jpg", 0,0,99)){
				  Height = true;
				  }
			  assertEquals("fontFamily",true,Height); 	
		 
		}   */
	 public void testStyleTableCaptionSide(){
		 //Known error
	 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/table/captionside.html");
			  solo.sleep(2000);
			/*  solo.clickOnText("Style");
			  solo.clickOnText("Table");
			  solo.clickOnText("captionSide");*/
			  solo.sleep(1000);
			  solo.takeScreenshot("CaptionSide",20);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("CaptionSide_2",20);
			  solo.sleep(2000);
			  boolean listStyleNow = false;
			  if(ImageCompare.compareImage("CaptionSide.jpg", "CaptionSide_2.jpg", 0,0,99)){
				  listStyleNow = true;
				  }
			  assertEquals("CaptionSide",true,listStyleNow);
			   
		}  
public void testStyleLayoutVerticalAlign(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/verticalalign.html");
		  solo.sleep(2000);
	/*	  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("verticalAlign");*/
		  solo.sleep(1000);
		   solo.takeScreenshot("LayoutverticalAlign",10);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("LayoutverticalAlign_2",10);
		  solo.sleep(1000);
		  boolean Height = false;
		  if(ImageCompare.compareImage("LayoutverticalAlign.jpg", "LayoutverticalAlign_2.jpg", 100,150,99)){
			  Height = true;
			  }
		  assertEquals("LayoutverticalAlign",true,Height); 	
		   
	} 
public void testStyleListStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/list/liststyle.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("List");
		  solo.clickOnText("listStyle");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("ListStyle",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("ListStyle_2",100);
		  solo.sleep(1000);
		  boolean actual = false;
			 if (solo.searchText("1.")) { 
				 //+"\t"+ "an"+"\t"+ "example"+"\t"+ "paragraph."
				 actual = true;
				  }
			 assertEquals("ListStyle",true,actual); 
			  
	} 
	public void testStyleListStyleImage(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/list/liststyleimage.html");
		  solo.sleep(2000);
	/*	  solo.clickOnText("Style");
		  solo.clickOnText("List");
		  solo.clickOnText("listStyleImage");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("ListStyleImage",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("ListStyleImage_2",100);
		  solo.sleep(1000);

		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("listStyleImage.jpg", "ListStyleImage_2.jpg", 100,100,99)){
			  listStyleNow = true;
			  }
		  assertEquals("ListStyleImage",true,listStyleNow);
		   
	}  
public void testStyleListStyleType(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/list/liststyletype.html");
		  solo.sleep(2000);
	/*	  solo.clickOnText("Style");
		  solo.clickOnText("List");
		  solo.clickOnText("listStyleType");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("listStyleType_1",1);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("listStyleType_2",1);
		  solo.sleep(1000);

		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("listStyleType_1.jpg", "listStyleType_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("listStyleType",true,listStyleNow);
		  
	}  
/*public void testStyleLayoutCursor(){
		//known error,  本身点击后就没反应
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/DOM.html");
		  solo.sleep(2000);
		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("cursor");
		  solo.sleep(1000);
		  solo.takeScreenshot("cursor",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("cursor_2",50);
		  solo.sleep(1000);
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("cursor.jpg", "cursor_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("cursor",true,listStyleNow);
		  
	}  */
public void testStyleBackgroundpaddingBottom(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/paddingbottom.html");
		  solo.sleep(2000);
	/*	  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");*/
		/*  solo.sleep(1000);
		  solo.clickOnText("paddingBottom");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("paddingBottom",50);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("paddingBottom_2",50);
		  solo.sleep(1000);

		  boolean Border = false;
		  if(ImageCompare.compareImage("paddingBottom.jpg", "paddingBottom_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("paddingBottom",true,Border);
		  
			} 
 public void testStyleBackgroundBorderLeftStyle(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/borderleftstyle.html");
		  solo.sleep(2000);
		/*  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("borderLeftStyle");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("borderLeftStyle",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderLeftStyle_2",50);
		  solo.sleep(1000);

		  boolean Border = false;
		  if(ImageCompare.compareImage("borderLeftStyle.jpg", "borderLeftStyle_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("borderLeftStyle",true,Border);
	 
			} 
public void testSpecifyFramesg(){		  
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/frame.html");
		  solo.sleep(2000);
		/*  solo.clickOnText("Table");
		  solo.clickOnText("Specify frames");
		 */
		  solo.sleep(1000);
		  solo.takeScreenshot("Specify_frames", 50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  for(WebElement web:solo.getCurrentWebElements()){
				if(web.getvalue().equals("Show below frames")){
					solo.clickOnWebElement(web);
					solo.sleep(2000);
			} 
		  }
		  solo.takeScreenshot("Specify_frames_2", 50);
		  solo.sleep(1000);
		  boolean expected = true;
		  boolean Border = false;
		  if(ImageCompare.compareImage("Specify_frames.jpg", "Specify_frames_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("Specify frames",expected,Border);
		   
	} 
public void testStyleTextFontSize(){
		 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/fontsize.html");
		 solo.sleep(2000);
		 /*olo.clickOnText("Style");
		 solo.clickOnText("Text");
			  solo.clickOnText("fontSize");*/
			  solo.sleep(1000);
			  solo.takeScreenshot("fontSize",50);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("fontSize_2",50);
			 solo.sleep(1000);
 
			  boolean Height = false;
			  if(ImageCompare.compareImage("fontSize.jpg", "fontSize_2.jpg", 0,0,99)){
				  Height = true;
				  }
			  assertEquals("fontSize",true,Height); 
			 
		}   
  public void testStyleTextColor() throws Exception{
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/color.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("color");*/
		 
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

			  			 
			  
			  assertEquals("compare",true,actual);
		  }
		  solo.goBack();
		  }  
 
 public void testNavigatorAllDetails(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/navigator/all_detail.html");//http://blog.sina.com.cn/s/blog_45d0b2cb0100nqif.html
		  solo.sleep(2000);
		/*  solo.clickOnText("Navigator");
		  solo.clickOnText("All details about visitor browser");*/
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
  public void testStyleTextFontVariant(){
		
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/fontvariant.html");
			  solo.sleep(2000);
	/*		  solo.clickOnText("Style");
			  solo.clickOnText("Text");
			  solo.clickOnText("fontVariant");*/
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
			 

	} 
  
  public void testStyleTextTextDecoration(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/textdecoration.html");
		  solo.sleep(2000);
	/*	  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("textDecoration");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("textDecoration",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("textDecoration_2",50);
		 solo.sleep(2000);
		  boolean Height = false;
		  if(ImageCompare.compareImage("textDecoration.jpg", "textDecoration_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("textDecoration",true,Height);
		 
	} 
  public void testStyleTextWordSpacing(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/wordspacing.html");
		  solo.sleep(2000);
	/*	  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("wordSpacing");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("wordSpacing",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("wordSpacing_2",100);
		  solo.sleep(2000);
		  boolean actual = false;
			 if (solo.searchText("example"+" "+"paragraph")) { 
				 //+"\t"+ "an"+"\t"+ "example"+"\t"+ "paragraph."
				 actual = true;
				  }
			 assertEquals("fontSize",true,actual); 	
			 solo.goBack();
	} 
  
  public void testStyleTableBorderCollapse(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/table/bordercollapse.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Table");
		  solo.clickOnText("borderCollapse");*/
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
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/maxwidth.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("maxWidth");*/
		  solo.sleep(1000);
		   solo.takeScreenshot("maxWidth",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("maxWidth_2",50);
		  solo.sleep(1000);
		  boolean Height = false;
		  if(ImageCompare.compareImage("maxWidth.jpg", "maxWidth_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("maxWidth",true,Height); 
		   
	} 
  public void testStyleLayoutMinHeight(){
		 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/minheight.html");
		 solo.sleep(2000);
/*			  solo.clickOnText("Style");
			  solo.clickOnText("Layout");
			  solo.clickOnText("minHeight");*/
			  solo.sleep(1000);
			  solo.takeScreenshot("minHeight",20);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(1000);
			 solo.takeScreenshot("minHeight_2",50);
			 solo.sleep(1000);
			  boolean Height = false;
			  if(ImageCompare.compareImage("minHeight.jpg", "minHeight_2.jpg", 100,100,99)){
				  Height = true;
				  }
			  assertEquals("minHeight",true,Height); 
			  solo.goBack();
		}  
  public void testStyleLayoutOverFlow(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/overflow.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("overflow");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("overflow",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("overflow_2",50);
		  solo.sleep(1000);
		  boolean Height = false;
		  if(ImageCompare.compareImage("overflow.jpg", "overflow_2.jpg",200,300,99)){
			  Height = true;
			  }
		  assertEquals("overflow",true,Height); 	
		   
	} 
  
  public void testStyleLayoutMaxHeight(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/maxheight.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("maxHeight");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("MaxHeight",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("MaxHeight_2",50);
		  solo.sleep(1000);
		  boolean Height = false;
		  if(ImageCompare.compareImage("MaxHeight.jpg", "MaxHeight_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("MaxHeight",true,Height); 	
		   
	}  
  
  
  public void testStyleBackgroundpaddingRight(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/border_margin/paddingright.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Border and margin");
		  solo.sleep(1000);
		  solo.clickOnText("paddingRight");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("paddingRight",20);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("paddingRight_2",20);
		  solo.sleep(1000);

		  boolean Border = false;
		  if(ImageCompare.compareImage("paddingRight.jpg", "paddingRight_2.jpg", 0,0,99)){
			  Border = true;
			  }
		  assertEquals("paddingRight",true,Border);
		 
			} 
 
  
  
  public void testStylePositionposition(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/positioning/position.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Positioning");
		  solo.clickOnText("positions");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("positions",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("positions_2",50);
		  solo.sleep(1000);
 
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("positions.jpg", "positions_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("positions",true,listStyleNow);
		   
	} 
  public void testOptionDisableAndEnableDropdownList(){
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/option/enable_disable.html");
			  solo.sleep(2000);
			/*  solo.clickOnText("Option");
			  solo.clickOnText("Disable and enable dropdown list");*/
			  solo.clickOnWebElement(new TagName("INPUT"));
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.Id("mySelect"));
			  solo.sleep(1000);
			  boolean actual = false;
			  solo.clickOnWebElement("Enable list", 0, true);
/*			 for(WebElement webs:solo.getCurrentWebElements()){
					if(webs.getvalue().equals("Enable list")){
						solo.clickOnScreen(webs.getLocationX(),webs.getLocationY());
			  
				}  
					 
			 }*/
			
			 for (int i = 1;i<4;i++){
				 solo.clickOnWebElement(new By.Id("mySelect"));
				 solo.clickInList(i);
				  if(solo.searchText("Banana")){
					  actual = true;
				  }
			 }
			 solo.clickOnWebElement(new By.Id("mySelect"));
			 if(solo.searchText("Banana")){
				  actual = true;
			  }
			assertEquals("Droplist",true,actual);
			solo.goBack();
			} 
  public void testOptionGetIdOfFormThatContainsdropdownList(){
		  	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/option/id.html");
			  solo.sleep(2000);
			 /* solo.clickOnText("Option");
			  solo.clickOnText("Get id of form that contains dropdown list");*/
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
      webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/option/size.html");
	  solo.sleep(2000);
/*	  solo.clickOnText("Option");
	  solo.clickOnText("Turn dropdown list into multipleline list");*/
	  solo.sleep(1000);
	  solo.takeScreenshot("TurnDropdown", 50);
	  solo.sleep(1000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(1000);
	  solo.takeScreenshot("TurnDropdown_2", 50);
	  solo.sleep(1000);
	  boolean actual =false;
	 
	   
	  if(ImageCompare.compareImage("TurnDropdown.jpg", "TurnDropdown_2.jpg", 0,0,99)){
		  actual = true;
		  }
	  assertEquals("TurnDropdown",true,actual);
	  
 
	} 	 
  
  
 /* public void testStyleStandardTitleOfAreaInMap(){
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
		  if(ImageCompare.compareImage("AreaInMap.jpg", "AreaInMap_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("AreaInMap",expected,listStyleNow);
		  
		}  */
  public void testAlertButton() throws Exception{
		    webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/anchor/attribute.html");
		    solo.sleep(3000);
		    solo.clickOnWebElement(new By.TagName("INPUT"));
		    boolean actual_result=solo.waitForText("Yahoo");
		    solo.sleep(2000);
			assertEquals("Sohu doesn't displayed", true, actual_result);
			//solo.sendKey(KeyEvent.KEYCODE_BACK);
			} 
  public void testReturnUrl() throws Exception{
		   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/url.html");
		   boolean actual_result_returnUrl=solo.waitForText("http://123.71.192.55:8001/Browser/DOM/document/url.html");
		   solo.sleep(2000);
		   assertEquals("Sohu doesn't displayed", true, actual_result_returnUrl);
		   solo.sleep(3000);
		  

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
 
  public void testWindowReloadAPage(){
		 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/reload.html");
		  solo.sleep(5000);
		  //solo.clickOnText("Reload a page");
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
		  

		 
		 
	  }
 
 
  
  public void testOptionRemoveOptionsFromDropdownList(){
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/option/remove.html");
			  solo.sleep(2000);
			 /* solo.clickOnText("Option");
			 solo.clickOnText("Remove options from dropdown list");*/
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
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/navigator/more_detail.html");
			  solo.sleep(2000);
			/*  solo.clickOnText("Navigator");
			  solo.clickOnText("More details about visitor browser");*/
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
					    actual = true;  }
				  assertEquals("browser",true,actual);
				  solo.goBack();			  
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