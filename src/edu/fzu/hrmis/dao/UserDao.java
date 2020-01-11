package edu.fzu.hrmis.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import edu.fzu.hrmis.domain.User;

public class UserDao {

	private static final String USER_FILE_PATH = "e:\\user.txt";
	
	public List<User> loadEmps() {

		BufferedReader reader = null;
		String entry = null;
		List<User> empList = new ArrayList<User>();

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(USER_FILE_PATH)));
			while ((entry = reader.readLine()) != null) {
				// ◊÷∑˚¥Æ -> Employee∂‘œÛ£ø
				empList.add(User.getEmployeeFromStr(entry));
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
	
}
