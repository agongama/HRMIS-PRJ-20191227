package pers.work.zecong.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import pers.work.zecong.person.Person;
/**
 * 文件流当作数据库使用，实现持久化
 * 这是存放数据对象的文件
 * @author 24538
 *
 */
public class ConnData {
	public File file = new File("records.txt");

	/**
	 * 
	 * @return 返回文件的全部数据的集合
	 * @throws IOException
	 */
	public ArrayList<Person> ReadFileToList() throws IOException {
		String str = new String();
		// 创建一个输入缓冲对象
		BufferedReader br = new BufferedReader(new FileReader(file));
		// 创建集合对象
		ArrayList<Person> array = new ArrayList<Person>();
		// 读取文件
		String line;
		while ((line = br.readLine()) != null) {// br.read.line读一行
			String[] strs = line.split(":");// 分割
			Person s = new Person();
			s.setEpnum(strs[0]);
			s.setTelnum(strs[1]);
			s.setName(strs[2]);
			s.setName2(strs[3]);
			s.setName3(strs[4]);
			s.setDepartnum(strs[5]);
			s.setJonname(strs[6]);
			s.setDateHiring(strs[7]);
			array.add(s);
		}
		// 释放资源
		br.close();
		return array;
	}

	/**
	 * 写,将数据存入文件
	 * @param wridata Person的对象
	 */
	public void writeFile(Person wridata) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true)); // 读文件
			if (file.exists()) {
				out.newLine();
			}
			out.write(wridata.getEpnum() + ":" + wridata.getTelnum() + ":" + wridata.getName() + ":"
					+ wridata.getName2() + ":" + wridata.getName3() + ":" + wridata.getDepartnum() + ":"
					+ wridata.getJonname() + ":" + wridata.getDateHiring());
			out.flush();
			out.close();
			System.out.println("员工信息已写入！");
		} catch (IOException e) {
		}
	}
	
	public void writeFile(String wridata) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true)); // 读文件
			if (file.exists()) {
				out.newLine();
			}
			out.write(wridata);
			out.flush();
			out.close();
		} catch (IOException e) {
		}
	}

	/**
	 * 读
	 * Print:将文件所有数据遍历输出
	 */
	public void readFile() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			StringBuffer sb;
			while (in.ready()) {
				sb = (new StringBuffer(in.readLine()));
				System.out.println(sb);
			}
			in.close();
		} catch (IOException e) {
		}
	}

	/**
	 * 
	 * @param epnum 工号
	 * @return 根据工号查找成功返回true;
	 * @throws IOException
	 */
	public boolean seachId(String epnum) throws IOException {
		String str = new String();
		ArrayList<Person> array = ReadFileToList();
		for (Person student : array) {
			if (student.getEpnum().equals(epnum)) {
				str = "工号：" + student.getEpnum() + "  姓名：" + student.getName() + "  电话：" + student.getTelnum()
						+ "  工作单位：" + student.getJonname();
				System.out.println(str);
			}
		}
		if (str == null || str.length() == 0) {
			System.out.println("没有找到该工人");
			return false;
		}
		return true;
	}

}
