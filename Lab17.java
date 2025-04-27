package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab17 {
public static void main(String[] args) {
	Connection con=null;
	PreparedStatement ps=null;
	Object [][] mycustomers= {
	{507,"dd","dd@jlc",444,"Hyd"},
	{508,"ee","ee@jlc",555,"Hyd"},
	{509,"ff","ff@jlc",666,"Blore"},
	{510,"ff","ff@jlc",666,"Blore"},
	};
	try {
	con=JDBCUtil.getConnection();
	String SQL="insert into mycustomers values(?,?,?,?,?)";
	ps=con.prepareStatement(SQL);
	for( Object [] mycust : mycustomers) {
	int paramNum=1;
	for(Object obj:mycust) {
	ps.setObject(paramNum++, obj);
	}
	ps.addBatch();
	}
	int results[]= ps.executeBatch();
	for(int x : results) {
	System.out.println(x);
	}
	System.out.println("Done !!! ");
	}catch(Exception ex) {
	ex.printStackTrace();
	}finally {
	JDBCUtil.cleaup(ps, con);
	}
	}
	}