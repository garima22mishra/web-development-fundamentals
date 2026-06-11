package com.custom.tag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport {

	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps;

	ResultHandler() {
		try {
			System.out.println("Inside constructor");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			ps = con.prepareStatement("select * from user where email=?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("null")
	@Override
	public int doStartTag() throws JspException {

		System.out.println("Inside doStartTag");

		ServletRequest request = pageContext.getRequest();

		String email = request.getParameter("email");

		// bind this email to prepared statement
		try {
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			JspWriter out = pageContext.getOut();

			if (resultSet.next()) {
				out.print("User details are : <br/>");
				out.print("First name : "+resultSet.getString("firstname"));
				out.print("<br/>Last name : "+resultSet.getString("lastname"));
			} else {
				out.print("Invalid email found");
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return Tag.SKIP_BODY;
	}

	@Override
	public void release() {
		try {
			System.out.println("Inside release");
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
