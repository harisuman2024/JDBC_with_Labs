package com.hello_hari.jdbc;

import java.sql.*;

public class Lab1 {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try {
            // Load the Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open the Connection with SSL disabled
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/myjdbcdb?useSSL=false",
                "root",
                "Mysql!@#108"
            );

            // Insert SQL Statement (without specifying 'cid' if it's auto-incremented)
            String SQL = "INSERT INTO mycustomers (cname, email, phone, city) VALUES ('Java_DSA', 'ds@jlc', 12350, 'Hyd')";

            // Create the JDBC Statement
            st = con.createStatement();

            // Submit SQL to DB
            int x = st.executeUpdate(SQL);

            // Process Results
            if (x == 1) {
                System.out.println("Customer Record Inserted Successfully");
            } else {
                System.out.println("Insertion Failed");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Catch and print the exception
        } finally {
            // Step 7: Close the Resources
            try {
                if (st != null) 
                	st.close();
                if (con != null) 
                	con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


/*
 
package com.hello_hari.jdbc;

import java.sql.*;

public class Lab1 {

	public static void main(String[] args) {
			
		try {
		//Step 1: Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");

		//Step 2: Open the Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbcdb",
				"root",
				"Mysql!@#108"
				);
		
		//Step 3: Prepare SQL Statement
		String SQL="insert into mycustomers values(106,'ds','ds@jlc',12345,'Blore')";
	
		//Step 4: Create the JDBC Statement
		Statement st=con.createStatement();
		
		//Step 5: Submit SQL to DB
		int x=st.executeUpdate(SQL);
		
		//Step 6: Process Results
		if(x==1) {
		System.out.println("Customer Record is Inserted Succesfully");
		}else {
		System.out.println("Sorry, Customer Record is Not Inserted");
		} 
		
			//Step 7: Close the Resources.
		
			st.close();
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}


*/


		






		

