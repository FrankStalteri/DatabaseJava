import java.sql.*;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		DatabaseWork dw = new DatabaseWork();
		String user = "root";
		String password = "";
		
		System.out.println("Enter a choice.");
		System.out.println("1: Add Record");
		System.out.println("2: Delete Record");
		System.out.println("3: Display Table");
		System.out.println("4: Update Table");
		int choice = kb.nextInt();
		
		try {
			// create a connection to database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
			
			switch (choice) {
			case 1:
				dw.addRecord(con);
				break;
				
			case 2:
				dw.deleteRecord(con);
				break;
				
			case 3:
				dw.displayTable(con);
				break;
				
			case 4:
				dw.updateTable(con);
				break;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}