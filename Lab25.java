package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.DataSourceUtil;

public class Lab25 {
public static void main(String[] args) {
Connection con = null;
PreparedStatement ps=null;
int dd = 16;
int mm = 6;
int yy = 1979;
Date dob = new Date(yy - 1900, mm - 1, dd); //1 
try {
con=DataSourceUtil.getConnection();
String SQL = "insert into mystudents values(?,?,?)";
ps=con.prepareStatement(SQL);
ps.setInt(1, 103);
ps.setString(2, "Srinivas");
ps.setDate(3,dob); //2
int x= ps.executeUpdate();
System.out.println(x);
System.out.println("----Done-----");
} catch (Exception ex) {
ex.printStackTrace();
} finally {
DataSourceUtil.cleanUp(ps, con);
}
}
}
