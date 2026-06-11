package com.advanced.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchDao {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			stmt = con.createStatement();

			stmt.addBatch("insert into account values(1, 'Bill', 'Clinton', 20000)");
			stmt.addBatch("insert into account values(2, 'Hillary', 'Clinton', 25000)");

			int[] result = stmt.executeBatch();

			for (int i : result) {
				System.out.println(i);
			}

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
