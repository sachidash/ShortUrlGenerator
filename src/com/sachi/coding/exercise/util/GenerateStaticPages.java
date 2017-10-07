package com.sachi.coding.exercise.util;

public class GenerateStaticPages {
	
	/**
	 * This method is invoked with the parameter. 
	 * It renders an static HTML page to display a message
	 * @param data
	 * @return String
	 */
	public static String generateErrorPage(String data){
	StringBuilder sb=new StringBuilder("<html>");
	sb.append("<div align=\"center\">");
	sb.append("<h2> The URL ").append(data).append(" is invalid <br/>");
	sb.append("</div>");
	sb.append("<html>");
	return sb.toString();	
	}
	
	/**
	 * This method is invoked with the parameter as short URL and contextPath. 
	 * It renders an static HTML page that directs  to the valid URL
	 * @param shortUrl
	 * @param path
	 * @return String
	 */
	public static String generateSucsResponsePage(String shortUrl, String path){
		//<input type="hidden" name="param1" value="param1Value">
		//<A HREF="javascript:document.submitForm.submit()">Click Me</A>

		StringBuilder sb=new StringBuilder("<html>");
		sb.append("<div align=\"center\">");
		sb.append("<form name=\"submitForm\" method=\"POST\" action=\"shrtToLong\">");
		sb.append("<br> ");
		sb.append("<h2> The Short URL is </h2>");
		sb.append("<br> ");
		sb.append("<input type=\"hidden\" name=\"shorturl\" value="+shortUrl+">");
		sb.append("<a href=\"javascript:document.submitForm.submit()\">");
		sb.append(shortUrl);
		sb.append("</a>");
		sb.append("<br>");
		sb.append("</form>");
		sb.append("</div>");
		sb.append("<html>");
		return sb.toString();	
		}

	
	public static String generateNotFoundPage(){
		StringBuilder sb=new StringBuilder("<html>");
		sb.append("<div align=\"center\">");
		sb.append("<br>");
		sb.append("<h2> Could not find the actual URL in reference to short url <br/>");
		sb.append("</div>");
		sb.append("<html>");
		return sb.toString();	
		}
}
