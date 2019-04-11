package seplePratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbtesting {

	public static void main(String[] args) {
		
		
		
		
		try {
			
			String url="jdbc:mysql://172.25.10.54/forse_db?useSSL=false";
			String user="forseuser";
			String password="Forseqa@2018";
			
			Connection myconn=(Connection) DriverManager.getConnection(url, user, password);
			Statement stmt=(Statement) myconn.createStatement();
			ResultSet rs=stmt.executeQuery(" SELECT * FROM forse_db.USER where USER_ID='1'");
			while(rs.next()) {
				System.out.println(rs.getString("USER_NAME")+","+rs.getString("PHONE"));
			}
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		

	}

}
