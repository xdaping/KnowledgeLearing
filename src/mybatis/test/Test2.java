package mybatis.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Test2 {
	public static final String url = "jdbc:mysql://172.16.170.97:3306/mybatis?useUnicode=true&amp;characterEncoding=gbk";
	
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "123456";
	
	public static Connection conn = null;
	public static PreparedStatement pst = null;


	public static void main(String[] args) throws Exception {
		open();//打开连接
		
		insertData();
		
		selectData();
		
		close();//关闭连接
	}
	
	private static void insertData() {
		String sql = "INSERT INTO users(NAME, age) VALUES('daping平', 27);";//SQL语句
		System.out.println(sql);
		
		try {
			pst = conn.prepareStatement(sql);//准备执行语句
			pst.execute(sql);//执行语句，得到结果集
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private static void selectData() {
		String sql = "select * from users";//SQL语句
		System.out.println(sql);
		
		try {
			pst = conn.prepareStatement(sql);//准备执行语句
			ResultSet ret = pst.executeQuery();//执行语句，得到结果集
			while (ret.next()) {
				String uid = ret.getString(1);
				String ufname = ret.getString(2);
				
				System.out.println(uid+":"+ufname);
			}//显示数据
			ret.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void open() {
		try {
			Class.forName(name);//指定连接类型
			conn = DriverManager.getConnection(url, user, password);//获取连接			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			conn.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

