package pers.work.zecong.client;

import java.util.Scanner;

import per.work.zecong.service.UserSeriviceDom;
import per.work.zecong.service.UserSeriviceImpl;
import pers.work.zecong.dao.EmpDao;
import pers.work.zecong.dao.EmpDaoImpl;
/**
 * 视图层
 * @author 24538
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String select = new String();
		System.out.println("\t\t提示信息:\t账号:38\t密码:38，密码使用MD5加密,在user.txt文件夹查看");
		System.out.println("请输入用户名:");
		String username = sc.nextLine();
		System.out.println("请输入密码:");
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
					// 读所有
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
				case "5":// 搜索并显示特定的员工记录
					System.out.println("请输入员工的姓名搜索记录:");
					select = sc.nextLine();
					if (select.length() == 0) {
						System.out.println("No keyword entered – try again…");
						continue;
					}
					cd.searchRecords(select);
					System.out.print("Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "6": // 新增加记录
					cd.addPerson();
					System.out.print("Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "7": // 删除
					System.out.println("请输入员工的工号，删除该员工的记录:");
					select = sc.nextLine();
					if(!cd.deleteRecords(select)) {
						System.out.print("Press Enter to continue...:");
						break;
					}
					System.out.print("删除成功 Press Enter to continue...:");
					select = sc.nextLine();
					break;
				case "8": // 更新 根据工号更改
					System.out.println("请输入员工的工号，修改该员工的记录:");
					select = sc.nextLine();
					if (!cd.updateRecords(select)) {
						System.out.println("没有保存...并退出");
						break;
					}
					System.out.print("保存成功 Press Enter to continue...:");
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
						System.out.println("No selection entered. Press Enter to continue…");
						select = sc.nextLine();
						break;
					}
					System.out.print("Invalid code! Press Enter to continue…:");
					select = sc.nextLine();
					break;
				}
			}
		}
		else {
			System.out.println("账号或密码错误");
		}
	}
	
	private static void init() {
		StringBuilder builder = new StringBuilder();

		builder.append("讯通科技 - Employee Information - Main Menu\n")
				.append("=====================================================\n\n")
				.append("1 - Print All Current Records\n").append("2 – Print All Current Records (formatted)\n")
				.append("3 – Print Names and Phone Numbers\n").append("4 – Print Names and Phone Numbers (formatted)\n")
				.append("5 - Search for specific Record(s)\n").append("6 - Add New Records\n")
				.append("7 – Delete Records\n").append("8 - 更新员工资料(根据ID)\n\n").append("Q - Quit");
		System.out.println(builder);
	}
}
