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
 * 系统工具类
 * 
 * @author joeyang ong
 *
 */
public class SysUtils {

	/**
	 * 从控制台获得一行录入，不允许空输入
	 * 
	 * @return
	 */
	public static String getEntry() {
		return getEntry(false);
	}

	/**
	 * 暂停录入
	 */
	public static void pause() {
		getEntry(true);
	}

	/**
	 * 带提示的暂停
	 * 
	 * @param promptStr
	 */
	public static void pause(String promptStr) {
		System.out.print(promptStr);
		pause();
	}

	/**
	 * 从控制台上获得一行录入
	 * 
	 * @param allowBlank 是否允许空输入(暂停)
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
	 * 字符串空串检测
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlankStr(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 执行UI部件
	 * 
	 * @param type
	 */
	public static void runUI(UIType type) {
		UIFactory.getInstance().getUI(type).setup();
	}

	/**
	 * 资源检测
	 */
	public static void checkResource() {

		File file = new File("e:/records.txt");

		if (!file.exists())
			throw new HRMISException("Required file – records, does not exist.");

	}
	
	/**
	 * User.txt
	 * 资源检测
	 */
	public static void checkUser() {

		File file = new File("e:/user.txt");
		BufferedWriter writer = null;
		if (!file.exists()) {
			try {
				writer = new BufferedWriter(new FileWriter(file, true));
				file.createNewFile();
				writer.write("000:"+SysUtils.md5("000")+":撒旦");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 正则判断电话座机规范
	 * 
	 * @param str:电话
	 * @return true:成功
	 */
	public static boolean isTelePhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean isPhone = false;
		p1 = Pattern.compile("^[0][1-9]-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
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
	 * 正则判断名字规范
	 * 
	 * @param name:姓名
	 * @return true:成功
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
	 * 工作名。可包含字母、数字、括号、字符间支持一个空格、“.”、“●”、“-”
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isWorkName(String name) {
		if (name.length() == 0) {
			return false;
		}
		Pattern p = Pattern.compile(
				"^(?:[\\u4e00-\\u9fa5]+)(?:●[\\u4e00-\\u9fa5]+)*$|^[a-zA-Z0-9]+\\s?[\\.·\\-()a-zA-Z]*[a-zA-Z]+$");
		Matcher m = p.matcher(name);
		return m.matches();
	}

	/**
	 * 正则判断日期规范
	 * 
	 * @param str:日期
	 * @return true:成功
	 */
	public static boolean isDate(String str) {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			sd.setLenient(false);// 此处指定日期/时间解析是否不严格，在true是不严格，false时为严格
			sd.parse(str);// 从给定字符串的开始解析文本，以生成一个日期
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 利用正则表达式判断字符串是否是数字
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
	 * 员工号是否唯一
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
	 * 根据获取该工号相应的信息
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
	 * MD532位 大写加密
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
	 * 是否要执行 or 是否要继续执行其他
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
