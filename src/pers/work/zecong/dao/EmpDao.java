package pers.work.zecong.dao;

import java.io.IOException;
import java.util.ArrayList;

import pers.work.zecong.person.Person;
/**
 * 提供了访问文件所需操作的接口
 * @author 24538
 *
 */
public interface EmpDao {
		/**
		 * @param username
		 * @param password
		 * @return true 返回登陆成功
		 */
		public boolean login(String username, String password);
		
		/**
		 * 新增工人信息
		 */
		public void addNewRecords(Person p);
		/**
		 * 
		 * @param epnum 根据工号搜索删除
		 * @return true 返回删除成功
		 */
		public boolean deleteRecords(String epnum);
		/**
		 * 
		 * @param epnum 根据公告查询更改
		 * @return true 返回更改成功
		 */
		public boolean updateRecords(String epnum, Person wridata);
		/**
		 * 
		 * @return ArrayList<Person>集合 文件的数据
		 * @throws IOException
		 */
		public ArrayList<Person> dataAllList() throws IOException;
		/**
		 * 
		 * @return 根据ID查找用户
		 * @throws IOException 
		 */
		public boolean seachId(String epnum) throws IOException;
	}
