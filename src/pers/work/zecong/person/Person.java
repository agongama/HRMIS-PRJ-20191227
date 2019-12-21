package pers.work.zecong.person;
/**
 * 实体类 存放与输出员工对象数据
 * @author 24538
 *
 */
public class Person {

	String epnum;  //工号
	String telnum; //电话
	String name;   //姓名
	String name2;  //姓名2
	String name3;  //姓名3
	String departnum; //职位编号
	String jonname;   //职位
	String dateHiring; //入职日期
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEpnum() {
		return epnum;
	}
	public void setEpnum(String epnum) {
		this.epnum = epnum;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getDepartnum() {
		return departnum;
	}
	public void setDepartnum(String departnum) {
		this.departnum = departnum;
	}
	public String getJonname() {
		return jonname;
	}
	public void setJonname(String jonname) {
		this.jonname = jonname;
	}
	public String getDateHiring() {
		return dateHiring;
	}
	public void setDateHiring(String dateHiring) {
		this.dateHiring = dateHiring;
	}
}
