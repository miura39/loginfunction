package model;

import dao.AccountDAO;

public class LoginLogic {
	
	public boolean execute(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findbyLogin(login);
		return account !=null;
	}
}
