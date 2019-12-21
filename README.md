# javaFinalAssignment
期末作业



项目要求 : 此项目需要实现CUI（Command User Interface）版本 。至少应包含以下项目要求功能,在项目实现时还应能尽可能多考虑实际软件的必须因素(如登陆等等) 。不一定要按项目中建议的类来进行设计(项目书中给出的几个类设计只是简单的划分,不一定合理),在实际编程中类的设计建议尽量考虑利用面向对象的相关知识，在项目的可重用性 可拓展性 易修改性上反复调优代码质量。

(注:基础较弱学员可先考虑功能实现,待功能实现后再考虑代码优化)

 

***\*额外附加功能：\****

**1.** ***\*提供员工信息修改模块\****

**2.** ***\*增加登录模组，实现输入用户名和密码正确之后，才能指向相关操作。\****

**3.** ***\*用户名和密码所保存的文件，可以对用户密码进行加密保存。\****

***\*（使用J\*******\*AVA\*******\*加密A\*******\*PI\*******\*）\****

 

 

讯通科技是上海的一个小咨询公司，创建于1992年，目前已经有600名以上的全职员工。请创建一个小mis(Management Information System)系统，主要完成对该公司员工信息的管理。在该系统中，员工信息存储在一个名为records的文本文件中。

 

111:02-98781999:Williams:Nick:T:35:Computer Officer:14-10-2000

112:02-99893878:Brown:Sarah:B:12:Electrician:09-02-1992

131:02-95673456:Couch:David:A:26:Consultant:23-04-1994

236:02-95437869:Anderson:Sarah:K:19:CEO:21-09-1988

553:03-99999999:Coles:David:M:12:Manager:12-12-1999

869:02-95671660:Jones:Sarah:B:45:Sales Manager:14-12-1995

148:02-93272658:Smith:John:C:43:Technical Manager:21-10-1988

372:02-12345678:Miller:Sam:B:22:Engineer:12-03-1998

059:02-95673455:Chen:Xiao:Y:26:Consultant:01-05-2003

812:02-98781987:Xue:Fei:L:35:Computer Officer:10-08-1998

619:02-95436669:Wang:Mengjie:X:26:Consultant:12-02-2001

 

员工信息必须满足以下规范

· employee payroll number:3位数字

· telephone number：XX-XXXXXXXX （X都为数字，详细要求见下文P8）

· name, (last name, first name, initial) （必须都为英文）

· department number, （都为数字）

· job title （必须都为英文）

· date of hiring.  XX-XX-XXXX（X都为数字）

 

以下是程序的主菜单页面，它实现以下七个功能 

\1. 在屏幕上显示所有当前员工记录。

\2. 在屏幕上显示所有当前的员工记录（格式化和排序） (工号)

\3. 在屏幕上仅显示姓名和电话号码.

\4. 在屏幕上仅显示名称和电话号码（格式化和排序）. （名字）

\5. 搜索并显示特定的员工记录.

\6. 将新记录添加到记录文件.

\7. 从记录文件中删除记录.

\8. 将记录更新到记录文件.

 

1 2 3 4主要实现的是显示功能，5实现的是查找功能，6实现的增加功能，7实现的是删除功能。

 

 

以下详细描述项目的需求

 

 

讯通科技 - Employee Information - Main Menu

=====================================================

 

1 - Print All Current Records

2 – Print All Current Records (formatted)

3 – Print Names and Phone Numbers

4 – Print Names and Phone Numbers (formatted)

5 - Search for specific Record(s)

6 - Add New Records

7 – Delete Records

 

Q - Quit

 

Your Selection: | **(waiting for user input)**

 

· 如果records数据文件不存在，程序应该提示并终止运行。

比如, 如果***\*records\*******\*.\*******\*txt\**** 不存在，应该显示 

“Required file – records, does not exist.”, 然后退出程序。

· 在menu菜单上，如果用户的选择输入的不是1, 2, 3, 4, 5, 6, 7或 Q, 程序应该显示"Invalid code! Press Enter to continue…" (这时候，程序的光标应该停在这个消息的后面，而不能停在下一行的开头). 当 用户重新敲回车后，最初的主菜单重新显示以便用户重新做选择。用户可以通过输入Q 或q退出程序.

