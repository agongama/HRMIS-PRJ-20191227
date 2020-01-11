package edu.fzu.hrmis.ui;

import edu.fzu.hrmis.dao.EmployeeDao;
import edu.fzu.hrmis.domain.Employee;
import edu.fzu.hrmis.exception.BlankEntryException;
import edu.fzu.hrmis.exception.IllegalDataException;
import edu.fzu.hrmis.utils.SysUtils;

/**
 * 员工信息删除界面
 * @author yangzecong
 *
 */
public class EmpDeleteUI implements BaseUI {

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		EmployeeDao empDao = new EmployeeDao();

		for (;;) {
			emp.setPayrollNo(this.getEmpNo());
			String empInfo = SysUtils.EmpNoToInfo(emp.getPayrollNo());
			System.out.println(empInfo);
			
			if (empInfo == null) {
				System.out.println("Employee record for " + emp.getPayrollNo() + " not found!");
				SysUtils.pause("Press Enter to continue...");
				break;
			}
			
			if (!SysUtils.isYesOrNo("Confirm record deletion, (y)es or (n)o, y (user input)")) {
				break;
			}
			
			empDao.deleteEmps(empInfo);
			System.out.println("Record deleted.");
			
			if (!SysUtils.isYesOrNo("Delete another? (y)es or (n)o")) {
				break;
			}
		}
	}

	/**
	 * 获得员工工号
	 */
	private String getEmpNo() {

		String entry = null;

		while (true) {
			System.out.println("Adfaith Consulting – Employee Records:\r\n" + "======================================");
			System.out.println("Employee Record Deletion:");
			System.out.print("Enter employee’s 3 digit payroll number to enable file deletion: ");

			try {
				entry = SysUtils.getEntry();
				Integer.parseInt(entry);
				if (String.valueOf(entry).length() != 3) {
					throw new IllegalDataException();
				}
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No payroll number entered – try again");
			} catch (NumberFormatException e) {
				SysUtils.pause("Payroll number can contain only numerical characters");
			} catch (IllegalDataException e) {
				SysUtils.pause("Employee number must be three digits");
			}
		}

		return entry;

	}

	

}
