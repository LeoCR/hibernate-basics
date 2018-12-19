package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user="root";
		String pass="79461313";
		try {
			Connection conn=DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connecting to Database"+jdbcUrl);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
