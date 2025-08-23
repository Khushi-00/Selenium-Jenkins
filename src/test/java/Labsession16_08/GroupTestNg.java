package Labsession16_08;

import org.testng.annotations.Test;

public class GroupTestNg {

	@Test (groups = {"Smoke"})
	public void loginTest() {
		System.out.println("loginTest is executed");

	}
	@Test (groups = {"Regression"})
	public void paymentTest() {
		System.out.println(" paymentTest is executed");

	}
	@Test (groups = {"Smoke"})
	public void logoutTest() {
		System.out.println("logoutTest is executed");
}
}
