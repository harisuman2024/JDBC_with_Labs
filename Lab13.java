package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab13 {
public static void main(String[] args) {
Connection con=null;
CallableStatement cs=null;
int mysid= 102;
try {
con=JDBCUtil.getConnection();
String SQL="{call findGrade(?)}";
cs=con.prepareCall(SQL);
cs.setInt(1, mysid);
cs.execute();
System.out.println("Done- Call Completed : ");
}catch(Exception ex) {
ex.printStackTrace();
}finally {
JDBCUtil.cleaup(cs, con);
}
}
}