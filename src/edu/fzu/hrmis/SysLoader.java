/**
 * 
 */
package edu.fzu.hrmis;

import edu.fzu.hrmis.exception.HRMISException;
import edu.fzu.hrmis.ui.BaseUI;
import edu.fzu.hrmis.ui.MainMenuUI;
import edu.fzu.hrmis.ui.UIType;
import edu.fzu.hrmis.utils.SysUtils;

/**
 * @author joeyang ong
 *
 */
public class SysLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
		  SysUtils.checkResource();
		  SysUtils.checkUser();
		  SysUtils.runUI(UIType.EmpLoginUI);
		  SysUtils.runUI(UIType.MainMenuUI);
		}catch(HRMISException e){
		  System.out.println(e.getMessage());
		}

	}

}
