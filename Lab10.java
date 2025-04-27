package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab10 {
public static void main(String[] args) { 
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
String SQL1="insert into mycustomers values(201,'aa','aa@jlc',111,'Blore') ";
String SQL2="update mycustomers set phone=12345 where phone=111";
String SQL3="select * from mycustomers where city='Blore'";
try {
con=JDBCUtil.getConnection();
//ps=con.prepareStatement(SQL1);
//ps=con.prepareStatement(SQL2);
ps=con.prepareStatement(SQL3);
boolean b=ps.execute();
if(b==false) {
System.out.println("Submited - Updatable Op");
int x=ps.getUpdateCount();
System.out.println("Records Updated : " + x);
}else {
System.out.println("Submited - Select Op");
rs=ps.getResultSet();
while(rs.next()) {
int cid= rs.getInt(1);
String cn=rs.getString(2);
String em=rs.getString(3);
int ph=rs.getInt(4);
String ci=rs.getString(5);
System.out.println(cid+"\t"+cn+"\t"+em+"\t"+ph+"\t"+ci);
}
}
}catch(Exception ex) {
ex.printStackTrace();
}finally {
JDBCUtil.cleaup(rs, ps, con);
}
}
}
