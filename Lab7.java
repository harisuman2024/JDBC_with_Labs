package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab7 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;

        String mycname = "bbb";
        String myemail = "bbb@jlc";
        int myphone = 222;
        String mycity = "Blore";

        try {
            con = JDBCUtil.getConnection();
            String SQL = "insert into mycustomers(cname, email, phone, city) values(?, ?, ?, ?)";
            ps = con.prepareStatement(SQL);

            ps.setString(1, mycname);
            ps.setString(2, myemail);
            ps.setInt(3, myphone);
            ps.setString(4, mycity);

            int x = ps.executeUpdate();
            if (x == 1) {
                System.out.println("Customer Record is Inserted Successfully");
            } else {
                System.out.println("Sorry, Customer Record is Not Inserted");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.cleaup(ps, con);
        }
    }
}
