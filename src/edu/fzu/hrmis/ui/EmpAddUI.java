/**
 * 
 */
package edu.fzu.hrmis.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.fzu.hrmis.dao.EmployeeDao;
import edu.fzu.hrmis.domain.Employee;
import edu.fzu.hrmis.exception.IllegalDataException;
import edu.fzu.hrmis.exception.BlankEntryException;
import edu.fzu.hrmis.utils.SysUtils;

/**
 * 
 * Ա����Ϣ�Ǽ�ע�����
 * 
 * @author joeyang ong
 *
 */
public class EmpAddUI implements BaseUI {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.fzu.hrmis.ui.BaseUI#setup()
	 */
	@Override
	public void setup() {

		Employee emp = new Employee();
		EmployeeDao empDao = new EmployeeDao();
		
		for (;;) {
			emp.setPayrollNo(this.getEmpNo());
			emp.setTelephoneCode(EmpAddUI.getEmpTelePhone());
			emp.setFirstName(EmpAddUI.getEmpName("Enter First Name: "));
			emp.setLastName(EmpAddUI.getEmpName("Enter Last Name: "));
			emp.setInitial(EmpAddUI.getEmpName("Enter Middle Init: "));
			emp.setDeptNo(EmpAddUI.getEmpDept());
			emp.setJobTitle(EmpAddUI.getEmpJobTitle());
			emp.setHiringDate(EmpAddUI.getEmpDate());
			
			empDao.writeFile(emp);
			System.out.println("Record Saved ");
			
			if(!SysUtils.isYesOrNo("Add another employee record? (y)es or (n)o")) {
				break;
			}
		}
	}

	/**
	 * ���Ա������
	 */
	private String getEmpNo() {

		String entry = null;

		while (true) {

			System.out.print("Enter employee 3 digit payroll number: ");

			try {
				entry = SysUtils.getEntry();
				Integer.parseInt(entry);
				if (String.valueOf(entry).length() != 3) {
					throw new IllegalDataException();
				}
				if(!SysUtils.isOnlyEmpNo(entry)) {
					SysUtils.pause("The Payroll number already exists");
					continue;
				}
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No payroll number entered �C try again");
			} catch (NumberFormatException e) {
				SysUtils.pause("Payroll number can contain only numerical characters");
			} catch (IllegalDataException e) {
				SysUtils.pause("Employee number must be three digits");
			}
		}

		return entry;

	}

	/**
	 * ��õ绰����
	 */
	protected static String getEmpTelePhone() {
		String entry = null;

		while (true) {

			System.out.print("Enter Phone Number (02-12345678): ");

			try {
				entry = SysUtils.getEntry();
				if(!SysUtils.isTelePhone(entry)) {
					throw new IllegalDataException();
				}
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No phone number entered �C try again");
			} catch (IllegalDataException e) {
				SysUtils.pause("Invalid phone number �C try again");
			}
		}

		return entry;
	}
	
	/**
	 * �������
	 */
	protected static String getEmpName(String name_str) {
		String entry = null;

		while (true) {

			System.out.print(name_str);

			try {
				entry = SysUtils.getEntry();
				if(!SysUtils.isName(entry)) {
					throw new IllegalDataException();
				}
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No last name entered �C try again");
			} catch (IllegalDataException e) {
				SysUtils.pause("Last name can contain only alphabetical characters and spaces ");
			}
		}

		return entry;
	}
	
	/**
	 * ���Ա������
	 */
	protected static int getEmpDept() {

		String entry = null;

		while (true) {

			System.out.print("Enter Dept #: ");

			try {
				entry = SysUtils.getEntry();
				Integer.parseInt(entry);
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No Dept # entered �C try again");
			} catch (NumberFormatException e) {
				SysUtils.pause("Dept # can contain only digits with no spaces");
			}
		}

		return Integer.parseInt(entry);

	}

	/**
	 * ��ù�����
	 */
	protected static String getEmpJobTitle() {
		String entry = null;

		while (true) {

			System.out.print("Enter Job Title: ");

			try {
				entry = SysUtils.getEntry();
				if(!SysUtils.isWorkName(entry)) {
					throw new IllegalDataException();
				}
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No Job title entered �C try again");
			} catch (IllegalDataException e) {
				SysUtils.pause("Job title can contain only alphabetical characters and spaces ");
			}
		}

		return entry;
	}
	
	/**
	 * �������
	 */
	protected static Date getEmpDate() {
		
		String entry = null;
		SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
		
		while (true) {
			
			System.out.print("Enter Date Hired (dd-mm-yyyy): ");

			try {
				entry = SysUtils.getEntry();
				if(!SysUtils.isDate(entry)) {
					throw new IllegalDataException();
				}
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No date hired entered �C try again");
			} catch (IllegalDataException e) {
				SysUtils.pause("Invalid Date Hired ");
			}
		}

		try {
			return SDF.parse(entry);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
