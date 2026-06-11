package com.session.management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/TargetServlet")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");

		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie: cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println("Cookie name : "+name);
			System.out.println("Cookie value : "+value);
		}
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		writer.print("<h1> User name is " + userName + "</h1>");
	}
}
