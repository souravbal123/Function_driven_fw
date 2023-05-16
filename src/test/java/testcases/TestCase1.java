package testcases;

import org.testng.annotations.Test;

import library.Library;

public class TestCase1 extends Library {
	@Test
	public void tc1_Login_Validation() throws Throwable {
		login();
		login_Validation();
	}
}
