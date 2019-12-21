package pers.work.zecong.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import per.work.zecong.service.PsdMd5;
/**
 * �ļ����������ݿ�ʹ�ã�ʵ�ֳ־û�
 * ���Ǵ���û��˺�������ļ����������md5����
 * @author 24538
 *
 */
public class ConnUser {
	File file = new File("user.txt");
	String user_name;
	String password;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @param uname �˺�
	 * @param psd   ����ʹ��md5����
	 * @return ����true���˺�������ȷ
	 * @throws IOException
	 */
	public boolean checkUser(String uname, String psd) throws IOException {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String str = new String();
		// ����һ�����뻺�����
		BufferedReader br = new BufferedReader(new FileReader(file));
		// �������϶���
		ArrayList<ConnUser> array = new ArrayList<ConnUser>();
		// ��ȡ�ļ�
		String line;
		while ((line = br.readLine()) != null) {// br.read.line��һ��
			String[] strs = line.split(":");// �ָ�
			ConnUser u = new ConnUser();
			u.setUser_name(strs[0]);
			u.setPassword(strs[1]);
			array.add(u);
		}
		// �ͷ���Դ
		br.close();
		for (ConnUser student : array) {
			if (student.getUser_name().equals(uname) && student.getPassword().equals(PsdMd5.md5(psd))) {
				return true;
			} else {
			}
		}
		return false;
	}

}
