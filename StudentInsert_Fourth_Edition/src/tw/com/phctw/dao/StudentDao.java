package tw.com.phctw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import tw.com.phctw.bean.Student;

public class StudentDao {
	
	private DataSource dataSource;
	
    public StudentDao() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/test");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
	
	public String maxSno(){ //取最大sno
		
		String sqlSyntax = "select max(sno) max from student";
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
	
	public String countSno(){
			
			String sqlSyntax = "select count(sno) as countSno from student";
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			
			String snoCount = null;
			try {
				conn = dataSource.getConnection();
				preparedStatement = conn.prepareStatement(sqlSyntax);
				rs = preparedStatement.executeQuery();
				while (rs.next()) {
					snoCount = rs.getString("countSno");//getString(欄位名稱 和欄位index)
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
			return snoCount;
		}
	
	public List<Student> selectAll(){
		
		String selectTableSQL = "SELECT * FROM Student ";
		
		List<Student> list = new ArrayList();//拿來存從bean撈出來的資料
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
		
			conn = dataSource.getConnection(); //取得連線
			
			preparedStatement = conn.prepareStatement(selectTableSQL);
			rs = preparedStatement.executeQuery();
				
			
			while (rs.next()) {//boolean 是否有下一筆
				
				Student bean = new Student();
				bean.setSno(rs.getString(1));
				bean.setSfname(rs.getString(2));
				bean.setSlname(rs.getString(3));
				bean.setSage(rs.getInt(4));
				bean.setSsex(rs.getString(5));
				bean.setSid(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setPassword(rs.getString(8));
				list.add(bean); //把每一個bean存進list裡
//				Resignation bean = new Resignation();
			
//			    bean.setSerialNum(rs.getInt(1));
//			    bean.setResponsible(rs.getString(2));
//			    list.add(bean); //把每一個bean存進list裡
			    
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally //一定要做這件事
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
		
		return list;
	};

	public Student selectOne(String sno){
		
		String selectOneTableSQL = "SELECT * FROM Student where sno = " + sno;
		Student bean = null;
		Connection conn = null;
		ResultSet rs = null;
		Statement stm = null;

		  try {
		   conn = dataSource.getConnection(); // oooopen connection to DB
		   stm = conn.createStatement();
		   rs = stm.executeQuery(selectOneTableSQL);
		   while (rs.next()) {
			    bean = new Student();
				bean.setSno(rs.getString(1));
				bean.setSfname(rs.getString(2));
				bean.setSlname(rs.getString(3));
				bean.setSage(rs.getInt(4));
				bean.setSsex(rs.getString(5));
				bean.setSid(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setPassword(rs.getString(8));
//		    Resignation bean = new Resignation();
//		    bean.setSerialNum(rs.getInt(1));
//		    bean.setResponsible(rs.getString(2));
//		    bean.setResignationDate(rs.getDate(3));
//		    list.add(bean);
		   }
		  } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } finally {
		   try {
				rs.close();
				stm.close();
				conn.close();
		   } catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		 return bean;
	}; 

	public Boolean insert(Student bean){
		
		int num = 0;
		String insertTableSQL = "INSERT INTO Student VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement stm = null;
		Connection conn = null;
		try {
			   conn =  dataSource.getConnection();//connect to DB
			   stm = conn.prepareStatement(insertTableSQL);
			   stm.setString(1,bean.getSno());
			   stm.setString(2,bean.getSfname() );
			   stm.setString(3, bean.getSlname());
			   stm.setInt(4,bean.getSage() );
			   stm.setString(5,bean.getSsex());
			   stm.setString(6,bean.getSid() );
			   stm.setString(7,bean.getEmail());
			   stm.setString(8,bean.getPassword());
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
//		// sno 加一, 並做檢查最大值檢查
//		    public int incrementSno(int sno) {
//		        // sno 只有三碼,從 a01~z99, 所以最大為 2699
//		        if(sno > 2699) {
//		            sno = 2699;
//		        }
//		        
//		        // a99下一數的變b01 b99下一數會變c01, 所以 sno 多加 1
//		        ++sno;
//		        if(sno%100==0) {
//		            ++sno;
//		        }
//		        return sno;
//		    }
//		    // 產生學號 sno
//		    public String getSno(int no){    
//		        // sno 只有三碼, 第一碼為 'a' 到 'z', 第二, 三碼為數字
//		        // 小寫字母為 97-122, 大寫字母為 65-90
//		        String sno =  String.format("%c%02d", (char)((no/100) + 97) , no % 100) ;
//		        System.out.println( no + " " +sno);
//		        return sno;
//		    }
//		 
		 
	};

	public Boolean update(Student bean){
		
		  System.out.println("update......");
		  int num = 0;
		  String updateTableSQL = "UPDATE Student set SNO = ?, SFNAME = ?, "
		  		+ "SLNAME = ?, SAGE = ?, SSEX = ?, SID = ? EMAIL = ?, PASSWORD = ? where SNO = ('"
		    + bean.getSno() + "')";
		  Connection conn = null;
		  PreparedStatement stm = null;
		  try {
		   conn =  dataSource.getConnection();//connect to DB
		   stm = conn.prepareStatement(updateTableSQL);
		   // stm.setInt(1, bean.getSerialNum());
		   // stm.setString(2, bean.getResponsible());
		   stm.setString(1, bean.getSno());
		   stm.setString(2,bean.getSfname());
		   stm.setString(3,bean.getSlname());
		   stm.setInt(4,bean.getSage());
		   stm.setString(5,bean.getSsex());
		   stm.setString(6,bean.getSid());
		   stm.setString(7,bean.getEmail());
		   stm.setString(8,bean.getPassword());
		   
		   num = stm.executeUpdate();//0代表

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
		   System.out.println("update 完成");
		   return true;
		  } else {
		   System.out.println("update 失敗");
		   return false;
		  }
		
	};

	public Boolean delete(String sno){
		
		  String deleteTableSQL = "DELETE FROM Student WHERE SNO = " +"'"+sno+"'" ;
		  Connection conn = null;
		  Statement Statement = null;
		  boolean haveOrNot = true;
		  try {
		   conn =  dataSource.getConnection();//connect to DB
		   Statement = conn.createStatement();
		   haveOrNot = Statement.execute(deleteTableSQL);
		   System.out.println("haveOrNot "+haveOrNot);
		  } catch (SQLException e) {
			  haveOrNot=false;  
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } finally {
		   try {
		    conn.close();
		   } catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		  if (haveOrNot) {
		   System.out.println("delete 完成");
		   return true;
		  } else {
		   System.out.println("delete 失敗");
		   return false;
		  }
	};
	
	public String emailCount(String email){
		
		String sqlSyntax = "select count(email) emailCount from student where email = " + "'" + email + "'";
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String getEmail = null;
		try {
			conn = dataSource.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sqlSyntax);
			while (rs.next()) {		
				getEmail = rs.getString("emailCount");//getString(欄位名稱 和欄位index)
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
		return getEmail;
	}
	
	public String passwordCount(String password){
			String sqlSyntax = "select count(password) passwordCount from student where password = " + "'" + password +"'";
			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;
			
			String getPassword = null;
			try {
				conn = dataSource.getConnection();
				stm = conn.createStatement();
				rs = stm.executeQuery(sqlSyntax);
				while (rs.next()) {		
					getPassword = rs.getString("passwordCount");//getString(欄位名稱 和欄位index)
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
			return getPassword;
		}
	
	public String getEmail(String email) {//拿到email當成account
		
		String sqlSyntax = "select email from student where email="+"'"+email+"'";
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String getEmail = null;
		try {
			conn = dataSource.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sqlSyntax);
			while (rs.next()) {		
				getEmail = rs.getString("email");//getString(欄位名稱 和欄位index)
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
		return getEmail;
	}
	
	
		
}
