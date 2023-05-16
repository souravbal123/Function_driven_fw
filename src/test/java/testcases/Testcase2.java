package testcases;

import org.testng.annotations.Test;

import library.Library;

public class Testcase2 extends Library {
@Test
public void tc2_logout_Validation() throws Throwable {
	login();
	logout();
	logout_Validation();
}
}
