package com.advanced.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetadataDao {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			stmt = con.createStatement();

			ResultSet resultSet = stmt.executeQuery("select * from account");
			ResultSetMetaData metaData = resultSet.getMetaData();

			int count = metaData.getColumnCount();

			for (int i = 1; i <= count; i++) {
				System.out.print(metaData.getColumnName(i)+":");
				System.out.println(metaData.getColumnType(i));
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