· 在menu菜单上，如果用户的选择输入仅仅敲回车，应该提示"No selection entered. Press Enter to continue…"(这时候，程序的光标应该停在这个消息的后面，而不能停在下一行的开头). 当 用户重新敲回车后，最初的主菜单重新显示以便用户重新做选择。

 

***\*When the User Selects Option 1 - Print All Current Records\****

 

Here is a sample output from ***\*menu\**** when the user selects option 1 from the main menu:

 

**(The main menu here)**

 

Your Selection: ***\*1\**** **(user input)**

111:02-98781999:Williams:Nick:T:35:Computer Officer:14-10-2000

112:02-99893878:Brown:Sarah:B:12:Electrician:09-02-1992

131:02-95673456:Couch:David:A:26:Consultant:23-04-1994

236:02-95437869:Anderson:Sarah:K:19:CEO:21-09-1988

553:03-99999999:Coles:David:M:12:Manager:12-12-1999

869:02-95671660:Jones:Sarah:B:45:Sales Manager:14-12-1995

148:02-93272658:Smith:John:C:43:Technical Manager:21-10-1988

372:02-12345678:Miller:Sam:B:22:Engineer:12-03-1998

059:02-95673455:Chen:Xiao:Y:26:Consultant:01-05-2003

812:02-98781987:Xue:Fei:L:35:Computer Officer:10-08-1998

619:02-95436669:Wang:Mengjie:X:26:Consultant:12-02-2001

 

Press Enter to continue... **(Waiting here for the user to press** **Enter****. After the user presses** **Enter****, the main menu is displayed again)**

 

 

***\*When the User Selects Option 2 – Print All Current Records (formatted)\****

 

Here is a sample output when the user selects option 2 from the main menu:

 

**(The main menu here)**

 

Your Selection: ***\*2\**** **(user input)**

Anderson	Sarah	K	236	02-95437869	19	CEO	21-09-1988

Brown	Sarah	B	112	02-99893878	12	Electrician	09-02-1992

Chen	Xiao	Y	059	02-95673455	26	Consultant	01-05-2003

Coles	David	M	553	03-99999999	12	Manager	12-12-1999

Couch	David	A	131	02-95673456	26	Consultant	23-04-1994

Jones	Sarah	B	869	02-95671660	45	Sales Manager	14-12-1995

Miller	Sam	B	372	02-12345678	22	Engineer	12-03-1998

Smith	John	C	148	02-93272658	43	Technical Manager	21-10-1988

Wang	Mengjie	X	619	02-95436669	26	Consultant	12-02-2001

Williams	Nick	T	111	02-98781999	35	Computer Officer	14-10-2000

Xue	Fei	L	812	02-98781987	35	Computer Officer	10-08-1998

 

Press Enter to continue... **(Waiting here for the user to press** **Enter****. After the user presses** **Enter****, the main menu is displayed again)**

 

**(Note that the above output has been formatted and sorted by family name. Each column must be left justified.)**

 

 

 

***\*When the User Selects Option 3 – Print Names and Phone Numbers\****

 

Here is a sample output when the user selects option 3 from the main menu:

 

 

**(The main menu here)**

 

Your Selection: ***\*3\**** **(user input)**

Williams,Nick,02-98781999

Brown,Sarah,02-99893878

Couch,David,02-95673456

Anderson,Sarah,02-95437869

Coles,David,03-99999999

Jones,Sarah,02-95671660

Smith,John,02-93272658

Miller,Sam,02-12345678

Chen,Xiao,02-95673455

Xue,Fei,02-98781987

Wang,Mengjie,02-95436669

 

Press Enter to continue... **(Waiting here for the user to press** **Enter****. After the user presses** **Enter****, the main menu is displayed again)**

 

**(Note the difference between the above output and the content of the** **records** **file. The colons have been replaced by comma. For each entry, only the name and the phone number is displayed)**

***\*When the User Selects Option 4 – Print Names and Phone Numbers (formatted)\****

 

Here is a sample when the user selects 4 on the main menu,

 

**(The main menu here)**

 

Your Selection: ***\*4\**** **(user input)**

Anderson	Sarah	02-95437869

Brown	Sarah	02-99893878

Chen	Xiao	02-95673455

Coles	David	03-99999999

Couch	David	02-95673456

Jones	Sarah	02-95671660

Miller	Sam	02-12345678

Smith	John	02-93272658

Wang	Mengjie	02-95436669

Williams	Nick	02-98781999

Xue	Fei	02-98781987

 

