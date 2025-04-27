package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab8 {
public static void main(String[] args) {
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
String mycity="Blore";
try {
con=JDBCUtil.getConnection();
String SQL="select * from mycustomers where city=?";
ps=con.prepareStatement(SQL);
ps.setString(1, mycity);
rs=ps.executeQuery();
while(rs.next()) {
int cid= rs.getInt(1);
String cn=rs.getString(2);
String em=rs.getString(3);
int ph=rs.getInt(4);
String ci=rs.getString(5);
System.out.println(cid+"\t"+cn+"\t"+em+"\t"+ph+"\t"+ci);
}
System.out.println("----Done-----"); 
}catch(Exception ex) {
ex.printStackTrace();
}finally {
JDBCUtil.cleaup(rs, ps, con);
}
}
}