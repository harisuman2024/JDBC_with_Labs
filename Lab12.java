package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab12 {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cs = null;
		int mysid = 102;

		try {

			con = JDBCUtil.getConnection();
			String SQL = "{call findBalance(?,?)}";

			cs = con.prepareCall(SQL);
			cs.setInt(1, mysid);
			cs.registerOutParameter(2, Types.DOUBLE);
			cs.execute();

			double bal = cs.getDouble(2);
			System.out.println("Balance : " + bal);

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			JDBCUtil.cleaup(cs, con);
		}
	}
}