package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			String sql = "SELECT id,userName,text FROM MUtter ORDER BY id DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);


			//SELECT文を実行し、結果を取得
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
			int id = rs.getInt("ID");
			String userName = rs.getString("NAME");
			String text = rs.getString("TEXT");

			Mutter mutter = new Mutter(id,userName,text);
			mutterList.add(mutter);

			}

	}catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
		return mutterList;

	}
}
