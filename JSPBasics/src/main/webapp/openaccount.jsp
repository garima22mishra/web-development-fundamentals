<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" errorPage="errorHandler.jsp" %>
<%! 
	Connection conn;
	PreparedStatement ps;
	
	public void jspInit(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");		
		String sql = "insert into account value(?,?,?,?)";
		ps = conn.prepareStatement(sql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void jspDestroy(){
		try{
			ps.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<%
	int accno = Integer.parseInt(request.getParameter("accno"));
	String lastname = request.getParameter("lastname");
	String firstname = request.getParameter("firstname");
	int bal = Integer.parseInt(request.getParameter("bal"));
	
	ps.setInt(1, accno);
	ps.setString(2, lastname);
	ps.setString(3, firstname);
	ps.setInt(4, bal);
	
	ps.executeUpdate();

%>
<%@ include file="openaccount.html" %>