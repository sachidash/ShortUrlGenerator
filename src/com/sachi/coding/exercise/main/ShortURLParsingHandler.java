package com.sachi.coding.exercise.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sachi.coding.exercise.cache.ComputableDataStore;
import com.sachi.coding.exercise.util.GenerateStaticPages;

@WebServlet("/shrtToLong")
public class ShortURLParsingHandler extends HttpServlet{
	
	private static final long serialVersionUID = -1771963363605200085L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String shortUrl = request.getParameter("shorturl");
		
		if(ComputableDataStore.containsShortUrl(shortUrl)){
			String longUrl= ComputableDataStore.findByshortUrl(shortUrl);
			response.sendRedirect(longUrl);
		}else{
			PrintWriter writer = response.getWriter();
			writer.println(GenerateStaticPages.generateNotFoundPage());
		}
		
	}
}
