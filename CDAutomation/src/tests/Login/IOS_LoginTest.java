package tests.Login;

import elements.IOSDrivers;
import elements.IOS_LoginWith;

public class IOS_LoginTest extends IOSDrivers {
	
	IOS_LoginWith loginAs = new IOS_LoginWith();
	
	public void Login() throws Exception {
		loginAs.user("testacct01\n", "test01\n");
	}
}
