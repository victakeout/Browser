package com.BrowserTest;

import java.util.ArrayList;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.*;
import android.widget.EditText;

/**
 * Contains TextView related methods. Examples are:
 * getTextViewsFromWebViews(), createTextViewAndAddInList().
 * 
 * @author Renas Reda, renasreda@gmail.com
 * 
 */

class WebElementCreator {

	private ArrayList<WebElement> webElements;
	private ViewFetcher viewFetcher;//add by zhubin,add view fetcher.
	private Sleeper sleeper;
	private boolean isFinished = false;

	/**
	 * Constructs this object
	 * 
	 * @param sleeper the {@code Sleeper} instance
	 * 
	 */
	//edit by zhu bin,add view fether in webcreator
	public WebElementCreator(Sleeper sleeper,ViewFetcher viewFetcher){
		this.sleeper = sleeper;
		this.viewFetcher = viewFetcher;
		webElements = new ArrayList<WebElement>();
	}

	/**
	 * Prepares for start of creating {@code TextView} objects based on web elements 
	 */

	public void prepareForStart(){
		setFinished(false);
		webElements.clear();
	}

	/**
	 * Returns an {@code ArrayList} of {@code TextView} objects based on the web elements shown
	 * 
	 * @return an {@code ArrayList} of {@code TextView} objects based on the web elements shown
	 */

	public ArrayList<WebElement> getWebElementsFromWebViews(){
		waitForWebElementsToBeCreted();
		return webElements;
	}

	/**
	 * Returns true if all {@code TextView} objects based on web elements have been created
	 * 
	 * @return true if all {@code TextView} objects based on web elements have been created
	 */

	public boolean isFinished(){
		return isFinished;
	}


	/**
	 * Set to true if all {@code TextView} objects have been created
	 * 
	 * @param isFinished true if all {@code TextView} objects have been created
	 */

	public void setFinished(boolean isFinished){
		this.isFinished = isFinished;
	}

	/**
	 * Creates a {@ WebElement} object from the given text and {@code WebView}
	 * 
	 * @param webData the data of the web element 
	 * @param webView the {@code WebView} the text is shown in
	 */

	public void createWebElementAndAddInList(String webData, WebView webView){

		WebElement webElement = createWebElementAndSetLocation(webData, webView);

		if((webElement!=null))
			webElements.add(webElement);
	}

	/**
	 * Sets the location of a {@code WebElement} 
	 * 
	 * @param webElement the {@code TextView} object to set location 
	 * @param webView the {@code WebView} the text is shown in
	 * @param x the x location to set
	 * @param y the y location to set
	 * @param width the width to set
	 * @param height the height to set
	 */

	private void setLocation(WebElement webElement, WebView webView, int x, int y, int width, int height ){
		float scale = webView.getScale();
		int[] locationOfWebViewXY = new int[2];
		webView.getLocationOnScreen(locationOfWebViewXY);
		final ArrayList<EditText> inputUrlZone = viewFetcher.getCurrentViews(EditText.class);//add by zhu bin, add the url input zone height.
		int[] urlZone = new int[2];
		inputUrlZone.get(0).getLocationOnScreen(urlZone);
		Log.e(urlZone[1]+""+urlZone[0]+"","urlzone");
		Log.e(inputUrlZone.get(0).getHeight()+"","urlheight");
		Log.e(locationOfWebViewXY[0]+""+locationOfWebViewXY[1]+"", "url");
		int locationX = (int) (locationOfWebViewXY[0] + (x + (Math.floor(width / 2))) * scale);
		int locationY = (int) (locationOfWebViewXY[1] + (y + (Math.floor(height / 2))) * scale)+urlZone[1]+inputUrlZone.get(0).getHeight()-locationOfWebViewXY[1]-1;//edit by zhubin to modify the screen size to fit our phone.

		webElement.setLocationX(locationX);
		webElement.setLocationY(locationY);
	}

	/**
	 * Creates a {@code WebView} object 
	 * 
	 * @param information the data of the web element
	 * @param webView the web view the text is shown in
	 * 
	 * @return a {@code WebElement} object with a given text and location
	 */

	private WebElement createWebElementAndSetLocation(String information, WebView webView){
		String[] data = information.split(";,");
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		try{
			x = Integer.valueOf(data[5]);
			y = Integer.valueOf(data[6]);
			width = Integer.valueOf(data[7]);
			height = Integer.valueOf(data[8]);
		}catch(Exception ignored){}

		WebElement webElement = null;

		try{
			if(data.length==9){
			  webElement = new WebElement(data[0], data[1], data[2], data[3], data[4]);
			  Log.e("webcreate9", "webelement");
			}
			else{
				webElement = new WebElement(data[0], data[1], data[2], data[3], data[4],data[9]);
				Log.e("webcreate10", "webelement");
			}
			setLocation(webElement, webView, x, y, width, height);
		}catch(Exception ignored) {}

		return webElement;
	}
	//add by zhu bin


	/**
	 * Waits for {@code WebElement} objects to be created
	 * 
	 * @return true if successfully created before timout
	 */

	private boolean waitForWebElementsToBeCreted(){
		final long endTime = SystemClock.uptimeMillis() + 5000;

		while(SystemClock.uptimeMillis() < endTime){

			if(isFinished){
				return true;
			}

			sleeper.sleepMini();
		}
		return false;
	}

}