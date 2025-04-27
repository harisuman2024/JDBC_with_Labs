package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab4 {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = JDBCUtil.getConnection();
            String SQL = "select * from mycustomers";
            st = con.createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                int cid = rs.getInt(1);
                String cname = rs.getString(2);
                String email = rs.getString(3);
                int phone = rs.getInt(4);
                String city = rs.getString(5);
                System.out.println(cid + "\t" + cname + "\t" + email + "\t" + phone + "\t" + city);
            }
            System.out.println("----Done-----");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.cleaup(rs, st, con);
        }
    }
}
