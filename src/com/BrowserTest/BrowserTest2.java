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
public class BrowserTest2 extends ActivityInstrumentationTestCase2 {
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
	public BrowserTest2()throws ClassNotFoundException{
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	
	public void setUp()throws Exception{
		solo = new Solo(getInstrumentation(),getActivity());
		solo.sleep(3000);
		webview=solo.getCurrentViews(WebView.class).get(0);
		solo.sleep(2000);

		}
	public void testWindowClock(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/clock.html");
		  solo.sleep(5000);
		  //solo.clickOnText("Clock");
		  Calendar ca = Calendar.getInstance();
		  int minute =ca.get(Calendar.MINUTE); 
		  int hour =ca.get(Calendar.HOUR_OF_DAY); 
		  String time = hour+""+":"+ minute+"";
		   Log.e("time",time);
		  boolean actual = solo.searchText(time);
		 
		  assertEquals("compart the current time",true,actual);
	}
 public void testTableChangeContentOfCell(){
	 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/change_content.html");
			  solo.sleep(2000);
			 /* solo.clickOnText("Table");
			  solo.clickOnText("Change content of cell");*/
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  boolean button2 = solo.searchText("NEW CONTENT");  
			  assertEquals("delete",true,button2);	
			  
		} 
	  public void testTableCreateCaption(){//服务器检查
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/caption.html");
		  solo.sleep(2000);
		/*  solo.clickOnText("Table");
		  solo.clickOnText("Create caption");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean row = solo.searchText("My table caption");
 
		  assertEquals("InnerHTML",true,row);
		  solo.sendKey(KeyEvent.KEYCODE_BACK);
		 
	}
	  public void testTableDeleteRows(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/deleterow.html");
			  solo.sleep(2000);
			  /*solo.clickOnText("Table");
			  solo.clickOnText("Delete rows");*/
			  for (int i =0;i<3;i++){
				  solo.clickOnWebElement(new By.TagName("INPUT"));
			  }
			  boolean button = solo.searchText("Delete");
			  boolean  actual = false;
			  assertEquals("delete",actual,button);
			  //solo.sendKey(KeyEvent.KEYCODE_BACK);
			 
		}
	  public void testTableInnerHTMLOfARow(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/inner_row.html");
		  solo.sleep(2000);
		  /*solo.clickOnText("Table");
		  solo.clickOnText("InnerHTML of a row");*/
		  solo.clickOnWebElement(new By.Id("myTable"));
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean row = solo.searchText("<td>Row1 cell1</td>");
		  boolean row1 = solo.searchText("<td>Row1 cell2</td>");
		  assertEquals("InnerHTML",row1,row);
		  solo.clickOnButton("OK");
		  solo.sleep(1000);
		  solo.goBack();
		  
	} 
	  
  public void testWindowPopUp(){
	  //Know error,手机点击后本来就不会弹出来
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/popup.html");
		  solo.sleep(5000);
		  //solo.clickOnText("Pop-up");
		  solo.clickOnWebElement(new By.TagName("BUTTON"));
		  solo.sleep(5000);
		  solo.goBack();
	}  
  public void testWindowPrompt_box(){
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/prompt.html");
	  solo.sleep(5000);
	  //solo.clickOnText("Display prompt box");
	  
	 // solo.clickOnWebElement("Display a prompt box",0,true);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(2000);
	 
	  solo.enterText(0, "TCL Mobile");
	 // solo.clickOnView(solo.getView(id.button1));
	  
	  boolean actual= solo.waitForText("Hello TCL Mobile! How are you today?");
	 // solo.clickOnButton("OK");
	  assertEquals("hi",true,actual);
	 
 }
public void testStyleFont() throws Exception{
		 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/font.html");
		  solo.sleep(2000);
		  solo.sleep(1000);
	/*	  solo.clickOnText("Text");
		  solo.sleep(1000);
		  solo.clickOnText("font");
		  solo.sleep(1000); */
		  solo.takeScreenshot("font",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  
		  solo.sleep(1000);
		  solo.takeScreenshot("font_1",100);
		  solo.sleep(1000);

		  boolean listStyleNow = false;
		if(ImageCompare.compareImage("font.jpg", "font_1.jpg", 0,0,99)){
				  listStyleNow = true;
			 }
			  assertEquals("tableLayout",true,listStyleNow);
			  
		} 
	  public void testStyleStandardDir(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/standard/dir.html");
		  solo.sleep(2000);
		/*  solo.clickOnText("Style");
		  solo.clickOnText("Standard");
		  solo.clickOnText("dir");*/
		  solo.sleep(1000);
		 
		 
		  boolean listStyleNow = false;
		  if(solo.searchText("Text direction: rtl") & solo.searchText( "An alternate way: rtl")){
			  listStyleNow = true;
			  }
		  assertEquals("zIndex",true,listStyleNow);
		  
	} 
	  public void testStyleStandardTitle(){
			 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/standard/title.html");
				  solo.sleep(2000);
				/*  solo.clickOnText("Style");
				  solo.clickOnText("Standard");
				  solo.clickOnText("title");*/
				  solo.sleep(1000);
		          boolean listStyleNow = false;
				  if(solo.searchText("Body title: mytitle") & solo.searchText( "An alternate way: mytitle")){
					  listStyleNow = true;
					  }
				  assertEquals("title",true,listStyleNow);
				   
			} 
	  public void testStyleTableEmptyCells(){
		  //Known error   点击没反应
	 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/table/emptycells.html");
			  solo.sleep(2000);
	/*		  solo.clickOnText("Style");
			  solo.clickOnText("Table");
			  solo.clickOnText("emptyCells");*/
			  solo.sleep(1000);
			  solo.takeScreenshot("emptyCells",50);
			  solo.sleep(1000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  solo.sleep(2000);
			  solo.takeScreenshot("emptyCells_2",50);
			  solo.sleep(1000);
	 
			  boolean listStyleNow = false;
			  if(ImageCompare.compareImage("emptyCells.jpg", "emptyCells_2.jpg", 0,0,99)){
				  listStyleNow = true;
				  }
			  assertEquals("emptyCells",true,listStyleNow);
			   
		} 
	  public void testTableAddCells(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/insertcell.html");
			  solo.sleep(2000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  boolean button = solo.searchText("Peter");
			  boolean button2 = solo.searchText("John");
			  
			  assertEquals("delete",button,button2);
			 // solo.sendKey(KeyEvent.KEYCODE_BACK);
			 
		} 
	  public void testTableAddRows(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/insertrow.html");
			  solo.sleep(2000);
			  solo.clickOnWebElement(new By.TagName("INPUT"));
			  
			  boolean button = solo.searchText("NEW CELL1");
			  boolean button2 = solo.searchText("NEW CELL2");
			  
			  assertEquals("delete",button,button2);
			  //solo.sendKey(KeyEvent.KEYCODE_BACK);
			  
		}
public void testWindowDisplayAlertbox() {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/alert.html");
	  solo.sleep(5000);
	  //solo.clickOnText("Display alert box");
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(1000);
	  boolean actual = solo.waitForText("I am an alert box!!");  
	  assertEquals("isfound?",true,actual);
	  solo.clickOnButton("OK");
	  solo.sleep(3000);
 
 
	}
  public void testWindowAlertboxwithline_breaks() {

		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/alert_multiline.html");
		  solo.sleep(5000);
		  //solo.clickOnText("Alert box with line-breaks");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(5000);

		  boolean actual = solo.waitForText("Hello again! This is how we" + '\n' + "add line breaks to an alert box!");
		  assertEquals("isfound?",true,actual);
		  solo.clickOnButton("OK");
		  solo.sleep(3000);
		  solo.goBack();
	 
		
	}
  public void testWindowDisplay_confirm_box(){
	     webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/confirm.html");
		  //solo.clickOnText("Display confirm box");
	     solo.sleep(5000); 
	     solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(5000);
		  solo.clickOnView(solo.getView(id.button1));
		  
		  for(WebElement web:solo.getCurrentWebElements()){
			   if(web.getvalue().equals("OK")){
				   solo.clickOnText("OK");
			   }
				   
			}
		  boolean Button_Cancel = solo.waitForText("You pressed OK!");
		  assertEquals("isfound?",true,Button_Cancel);
		  
		 
	 }

  public void testWindowWriteTextInStatusbar(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/status.html");
		  solo.sleep(5000);
		  //solo.clickOnText("Write text in status bar");
		  boolean actual = solo.searchText("Look at the text in the statusbar."); 
 
		  assertEquals("write",true,actual);
		  solo.sleep(5000);
		  
	}
  public void testScreen(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/screen/screen.html");
			  solo.sleep(5000);
			  DisplayMetrics dm = new DisplayMetrics();
			  getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
			  String h =  dm.heightPixels +"";
			  String w =  dm.widthPixels +"";
			  System.out.println("The device width is :"+ w+ "and heigh is :" + h);
			  boolean pi = solo.searchText(w) || solo.searchText(h);		  
			  assertEquals("pixle",true,pi);		  
		}
 /* public void testTableInnerHTMLOfACell(){
	      webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/table/inner_row.html");
		  solo.sleep(2000);
		  solo.clickOnText("Table");
		  solo.clickOnText("InnerHTML of a cell");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean row = false;
		  if(solo.searchText("cell 1")){
			  
			  solo.clickOnButton("OK");
			  row = true; 
		  }
		  assertEquals("InnerHTML",true,row);
		  solo.goBack();
	} */

  public void testWindowOpen_multiple_windows(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/open_multi.html");
		  solo.sleep(5000);
		  //solo.clickOnText("Open multiple windows");
		  solo.sleep(2000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(4000);
	}
  public void testWindowSimpleTiming(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/timing.html");
		  solo.sleep(5000);
		  //solo.clickOnText("Simple timing");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean actually= solo.waitForDialogToOpen(7000);
		  assertEquals("dialog",true,actually);
		  solo.sleep(4000);
		  if(solo.searchText("5 seconds!")){
			  solo.clickOnButton("OK");
		  }
		  solo.sleep(2000);
	}
  public void testWindowAnotherSimpleTiming(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/timing2.html");
		  solo.sleep(5000);
		  //solo.clickOnText("Another simple timing");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(10000);
		  boolean actual = false;
		  for(WebElement web:solo.getCurrentWebElements()){
			  if(web.getvalue().equals("6 seconds!")){
				 actual = true;
				
				 Log.e("thanks","Giving day");
			  }  
		  }assertEquals("searchTxt",true,actual);
		  
	}	
  public void testWindowTimingEventInInfiniteLoop(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/timing_event.html");
		  solo.sleep(5000);
		  //solo.clickOnText("Timing event in infinite loop");
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(10000);
		  boolean actual = false;
		  for(WebElement web:solo.getCurrentWebElements()){
			  if(web.getvalue().equals("7") || web.getvalue().equals("9") || web.getvalue().equals("8")){
				 actual = true;
				
				 Log.e("thanks","Giving day");
			  }  
		  }assertEquals("searchNum",true,actual);
		 
	}	
  public void testWindowTimingEventInInfiniteLoopWithStopButton(){
		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/window/timing_event2.html");
		  solo.sleep(5000);
		  //solo.clickOnWebElement(new By.Text("Timing event in infinite loop with Stop button"));
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
		 
	}	
 
 
  public void testStyleBackgroundImageFix(){
		//No effect
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/background/backgroundimage_fix.html");
		  solo.sleep(2000);
		 /* solo.clickOnText("Style");
		  solo.clickOnText("Background");
		  solo.sleep(1000);
		  solo.clickOnText("backgroundImage fix");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("Background_5",100);
		  	} 
  public void testStyleLayoutDisplay(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/layout/display.html");
		  solo.sleep(2000);
	/*	  solo.clickOnText("Style");
		  solo.clickOnText("Layout");
		  solo.clickOnText("display");*/
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean actual = true;
	 
		  if(solo.searchText("This is some text. This is some text.")){
			  actual = false;;
			  
		  }
 
		  assertEquals("display",true,actual); 	
		   
	} 

  public void testStyleStandardLang(){
	  	webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/standard/lang.html");
		  solo.sleep(2000);
		 /* solo.clickOnText("Style");
		  solo.clickOnText("Standard");
		  solo.clickOnText("lang");*/
		  solo.sleep(1000);

		  boolean listStyleNow = false;
		  if(solo.searchText("Body language: en-us") & solo.searchText( "An alternate way: en-us")){
			  listStyleNow = true;
			  }
		  assertEquals("lang",true,listStyleNow);
		  
	} 

  public void testStyleTableBorderSpacing(){
 		webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/table/borderspacing.html");
		  solo.sleep(2000);
/*		  solo.clickOnText("Style");
		  solo.clickOnText("Table");
		  solo.clickOnText("borderSpacing");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("borderSpacing",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(2000);
		  solo.takeScreenshot("borderSpacing_2",100);
		  solo.sleep(1000);
 
		  boolean listStyleNow = false;
		  if(ImageCompare.compareImage("borderSpacing.jpg", "borderSpacing_2.jpg", 0,0,99)){
			  listStyleNow = true;
			  }
		  assertEquals("borderSpacing",true,listStyleNow);
		 
	} 

 
  public void testStyleTextLineHeight(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/lineheight.html");
		  solo.sleep(2000);
		/*  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("lineHeight");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("lineHeight",100);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		 solo.takeScreenshot("lineHeight_2",100);
		  solo.sleep(1000);
 
		  boolean Height = false;
		  if(ImageCompare.compareImage("lineHeight.jpg", "lineHeight_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("lineHeight",true,Height); 	
		 
	}
  public void testStyleTextTextAlign(){
		 
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/style/text/textalign.html");
		  solo.sleep(2000);
	/*	  solo.clickOnText("Style");
		  solo.clickOnText("Text");
		  solo.clickOnText("textAlign");*/
		  solo.sleep(1000);
		  solo.takeScreenshot("textAlign",50);
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(1000);
		  solo.takeScreenshot("textAlign_2",50);
		  solo.sleep(1000);
 
		  boolean Height = false;
		  if(ImageCompare.compareImage("textAlign.jpg", "textAlign_2.jpg", 0,0,99)){
			  Height = true;
			  }
		  assertEquals("textAlign",true,Height); 	
		   
	}
  public void testOptionGetNumberOfOptionsInDropdownList(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/option/length.html");
		  solo.sleep(2000);
		/*  solo.clickOnText("Option");
		  solo.clickOnText("Get number of options in dropdown list");*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean number = solo.searchText("4");
 
		  assertEquals ("Equals number",number,true);
		  solo.clickOnButton("OK");
		  
	} 
  public void testOptionSelectMultipleOptionsInDropdownList(){
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/option/multiple.html");
		  solo.sleep(2000);
		 /* solo.clickOnText("Option");
		  solo.clickOnText("Select multiple options in dropdown list");*/
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
		  
			} 
  public void testOptionAlertOptionSelectedInDropdownList(){
		 webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/option/options.html");
		 solo.sleep(2000);
		/*  solo.clickOnText("Option");
		  solo.clickOnText("Alert option selected in dropdown list");*/
		  solo.clickOnWebElement(new By.Id("mySelect"));
		  solo.clickInList(2);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  boolean search = solo.searchText("Banana");
		  assertEquals("check",true,search);
		  solo.clickOnButton("OK");
		   
			} 
  public void testOptionAlertIndexOfSelectedOptionInDropdownList(){	
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/option/index.html");
		  solo.sleep(2000);
		  /*solo.clickOnText("Option");
		  solo.clickOnText("Alert index of selected option in dropdown list");*/
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
			  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/option/text.html");
			  solo.sleep(2000);
			 /* solo.clickOnText("Option");
			  solo.clickOnText("Change text of option selected");*/
			  for (int i =1;i<5;i++){
				  solo.clickOnWebElement(new By.Id("mySelect"));
				  solo.clickInList(i);
				  solo.clickOnWebElement(new By.TagName("INPUT"));
				  }
			  solo.clickOnWebElement(new By.Id("mySelect"));
			  boolean water = solo.searchText("Melon");
			  assertEquals("water",true,water);
			  //solo.clickOnText("Melon");
			   
			}
  public void testNavigatorAlertUserDependingOnBrowser(){
		
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/navigator/alert.html");//http://blog.sina.com.cn/s/blog_45d0b2cb0100nqif.html
		  //solo.sleep(2000);
		  //solo.clickOnText("Navigator");
		 // solo.clickOnText("Alert user depending on browser");
		 /* solo.sleep(1000);
		  solo.sleep(1000);
		  solo.takeScreenshot("AlertUser", 100);
		  solo.sleep(2000);*/
		  if(solo.searchText("Your browser is good enough!")){
			  solo.clickOnButton("OK");
			  solo.sleep(1000);
			  solo.goBack();
			  solo.sleep(1000);
		  }
		 
		  
	}
  public void testNavigatorDetectVisitor(){
		//为了兼容性而考虑的
		//appVersion Must return either the string "4.0" or a string representing the version of the browser in detail, e.g. "1.0 (VMS; en-US) Mellblomenator/9000".
		//appName Must return either the string "Netscape" or the full name of the browser, e.g. "Mellblom Browsernator".
		  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/navigator/name_version.html");//http://blog.sina.com.cn/s/blog_45d0b2cb0100nqif.html
		  solo.sleep(2000);
	/*	  solo.clickOnText("Navigator");
		  solo.clickOnText("Detect visitor browser and version");*/
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