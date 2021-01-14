import java.sql.*;
import java.util.Scanner;

public class DatabaseWork {
	
	// adds record to database
	public void addRecord(Connection con) throws SQLException {
		Scanner kb = new Scanner(System.in);
		Statement stmnt = con.createStatement();
		System.out.println("Enter information.");
		String firstName = kb.nextLine();
		String lastName = kb.nextLine();
		int age = kb.nextInt();
		
		String sql =  "insert into test (firstName, lastName, age)" + 
		"values (" + "'" + firstName + "',"  + "'" + lastName + "'," + "'" + age + "')"; 
		
		if (stmnt.execute(sql) == false)
			System.out.println("Record added.");
		else
			System.out.println("Recorded failed to add.");
	}
	// deletes record from database
	public void deleteRecord(Connection con) throws SQLException {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a row to be deleted. Enter person's last name");
		String lastName = kb.nextLine();
		
		Statement stmnt = con.createStatement();
		
		String sql = "delete from test where lastName = " + "'" + lastName + "'";
		
		if (stmnt.execute(sql) == false)
			System.out.println("Record removed.");
		else
			System.out.println("Delete failed.");
	}
	// displays the entire table
	public void displayTable(Connection con) throws SQLException {
		Scanner kb = new Scanner(System.in);
		Statement stmnt = con.createStatement();
		
		String sql = "Select * from test";
		
		ResultSet results = stmnt.executeQuery(sql);
		
		System.out.println("Table Information\n");
		while (results.next()) {
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String age = results.getString("age");
			
			System.out.println("First Name: " + firstName);
			System.out.println("Last Name: "  + lastName);
			System.out.println("Age: " + age);
			System.out.println();
		}
	}
	// updates the table
	public void updateTable(Connection con) throws SQLException {
		Scanner kb = new Scanner(System.in);
		Statement stmnt = con.createStatement();
		
		System.out.println("Enter data you want to add. Enter data, column name, and old data.");
		String data = kb.nextLine();
		String columnName = kb.nextLine();
		String oldData = kb.nextLine();
		
		String sql = "Update test set " + columnName + " = " + data + " where " + columnName + 
				" = " + oldData;
		
		if (stmnt.execute(sql) == false)
			System.out.println("Update successful.");
		else
			System.out.println("Update failed.");
	}
 }
