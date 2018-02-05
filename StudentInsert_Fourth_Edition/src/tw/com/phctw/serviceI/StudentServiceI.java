package tw.com.phctw.serviceI;

import java.util.List;

import tw.com.phctw.bean.Student;

public interface StudentServiceI {
	
	public Boolean insertStudent(); //新增學生資料

	public List<Student> selectAll(); //查詢學生資料

	public String getFname(); //產生姓

	public String getLname(); //產生名

	public int getAge(); //產生年紀

	public String getSid();  //產生身份證
	
	public String selsno();

	public int snoCount();

	public String getEmailCount(String email);

	public String getPasswordCount(String password);
	
	public String Md5Encrypt(String password);
	
	public Boolean emailValidator(String email);
	
	public Boolean idValidator(String id);
	
	public Boolean ageValidator(String age);
	
	public Boolean deleteStudent(String sno);
	
	public Boolean updateStudent(Student bean);
}
