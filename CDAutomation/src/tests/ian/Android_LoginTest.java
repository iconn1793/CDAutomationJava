package tests.ian;

import elements.Drivers;
import elements.LoginWith;

public class Android_LoginTest extends Drivers {
	
	LoginWith loginAs = new LoginWith();
	
	public void Login() throws Exception {
		loginAs.user("testacct01", "test01" );
	}
}
