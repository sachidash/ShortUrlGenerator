package com.sachi.coding.exercise.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.sachi.coding.exercise.main.Constants;
public class GeneralUtility {

		
	
/**
 * This method will validate the string passed. The value should be a URL.
 * If the URL is valid it returns true else false.
 * @param inputUrl
 * @return boolean
 */
	public static boolean validateUrl(String inputUrl) {
		
		if(inputUrl !=null && inputUrl.length()> 0){
			try {
				URL url = new URL(inputUrl);
				URLConnection conn = url.openConnection();
				conn.connect();
				System.out.println("Validation of URL :" + inputUrl + "Completed successfully");
				return true;
			} catch (MalformedURLException e) {
				System.out.println("Validation of URL :" + inputUrl + "Completed un-successfully");
				return false;
			} catch (IOException e) {
				System.out.println("Unable to connect the URL :"+ inputUrl + "now, but assumning that the URL can be reachable later");
				return true;
			}
		}else{
			System.out.println("The URL as a input should be a valid one");
			return false;
		}
		
		
	}
	
	/**
	 * This method generates randomId to string based on base62 encoding
	 * @param num
	 * @return
	 */
	public static  String convertIdToShortString(int num){
        StringBuilder sb = new StringBuilder();
        while (num > 0){
            sb.append(Constants.CHAR_MAP.charAt(num % Constants.CHAR_BASE));
            num /= Constants.CHAR_BASE;
        }
        System.out.println("The Reversed String is  :"+sb.reverse().toString());
        return sb.reverse().toString();
    }


	
	/**
	 * This method generates a random number
	 * @return outSeed
	 */
	public static int getRandomId() {
        long nanoTimeSeed = System.nanoTime();
        double randomSeed = Math.random() * 1000;
        long mideanSeed = (long)(nanoTimeSeed*randomSeed);
        String s = mideanSeed + "";
        String subStr = s.substring(0, 9);
        int outSeed = Integer.parseInt(subStr);   
        System.out.println(outSeed);
        return outSeed;
    }
	
	public static boolean validateURLPattern(String url){
		if(url != null){
			if(url.matches(Constants.URL_PATTERN)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	/**
	 * This method generates the short URL
	 * @return shortUrl
	 */
	public static String getShortUrl(String protocol){
		String shortUrl="";
		if(protocol !=null && (protocol.equalsIgnoreCase("HTTPS") || protocol.equalsIgnoreCase("HTTP"))){
			String cnvrtdString=convertIdToShortString(getRandomId());
			shortUrl=protocol+"://"+Constants.DOMAIN+"/"+cnvrtdString;
			System.out.println("The generated short url is :"+shortUrl);
			return shortUrl;
		}else{
			return "SHORT_URL_NOT_GENERATED";
		}
		
		
	}
	
	
	
	
}
