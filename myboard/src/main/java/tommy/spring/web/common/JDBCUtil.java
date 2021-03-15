package tommy.spring.web.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1","mytest","9654");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(PreparedStatement ps,Connection con) {
		if(ps !=null) {
			try {
				if(!ps.isClosed()) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ps = null;
			}
		}
		if(con != null) {
			try {
				if(!con.isClosed()) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				con = null;
			}
		}
	}
	public static void close(ResultSet rs,PreparedStatement ps, Connection con) {
		if(rs !=null) {
			try {
				if(!rs.isClosed())rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		if(ps != null) {
			try {
				if(!ps.isClosed())ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ps = null;
			}
		}
		if(con != null) {
			try {
				if(!con.isClosed())con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				con = null;
			}
		}
	}
}
