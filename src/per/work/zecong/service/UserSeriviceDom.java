package per.work.zecong.service;

import pers.work.zecong.person.Person;
/**
 * �����������в�������ɳ��󷽷� ҵ������
 * @author 24538
 *
 */
public interface UserSeriviceDom {
	/**
	 * 
	 * @param username
	 * @param password
	 * @return 
	 */
	public boolean checkLogin(String username, String password);
	/**
	 * 
	 * @param epnum
	 * @return
	 */
	public boolean updateRecords(String epnum);
	/**
	 * �����û���Ϣ��Person�Ķ�����
	 * @return Person����
	 */
	public Person print_init();
	/**
	 * ����������Ϣ
	 */
	public void addPerson();
	/**
	 * 
	 * @param enter_status  2��3��4 �ֱ��Ӧ switch��2��3��4�Ĺ���
	 */
	public String sortDisplayOther(int enter_status);
	/**
	 * ������ʾ��������
	 * @return String �������ݵ�
	 */
	public String display();
	/**
	 * 
	 * @param epnum
	 * @return
	 */
	public boolean deleteRecords(String epnum);
	
	/**
	 * 
	 * @param scan_string
	 * @return
	 */
	public boolean searchRecords(String scan_string);
}
