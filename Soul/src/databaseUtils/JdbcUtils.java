package databaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBBASICURL = "jdbc:mysql://localhost:3306?characterEncoding=gbk&useSSL=true";
	private static final String DBURL = "jdbc:mysql://localhost:3306/SoulOfHero?characterEncoding=gbk&useSSL=true";
	private static final String DBUSER = "root";
	private static final String DBPASS = "1234";
	
	static{
		try{
			Class.forName(DBDRIVER);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private JdbcUtils(){}
	
	public static Connection getBasicConnection() throws SQLException {
		return DriverManager.getConnection(DBBASICURL, DBUSER, DBPASS);
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	}
	
	public static void free(ResultSet rs, Statement st, Connection con){
		try{
			if(rs != null) {
				rs.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(st != null) {
					st.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try{
					if(con != null) {
						con.close();
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void buildDatabase() {
		
	}
}
