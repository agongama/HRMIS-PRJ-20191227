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
 * �ļ����������ݿ�ʹ�ã�ʵ�ֳ־û�
 * ���Ǵ�����ݶ�����ļ�
 * @author 24538
 *
 */
public class ConnData {
	public File file = new File("records.txt");

	/**
	 * 
	 * @return �����ļ���ȫ�����ݵļ���
	 * @throws IOException
	 */
	public ArrayList<Person> ReadFileToList() throws IOException {
		String str = new String();
		// ����һ�����뻺�����
		BufferedReader br = new BufferedReader(new FileReader(file));
		// �������϶���
		ArrayList<Person> array = new ArrayList<Person>();
		// ��ȡ�ļ�
		String line;
		while ((line = br.readLine()) != null) {// br.read.line��һ��
			String[] strs = line.split(":");// �ָ�
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
		// �ͷ���Դ
		br.close();
		return array;
	}

	/**
	 * д,�����ݴ����ļ�
	 * @param wridata Person�Ķ���
	 */
	public void writeFile(Person wridata) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true)); // ���ļ�
			if (file.exists()) {
				out.newLine();
			}
			out.write(wridata.getEpnum() + ":" + wridata.getTelnum() + ":" + wridata.getName() + ":"
					+ wridata.getName2() + ":" + wridata.getName3() + ":" + wridata.getDepartnum() + ":"
					+ wridata.getJonname() + ":" + wridata.getDateHiring());
			out.flush();
			out.close();
			System.out.println("Ա����Ϣ��д�룡");
		} catch (IOException e) {
		}
	}
	
	public void writeFile(String wridata) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true)); // ���ļ�
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
	 * ��
	 * Print:���ļ��������ݱ������
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
	 * @param epnum ����
	 * @return ���ݹ��Ų��ҳɹ�����true;
	 * @throws IOException
	 */
	public boolean seachId(String epnum) throws IOException {
		String str = new String();
		ArrayList<Person> array = ReadFileToList();
		for (Person student : array) {
			if (student.getEpnum().equals(epnum)) {
				str = "���ţ�" + student.getEpnum() + "  ������" + student.getName() + "  �绰��" + student.getTelnum()
						+ "  ������λ��" + student.getJonname();
				System.out.println(str);
			}
		}
		if (str == null || str.length() == 0) {
			System.out.println("û���ҵ��ù���");
			return false;
		}
		return true;
	}

}
