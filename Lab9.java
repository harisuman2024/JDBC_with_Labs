package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab9 {
public static void main(String[] args) {
Connection con=null;
Statement st=null;
ResultSet rs=null;
String SQL1="insert into mycustomers values(201,'aa','aa@jlc',111,'Blore') ";
String SQL2="update mycustomers set phone=5599 where phone=12345";
String SQL3="select * from mycustomers";
try {
con=JDBCUtil.getConnection();
st=con.createStatement();
//boolean b=st.execute(SQL1);
//boolean b=st.execute(SQL2);
boolean b=st.execute(SQL3); 
if(b==false) {
System.out.println("Submited - Updatable Op");
int x=st.getUpdateCount();
System.out.println("Records Updated : " + x);
}else {
System.out.println("Submited - Select Op");
rs=st.getResultSet();
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
JDBCUtil.cleaup(rs, st, con);
}
}
}

