package com.hello_hari.jdbc;

import java.sql.SQLException;
import javax.sql.RowSet;
import com.sun.rowset.CachedRowSetImpl;

public class Lab23 {
    public static void main(String[] args) {
        RowSet myrowset = null;
        try {
            String SQL = "select * from mycustomers where city='Blore'";

            myrowset = new CachedRowSetImpl();
            myrowset.setUrl("jdbc:mysql://localhost:3306/myjdbcdb?useSSL=false&allowPublicKeyRetrieval=true");
            myrowset.setUsername("root");
            myrowset.setPassword("Mysql!@#108");
            myrowset.setCommand(SQL);
            
            myrowset.execute();  // ****** 

            while (myrowset.next()) {
                int cid = myrowset.getInt(1);
                String cn = myrowset.getString(2);
                String em = myrowset.getString(3);
                int ph = myrowset.getInt(4);
                String ci = myrowset.getString(5);
                
                System.out.println(cid + "\t" + cn + "\t" + em + "\t" + ph + "\t" + ci);
            }
            System.out.println("----Done-----");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (myrowset != null) myrowset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
