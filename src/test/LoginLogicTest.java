package test;

import java.lang.reflect.InvocationTargetException;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[] args) throws InvocationTargetException {
		testExecute1(); //ログイン成功のテスト
		testExecute2(); //ログイン失敗のテスト
	}
	public static void testExecute1() throws InvocationTargetException {
		Login login = new Login("testname","1234");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if(result) {
			System.out.println("testExecute1:成功しました");
		}else {
			System.out.println("testExcute1:;失敗しました");
		}
	}
	public static void testExecute2() throws InvocationTargetException {
		Login login = new Login("testname","12345");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if(!result) {
			System.out.println("testExecute2:成功しました");
		}else {
			System.out.println("testExecute2:失敗しました");
		}
	}
}
