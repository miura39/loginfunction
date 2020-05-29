package util;

import common.ProductException;
import dao.AccountDAO;

public class ProductValidation {

	public void checkProductID(AccountDAO pib, String id) throws ProductException{

		if(id.contentEquals("")) {
				throw new ProductException("1001W",new Exception());
			}else if(id.length() != 8) {
				throw new ProductException("1002W",new Exception());
			}else if(id.matches("^[a-zA-Z0-9]*$) != true")){
				throw new ProductException("1003W",new Exception());
			}
	}
}
