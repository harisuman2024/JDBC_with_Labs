package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab15 {
	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		
		try {
			con = JDBCUtil.getConnection();
			String SQL1 = "insert into mycustomers values(501,'aa','aa@jlc',111,'Blore')";
			String SQL2 = "insert into mycustomers values(502,'bb','bb@jlc',222,'Blore')";
			String SQL3 = "insert into mycustomers values(503,'cc','cc@jlc',222,'Blore')";
			
			String SQL4 = "update mycustomers set phone=55555 where cid=101";
			String SQL5 = "update mycustomers set phone=99999 where city='Hyd'";
			
			String SQL6 = "delete from mycustomers where cid=201";
			
			st = con.createStatement();
			
			st.addBatch(SQL1);
			st.addBatch(SQL2);
			st.addBatch(SQL3);
			st.addBatch(SQL4);
			st.addBatch(SQL5);
			st.addBatch(SQL6);
			int results[] = st.executeBatch();
			for (int x : results) {
				System.out.println(x);
			}
			System.out.println("Done !!! ");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleaup(st, con);
		}
	}
}