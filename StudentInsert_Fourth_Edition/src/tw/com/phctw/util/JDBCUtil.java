package tw.com.phctw.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

	
	public static Connection getDb()
	{
		Connection conn = null;
		
		try {
			Class.forName(JDBCConstant.DB_DRIVER);
			 conn = DriverManager.getConnection(JDBCConstant.DB_CONNECTION, JDBCConstant.DB_USER, JDBCConstant.DB_PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
		
	}
}
