package com.hello_hari.jdbc;

import java.sql.*;
import com.hello_hari.jdbc.util.JDBCUtil;

class InvalidAccountNumberException extends RuntimeException {
	int accno;

	InvalidAccountNumberException() {
	}

	InvalidAccountNumberException(int accno) {
		this.accno = accno;
	}

	public String toString() {
		return "Accno : " + accno + " is Not Found";
	}
}

class InsufficientFundsException extends RuntimeException {
	InsufficientFundsException() {
	}

	public String toString() {
		return "Sufficient Funds are Not Available";
	}
}

class AccountService {
	void fundsTransfer(int saccno, int daccno, double amt) {
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			con.setAutoCommit(false); // Tx Begin
			String SQL1 = "select bal from myaccounts where accno=?";
			String SQL2 = "update myaccounts set bal=? where accno=?";
			ps1 = con.prepareStatement(SQL1);
			ps2 = con.prepareStatement(SQL2);
// Deposit
			ps1.setInt(1, daccno); // 102
			rs = ps1.executeQuery(); // OP1-Select
			if (rs.next()) {
				double bal = rs.getInt(1);
				bal = bal + amt;
				ps2.setDouble(1, bal);
				ps2.setInt(2, daccno);
				ps2.executeUpdate(); // OP2-Update
			} else {
				throw new InvalidAccountNumberException();
			}
            // Withdraw
			ps1.setInt(1, saccno); // 101
			rs = ps1.executeQuery(); // OP3-Select
			if (rs.next()) {
				double bal = rs.getInt(1);
				if (bal >= amt) {
					bal = bal - amt;
					ps2.setDouble(1, bal);
					ps2.setInt(2, saccno);
					ps2.executeUpdate(); // OP4-Update
				} else {
					throw new InsufficientFundsException();
				}
			} else {
				throw new InvalidAccountNumberException();
			}
			con.commit(); // End of Tx
			System.out.println("----Done-----");
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				con.rollback(); // End of Tx
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			JDBCUtil.cleaup(rs, ps1, con);
		}
	}
}

public class Lab22 {
	public static void main(String[] args) {
		AccountService as = new AccountService();
		as.fundsTransfer(101, 102, 5000);
	}
}