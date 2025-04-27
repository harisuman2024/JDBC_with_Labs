package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab16 {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		Object[][] mycustomers = { { 504, "dd", "dd@jlc", 444, "Hyd" }, { 505, "ee", "ee@jlc", 555, "Hyd" },
				                                              { 506, "ff", "ff@jlc", 666, "Blore" }, };
		
		try {
			con = JDBCUtil.getConnection();
			
			String SQL = "insert into mycustomers values(?,?,?,?,?)";
			ps = con.prepareStatement(SQL);
			
			for (Object[] mycust : mycustomers) {
				
				ps.setInt(1, (int) mycust[0]);
				ps.setString(2, (String) mycust[1]);
				ps.setString(3, (String) mycust[2]);
				ps.setInt(4, (int) mycust[3]);
				ps.setString(5, (String) mycust[4]);
				ps.addBatch();
			}
			
			int results[] = ps.executeBatch();
			for (int x : results) {
				System.out.println(x);
			}
			System.out.println("Done !!! ");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleaup(ps, con);
		}
	}
}