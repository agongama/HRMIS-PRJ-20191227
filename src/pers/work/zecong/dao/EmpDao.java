package pers.work.zecong.dao;

import java.io.IOException;
import java.util.ArrayList;

import pers.work.zecong.person.Person;
/**
 * �ṩ�˷����ļ���������Ľӿ�
 * @author 24538
 *
 */
public interface EmpDao {
		/**
		 * @param username
		 * @param password
		 * @return true ���ص�½�ɹ�
		 */
		public boolean login(String username, String password);
		
		/**
		 * ����������Ϣ
		 */
		public void addNewRecords(Person p);
		/**
		 * 
		 * @param epnum ���ݹ�������ɾ��
		 * @return true ����ɾ���ɹ�
		 */
		public boolean deleteRecords(String epnum);
		/**
		 * 
		 * @param epnum ���ݹ����ѯ����
		 * @return true ���ظ��ĳɹ�
		 */
		public boolean updateRecords(String epnum, Person wridata);
		/**
		 * 
		 * @return ArrayList<Person>���� �ļ�������
		 * @throws IOException
		 */
		public ArrayList<Person> dataAllList() throws IOException;
		/**
		 * 
		 * @return ����ID�����û�
		 * @throws IOException 
		 */
		public boolean seachId(String epnum) throws IOException;
	}
