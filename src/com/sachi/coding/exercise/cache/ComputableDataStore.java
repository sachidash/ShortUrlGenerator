package com.sachi.coding.exercise.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ComputableDataStore {
	private static Map<String, String> shortToLongUrlMap = new ConcurrentHashMap<>();
	private static Map<String, String> longToShortUrlMap = new ConcurrentHashMap<>();
	
	public static String findByLongUrl(String longUrl) {
        return longToShortUrlMap.get(longUrl);
	}
	
	public static void storeLongToshortUrls(String longUrl, String shortUrl) {
		longToShortUrlMap.put(longUrl, shortUrl);
	}
	
	public static boolean containsLongUrl(String longUrl){
		return longToShortUrlMap.containsKey(longUrl);
	}
	
	public static String findByshortUrl(String shortUrl) {
        return shortToLongUrlMap.get(shortUrl);
	}
	
	public static void storeShortToLongUrls(String shortUrl, String longUrl) {
		shortToLongUrlMap.put(shortUrl, longUrl);
	}
	
	public static boolean containsShortUrl(String shortUrl){
		return shortToLongUrlMap.containsKey(shortUrl);
	}
}


