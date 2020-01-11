/**
 * 
 */
package edu.fzu.hrmis.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import edu.fzu.hrmis.domain.Employee;
/**
 * 
 * DAO: Data Access Object EmployeeDao 将负责员工信息的增删改查操作
 * 
 * @author joeyang ong
 *
 */
public class EmployeeDao {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
	private static final String DATA_FILE_PATH = "e:\\records.txt";

	public List<Employee> loadEmps() {

		BufferedReader reader = null;
		String entry = null;
		List<Employee> empList = new ArrayList<Employee>();

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(DATA_FILE_PATH)));
			while ((entry = reader.readLine()) != null) {
				// 字符串 -> Employee对象？
				empList.add(Employee.getEmployeeFromStr(entry));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return empList;

	}

	/**
	 * 写入文件
	 * 
	 * @param writeData
	 * @return
	 */
	public void writeFile(Employee writeData) {

		File file = new File(DATA_FILE_PATH);
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH, true));

			if (file.exists()) {
				writer.newLine();
			}
			writer.write(writeData.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
		}
	}

	/**
	 * 删除员工
	 * 
	 * @param empInfo
	 */
	public void deleteEmps(String empInfo) {

		int file_line_num = this.loadEmps().size();
		String indexstr = empInfo; 
		String newstr = ""; 
		
		BufferedReader br = null;
		StringBuffer bf = new StringBuffer();
		String rl = null;
		
		try {
			br = new BufferedReader(new FileReader(DATA_FILE_PATH));
			
			while ((rl = br.readLine()) != null) {
				if (rl.indexOf(indexstr) == 0) {
					bf.append(newstr);
				} else {
					if (file_line_num > 1) {
						bf.append(rl + "\r\n");
					} else {
						bf.append(rl);
					}
				}
				file_line_num--;
			}
			
			br.close();
			BufferedWriter out = new BufferedWriter(new FileWriter(DATA_FILE_PATH));// 写入文件
			out.write(bf.toString());
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 更新员工信息
	 * 
	 * @param empInfo
	 */
	public boolean updateEmps(String empInfo, Employee empUp) {
		
		int file_line_num = this.loadEmps().size();
		String indexstr = empInfo; 
		String newstr = empUp.toString();
		
		BufferedReader br = null;
		StringBuffer bf = new StringBuffer();
		String rl = null;
		
		try {
			br = new BufferedReader(new FileReader(DATA_FILE_PATH));
			
			while ((rl = br.readLine()) != null) {
				if (rl.indexOf(indexstr) == 0) {
					bf.append(newstr + "\r\n");
				} else {
					if (file_line_num > 1) {
						bf.append(rl + "\r\n");
					} else {
						bf.append(rl);
					}
				}
				file_line_num--;
			}
			
			br.close();
			BufferedWriter out = new BufferedWriter(new FileWriter(DATA_FILE_PATH));// 写入文件
			out.write(bf.toString());
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}

	/**
	 * 获得按照lastname属性排序的Employee信息序列
	 * 
	 * @return
	 */
	public Set<Employee> loadSortedEmps() {
		return new TreeSet<Employee>(this.loadEmps());
	}

}
