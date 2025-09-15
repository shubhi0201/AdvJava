package jdbcdemo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
* Author :Ayush.Joshi
* Date   :Sep 10, 2025
* Time   :3:16:18 PM
* project:AdvancedJava
*/
public class SelectDemo2 {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt;
		ResultSet rs;

		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coforgedb","root","mysql123");

			// Create a statement object to execute the query
			stmt=con.createStatement();

			// Execute the query and get the result set
			rs=stmt.executeQuery("SELECT emp_id,first_name,last_name,dob,dept_id "
					+ "from employees order by last_name");

			// Process the result set
			while(rs.next())
			{
				// Retrieve data by column name or index
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString("last_name")+"\t"+
						rs.getDate("dob")+"\t"+rs.getInt("dept_id"));
			}
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

	}

}
