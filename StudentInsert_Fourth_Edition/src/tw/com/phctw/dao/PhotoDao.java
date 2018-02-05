package tw.com.phctw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tw.com.phctw.bean.Photo;

public class PhotoDao {
	
private DataSource dataSource;
	
    public PhotoDao() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/batch");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public String getPhotoPath(String photoId) {
    	
    	String sqlSyntax = "select photopath from STUDENTPHOTO where PHOTOID ="+" '"+ photoId +"'";
//    						select photopath from STUDENTPHOTO where PHOTOID = '1';
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String getPhotoPath = null;
		try {
			conn = dataSource.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sqlSyntax);
			while (rs.next()) {		
				getPhotoPath = rs.getString("photopath");//getString(欄位名稱 和欄位index)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally //一定要做這件事
		{
			if(conn!=null)//如果連線不等於null就關閉連線
			{	
				try {
					rs.close();
					stm.close();
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return getPhotoPath;
    }
    
    public Boolean insertPhotoPathAndId(Photo bean) {
    	int num = 0;
		String insertTableSQL = "INSERT INTO studentphoto VALUES(?,?)";
		PreparedStatement stm = null;
		Connection conn = null;
		try {
			   conn = dataSource.getConnection();//connect to DB
			   stm = conn.prepareStatement(insertTableSQL);
			   stm.setString(1,bean.getPhotoid());
			   stm.setString(2,bean.getPhotopath() );
			   num = stm.executeUpdate();
			  } catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  } finally {
					   try {
							stm.close();
						    conn.close();
					   } catch (Exception e) {
						    // TODO Auto-generated catch block
						    e.printStackTrace();
					     }
			    } 
		
		 if (num > 0) {
			   System.out.println("insert 完成");
			   return true;
			  } else {
			   System.out.println("insert 失敗");
			   return false;
			  }
    }
    
    public String maxPhotoId(){ //取最大sno
		
		String sqlSyntax = "select max(photoid) max from studentphoto";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String rs1 = null;
		try {
			conn = dataSource.getConnection();
			preparedStatement = conn.prepareStatement(sqlSyntax);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				rs1 = rs.getString("max");//getString(欄位名稱 和欄位index)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally //一定要做這件事
		{
			if(conn!=null)//如果連線不等於null就關閉連線
			{	
				try {
					rs.close();
					preparedStatement.close();
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rs1;
	}
    
    
    
}
