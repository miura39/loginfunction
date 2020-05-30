package bean;

/**
 *
 * @author miurayuuichirou
 *
 */

public class UserInfoBean {

	private String userID ="";
	private String userName="";
	private String password="";

	public void reset() {
		this.userID="";
		this.password="";
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
