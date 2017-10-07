package com.sachi.coding.exercise.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sachi.coding.exercise.cache.ComputableDataStore;
import com.sachi.coding.exercise.util.GeneralUtility;
import com.sachi.coding.exercise.util.GenerateStaticPages;

@WebServlet("/genShrtUrl")
public class LongURLParsingHandler extends HttpServlet {

	private static final long serialVersionUID = 2879418309567122211L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String requestUrl = request.getParameter("urltotest");
		PrintWriter writer = response.getWriter();
		if(requestUrl !=null){
			System.out.println("The input url is  " + requestUrl);
			boolean isValidUrl= GeneralUtility.validateUrl(requestUrl);
			boolean isValidUrlPattern=GeneralUtility.validateURLPattern(requestUrl);
			if(isValidUrl && isValidUrlPattern){
				String shrtUrl="";

				if(ComputableDataStore.containsLongUrl(requestUrl)){
					shrtUrl=ComputableDataStore.findByLongUrl(requestUrl);
					System.out.println("The in memory datastore contains the requestUrl");
				}else{
					System.out.println("The in memory datastore does not contains the requestUrl");
					if(requestUrl.startsWith(Constants.HTTP))
					{
						shrtUrl=GeneralUtility.getShortUrl(Constants.HTTP);
						ComputableDataStore.storeLongToshortUrls(requestUrl, shrtUrl);
						ComputableDataStore.storeShortToLongUrls(shrtUrl, requestUrl);
					}else if(requestUrl.startsWith(Constants.HTTPS)){

						shrtUrl=GeneralUtility.getShortUrl(Constants.HTTPS);
						ComputableDataStore.storeLongToshortUrls(requestUrl, shrtUrl);
						ComputableDataStore.storeShortToLongUrls(shrtUrl, requestUrl);
					}
				}

				String succresp= GenerateStaticPages.generateSucsResponsePage(shrtUrl,request.getServletContext().getContextPath());
				writer.println(succresp);
			}else{
				System.out.println("The input url is  " + requestUrl + " is not valid !!");
				String errorresposne= GenerateStaticPages.generateErrorPage(requestUrl);
				writer.println(errorresposne);
			}
		}else{
			System.out.println("The input url is  cannot be null !!");
			String errorresposne= GenerateStaticPages.generateErrorPage(requestUrl);
			writer.println(errorresposne);
		}



	}

}