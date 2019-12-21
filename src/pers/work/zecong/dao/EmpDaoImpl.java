package pers.work.zecong.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import pers.work.zecong.files.ConnData;
import pers.work.zecong.files.ConnUser;
import pers.work.zecong.person.Person;
/**
 * �ļ������ӿڵ�ʵ����
 * @author 24538
 *
 */
public class EmpDaoImpl implements EmpDao {

	public boolean login(String username, String password){
		ConnUser connfile = new ConnUser();
		boolean status_login = false;
		try {
			status_login = connfile.checkUser(username, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status_login;
	}

	@Override
	public void addNewRecords(Person p) {
		ConnData conn_data = new ConnData();
		conn_data.writeFile(p);
	}

	@Override
	public boolean deleteRecords(String epnum) {
		ConnData conn_data = new ConnData();
		File file = conn_data.file;
		try {
			if (!conn_data.seachId(epnum)) {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String indexstr = epnum;	// ���ݸ��ַ��������������ļ����ڵ�һ��
		String newstr = "";			//ɾ������һ��

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}// ���ļ�
		StringBuffer bf = new StringBuffer();
		String rl = null;// ��ʱ��ÿ������
		int line_num = 0;
		try {
			line_num = dataAllList().size();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			while ((rl = br.readLine()) != null) {
				if (rl.indexOf(indexstr) == 0) { 
					bf.append(newstr);
				} else {
					if(line_num > 2) {
						bf.append(rl + "\r\n");
					} else {
						bf.append(rl);
					}
				}
				line_num--;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			br.close();
			BufferedWriter out = new BufferedWriter(new FileWriter(file));// д���ļ�
			out.write(bf.toString());// ��bfд���ļ�
			out.flush();// һ��Ҫflush����д�����
			out.close();// �ر�
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateRecords(String epnum, Person wridata) {
		ConnData conn_data = new ConnData();
		Scanner y_or_no = new Scanner(System.in);
		boolean judge = false;
		File file = conn_data.file;
		String indexstr = epnum;// ���ݸ��ַ��������������ļ����ڵ�һ�У�Ȼ���滻���µ�һ�У����������ݲ���
		String newstr = wridata.getEpnum() + ":" + wridata.getTelnum() + ":" + wridata.getName() + ":" + wridata.getName2() + ":" + wridata.getName3() + ":"
				+ wridata.getDepartnum() +  ":" + wridata.getJonname() + ":" +wridata.getDateHiring();// �µ�һ��
		int line_num = 0;
		try {
			line_num = dataAllList().size();
			BufferedReader br = new BufferedReader(new FileReader(file));// ���ļ�
			StringBuffer bf = new StringBuffer();
			String rl = null;// ��ʱ��ÿ������
			while ((rl = br.readLine()) != null) {
				if (rl.indexOf(indexstr) == 0) { // ����!r1.startsWith(indexstr)
					bf.append(newstr + "\r\n");
				} else {
					if(line_num > 2) {
						bf.append(rl + "\r\n");
					} else {
						bf.append(rl);
					}
				}
				line_num--;
			}
			br.close();
			System.out.println("����y���棬����n������");
			String bool = y_or_no.nextLine();
			if (bool.equals("y")) {
				BufferedWriter out = new BufferedWriter(new FileWriter(file));// д���ļ�
				out.write(bf.toString());// ��bfд���ļ�
				out.flush();// һ��Ҫflush����д�����
				out.close();// �ر�
				judge = true;
			} else {
				judge = false;
			}

		} catch (IOException e) {
		}
		return judge;
	}

	@Override
	public ArrayList<Person> dataAllList() throws IOException {
		ConnData conn_data = new ConnData();
		return conn_data.ReadFileToList();
	}

	@Override
	public boolean seachId(String epnum) throws IOException {
		ConnData conn_data = new ConnData();
		return conn_data.seachId(epnum);
	}


}
