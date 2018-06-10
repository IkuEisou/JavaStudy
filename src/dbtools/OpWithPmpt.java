/**
 * 
 */
package dbtools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cleve
 *
 */
public class OpWithPmpt {
	public static void execute() {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "1030");
			
			PreparedStatement st = conn.prepareStatement("select * from HR.JOBS");
			ResultSet rs = st.executeQuery();;
			while (rs.next()) {
				// 列番号による指定
				String res = rs.getString("JOB_ID") + "\t" + rs.getString("JOB_TITLE");
				System.out.println(res);
			}
//			rs.close();
			
			System.out.println("----------------------------------------------------------------");
			st = conn.prepareStatement("select * from HR.EMPLOYEES");
			rs = st.executeQuery();
			while (rs.next()) {
				// 列番号による指定
				String res = rs.getInt("EMPLOYEE_ID") + "\t" + rs.getString("FIRST_NAME");
				System.out.println(res);
			}
			rs.close();
			st.close();

			// 接続をクローズ
			conn.close();
			
			System.out.println("查询结束");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
