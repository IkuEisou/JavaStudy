package dbtools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface OperateDB {
	public static void execute() {
		Connection conn;
		try {
			// Oracle JDBC Driverのロード
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "1030");
			Statement st = conn.createStatement();
			queryJob(st);

			queryEmp(st);

			st.close();

			// 接続をクローズ
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void queryJob(Statement st) throws SQLException {
		String sql = "select * from HR.JOBS";
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			// 列番号による指定
			String res = rs.getString(1) + "\t" + rs.getString(2);
			System.out.println(res);
		}
		// 結果セットをクローズ
		rs.close();
		System.out.println("查询结束");
	}

	public static void queryEmp(Statement st) throws SQLException {
		String sql;
		ResultSet rs;
		sql = "select * from HR.EMPLOYEES";
		rs = st.executeQuery(sql);
		while (rs.next()) {
			// 列番号による指定
			String res = rs.getInt(1) + "\t" + rs.getString(2);
			System.out.println(res);
		}
		
		// 結果セットをクローズ
		rs.close();
		System.out.println("查询结束");
	}
}
