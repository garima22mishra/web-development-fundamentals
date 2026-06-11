package com.advanced.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionDao {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			stmt = con.createStatement();

			con.setAutoCommit(false);
			stmt.executeUpdate("update account set bal=bal-500 where lastname='Bill'");
			stmt.executeUpdate("update account set bal=bal+500 where lastname='Hillary'");

			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
