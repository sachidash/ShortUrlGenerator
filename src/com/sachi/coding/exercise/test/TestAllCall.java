package com.sachi.coding.exercise.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import com.sachi.coding.exercise.cache.ComputableDataStore;
import com.sachi.coding.exercise.util.GeneralUtility;

import junit.framework.TestCase;

public class TestAllCall extends TestCase{
	String longUrl="";
	String shortUrl="";
	
    protected void setUp() {
    	longUrl="https://www.apple.com/iphone/";
    	shortUrl="http://test.com/bfMcuD";
    	ComputableDataStore.storeLongToshortUrls(longUrl, shortUrl);
    	ComputableDataStore.storeShortToLongUrls(shortUrl, longUrl);
    } 

    protected void tearDown() { 
    	longUrl = null; 
    	shortUrl= null;
    } 

    @Test
    public void testValidateUrl() throws MalformedURLException, IOException{ 
         assertTrue(GeneralUtility.validateUrl(longUrl));
         assertFalse(GeneralUtility.validateUrl(""));
         GeneralUtility.validateUrl("htp://www.apple.com/iphone/");
    } 
    
    @Test
    public void testGetRandomId(){ 
    	assertNotSame(0,GeneralUtility.getRandomId());
    	assertNotSame(-1,GeneralUtility.getRandomId());
   } 
    
    @Test
    public void testConvertIdToShortString(){ 
    	assertNotNull(GeneralUtility.convertIdToShortString(GeneralUtility.getRandomId()));
    	assertNotEquals("tfeZD",GeneralUtility.convertIdToShortString(281960591));
   } 

    @Test
    public void testGetShortUrl(){ 
    	assertNotNull(GeneralUtility.getShortUrl("HTTP"));
    	assertNotNull(GeneralUtility.getShortUrl("HTTPS"));
    	assertEquals("SHORT_URL_NOT_GENERATED",GeneralUtility.getShortUrl(""));
    	
   } 
    
    @Test
    public void testComputableDataSource(){
    	assertEquals(shortUrl,ComputableDataStore.findByLongUrl(longUrl));
    	assertEquals(longUrl,ComputableDataStore.findByshortUrl(shortUrl));
    	assertTrue(ComputableDataStore.containsLongUrl(longUrl));
    	assertTrue(ComputableDataStore.containsShortUrl(shortUrl));
    }
    
    


}
