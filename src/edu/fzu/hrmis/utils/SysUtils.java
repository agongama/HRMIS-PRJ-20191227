/**
 * 
 */
package edu.fzu.hrmis.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.fzu.hrmis.dao.EmployeeDao;
import edu.fzu.hrmis.domain.Employee;
import edu.fzu.hrmis.exception.BlankEntryException;
import edu.fzu.hrmis.exception.HRMISException;
import edu.fzu.hrmis.ui.UIFactory;
import edu.fzu.hrmis.ui.UIType;

/**
 * 
 * ϵͳ������
 * 
 * @author joeyang ong
 *
 */
public class SysUtils {

	/**
	 * �ӿ���̨���һ��¼�룬�����������
	 * 
	 * @return
	 */
	public static String getEntry() {
		return getEntry(false);
	}

	/**
	 * ��ͣ¼��
	 */
	public static void pause() {
		getEntry(true);
	}

	/**
	 * ����ʾ����ͣ
	 * 
	 * @param promptStr
	 */
	public static void pause(String promptStr) {
		System.out.print(promptStr);
		pause();
	}

	/**
	 * �ӿ���̨�ϻ��һ��¼��
	 * 
	 * @param allowBlank �Ƿ����������(��ͣ)
	 * @return
	 */
	private static String getEntry(boolean allowBlank) {

		BufferedReader reader = null;
		String entry = null;

		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			entry = reader.readLine();
			if (!allowBlank && isBlankStr(entry))
				throw new BlankEntryException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entry;

	}

	/**
	 * �ַ����մ����
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlankStr(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * ִ��UI����
	 * 
	 * @param type
	 */
	public static void runUI(UIType type) {
		UIFactory.getInstance().getUI(type).setup();
	}

	/**
	 * ��Դ���
	 */
	public static void checkResource() {

		File file = new File("e:/records.txt");

		if (!file.exists())
			throw new HRMISException("Required file �C records, does not exist.");

	}
	
	/**
	 * User.txt
	 * ��Դ���
	 */
	public static void checkUser() {

		File file = new File("e:/user.txt");
		BufferedWriter writer = null;
		if (!file.exists()) {
			try {
				writer = new BufferedWriter(new FileWriter(file, true));
				file.createNewFile();
				writer.write("000:"+SysUtils.md5("000")+":����");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * �����жϵ绰�����淶
	 * 
	 * @param str:�绰
	 * @return true:�ɹ�
	 */
	public static boolean isTelePhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean isPhone = false;
		p1 = Pattern.compile("^[0][1-9]-[0-9]{5,10}$"); // ��֤�����ŵ�
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // ��֤û�����ŵ�
		if (str.length() > 9) {
			m = p1.matcher(str);
			isPhone = m.matches();
		} else {
			m = p2.matcher(str);
			isPhone = m.matches();
		}
		return isPhone;
	}

	/**
	 * �����ж����ֹ淶
	 * 
	 * @param name:����
	 * @return true:�ɹ�
	 */
	public static boolean isName(String name) {
		if (name.length() == 0) {
			return false;
		}
		
		Pattern p = Pattern.compile("^[\u4E00-\u9FA5a-zA-Z]+");
		Matcher m = p.matcher(name);
		return m.matches();
	}

	/**
	 * ���������ɰ�����ĸ�����֡����š��ַ���֧��һ���ո񡢡�.�������񡱡���-��
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isWorkName(String name) {
		if (name.length() == 0) {
			return false;
		}
		Pattern p = Pattern.compile(
				"^(?:[\\u4e00-\\u9fa5]+)(?:��[\\u4e00-\\u9fa5]+)*$|^[a-zA-Z0-9]+\\s?[\\.��\\-()a-zA-Z]*[a-zA-Z]+$");
		Matcher m = p.matcher(name);
		return m.matches();
	}

	/**
	 * �����ж����ڹ淶
	 * 
	 * @param str:����
	 * @return true:�ɹ�
	 */
	public static boolean isDate(String str) {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			sd.setLenient(false);// �˴�ָ������/ʱ������Ƿ��ϸ���true�ǲ��ϸ�falseʱΪ�ϸ�
			sd.parse(str);// �Ӹ����ַ����Ŀ�ʼ�����ı���������һ������
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * ����������ʽ�ж��ַ����Ƿ�������
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Ա�����Ƿ�Ψһ
	 * 
	 * @param EmpNo
	 * @return
	 */
	public static boolean isOnlyEmpNo(String EmpNo) {
		EmployeeDao empDao = new EmployeeDao();
		List<Employee> empList = empDao.loadEmps();
		for (Employee simple : empList) {
			if (simple.getPayrollNo().equals(EmpNo)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ���ݻ�ȡ�ù�����Ӧ����Ϣ
	 * 
	 * @param EmpNo
	 * @return
	 */
	public static String EmpNoToInfo(String EmpNo) {
		EmployeeDao empDao = new EmployeeDao();
		List<Employee> empList = empDao.loadEmps();
		for (Employee simple : empList) {
			if (simple.getPayrollNo().equals(EmpNo)) {
				return simple.toString();
			}
		}
		return null;
	}
	
	/**
	 * MD532λ ��д����
	 * 
	 * @param psd
	 * @return
	 */
	public static String md5(String psd) {
		String src = psd;
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			byte[] b = src.getBytes();
			byte[] digest = md5.digest(b);
			char[] chars = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
					'F' };
			
			for (byte bb : digest) {
				sb.append(chars[(bb >> 4) & 15]);
				sb.append(chars[bb & 15]);
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * �Ƿ�Ҫִ�� or �Ƿ�Ҫ����ִ������
	 * @param str_delete
	 * @return
	 */
	public static boolean isYesOrNo(String str_delete) {

		String entry = null;
		boolean is_delete = false;

		System.out.println(str_delete);

		entry = SysUtils.getEntry();
		char choice = entry.toUpperCase().charAt(0);

		if (choice == 'Y') {
			is_delete = true;
		}

		return is_delete;

	}

}
