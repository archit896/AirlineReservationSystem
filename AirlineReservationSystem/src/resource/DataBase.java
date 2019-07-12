package resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	private static Connection con;

	public static Connection getDbConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@is-zinvdbqat2:1521/TESTZ_PRIMARY", "TRAIN18", "welcome19");
		} catch (Exception e) {
			System.out.println("Db Connection Error" + e.toString());
		}
		return con;
	}
	
}