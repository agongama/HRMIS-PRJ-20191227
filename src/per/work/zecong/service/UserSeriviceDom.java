package per.work.zecong.service;

import pers.work.zecong.person.Person;
/**
 * 控制器的所有操作定义成抽象方法 业务流程
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
	 * 存入用户信息到Person的对象中
	 * @return Person对象
	 */
	public Person print_init();
	/**
	 * 新增工人信息
	 */
	public void addPerson();
	/**
	 * 
	 * @param enter_status  2，3，4 分别对应 switch的2，3，4的功能
	 */
	public String sortDisplayOther(int enter_status);
	/**
	 * 用于显示所有数据
	 * @return String 所有数据的
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
