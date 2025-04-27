package com.hello_hari.jdbc;

import java.sql.*;

public class Lab2 {
    public static void main(String[] args) {
    	
    	Connection con = null;
    	Statement st = null;
    	ResultSet rs = null;
    	
        try {
            // Step 1: Load the Driver Class.
            Class.forName("com.mysql.cj.jdbc.Driver");

          //Step 2: Open the Connection 
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/myjdbcdb?useSSL=false", // Disabling SSL
                "root",
                "Mysql!@#108"
            );

            //Step 3: Prepare SQL Statement
            String SQL="select * from mycustomers where city='Hy' "; 

          //Step 4: Create the JDBC Statement
             st = con.createStatement();

            // Step 5: Submit SQL to DB.
            rs=st.executeQuery(SQL);

            // Step 6: Process Results.
            while(rs.next()) {
            	int cid= rs.getInt(1);
            	String cname=rs.getString(2);
            	String email=rs.getString(3);
            	int phone=rs.getInt(4);
            	String city=rs.getString(5);
            	System.out.println(cid+"\t"+cname+"\t"+email+"\t"+phone+"\t"+city);
            	} 
            
            System.out.println("----Done-----"); 


        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
        	//Step 7: Close the Resources.
        	try {
        	if(rs!=null)
        	rs.close();
        	if(st!=null)
        	st.close();
        	if(con!=null)
        	con.close();
        	}catch(Exception e) {
        	e.printStackTrace();
        	}
        	}
        	}
        	}