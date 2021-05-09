package mc.sn.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class reviewDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reviewDatabase DB = new reviewDatabase();
		try {
			DB.query1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void query2() {
		String sql = "INSERT INTO gisaTBL values (?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = this.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, 0);
			int affectedCount = stmt.executeUpdate();
			if (affectedCount > 0)
				System.out.println("성공");
			else
				System.out.println("실패");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException se) {

			}
		}
	}

	public void query1() throws ClassNotFoundException, SQLException {
		Connection con = this.getConnection();
		Statement stmt = con.createStatement();

		String sql = "INSERT INTO testTBL2(id, userNAME, age)\r\n" + "VALUES (4, 'kim',20)";
		int affectedCount = stmt.executeUpdate(sql);
		if (affectedCount > 0)
			System.out.println("성공");
		else
			System.out.println("실패");

		con.close();
		stmt.close();
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id = "hr";
		String pwd = "1234";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbcURL, id, pwd);

		return con;
	}
}
