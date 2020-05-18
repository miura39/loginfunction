package dao;

import java.sql.Connection; //DBMSへの接続や切断
import java.sql.DriverManager;//DBMSへの接続準備
import java.sql.PreparedStatement;//SQLの送信を行う
import java.sql.ResultSet;//DBMSから検索結果を受け取る
import java.sql.SQLException;//データベースに関するエラー情報を提供する

import model.Account;
import model.Login;


public class AccountDAO {
	//データベース接続に使用する情報
	private final String URL = "jdbc:mysql://localhost:3306/login?useSSL=false";
	private final String USER = "user1";
	private final String PASS = "password";
	
	public Account findbyLogin(Login login) {
		Account account = null;
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(URL,USER,PASS)){
			//SELECT文を準備
			String sql = "SELECT USER_ID,PASS,MAIL,NAME,AGE FROM ACCOUNT WHERE USER_ID = ?AND PASS = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserId());
			pstmt.setString(2, login.getPass());
			
			//SELECT文を実行し、結果を取得
			ResultSet rs = pstmt.executeQuery();
			
			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを作成
			if(rs.next()) {
				//SELECTの結果を取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("MAIL");
				int age = rs.getInt("AGE");
				account = new Account(userId,pass,mail,name,age);
			}
		}catch(SQLException e) {
			//データベースに関するエラー情報を提供する 
			//catchを先に記述しておくと良い。try文でエラーが出るため。
			e.printStackTrace();
		}
		//見つかったユーザーまたはnullで返す
		return account;
	}
	

}
