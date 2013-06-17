package com.BrowserTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;


class ImageCompare {
	private static int xPath;
	private static int yPath;
	private int rate;
	public ImageCompare() {
		}
	    public static String[][] getPX(String args,int xpath,int ypath) {  
	        int[] rgb = new int[3];  
	       // File directory = new File(android.os.Environment.getExternalStorageDirectory()+File.separator+"/BrowserTestFolder/");
	        File directory = new File(android.os.Environment.getExternalStorageDirectory()+"/BrowserTestFolder/");
	        if(!directory.exists())
	        	directory.mkdir();
	        File file = new File(directory,args); 
	        Bitmap bm = null;
			if(file.exists()){
				Log.e("file exist", "file");
	          bm =  BitmapFactory.decodeFile(file.toString());
			}
			else
				Log.e("file not exist", "file");
	        String[][] list = new String[300][300];  
	        for (int i = xPath; i < xPath+300; i++) {  
	            for (int j = yPath; j < yPath+300 ; j++) { 
	             
	                int pixel = bm.getPixel(i, j);  
	                rgb[0] = (pixel & 0xff0000) >> 16;  
	                rgb[1] = (pixel & 0xff00) >> 8;  
	                rgb[2] = (pixel & 0xff);  
	                list[i-xPath][j-yPath] = rgb[0] + "," + rgb[1] + "," + rgb[2];   
	            }  
	        } 
	       bm=null;
	      file=null;
	      return list; 
	    }   
		public static boolean compareImage(String imgPath1, String imgPath2,int xpath,int ypath,int rate){  
	    		String[] images = {imgPath1, imgPath2};  
		        if (images.length == 0) {  
          
		        }  
		        String[][] list1 = getPX(images[0],xpath,ypath);  
		        String[][] list2 = getPX(images[1],xpath,ypath);  
		        int xiangsi = 0;  
		        int busi = 0;  
		        int i = 0, j = 0;  
		        for (String[] strings : list1) {  
		            if ((i + 1) == list1.length) {  
		                continue;  
		            }  
		            for (int m=0; m<strings.length; m++) {  
		                try {  
		                    String[] value1 = list1[i][j].toString().split(",");  
		                    String[] value2 = list2[i][j].toString().split(",");
		                    int k = 0;  
		                    for (int n=0; n<value2.length; n++) {  
		                        if (Math.abs(Integer.parseInt(value1[n]) - Integer.parseInt(value2[n])) < 5) {  
		                            xiangsi++;  
		                        } else {  
		                            busi++;  
		                        }  
		                    }  
		                } catch (RuntimeException e) {  
		                    continue;  
		                }  
		                j++;  
		            }  
		            i++;  
		        }  
		        String baifen = "";  
		        try {  
		            baifen = ((Double.parseDouble(xiangsi + "") / Double.parseDouble((busi + xiangsi) + "")) + "");  
		            baifen = baifen.substring(baifen.indexOf(".") + 1, baifen.indexOf(".") + 3);  
		        } catch (Exception e) {  
		            baifen = "0";  
		        }  
		        if (baifen.length() <= 0) {  
		            baifen = "0";  
		        }  
		        if(busi == 0){  
		            baifen="100";  
		        }  
		        Log.e(baifen, "xiangshi");
		        if(Double.parseDouble(baifen)<=rate)
		        	return true;
		        else 
		        	return false;
		        
		        
		        
		    }  
}
