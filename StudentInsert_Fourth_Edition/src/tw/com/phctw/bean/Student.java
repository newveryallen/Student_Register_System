package tw.com.phctw.bean;

public class Student {
	
	    private String sno;
	    private String sfname;
	    private String slname;
	    private int sage;
	    private String ssex;
	    private String sid;
	    private String email;
	    private String password;
	    
	    public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getSno() {
			return sno;
		}

		public void setSno(String sno) {
			this.sno = sno;
		}

		public String getSfname() {
			return sfname;
		}

		public void setSfname(String sfname) {
			this.sfname = sfname;
		}

		public String getSlname() {
			return slname;
		}

		public void setSlname(String slname) {
			this.slname = slname;
		}

		public int getSage() {
			return sage;
		}

		public void setSage(int sage) {
			this.sage = sage;
		}

		public String getSsex() {
			return ssex;
		}

		public void setSsex(String ssex) {
			this.ssex = ssex;
		}

		public String getSid() {
			return sid;
		}

		public void setSid(String sid) {
			this.sid = sid;
		}

		

	    @Override
		public String toString() {
			return "Student [sno=" + sno + ", sfname=" + sfname + ", slname=" + slname + ", sage=" + sage + ", ssex="
					+ ssex + ", sid=" + sid + ", email=" + email + ", password=" + password + "]";
		}

		public static void main(String[] args) {
		 

	    }

}
