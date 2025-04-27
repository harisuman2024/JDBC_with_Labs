package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

public class Lab19 {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String SQL = "select * from mycustomers";
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(SQL);

            System.out.println("RS Type : " + st.getResultSetType());
            System.out.println("RS Updatability : " + st.getResultSetConcurrency());
            System.out.println("RS Holdability : " + st.getResultSetHoldability());

            // Insert Record into RS
            rs.moveToInsertRow();
            rs.updateInt(1, 503); // Changed from 502 to 503
            rs.updateString(2, "hai");
            rs.updateString(3, "hai@jlc");
            rs.updateInt(4, 555);
            rs.updateString(5, "Blore");
            rs.insertRow(); // Insert the Row in DB

            // Update the Row 6
            rs.absolute(6);
            rs.updateString(2, "test");
            rs.updateString(3, "test@jlc");
            rs.updateInt(4, 666);
            rs.updateRow(); // update the row in DB

            // Delete the Row 8
            rs.absolute(8);
            rs.deleteRow();

            // Delete the Row 9
            rs.absolute(9);
            rs.deleteRow();

            // Display all rows
            rs.beforeFirst();
            System.out.println("---------Forward Order-------");
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
            JDBCUtil.cleaup(rs, st, con);
        }
    }
}
