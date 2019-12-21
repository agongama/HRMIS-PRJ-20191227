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
 * 文件操作接口的实现类
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
		
		String indexstr = epnum;	// 根据该字符串，查找其在文件所在的一行
		String newstr = "";			//删除的那一行

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}// 读文件
		StringBuffer bf = new StringBuffer();
		String rl = null;// 临时的每行数据
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
			BufferedWriter out = new BufferedWriter(new FileWriter(file));// 写入文件
			out.write(bf.toString());// 把bf写入文件
			out.flush();// 一定要flush才能写入完成
			out.close();// 关闭
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
		String indexstr = epnum;// 根据该字符串，查找其在文件所在的一行，然后替换成新的一行，其它行数据不变
		String newstr = wridata.getEpnum() + ":" + wridata.getTelnum() + ":" + wridata.getName() + ":" + wridata.getName2() + ":" + wridata.getName3() + ":"
				+ wridata.getDepartnum() +  ":" + wridata.getJonname() + ":" +wridata.getDateHiring();// 新的一行
		int line_num = 0;
		try {
			line_num = dataAllList().size();
			BufferedReader br = new BufferedReader(new FileReader(file));// 读文件
			StringBuffer bf = new StringBuffer();
			String rl = null;// 临时的每行数据
			while ((rl = br.readLine()) != null) {
				if (rl.indexOf(indexstr) == 0) { // 或者!r1.startsWith(indexstr)
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
			System.out.println("输入y保存，输入n不保存");
			String bool = y_or_no.nextLine();
			if (bool.equals("y")) {
				BufferedWriter out = new BufferedWriter(new FileWriter(file));// 写入文件
				out.write(bf.toString());// 把bf写入文件
				out.flush();// 一定要flush才能写入完成
				out.close();// 关闭
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
