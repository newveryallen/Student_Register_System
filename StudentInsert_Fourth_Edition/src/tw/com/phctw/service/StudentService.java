package tw.com.phctw.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.NamingException;

import tw.com.phctw.bean.Student;
import tw.com.phctw.dao.StudentDao;
import tw.com.phctw.serviceI.StudentServiceI;

public class StudentService implements StudentServiceI{
	
    private StudentDao dao;
	
	private StudentDao getDao()
	{
		if( dao == null)
		{
			dao = new StudentDao();
		}	
		return dao;
	}
	
	@Override
	public Boolean insertStudent() {
		boolean result =false;
//		StudentService student = new StudentService();
		Student student = new Student();
		String sid = this.getSid();
		
		student.setSno(this.selsno());
		student.setSid(sid);
		student.setSfname(this.getFname());
		student.setSage(this.getAge());
		if (sid.charAt(1) == 49) { //性別判斷 refer to ascii 
			student.setSsex("M");
			student.setSlname(this.getLname());
		}else {
			student.setSsex("F");
			student.setSlname(this.getLname());
		}
			result=getDao().insert(student);
		
		return result;
	}
    
	public Boolean deleteStudent(String sno) {
//		getDao().delete(sno);
		return getDao().delete(sno);
	}
	
	@Override
	public String selsno() { //sno solution
		//a01
		String sno = null;
			sno = getDao().maxSno();
		if(sno == null) {
			sno = "a00";
		}
		String sno1 = null;
		int alpha = sno.charAt(0);// a = 97(ascii)
		int num = Integer.parseInt(sno.substring(1,3));//01 --> 1
		char alpha1=(char)(alpha+1);//97+1 = b
	    // more than 99 then from a to b to c to d etc......
		if (num<99) {//if num less than 99
			if (num<9) {
				sno1 = sno.substring(0,1)+String.format( "%02d",num+1); //a + (1+1)
			}else {
				sno1 = sno.substring(0,1)+(num+1);//a + 
			}
		}else {//if num > 99
			if(alpha <123) {
				sno1 = String.valueOf(alpha1)+"01";// b + 01  valueof ->將alpha1轉成字串
			} else {
				System.out.println("too much");
			}
			
		}
		return sno1;
	}
	
	@Override
	public List<Student> selectAll() {
		List<Student> list = null;
			list = getDao().selectAll();
		return list;
	}
    
	@Override
	public String getFname() {
		String[] fnameList = {"Allen","Jennifer","Amy","Json","Janathon","Micheal","Charles"};
		//  int num = (int)(Math.random() * 11);
		int index = (int) (Math.random() * fnameList.length);
		String fName = fnameList[index];
		return fName;
	}

	@Override
	public String getLname() {
		String[] lnameList = {"Huang","Wang","Lee","Haha","Jordan","Iverson","Barkley"};
		//  int num = (int)(Math.random() * 11);
		int index = (int) (Math.random() * lnameList.length);
		String lName = lnameList[index];
		return lName;
	}

	@Override
	public int getAge() {
		int age = (int)(Math.random() * 120);
		return age;
	}

