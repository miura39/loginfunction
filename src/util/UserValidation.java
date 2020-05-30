package util;

import bean.UserInfoBean;
import common.ProductException;

public class UserValidation{

	public void idCheck(UserInfoBean uib) throws ProductException {


		String id = uib.getUserID();

		if(id.equals("")) {
			throw new ProductException("1001W",new Exception());
		}else if(id.length()>5) {
			throw new ProductException("1002W",new Exception());
		}else if(id.matches("^[a-zA-Z0-9]*$")) {
			throw new ProductException("1003W",new Exception());
		}
	}
}

