package edu.fzu.hrmis.domain;


/**
 *
 * 操作用户
 * 
 * @author joeyang ong
 *
 */
public class User extends ValueObject{
	
	/** 用户编号  */
	private String userNo;
	
	/** 用户密码  */
	private String userPwd;
	
	/** 真实姓名  */
	private String realName;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
	public static User getEmployeeFromStr(String str){
		 
		String[] sections = str.split("\\:");
		User emp = new User(); 
		
		emp.setUserNo(sections[0]);
		emp.setUserPwd((sections[1]));
		emp.setRealName(sections[2]);
		
		return emp;
		 
	}
	
	/**
	 * 账户信息输出
	 */
	public void printOut(){
		System.out.println(this);
	}
	

	@Override
	public String toString() {
		return String.format("%s:%s", this.userNo
				                    , this.realName);
	}

	

}
