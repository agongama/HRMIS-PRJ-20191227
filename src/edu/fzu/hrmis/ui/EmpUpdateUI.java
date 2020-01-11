package edu.fzu.hrmis.ui;

import edu.fzu.hrmis.dao.EmployeeDao;
import edu.fzu.hrmis.domain.Employee;
import edu.fzu.hrmis.exception.BlankEntryException;
import edu.fzu.hrmis.exception.IllegalDataException;
import edu.fzu.hrmis.utils.SysUtils;

public class EmpUpdateUI implements BaseUI {

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		EmployeeDao empDao = new EmployeeDao();
		
		emp.setPayrollNo(this.getEmpNo());
		emp.setTelephoneCode(EmpAddUI.getEmpTelePhone());
		emp.setFirstName(EmpAddUI.getEmpName("Enter First Name: "));
		emp.setLastName(EmpAddUI.getEmpName("Enter Last Name: "));
		emp.setInitial(EmpAddUI.getEmpName("Enter Middle Init: "));
		emp.setDeptNo(EmpAddUI.getEmpDept());
		emp.setJobTitle(EmpAddUI.getEmpJobTitle());
		emp.setHiringDate(EmpAddUI.getEmpDate());
		
		String empInfo = SysUtils.EmpNoToInfo(emp.getPayrollNo());
		if(empDao.updateEmps(empInfo, emp)) {
			SysUtils.pause("更新成功  --  Press Enter to continue...");
		}
		
	}
	
	/**
	 * 获得员工工号
	 */
	private String getEmpNo() {

		String entry = null;

		while (true) {
			System.out.print("Enter employee’s 3 digit payroll number to enable file updation: ");

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
