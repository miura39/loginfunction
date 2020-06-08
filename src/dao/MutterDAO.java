package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import model.Mutter;


public class MutterDAO {
	//データベース接続に使用する情報
	//注）権限を与えること。GRANT ALL PRIVILEGES ON　〜〜〜〜
	//注）JDBCのビルドパスを設定すること。
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private final String URL = "jdbc:mysql://localhost:3306/loginaccounts?useSSL=false";
	private final String URL = "jdbc:mysql://localhost:3306/loginaccounts";
	private final String USER = "user1";
	private final String PASS = "password";

	public List<Mutter> findAll(){
		List<Mutter> mutterList = new ArrayList<>();


		try{
			//データベースへ接続ß
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL,USER,PASS);

			//SELECT文を準備
			String sql = "SELECT USER_ID,PASS,MAIL,NAME,AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserId());
			pstmt.setString(2, login.getPass());

			//SELECT文を実行し、結果を取得
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
			String userId = rs.getString(columnIndex);
			String pass = rs.getString("pass");

			}
		}
	}
}