	@Override
	public String getSid() {
		//method 1
//		 String sid = Integer.toString(((int) (Math.random() * 100000)));
//		String str1[] = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U",
//				"V", "X", "Y", "W", "Z", "I", "O" };
//		int step3 = 1;
//		String idNumber = "";
//		while (true) {
//			String str310 = Integer.toString((int) (Math.random() * 100000000));
//			if (str310.length() < 8) {
//				continue;
//			}
//
//			int num = (int) (Math.random() * 26); // 隨機取str1的位置0~25
//			String n1 = Integer.toString(num + 10); // 英文字母所代表的數字
//			int n1_1 = Integer.parseInt(n1.substring(0, 1)); // 字母代表的數字的十位數
//			int n1_2 = Integer.parseInt(n1.substring(1)); // 字母代表的數字的個位數
//			int n2 = (int) (Math.random() * 2) + 1; // 代表性別的1或2
//			int n3 = Integer.parseInt(str310.substring(0, 1));
//			int n4 = Integer.parseInt(str310.substring(1, 2));
//			int n5 = Integer.parseInt(str310.substring(2, 3));
//			int n6 = Integer.parseInt(str310.substring(3, 4));
//			int n7 = Integer.parseInt(str310.substring(4, 5));
//			int n8 = Integer.parseInt(str310.substring(5, 6));
//			int n9 = Integer.parseInt(str310.substring(6, 7));
//			int n10 = Integer.parseInt(str310.substring(7));
//			int step1 = n1_1 + n1_2 * 9; // 十位數+個位數x9
//			int step2 = n2 * 8 + n3 * 7 + n4 * 6 + n5 * 5 + n6 * 4 + n7 * 3 + n8 * 2 + n9 + n10;// 將流水碼依序乘8765432，一個個乘，乘完要相加起來
//			step3 = (step1 + step2) % 10;// 、將步驟1 和步驟2 的兩個數加起來除以10，可以整除，正確！
//
//			if (step3 == 0) {
//				idNumber = str1[num] + Integer.toString(n2) + str310;
//				break;
//			}
//		}
//		Student bean = null;
//		bean.setSid(idNumber);
//		return idNumber;
		
		
//		--------------------------------------
		
		//method 2
		char[] idByChar = new char[10];
		String iDString = "";
		int y = 0;
		int z = 0;
		int zz= 0;
		//隨機生成A~Z
		int x = (int)Math.floor(Math.random()*26+65);
		idByChar[0] = (char) x;
		//隨機生成1~2
		idByChar[1] = (char)(int)Math.floor(Math.random()*2+49);
		//隨機產出第3~第9個數字
		for (int i=2;i<9;i++){
			idByChar[i] = (char)(int)Math.floor(Math.random()*10+48);
		}
		//判斷出第10個數字
		if (x>=65 && x<=72 || x==87) {
			y = x-55;
		}else if (x==73) {
			y = 34;
		}else if (x>=74 && x<=78) {
			y = x-56;
		}else if (x==79) {
			y = 35;
		}else if (x>=80 && x<=86 || x==90) {
			y = x-57;
		}else if (x==88 || x==89) {
			y = x-58;
		}
		z = Math.floorDiv(y, 10)+(y%10)*9+(idByChar[1]-48)*8+(idByChar[2]-48)*7+(idByChar[3]-48)*6+
				(idByChar[4]-48)*5+(idByChar[5]-48)*4+(idByChar[6]-48)*3+(idByChar[7]-48)*2+(idByChar[8]-48)*1;
		zz =  (10-(z%10))%10;
		idByChar[9] = (char)(int)(zz+48);
		//轉成字串
		iDString = new String(idByChar);
		return iDString;
	}

	@Override
	public int snoCount() {
	
		String snoCount = null;
			snoCount = getDao().countSno();
		int snoCountNum = Integer.parseInt(snoCount);
		return snoCountNum;
	}
	
	@Override
	public String getEmailCount(String email) {
		// TODO Auto-generated method stub
		StudentDao sDao = new StudentDao();
		String emailFromDb = sDao.emailCount(email);
		return emailFromDb;
	}

	@Override
	public String getPasswordCount(String password) {
		// TODO Auto-generated method stub
		StudentDao sDao = new StudentDao();
		String pwdCount = sDao.passwordCount(password);
		return pwdCount;
	}

	
	@Override
	public String Md5Encrypt(String password) {
		  
		String plaintext = password;
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.reset();
		m.update(plaintext.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		
		return hashtext;
	}

	@Override
	public Boolean emailValidator(String email) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean emailVaildator = email.matches(EMAIL_REGEX);
		return emailVaildator;
	}

	@Override
	public Boolean idValidator(String id) { // 身份證驗證
		String ID_REGEX = "/^[A-Z]{1}[0-9]{9}$/";
		Boolean idVaildator = id.matches(ID_REGEX);
		return idVaildator;
	}

	@Override
	public Boolean ageValidator(String age) {//年齡數字輸入驗證
		String EMAIL_REGEX = "/^[0-9]+$/";
		Boolean ageValidator = age.matches(EMAIL_REGEX);
		return ageValidator;
	}

	@Override
	public Boolean updateStudent(Student bean) {
		boolean result =false;
//		StudentService student = new StudentService();
		Student student = new Student();
		String sid = this.getSid();//generate sid automatically
		
		student.setSno(this.selsno());
		student.setSid(sid);
		student.setSfname(this.getFname());
		student.setSage(this.getAge());
		if (sid.charAt(1) == 49) { //性別判斷 refer to ascii 
			student.setSsex("M");
			student.setSlname(this.getLname());
		}else {
			student.setSsex("F");
			student.setSlname(this.getLname());
		}
			result=getDao().update(student);
		
		return result;
	}
	
	
	
	
}


	


