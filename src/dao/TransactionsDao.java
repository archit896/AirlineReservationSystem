package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import resource.DataBase;
import bean.Transactions;

public class TransactionsDao {
	public int storeTransactionsInfo(Transactions tr) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		PreparedStatement pstmt = con.prepareStatement("insert into transactions values (transactions_sequence.nextval,?,?,?,?)");
		pstmt.setInt(1,  tr.getReservationId());
		pstmt.setString(2, tr.getStatus());
		pstmt.setFloat(3,  tr.getCost());
		Timestamp transactionDate = new Timestamp(tr.getTransactionDate().getTime());
		pstmt.setTimestamp(4, transactionDate);
		
		int result = pstmt.executeUpdate();
		
		/*if(result > 0){
			System.out.println("Record successfully inserted");
		}else{
			System.out.println("Record not inserted");
		}*/
		
		pstmt.close();
		con.close();
		return result;
	}
	
	public int deleteTransactionsInfo(int transactionId) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");

		PreparedStatement pstmt = con.prepareStatement("delete from transactions where transaction_id = ?");
		pstmt.setInt(1, transactionId);
		int result = pstmt.executeUpdate();
		
		/*if(result > 0){
			System.out.println("Record successfully deleted");
		}else{
			System.out.println("Error");
		}*/
		pstmt.close();
		con.close();
		return result;
	}
	
	public int updateTransactionsInfoViaId(Transactions tr) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("update transactions set reservation_id = ?, status = ?, cost = ?, transaction_date = ? where transaction_id = ?");
		pstmt.setInt(5, tr.getTransactionId());
		pstmt.setInt(1,  tr.getReservationId());
		pstmt.setString(2, tr.getStatus());
		pstmt.setFloat(3,  tr.getCost());
		Timestamp transactionDate = new Timestamp(tr.getTransactionDate().getTime());
		pstmt.setTimestamp(4, transactionDate);
		
		int result = pstmt.executeUpdate();
		/*if(result > 0){
			System.out.println("Name successfully updated");
		}else{
			System.out.println("Error");
		}*/
		pstmt.close();
		con.close();
		return result;
	}
	
	public List<Transactions> retrieveTransactionsInfo() throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("select * from transactions");
		
		List<Transactions> transactions = new ArrayList<Transactions>();
		
		while(rs.next()){
			//System.out.println("Transactions [transaction_id=" + rs.getInt(1) + ", reservation_id=" + rs.getInt(2) + ", status=" + rs.getString(3) + ", cost=" + rs.getFloat(4) + ", transaction_date=" + rs.getTimestamp(5)+ "]");
			Transactions transaction = new Transactions(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getTimestamp(5));
			transactions.add(transaction);
		}
		rs.close();
		stmt.close();
		con.close();
		return transactions;
	}
	
	public Transactions selectTransaction(int transactionId) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		PreparedStatement pstmt = con.prepareStatement("select * from transactions where transaction_id = ?");
		pstmt.setInt(1, transactionId);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		Transactions transaction = new Transactions(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getTimestamp(5));
		rs.close();
		pstmt.close();
		con.close();
		return transaction;
	}
}