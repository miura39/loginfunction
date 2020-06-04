package dao;

public class MutterDAO {
	//データベース接続に使用する情報
	//注）権限を与えること。GRANT ALL PRIVILEGES ON　〜〜〜〜
	//注）JDBCのビルドパスを設定すること。
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private final String URL = "jdbc:mysql://localhost:3306/loginaccounts?useSSL=false";
	private final String URL = "jdbc:mysql://localhost:3306/loginaccounts";
	private final String USER = "user1";
	private final String PASS = "password";




}
