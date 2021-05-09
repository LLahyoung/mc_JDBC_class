package mc.sn.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestBasicDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	TestBasicDB testDB = new TestBasicDB();
	try {
		testDB.selectGisaTable();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void selectGisaTable() throws ClassNotFoundException, SQLException {
		
		String sql = "select * from gisaTBL where localCode =?";
		Connection con = this.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "B");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int stdNo = rs.getInt(1);
			String email = rs.getString("email");
			String localCode =rs.getString("localCode");
			System.out.println(stdNo + " , " + email +  " , " + localCode);
		}
		
		rs.close();
		pstmt.close();
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id = "hr";
		String pwd = "1234";
		
		Class.forName(driver);
		con = DriverManager.getConnection(jdbcURL, id, pwd);
		
		return con;
		
	}

}