Press Enter to continue... **(Waiting here for the user to press** **Enter****. After the user presses** **Enter****, the main menu is displayed again)**

 

**(Note that the above output has been formatted and sorted by family name. Each column must be left justified.)**

 

 

***\*When the User Selects Option 5 - Search for specific Record(s)\****

 

Here is a sample when the user selects 5 on the main menu,

 

**(The main menu here)**

 

Your Selection: ***\*5\**** **(user input)**

Enter keyword: ***\*Jones\**** **(user input)**

 

869:02-95671660:Jones:Sarah:B:45:sales manager:14-12-1995

 

Press Enter to continue... **(Waiting here for the user to press** **Enter****. After the user presses** **Enter****, the main menu is displayed again.)**

 

 

如果用户输入的关键字找不到匹配的员工记录，则生成下面页面

 

**(The main menu here)**

 

Your Selection: ***\*5\**** **(user input)**

Enter keyword: ***\*Monks\**** **(user input)**

Keyword – Monks - not found

 

Press Enter to continue... **(Waiting here for the user to press Enter. After the user presses** **Enter****, the main menu is displayed again.)**

如果用户没有输入任何关键字而直接按回车，则生成下面页面

 **(The main menu here)**

 

Your Selection, ***\*5\**** **(user input)**

Enter keyword: **(user simply presses the Enter key without typing in anything)**

 

No keyword entered – try again…

 

Enter keyword: **(still wanting for the user to type in something)**

 

· 用户输入的关键字应该是大小写不敏感的， (比如 JONES 和 jones产生一样的输出).

 

 

 

 **(The main menu here)**

 

Your Selection, ***\*6\**** **(user input)**

 

 

Adfaith Consulting – Employee Records:

======================================

 

Employee Record Additions:

 

Enter the following details of the new employee:

 

Employee 3 digit payroll number

Phone Number

Last Name

First Name

Middle Init

Dept #

Job Title

Date Hired

 

Enter employee 3 digit payroll number: ***\*123\**** **(user input)**

 

**(****你的程序应该强制要求用户输入一个有效的员工号，你的程序应该能够验证用户输入的合法性****)**

**If the user simply presses the** **Enter** **key, the following must be produced,**

Enter employee 3 digit payroll number: **(user simply presses the Enter key)**

***\*No payroll number entered – try again\****

Enter employee 3 digit payroll number: ***\*abc\**** **(****user inputs invalid characters)**

***\*Payroll number can contain only numerical characters\****

Enter employee 3 digit payroll number: **(waiting for the user to enter a valid payroll number)**

 

(工号是唯一的，一个员工的表征，如何确保工作不雷同呢？)


Enter Phone Number (02-12345678): ***\*02-90807986\**** **(user input)**

