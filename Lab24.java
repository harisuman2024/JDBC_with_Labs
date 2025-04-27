package com.hello_hari.jdbc;

import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource; // ✅ Use dbcp2
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab24 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            BasicDataSource myds = new BasicDataSource();
            myds.setDriverClassName("com.mysql.cj.jdbc.Driver"); // ✅ Updated driver class
            myds.setUrl("jdbc:mysql://localhost:3306/myjdbcdb?useSSL=false&allowPublicKeyRetrieval=true");
            myds.setUsername("root");
            myds.setPassword("Mysql!@#108");
            myds.setInitialSize(10);
            myds.setMaxTotal(100); // ✅ dbcp2 uses setMaxTotal, not setMaxActive

            con = myds.getConnection();
            String SQL = "select * from mycustomers";
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int cid = rs.getInt(1);
                String cn = rs.getString(2);
                String em = rs.getString(3);
                int ph = rs.getInt(4);
                String ci = rs.getString(5);
                System.out.println(cid + "\t" + cn + "\t" + em + "\t" + ph + "\t" + ci);
            }

            System.out.println("----Done-----");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.cleanup(rs, ps, con);
        }
    }
}
