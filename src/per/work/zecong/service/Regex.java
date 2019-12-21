package per.work.zecong.service;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 正则表达式方法类
 * @author 24538
 *
 */
public class Regex {

	/**
	 * 正则判断电话座机规范
	 * @param str:电话
	 * @return true:成功
	 */
	public boolean isPhone(String str) {
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
	 * @param name:姓名
	 * @return true:成功
	 */
	public boolean isName(String name) {
		if (name.length() == 0) {
			return false;
		}
		//因项目需求，只需要限定在中文和英文上即可，长度已经在Android EditText中限制输入，此处不做长度限制
		Pattern p = Pattern.compile("^[\u4E00-\u9FA5a-zA-Z]+");
		Matcher m = p.matcher(name);
		return m.matches();
	}
	
	/**
	 * 工作名。可包含字母、数字、括号、字符间支持一个空格、“.”、“●”、“-”
	 * @param name
	 * @return
	 */
	public boolean isWorkName(String name) {
		if (name.length() == 0) {
			return false;
		}
		Pattern p = Pattern.compile("^(?:[\\u4e00-\\u9fa5]+)(?:●[\\u4e00-\\u9fa5]+)*$|^[a-zA-Z0-9]+\\s?[\\.·\\-()a-zA-Z]*[a-zA-Z]+$");
		Matcher m = p.matcher(name);
		return m.matches();
	}
	
	/**
	 * 正则判断日期规范
	 * @param str:日期
	 * @return true:成功
	 */
	public boolean checkData(String str) {
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");//括号内为日期格式，y代表年份，M代表年份中的月份（为避免与小时中的分钟数m冲突，此处用M），d代表月份中的天数
		try {
			sd.setLenient(false);//此处指定日期/时间解析是否不严格，在true是不严格，false时为严格
			sd.parse(str);//从给定字符串的开始解析文本，以生成一个日期
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
	public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
 }

}
