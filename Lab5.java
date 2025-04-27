package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab5 {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        // Customer data (no need to set 'cid')
        String mycname = "bbb";
        String myemail = "bbb@jlc";
        int myphone = 222;
        String mycity = "Blore";

        try {
            con = JDBCUtil.getConnection();

            // Skip 'cid' if it's auto-increment
            String SQL = String.format(
                "INSERT INTO mycustomers (cname, email, phone, city) VALUES ('%s', '%s', %d, '%s')",
                mycname, myemail, myphone, mycity
            );

            System.out.println(SQL); // Just for debugging

            st = con.createStatement();
            int x = st.executeUpdate(SQL);

            if (x == 1) {
                System.out.println("Customer Record is Inserted Successfully");
            } else {
                System.out.println("Sorry, Customer Record is Not Inserted");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.cleaup(st, con);
        }
    }
}
