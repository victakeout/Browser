package com.BrowserTest;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.util.Log;

class Checkwifi {
	private Activity activity;
	private static WifiManager wifimanager;
	private static WifiInfo wifinfo;
	private WifiLock wifilock;
	
	
	
	public Checkwifi(Activity activity){
		this.activity=activity;
		wifimanager=(WifiManager)this.activity.getSystemService(Context.WIFI_SERVICE);
		
	}
	public int getwifistate(){
		 return wifimanager.getWifiState();
		
	}
	public boolean wifiisenable(){
		if(wifimanager.isWifiEnabled()){
			return true;
			
		}
		else
			return false;
		/*
		if(getwifistate()==WifiManager.WIFI_STATE_ENABLED){
			Log.d("Wifi_state", "Wifi is enabled.");
			return true;
		}
		else{
			Log.d("Wifi_state", "Wifi is disabled.");
			return false;
			
		}*/
		}
	public void acquirewifilock(){
		wifilock.acquire();
		
	}
	
	public void releasewifilock(){
		if(wifilock.isHeld()){
			wifilock.acquire();
		}
		
	}
	
	public void createwifilock(){
		 wifilock = wifimanager.createWifiLock("Test");
	}
	
	public WifiInfo getwifinfo(){
		wifinfo=wifimanager.getConnectionInfo();
		return wifinfo;
		}
	
	
	public WifiConfiguration createwifiaccount(String SSID,String Password,int type){
		WifiConfiguration account = new WifiConfiguration();
		
		account.allowedAuthAlgorithms.clear();  
		account.allowedGroupCiphers.clear();  
		account.allowedKeyManagement.clear();  
		account.allowedPairwiseCiphers.clear();  
		account.allowedProtocols.clear();  
		account.SSID = "\"" + SSID + "\"";
		
		///WifiConfiguration tempConfig = wifimanager.IsExsits(SSID); 
		
		if(type == 1) //No password
        {  
			account.wepKeys[0] = "";  
			account.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);  
			account.wepTxKeyIndex = 0;  
        } 
		
		if(type == 2) //WIFICIPHER_WEP 
        {  
			account.hiddenSSID = true; 
			account.wepKeys[0]= "\""+Password+"\"";  
			account.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.SHARED);  
			account.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);  
			account.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);  
			account.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);  
			account.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP104);  
			account.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);  
			account.wepTxKeyIndex = 0;  
        }
		
		 if(type == 3) //WIFICIPHER_WPA 
         {  
			 account.preSharedKey = "\""+Password+"\"";  
			 account.hiddenSSID = true;    
			 account.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);    
			 account.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);                          
			 account.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);                          
			 account.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);                     
         //config.allowedProtocols.set(WifiConfiguration.Protocol.WPA);   
			 account.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP); 
			 account.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP); 
			 account.status = WifiConfiguration.Status.ENABLED;    
         } 
		 return account;
	}
	
	public boolean connecttowifi(String SSID,String Password,int type){
		WifiConfiguration accountinformation=createwifiaccount(SSID,Password,type);
		int wifiID=wifimanager.addNetwork(accountinformation);
		boolean wifienable=wifimanager.enableNetwork(wifiID, true);
		return wifienable;
		
	}
	

}
