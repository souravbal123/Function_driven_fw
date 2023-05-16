package testcases;

import org.testng.annotations.Test;

import library.Library;

public class TestCase3 extends Library {
	@Test
	public void tc3_newUser_Validation() throws Throwable {
		new_User_Creation("jacky", "kumar", "jack_kumar", "Jack@123");
		new_User_Validation("jack_kumar", "Jack@123");

	}
}
