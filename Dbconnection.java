package Shop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	

	private static String driver="oracle.jdbc.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static String userName="hr";
	private static String password="hr";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//load driver
		
	}
	
	public static Connection getDbConnection() {
		Connection con=null;	
		try {
			con=DriverManager.getConnection(url,userName,password);//conection to DB
			System.out.println("connection ");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}


}
