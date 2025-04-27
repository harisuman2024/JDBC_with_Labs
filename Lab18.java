package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab18 {
	public static void displayRow(ResultSet rs) throws SQLException {
		int cid = rs.getInt(1);
		String cn = rs.getString(2);
		String em = rs.getString(3);
		int ph = rs.getInt(4);
		String ci = rs.getString(5);
		System.out.println(cid + "\t" + cn + "\t" + em + "\t" + ph + "\t" + ci);
	}

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			String SQL = "select * from mycustomers";
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(SQL);
			System.out.println("RS Type : " + st.getResultSetType());
			System.out.println("RS Updatability : " + st.getResultSetConcurrency());
			System.out.println("RS Holdability : " + st.getResultSetHoldability());
			System.out.println("---------Forward Order-------");
			
			while (rs.next()) {
				displayRow(rs);
			}
			System.out.println("---------Reverse Order-------");
			while (rs.previous()) {
				displayRow(rs);
			}
			
			System.out.println(rs.isBeforeFirst());
			System.out.println(rs.isFirst());
			rs.first();
			System.out.println(rs.isBeforeFirst());
			System.out.println(rs.isFirst());
			System.out.println("1st Record");
			displayRow(rs);
			System.out.println(rs.isAfterLast());
			System.out.println(rs.isLast());
			rs.last();
			System.out.println(rs.isAfterLast());
			System.out.println(rs.isLast());
			System.out.println("Last Record");
			displayRow(rs);
			rs.absolute(5);
			System.out.println("5th Record");
			displayRow(rs);
			rs.relative(2);
			System.out.println("7th Record");
			displayRow(rs);
			rs.relative(-3);
			System.out.println("4th Record");
			displayRow(rs);
			System.out.println("----Done-----");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleaup(rs, st, con);
		}
	}
}