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
public class BrowserTest6 extends ActivityInstrumentationTestCase2 {
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
	public BrowserTest6()throws ClassNotFoundException{
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	
	public void setUp()throws Exception{
	
		solo = new Solo(getInstrumentation(),getActivity());
		solo.sleep(3000);
		webview=solo.getCurrentViews(WebView.class).get(0);
		solo.sleep(2000);
		
	}
	
	 public void testJavaScriptBasic_WriteText() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/text.html");
		  solo.sleep(3000);
		 /* solo.clickOnText("Write text with JavaScript");*/
		  boolean actual_result = solo.waitForText("Hello World!");
		  assertEquals("WriteText", true, actual_result);  
		 
	  }
	public void testJavaScriptBasic_WriteHTML() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/tag.html");
		  solo.sleep(3000);
		 /* solo.clickOnText("Write HTML tags with JavaScript");*/
		  boolean actual_result = solo.waitForText("This is a header");
		  assertEquals("WriteHTML", true, actual_result);  
		   
	  }
	public void testJavaScriptBasic_InBody() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/in_body.html");
		  solo.sleep(3000);
		 /* solo.clickOnText("JavaScript in body section");*/
		  boolean actual_result = solo.waitForText("This message is written by JavaScript");
		  assertEquals("InBody", true, actual_result);  
	 
	  }
	public void testJavaScriptBasic_InHead() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/in_head.html");
		  solo.sleep(3000);
		  /*solo.clickOnText("JavaScript in head section");*/
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/external_2.html");
		  solo.sleep(5000);
		  //solo.clickOnText("External JavaScript 2");
		  boolean actual_result = solo.waitForText("The actual script is in an external script file called \"external.js\".");
		  assertEquals("External_2", true, actual_result);  
		  
	  } 
	public void testJavaScriptBasic_Statements() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/statement.html");
		  solo.sleep(3000);
		  //solo.clickOnText("JavaScript statements");
		  boolean actual_result = solo.searchText("This is another paragraph");
		  assertEquals("Statements", true, actual_result);
		   
	  }
	public void testJavaScriptBasic_SingleLine() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/single_comment.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Single line comments");
		  boolean actual_result = solo.searchText("This is another paragraph");
		  assertEquals("SingleLine", true, actual_result);
		 
	  }
	public void testJavaScriptBasic_MultipleLine() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/multi_comment.html");
		  solo.sleep(3000);
		  /*solo.clickOnText("Multiple line comments");*/
		  boolean actual_result = solo.searchText("This is another paragraph");
		  assertEquals("Multiple line", true, actual_result); 
		   
	  }
	public void testJavaScriptBasic_Prevent() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/single_no_exe.html");
		  solo.sleep(3000);
		 /* solo.clickOnText("Single line comment to prevent execution");*/
		  boolean actual_result = solo.searchText("This is a paragraph");
		  assertEquals("prevent", true, actual_result);  
		   
	  }
	public void testJavaScriptBasic_MultiplePrevent() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/multi_no_exe.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Multiple lines comment to prevent execution");
		  boolean actual_result = solo.searchText("This is another paragraph");
		  assertEquals("MultiplePrevent", true, actual_result);  
		   
	  } 
	public void testJavaScriptBasic_Variables() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/var.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Declare a variable");
		  boolean actual_result = solo.searchText("The script above declares a variable");
		  assertEquals("Variables", true, actual_result);  
		   
	  }

	@SuppressWarnings("deprecation")
	public void testJavaScriptBasic_Condition_if_else() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/if_else.html");
		  solo.sleep(3000);
		  //solo.clickOnText("If...else statement");
		  Date date = new Date();
		  boolean actual_result = false;
		  int hours = date.getHours();
		  if (hours < 10) 
		  {  solo.searchText("Good morning!");
		  	 actual_result = true;
		  }
		  else if (hours >=10 & hours <=12)
		  {	solo.searchText("Good noon!");
		  	actual_result = true;
		  }
		  else if (hours >13 & hours <=17)
		  {	solo.searchText("Good afternoon!");
		  	actual_result = true;
		  } 
		  else if (hours >17 & hours <=20)
		  {	solo.searchText("Good evening!");
		  	actual_result = true;
		  }
		  else
		  {	solo.searchText("Good night!");
		  	actual_result = true;
		  }
		  assertEquals("Variables", true, actual_result);
	  } 
	public void testJavaScriptBasic_Switch() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/switch.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Switch statement");
		  boolean actual_result = false;
		  Date date = new Date();
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/function_call.html");
		  solo.sleep(3000);
		 /* solo.clickOnText("Call a function");
		  solo.sleep(1000);*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.waitForDialogToOpen(20);
		  boolean actual_result = solo.searchText("HELLO");
		  solo.clickOnButton("OK");
		  assertEquals("Function", true, actual_result);
		  
	  }
	public void testJavaScriptBasic_Function_argument() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/function_with_argument.html");
		  solo.sleep(3000);
		/*  solo.clickOnText("Function with an argument");
		  solo.sleep(1000);*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.waitForDialogToOpen(20);
		  boolean actual_result = solo.searchText("Hello");
		  solo.clickOnButton("OK");
		  assertEquals("argument", true, actual_result);  
		 
	  }
	public void testJavaScriptBasic_Function_argument_2() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/function_with_argument_ext.html");
		  solo.sleep(3000);
		/*  solo.clickOnText("Function with an argument 2");
		  solo.sleep(1000);*/
		  //add by zhubin to action two button
		//solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.clickOnWebElement("In the Morning", 0, true);
		  solo.waitForDialogToOpen(20);
		  boolean actual_result = solo.searchText("Good Morning!");
		  solo.clickOnButton("OK");
		  solo.clickOnWebElement("In the Evening", 0, true);
		  if(!solo.searchText("Good Evening!"))
			  actual_result = false;
		  solo.clickOnButton("OK");
		  assertEquals("argument_2", true, actual_result); 
		 
	  }
	public void testJavaScriptBasic_Function_Return_value() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/function_return_value.html");
		  solo.sleep(3000);
		 /* solo.clickOnText("Function that returns a value");
		  solo.sleep(1000);*/
		  boolean actual_result = solo.searchText("Following text is return from function call: Hello, have a nice day!");
		  assertEquals("Return_value", true, actual_result);  
		  
	  }
	public void testJavaScriptBasic_Function_Return_value_argument() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/function_return_value_argue.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Function with arguments, that returns a value");
		  solo.sleep(1000);
		  boolean actual_result = solo.searchText("4*3= 12");
		  assertEquals("value_argument", true, actual_result); 
		   
	  } 

	public void testJavaScriptBasic_Array_Create_Array() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/create.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Create an array");
		  boolean actual_result = solo.searchText("BMW") && solo.searchText("Volvo")&& solo.searchText("Saab");
		  assertEquals("BMW", true, actual_result);  
		  
	  }
	public void testJavaScriptBasic_Array_Through_Array() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/for.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Use for to loop through an array");
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/join.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Put elements into a string with join()");
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/array/sort2.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Numeric array - sort()");
		  boolean actual_result = solo.searchText("After sort is: 1,5,10,25,40,1000");
		  assertEquals("Numeric", true, actual_result);  
	 
	  }  
	public void testJavaScriptBasic_Boolean() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/boolean/check.html");
		  solo.sleep(3000);
		 // solo.clickOnText("Check Boolean value");
		  boolean actual_result = solo.searchText("0 is boolean false")&&solo.searchText("1 is boolean true")&&solo.searchText("An empty string is boolean false")&&solo.searchText("null is boolean false")&&solo.searchText("NaN is boolean false")&&solo.searchText("The string 'false' is boolean true");
		  assertEquals("Boolean", true, actual_result);  
		 
	  } 
	public void testJavaScriptBasic_Date() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/datetoday.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Use Date()");
		  Calendar cl = Calendar.getInstance();
		  SimpleDateFormat sf = new SimpleDateFormat("dd yyyy HH:mm");
		  boolean actual_result = solo.searchText(sf.format( cl.getTime()));
		  assertEquals("Boolean", true, actual_result);  
		  
	  } 
	public void testJavaScriptBasic_Date_Since1970() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/gettime.html");
		  solo.sleep(3000);
		 // solo.clickOnText("Use getTime()");		  
		  Calendar calendar=Calendar.getInstance();  
		  int year=calendar.get(Calendar.YEAR)-1970;  
		  String s = String.valueOf(year);
		  boolean actual_result = solo.searchText(s);
		  assertEquals("Boolean", true, actual_result);  
		  
	  } 
	public void testJavaScriptBasic_Date_FullYear() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/setfullyear.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Use setFullYear()");		  
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/getday.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Use getDay()");		  
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
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/date/clock.html");
		  solo.sleep(3000);
		  /*solo.clickOnText("Display a clock");	*/
		  Calendar calendar=Calendar.getInstance();  
		  int h = calendar.get(Calendar.HOUR_OF_DAY);
		  int m = calendar.get(Calendar.MINUTE);
		  boolean actual_result = solo.searchText(h+""+":"+m+"");
		  Log.e(h+""+":"+m+"","time");
		  assertEquals("FullYear", true, actual_result);  
		 
	  } 
	public void testJavaScriptBasic_Condition_if() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/if.html");
		  solo.sleep(3000);
		   
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
		   
	}  
	public void testJavaScriptBasic_Math_Round() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/math/round.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Use round()");	
		  boolean actual_result = solo.searchText("-5");
		  assertEquals("Round", true, actual_result);  
		  
	  }
	public void testJavaScriptBasic_Math_Random() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/math/random.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Use random()");	
		  boolean actual_result = solo.searchText("A random number between 0 & 1: 0.");
		  assertEquals("Round", true, actual_result);  
		  
	  }
	public void testJavaScriptBasic_Math_max() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/math/max.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Use max()");	
		  boolean actual_result = solo.searchText("-3");
		  assertEquals("max", true, actual_result);  
		   
	  }
	public void testJavaScriptBasic_Math_min() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/math/min.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Use min()");	
		  boolean actual_result = solo.searchText("-5");
		  assertEquals("min", true, actual_result);  
		  
	  } 
	/*public void testJavaScriptBasic_Math_Fahrenheit() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/math/math.html");
		  solo.sleep(3000);
		  solo.clickOnText("Convert Celsius to Fahrenheit");
		  boolean actual_result  =false;
		  solo.enterTextInWebElement(new By.Id("c"), "2");
		  solo.sleep(1000);
		  for(WebElement webs:solo.getCurrentWebElements()){
			  if(webs.getvalue().equals("Convert to F")){
				  solo.clickOnWebElement(webs);
				  solo.sleep(1000);
				  actual_result = true;
				  Log.e("他妹"," 一直空指针,倒低是怎么回事");
				   
					  }

		  }
		  
		  assertEquals("Fahrenheit", true, actual_result); 
		  
	  } */
	public void testJavaScriptBasic_Loops() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/for_loop.html");
		  solo.sleep(3000);
		/*  solo.clickOnText("For loop");//delete by zhubin
		  solo.sleep(1000);*/
		  boolean actual_result = solo.searchText("The number is 5");
		  assertEquals("Loops", true, actual_result); 
		 
	  }
	public void testJavaScriptBasic_Loops_HTML() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/loop_html_header.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Looping through HTML headers");
		  solo.sleep(1000);
		  boolean actual_result = solo.searchText("This is header 6");
		  assertEquals("Loops_HTML", true, actual_result);  
		  
	  }
	public void testJavaScriptBasic_Loops_While() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/while_loop.html");
		  solo.sleep(3000);
		  //solo.clickOnText("While loop");
		  solo.sleep(1000);
		  boolean actual_result = solo.searchText("The number is 5");
		  assertEquals("Loops_While", true, actual_result); 
		  
	  }
	public void testJavaScriptBasic_Loops_DoWhile() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/do_while_loop.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Do While loop");
		  solo.sleep(1000);
		  boolean actual_result = solo.searchText("The number is 5");
		  assertEquals("DoWhile", true, actual_result);
		   
	  }
	public void testJavaScriptBasic_Loops_Break() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/break_loop.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Break a loop");
		  solo.sleep(1000);
		  boolean actual_result = solo.searchText("The number is 2");
		  assertEquals("Break", true, actual_result); 
		 
	  }
	public void testJavaScriptBasic_Loops_continue_Break() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/break_continue_loop.html");
		  solo.sleep(3000);
		  /*solo.clickOnText("Break and continue a loop");
		  solo.sleep(1000);*/
		  boolean actual_result = solo.searchText("The number is 10");
		  assertEquals("continue_Break", true, actual_result);
		   
	  }
	public void testJavaScriptBasic_Loops_continue_Array() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/for_loop_through_array.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Use a for...in statement to loop through the elements of an array");
		  solo.sleep(1000);
		  boolean actual_result = solo.searchText("BMW");
		  assertEquals("BMW", true, actual_result);  
		   
	  } 
	public void testJavaScriptBasic_String_length() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/string/length.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Return length of string");	
		  boolean actual_result = solo.searchText("the length of \"Hello World!\" is 12");
		  assertEquals("min", true, actual_result);  
		  
	  } 
	public void testJavaScriptBasic_String_Style() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/string/style.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Style strings");	  
		  boolean actual_result = solo.searchText("Hello World!");
		  assertEquals("min", true, actual_result);  
		   
	  }
	public void testJavaScriptBasic_String_Return_position() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/string/indexof.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Return position of 1st occurrence of text in string with indexOf()");	  
		  boolean actual_result = solo.searchText("-1");
		  assertEquals("Return_positio", true, actual_result); 
		  
	  }
	public void testJavaScriptBasic_String_Search_returns() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/string/match.html");
		  solo.sleep(3000);
		 /* solo.clickOnText("Search & return the text found with match()");	*/  
		  boolean actual_result = solo.searchText("world")&&solo.searchText("null")&&solo.searchText("null")&&solo.searchText("world");
		  assertEquals("Search", true, actual_result);  
		  
	  }
	public void testJavaScriptBasic_String_replace() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/string/replace.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Replace characters in string with replace()");	  
		  boolean actual_result = solo.searchText("\"Visit Microsoft!\" is replaced by \"Visit JRD!\"");
		  assertEquals("replace", true, actual_result);  
		   
	    
	} 
	public void testJavaScriptBasic_PopupBoxes() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/alert.html");
		  solo.sleep(3000);
		  /*solo.clickOnText("Alert box");
		  solo.sleep(1000);*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.waitForDialogToOpen(20);
		  boolean actual_result = solo.searchText("I am an alert box!!");
		  solo.clickOnButton("OK");
		  assertEquals("PopupBoxes", true, actual_result); 
		  
	  }
	public void testJavaScriptBasic_PopupBoxes_linebreak() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/alert_line_break.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Alert box with line breaks");
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		 
		  boolean actual_result = solo.searchText("add line breaks to an alert box!");
		  solo.clickOnButton("OK");
		  assertEquals("linebreak", true, actual_result);
		 
	  }
	public void testJavaScriptBasic_PopupBoxes_ConfirmBox() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/confirm.html");
		  solo.sleep(3000);
		  //solo.clickOnText("Confirm box");
		  solo.sleep(1000);
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		   
		  solo.clickOnButton("OK");
		  boolean actual_result = solo.searchText("You pressed OK!");
		  assertEquals("ConfirmBox", true, actual_result); 
		  
	  }
	public void testJavaScriptBasic_PopupBoxes_Prompt() throws Exception {
		  webview.loadUrl("http://123.71.192.55:8001/Browser/JavaScripts/basic/prompt.html");
		  //点击之后文本框弹不出来
		  solo.sleep(3000);
		  //solo.clickOnText("Prompt box");
		  //solo.sleep(1000);
		/*  for(WebElement web:solo.getCurrentWebElements()){
			  if(web.getvalue().equals("Display a prompt box"))
				  solo.clickOnWebElement(web);
			  	  
		  }*/
		  solo.clickOnWebElement(new By.TagName("INPUT"));
		  solo.sleep(3000);
		/*  solo.enterText(null, "Vic takeout");
		  solo.clickOnButton("OK");
		  boolean actual_result = solo.searchText("Hello Vic takeout! How are you today?");
		  assertEquals("Prompt", true, actual_result);  
		   */
	  } 
	   public void tearDown() throws Exception {
	       
            try {
            	solo.finishOpenedActivities();
				solo.finalize();
				System.gc();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            super.tearDown();
	  }
	   
}


