package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab3 {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try {
            // Step 1: Get Connection using utility
            con = JDBCUtil.getConnection();

            // Step 2: SQL without 'cid' (assumes it's AUTO_INCREMENT)
            String SQL = "INSERT INTO mycustomers (cname, email, phone, city) VALUES ('hello', 'hello@jlc', 12345, 'Blore')";

            // Step 3: Create and execute statement
            st = con.createStatement();
            int x = st.executeUpdate(SQL);

            // Step 4: Handle result
            if (x == 1) {
                System.out.println("Customer Record Inserted Successfully");
            } else {
                System.out.println("Sorry, Customer Record Was Not Inserted");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Step 5: Cleanup
            JDBCUtil.cleaup(st, con);
        }
    }
}
