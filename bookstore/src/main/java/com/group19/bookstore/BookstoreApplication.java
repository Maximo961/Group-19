package com.group19.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.sql.*;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
//		Connection connection = null;
//		try {
//			// below two lines are used for connectivity.
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/sql_bookinventory",
//					"root", "password");
//
//			// mydb is database
//			// mydbuser is name of database
//			// mydbuser is password of database
//
//			Statement statement;
//			statement = connection.createStatement();
//			ResultSet resultSet;
//			// Place query here
//			resultSet = statement.executeQuery(
//					"SELECT * FROM sql_bookinventory.credit_card;");
//			String ccn;
//			while (resultSet.next()) {
//				ccn = resultSet.getString("credit_card_number").trim();
//				System.out.println("CCNs : " + ccn);
//			}
//			resultSet.close();
//			statement.close();
//			connection.close();
//		}
//		catch (Exception exception) {
//			System.out.println(exception);
//		}
	}

}
