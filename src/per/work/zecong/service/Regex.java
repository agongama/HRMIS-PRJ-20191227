package per.work.zecong.service;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * ������ʽ������
 * @author 24538
 *
 */
public class Regex {

	/**
	 * �����жϵ绰�����淶
	 * @param str:�绰
	 * @return true:�ɹ�
	 */
	public boolean isPhone(String str) {
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
	 * @param name:����
	 * @return true:�ɹ�
	 */
	public boolean isName(String name) {
		if (name.length() == 0) {
			return false;
		}
		//����Ŀ����ֻ��Ҫ�޶������ĺ�Ӣ���ϼ��ɣ������Ѿ���Android EditText���������룬�˴�������������
		Pattern p = Pattern.compile("^[\u4E00-\u9FA5a-zA-Z]+");
		Matcher m = p.matcher(name);
		return m.matches();
	}
	
	/**
	 * ���������ɰ�����ĸ�����֡����š��ַ���֧��һ���ո񡢡�.�������񡱡���-��
	 * @param name
	 * @return
	 */
	public boolean isWorkName(String name) {
		if (name.length() == 0) {
			return false;
		}
		Pattern p = Pattern.compile("^(?:[\\u4e00-\\u9fa5]+)(?:��[\\u4e00-\\u9fa5]+)*$|^[a-zA-Z0-9]+\\s?[\\.��\\-()a-zA-Z]*[a-zA-Z]+$");
		Matcher m = p.matcher(name);
		return m.matches();
	}
	
	/**
	 * �����ж����ڹ淶
	 * @param str:����
	 * @return true:�ɹ�
	 */
	public boolean checkData(String str) {
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");//������Ϊ���ڸ�ʽ��y������ݣ�M��������е��·ݣ�Ϊ������Сʱ�еķ�����m��ͻ���˴���M����d�����·��е�����
		try {
			sd.setLenient(false);//�˴�ָ������/ʱ������Ƿ��ϸ���true�ǲ��ϸ�falseʱΪ�ϸ�
			sd.parse(str);//�Ӹ����ַ����Ŀ�ʼ�����ı���������һ������
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
     * ����������ʽ�ж��ַ����Ƿ�������
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
