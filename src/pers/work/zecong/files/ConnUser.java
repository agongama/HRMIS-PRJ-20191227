package pers.work.zecong.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import per.work.zecong.service.PsdMd5;
/**
 * 文件流当作数据库使用，实现持久化
 * 这是存放用户账号密码的文件，密码采用md5加密
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
	 * @param uname 账号
	 * @param psd   密码使用md5加密
	 * @return 返回true则账号密码正确
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
		// 创建一个输入缓冲对象
		BufferedReader br = new BufferedReader(new FileReader(file));
		// 创建集合对象
		ArrayList<ConnUser> array = new ArrayList<ConnUser>();
		// 读取文件
		String line;
		while ((line = br.readLine()) != null) {// br.read.line读一行
			String[] strs = line.split(":");// 分割
			ConnUser u = new ConnUser();
			u.setUser_name(strs[0]);
			u.setPassword(strs[1]);
			array.add(u);
		}
		// 释放资源
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
