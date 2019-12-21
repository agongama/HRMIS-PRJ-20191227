package pers.work.zecong.client;

import java.util.Scanner;

import per.work.zecong.service.UserSeriviceDom;
import per.work.zecong.service.UserSeriviceImpl;
import pers.work.zecong.dao.EmpDao;
import pers.work.zecong.dao.EmpDaoImpl;
/**
 * ��ͼ��
 * @author 24538
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String select = new String();
		System.out.println("\t\t��ʾ��Ϣ:\t�˺�:38\t����:38������ʹ��MD5����,��user.txt�ļ��в鿴");
		System.out.println("�������û���:");
		String username = sc.nextLine();
		System.out.println("����������:");
		String password = sc.nextLine();
		
		UserSeriviceDom cd = new UserSeriviceImpl();
		boolean login_status = cd.checkLogin(username, password);
		
		if(login_status) {
			init();
			for (;;) {
				System.out.print("Your Selection: ");
				select = sc.nextLine();
				switch (select) {
				case "1":
					// ������
					System.out.println(cd.display());
					// system('pause')
					System.out.print("Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "2":
					System.out.println(cd.sortDisplayOther(2));
					System.out.print("Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "3":
					System.out.println(cd.sortDisplayOther(3));
					System.out.print("Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "4":
					System.out.println(cd.sortDisplayOther(4));
					System.out.print("Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "5":// ��������ʾ�ض���Ա����¼
					System.out.println("������Ա��������������¼:");
					select = sc.nextLine();
					if (select.length() == 0) {
						System.out.println("No keyword entered �C try again��");
						continue;
					}
					cd.searchRecords(select);
					System.out.print("Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "6": // �����Ӽ�¼
					cd.addPerson();
					System.out.print("Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "7": // ɾ��
					System.out.println("������Ա���Ĺ��ţ�ɾ����Ա���ļ�¼:");
					select = sc.nextLine();
					if(!cd.deleteRecords(select)) {
						System.out.print("Press Enter to continue...:");
						break;
					}
					System.out.print("ɾ���ɹ� Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "8": // ���� ���ݹ��Ÿ���
					System.out.println("������Ա���Ĺ��ţ��޸ĸ�Ա���ļ�¼:");
					select = sc.nextLine();
					if (!cd.updateRecords(select)) {
						System.out.println("û�б���...���˳�");
						break;
					}
					System.out.print("����ɹ� Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "Q":
					System.exit(0);
					break;
				case "q":
					System.exit(0);
					break;
				default:
					if (select.length() == 0) {
						System.out.println("No selection entered. Press Enter to continue��");
						select = sc.nextLine();
						break;
					}
					System.out.print("Invalid code! Press Enter to continue��:");
					select = sc.nextLine();
					break;
				}
			}
		}
		else {
			System.out.println("�˺Ż��������");
		}
	}
	
	private static void init() {
		StringBuilder builder = new StringBuilder();

		builder.append("Ѷͨ�Ƽ� - Employee Information - Main Menu\n")
				.append("=====================================================\n\n")
				.append("1 - Print All Current Records\n").append("2 �C Print All Current Records (formatted)\n")
				.append("3 �C Print Names and Phone Numbers\n").append("4 �C Print Names and Phone Numbers (formatted)\n")
				.append("5 - Search for specific Record(s)\n").append("6 - Add New Records\n")
				.append("7 �C Delete Records\n").append("8 - ����Ա������(����ID)\n\n").append("Q - Quit");
		System.out.println(builder);
	}
}
