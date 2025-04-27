package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab14 {
public static void main(String[] args) {
	
Connection con=null;
CallableStatement cs=null;

int mysid= 104;

try {
con=JDBCUtil.getConnection();
String SQL="{call findMyGrade(?,?,?,?,?)}";
cs=con.prepareCall(SQL);
cs.setInt(1, mysid);
cs.registerOutParameter(2, Types.INTEGER);
cs.registerOutParameter(3, Types.DOUBLE);
cs.registerOutParameter(4, Types.CHAR);
cs.registerOutParameter(5, Types.CHAR);

cs.execute();

int total= cs.getInt(2);
double avg = cs.getDouble(3);
String status= cs.getString(4);
String grade= cs.getString(5);

System.out.println("Total : \t"+total);
System.out.println("Avg : \t"+avg);
System.out.println("Status : \t"+status);
System.out.println("Grade : \t"+grade); 
}catch(Exception ex) {
ex.printStackTrace();
}finally {
JDBCUtil.cleaup(cs, con);
}
}
}

