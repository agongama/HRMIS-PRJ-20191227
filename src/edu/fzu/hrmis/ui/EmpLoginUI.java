package edu.fzu.hrmis.ui;

import java.util.List;

import edu.fzu.hrmis.dao.UserDao;
import edu.fzu.hrmis.domain.User;
import edu.fzu.hrmis.exception.BlankEntryException;
import edu.fzu.hrmis.utils.SysUtils;

public class EmpLoginUI implements BaseUI {

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
		User user = new User();
		StringBuilder sb = new StringBuilder();
		sb.append("Ա����¼���� -  Employee  login interface  - Login Menu\n")
		  .append("======  ������E�̸�Ŀ¼������user.text����˺�����  ======\n")
		  .append("============  user:000  password:000   =============\n");
		System.out.println(sb.toString());

		do {
			user.setUserNo(this.getUserNo());
			user.setUserPwd(getUserPsd());
		} while (!this.checkUser(user.getUserNo(),user.getUserPwd()));
		
	}
	
	/**
	 * ���Ա������
	 */
	private String getUserNo() {

		String entryUser = null;
		while (true) {
			System.out.print("Enter account number: ");

			try {
				entryUser = SysUtils.getEntry();
				
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No Username entered �C try again");
			}
		}

		return entryUser;

	}
	
	private String getUserPsd() {

		String entryPsd = null;
		while (true) {
			System.out.print("Enter account password: ");

			try {
				entryPsd = SysUtils.getEntry();
				
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No Password entered �C try again");
			}
		}

		return entryPsd;

	}

	public boolean checkUser(String userNo, String psd){
		UserDao userDao = new UserDao();
		List<User> userList = userDao.loadEmps();
		
		for (User user : userList) {
			if (user.getUserNo().equals(userNo) && user.getUserPwd().equals(SysUtils.md5(psd))) {
				return true;
			} else {
				System.out.println("Account or password error ");
			}
		}
		return false;
	}
}