**(****你的程序应该强制要求用户输入一个有效的员工号，你的程序应该能够验证用户输入的合法性**

**如果用户什么名字都没输入而直接按回车，则产生下面的页面）**

***\*No phone number entered – try again\****

Phone Number (02-12345678), **(still waiting for the user to enter a valid phone number)**

 

**如果用户输入一个非法的电话号码，则产生下面的页面**

Enter Phone Number (02-12345678): ***\*abc123\**** **(user input)**

***\*Invalid phone number – try again\****

Enter Phone Number (02-12345678): **(still waiting for the user to enter a valid phone number)**

**对合法电话号码的约束如下：有效的电话区号是****02, 03, 04, 05, 06, 07, 08.** **电话号码的首位****(****不包括区号****)****可以是** **1** **到** **9** **之间的任意数字，** **后** **7****个数字可以是0** **到** **9** **之间的任意数字。一个有效电话号码的例子是** **02-95671600.** **无效电话号码的例子是****0363243416, 1099887766, 1299998877,** **等****.**

 

**（考虑使用正则表达式来进行字符串规范验证）**

 

Enter Last Name: ***\*Warren\**** **(user input)**

**(****一个合法的名只能是字母和空格的组合，如果用户输入一个非法的名字，则提示“*****\*Last name can contain only alphabetical characters and spaces\**** **”然后要求用户重新输入，如果用户什么名字都没输入而直接按回车，则提示*****\*No l\*******\*ast name entered – try again\**** **然后要求用户重新输入)**

 

Enter First Name: ***\*Todd\**** **(user input)**

**(****一个合法的姓只能是字母和空格的组合，如果用户输入一个非法的姓，则提示“*****\*First\**** ***\*name can contain only alphabetical characters and spaces\**** **”然后要求用户重新输入，如果用户什么名字都没输入而直接按回车，则提示*****\*No\**** ***\*First\**** ***\*name entered – try again\**** **然后要求用户重新输入****)**

 

Enter Middle Init: ***\*L\**** **(user input****)**

**(****一个合法的职位只能是字母和空格的组合，如果用户输入一个非法的职位，则提示“**Middle Init ***\*can contain only alphabetical characters and spaces\**** **”然后要求用户重新输入，如果用户什么名字都没输入而直接按回车，则提示*****\*No\**** Middle Init ***\*entered – try again\**** **然后要求用户重新输入****.)**

 

Enter Dept #: ***\*20\**** **(user input)**

**(****一个合法的部门号码只能是数字。如果用户输入一个非法的部门号码，则提示“** Dept # can contain only digits with no spaces**”然后要求用户重新输入，如果用户什么名字都没输入而直接按回车，则提示*****\*No\**** ***\*Dept #\**** ***\*entered – try again\**** **然后要求用户重新输入)****)**

 

Enter Job Title: E***\*ngineer\**** **(user input)**

**(****一个合法的职称只能是字母和空格的组合，如果用户输入一个非法的职位，则提示“**Job title ***\*can contain only alphabetical characters and spaces\**** **”然后要求用户重新输入，如果用户什么名字都没输入而直接按回车，则提示*****\*No\**** Job title ***\*entered – try again\**** **然后要求用户重新输入)**

 

Enter Date Hired (dd-mm-yyyy): ***\*21-02-1996\**** **(user input)**

 

**（你的程序必须能够判断日期的有效性，比如 30-02-1998无疑就是一个错误的日期格式！**

**如果日期格式错误，则提示** ***\*Invalid Date Hired\******然后要求用户重新输入，如果用户什么名字都没输入而直接按回车，，则提示*****\*No d\*******\*ate hired entered – try again\******然后要求用户重新输入)**

 

 

Record Saved 

 

**（只有在上述信息都验证通过后，这个信息才会显示！接着再跳出提示，询问是否继续添加新记录****.)**

 

Add another employee record? (y)es or (n)o, ***\*y\**** **(user input)**

如果用户敲入y,则重新跳出新增加页面***\*，\****如果用户敲入***\*n\****, 那么离开add.java返回到主菜单页面 以便用户做新的选择，如果用户不小心敲不是n或y的其它字符，也一样返回到主菜单。

 

 

.Here is a sample output of ***\*delete.java\****

,

 

**(The main menu here)**

 

Your Selection, ***\*7\**** **(user input)**

 

**(Clear the user screen first)**

 

Adfaith Consulting – Employee Records:

======================================

 

Employee Record Deletion:

 

Enter employee’s 3 digit payroll number to enable file deletion: ***\*869\**** **(user input)**

 

869:02-95671660:Jones:Sarah:B:45:sales manager:14-12-1995

 

**(****你的程序必须验证员工号的有效性，否则产生如下页面的提示)**

**如果用户什么都没输入而直接按回车，则生产如下页面的提示）**

Enter employee 3 digit payroll number: **(user simply presses the Enter key)**

***\*No payroll number entered – try again\****

Enter employee 3 digit payroll number: ***\*abc\**** **(user inputs invalid characters)**

***\*Payroll number can contain only numerical characters\****

Enter employee 3 digit payroll number: **(waiting for the user to enter a valid payroll number)**

 

Confirm record deletion, (y)es or (n)o, ***\*y\**** **(user input)**

 

Record deleted. **(****只有在记录确实从records删除后才会出现该提示****.)**

 

**)**

 

Delete another? (y)es or (n)o, ***\*y\**** **(user input)**

 

 

**(****如果用户输入的不是y，而是n或者其它字符都跳回主菜单页面)****)**

 

 

**如果按用户的输入找不到相关匹配的记录，则产生的页面如下列所示**

 

Adfaith Consulting – Employee Records:

======================================

 

Employee Record Deletion:

 

Enter employee’s 3 digit payroll number to enable file deletion: ***\*123\**** **(user input)**

 

Employee record for ***\*123\**** not found!

 

Press Enter to continue ...

**(****这时候光标应该能停在本行末，当用户输入enter后重新回到主菜单页面****.)**

#  

 