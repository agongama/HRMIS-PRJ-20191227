package per.work.zecong.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import pers.work.zecong.dao.EmpDao;
import pers.work.zecong.dao.EmpDaoImpl;
import pers.work.zecong.person.Person;

/**
 * �������ӿڶ��巽���ľ���ʵ��
 * @author 24538
 *
 */
public class UserSeriviceImpl implements UserSeriviceDom {
	private EmpDao ud;
	private Regex re;
	
	public UserSeriviceImpl() {
		ud = new EmpDaoImpl();
		re = new Regex();
	}

	@Override
	public boolean checkLogin(String username, String password) {
		return ud.login(username, password);
	}

	@Override
	public Person print_init() {
		Scanner scan = new Scanner(System.in);
		Person sc_person = new Person();
		for (;;) {
			System.out.println("������Ա���Ĺ���(3λ����):");
			try {
				String str = scan.nextLine();
				boolean bool_id = true;
				if(!epnumIsOk(str)) {
					continue;
				}
				
				ArrayList<Person> array = ud.dataAllList();
				for (Person student : array) {
					if (student.getEpnum().equals(str)) {
						bool_id = false;
					}
				}
				if (!bool_id) {
					System.out.println("��ID�Ѵ���--����������->");
					continue;
				}
				sc_person.setEpnum(str);

				System.out.println("������Ա���ĵ绰:");
				str = scan.nextLine();
				// �жϵ绰�Ƿ�����
				while (!re.isPhone(str)) {
					System.out.println("Invalid phone number �C try again");
					System.out.println("������Ա���ĵ绰");
					str = scan.nextLine();
				}
				sc_person.setTelnum(str);
				
				System.out.println("������Ա���ĵ�1λ����:");
				str = scan.nextLine();
				while (!nameIsOk(str)) {
					System.out.println("������Ա���ĵ�1λ����:");
					str = scan.nextLine();
				}
				sc_person.setName(str);
				
				System.out.println("������Ա���ĵ�2λ����:");
				str = scan.nextLine();
				while (!nameIsOk(str)) {
					System.out.println("������Ա���ĵ�2λ����:");
					str = scan.nextLine();
				}
				sc_person.setName2(str);
				
				System.out.println("������Ա���ĵ�3λ����:");
				str = scan.nextLine();
				while (!nameIsOk(str)) {
					System.out.println("������Ա���ĵ�3λ����:");
					str = scan.nextLine();
				}
				sc_person.setName3(str);
				
				System.out.println("������Ա���Ĳ��ű��:");
				str = scan.nextLine();
				while(!re.isNumeric(str)) {
					System.out.println("Ա���Ĳ��ű�ű��������֣�");
					System.out.println("������Ա���Ĳ��ű��:");
					str = scan.nextLine();
				}
				sc_person.setDepartnum(str);
				
				System.out.println("������Ա���Ĺ�������:");
				str = scan.nextLine();
				while (!re.isWorkName(str)) {
					System.out.println("Middle Init can contain only alphabetical characters and spaces");
					System.out.println("������Ա���Ĺ�������:");
					str = scan.nextLine();
				}
				sc_person.setJonname(str);
				
				System.out.println("������Ա������Ƹ����:");
				str = scan.nextLine();
				if (!re.checkData(str)) {
					System.out.println("Invalid Date Hired");
					System.out.println("������Ա������Ƹ����:");
					str = scan.nextLine();
				}
				sc_person.setDateHiring(str);
				
				break;
			} catch (Exception e) {
				System.out.println("����ĸ�ʽ����,����������");
				continue;
			}
		}
		return sc_person;
	}

	@Override
	public boolean updateRecords(String epnum) {
		if(!epnumIsOk(epnum)) {
			return false;
		}
		try {
			if (!ud.seachId(epnum)) {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person upp = print_init();
		return ud.updateRecords(epnum,upp);
	}

	@Override
	public void addPerson() {
		ud.addNewRecords(print_init());
	}

	@Override
	public String sortDisplayOther(int enter_status) {
		String str = new String();
		// �������϶���
		ArrayList<Person> array = null;
		try {
			array = ud.dataAllList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> list1 = new ArrayList<>();
		for (Person student : array) {
			if (enter_status == 2) {
				str=String.format("%-10s%-20s%-15s%-15s%-15s%-10s%-20s%-15s",
						student.getEpnum(),student.getTelnum(),student.getName()
						  ,student.getName2(),student.getName3(),student.getDepartnum(),student.getJonname(),student.getDateHiring());
			} else if (enter_status == 3 || enter_status == 4) {
				// ����ʾ�����͵绰����.
				str = String.format("%-20s%-20s%-15s%-15s",student.getName()
						  ,student.getName2(),student.getName3(),student.getTelnum());
			}
			list1.add(str);
		}
		if (enter_status == 2 || enter_status == 4) {
			Collections.sort(list1);
		}
		String s = "";
		for (String i : list1) {
			s = s+i+"\n";
		}
		return s.trim();
	}
	
	@Override
	public boolean searchRecords(String scan_string) {
		if(!nameIsOk(scan_string)) {
			return false;
		}
		String str = new String();
		// �������϶���
		ArrayList<Person> array = null;
		try {
			array = ud.dataAllList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Person student : array) {
			if ((student.getName().toLowerCase().indexOf(scan_string.toLowerCase(), 0)) != -1
					||(student.getName2().toLowerCase().indexOf(scan_string.toLowerCase(), 0)) != -1
					||(student.getName3().toLowerCase().indexOf(scan_string.toLowerCase(), 0)) != -1) {
//	            index = index+scan_string.length();
				str=String.format("%-10s%-20s%-15s%-15s%-15s%-10s%-20s%-15s",
						student.getEpnum(),student.getTelnum(),student.getName()
						  ,student.getName2(),student.getName3(),student.getDepartnum(),student.getJonname(),student.getDateHiring());
				System.out.println(str);
			}
		}
		if (str == null || str.length() == 0) {
			System.out.println("û���ҵ��ù���");
			return false;
		}
		return true;
	}

	@Override
	public String display() {
		ArrayList<Person> array = null;
		try {
			array = ud.dataAllList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String s = "";
		for(Person worker : array) {
			s = s + worker.getEpnum() + ":" + worker.getTelnum() + ":" + worker.getName() 
								+ ":" + worker.getName2() + ":" + worker.getName3() + ":"+ worker.getDepartnum() 
								+  ":" + worker.getJonname() + ":" +worker.getDateHiring()+"\n";
		}
		return s.trim();
	}

	@Override
	public boolean deleteRecords(String epnum) {
		if(!epnumIsOk(epnum)) {
			return false;
		}
		return ud.deleteRecords(epnum);
	}
	
	/**
	 * �ж������Ƿ���ȷ
	 * @param epnum
	 * @return
	 */
	public boolean epnumIsOk(String epnum) {
		if(!re.isNumeric(epnum)) {
			System.out.println("���������֣�");
			return false;
		}
		if (String.valueOf(epnum).length() != 3) {
			System.out.println("������3λ����");
			return false;
		}
		return true;
	}
	/**
	 * �ж����ָ�ʽ�Ƿ���ȷ
	 * @param name
	 * @return
	 */
	public boolean nameIsOk(String name) {
		if(!re.isName(name)) {
			System.out.println("Last name can contain only alphabetical characters and spaces");
			return false;
		}
		return true;
	}

}
