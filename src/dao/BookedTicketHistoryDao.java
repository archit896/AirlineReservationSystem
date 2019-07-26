package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import bean.BookedTicketHistory;
import resource.DataBase;

public class BookedTicketHistoryDao {
	public int storeBookedTicketHistoryInfo(BookedTicketHistory bth) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("insert into booked_ticket_history values (Booked_ticket_history_sequence.nextval,?,?,sysdate,?,?,?,?,?,?)");
		pstmt.setInt(1, bth.getUserId());
		pstmt.setInt(2, bth.getSeatNo());
		//Timestamp dateOfBooking = new Timestamp(bth.getDateOfBooking().getTime());
		//pstmt.setTimestamp(3, dateOfBooking);
		pstmt.setFloat(3, bth.getCost());
		pstmt.setInt(4, bth.getFlightId());
		pstmt.setString(5, bth.getTicketStatus());
		pstmt.setString(6, bth.getName());
		pstmt.setInt(7, bth.getAge());
		pstmt.setString(8, bth.getGender());
		
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
	
	public int deleteBookedTicketHistoryInfo(int reservationId) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");

		PreparedStatement pstmt = con.prepareStatement("delete from booked_ticket_history where reservation_id = ?");
		pstmt.setInt(1, reservationId);
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
	
	public int updateBookedTicketHistoryInfoViaId(BookedTicketHistory bth) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("update booked_ticket_history set user_id = ?, seat_no = ?, date_of_booking = ?, cost = ?, flight_id = ?, ticket_status = ?, name = ?, age = ?, gender = ? where reservation_id = ?");
		pstmt.setInt(10, bth.getReservationId());
		pstmt.setInt(1, bth.getUserId());
		pstmt.setInt(2, bth.getSeatNo());
		Timestamp dateOfBooking = new Timestamp(bth.getDateOfBooking().getTime());
		pstmt.setTimestamp(3, dateOfBooking);
		pstmt.setFloat(4, bth.getCost());
		pstmt.setInt(5, bth.getFlightId());
		pstmt.setString(6, bth.getTicketStatus());
		pstmt.setString(7, bth.getName());
		pstmt.setInt(8, bth.getAge());
		pstmt.setString(9, bth.getGender());
		
		int result = pstmt.executeUpdate();
		
		/*if(result > 0){
			System.out.println("Record successfully updated");
		}else{
			System.out.println("Record not updated");
		}*/
		
		pstmt.close();
		con.close();
		return result;
	}
	
	public int cancelTicket(int id) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("update booked_ticket_history set ticket_status='cancelled' where reservation_id = ?");
		pstmt.setInt(1, id);

		
		int result = pstmt.executeUpdate();
		
		/*if(result > 0){
			System.out.println("Record successfully updated");
		}else{
			System.out.println("Record not updated");
		}*/
		
		pstmt.close();
		con.close();
		return result;
	}
	public List<BookedTicketHistory> retrieveBookedTicketHistoryInfo(int reservationId) throws Exception{
		List<BookedTicketHistory> tickets = new ArrayList<BookedTicketHistory>();
		Connection con = DataBase.getDbConnection();
		PreparedStatement pstmt=con.prepareStatement("select * from booked_ticket_history where reservation_id=? order by reservation_id desc");
		pstmt.setInt(1,reservationId);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			//System.out.println("BookedTicketHistory [reservation_id=" + rs.getInt(1) + ", user_id=" + rs.getInt(2) + ", seat_no=" + rs.getInt(3) + ", date_of_booking=" + rs.getTimestamp(4) + ", cost=" + rs.getFloat(5)+ ", flight_id=" + rs.getInt(6)+ ", ticket_status=" + rs.getString(7) + "]");
			BookedTicketHistory bth = new BookedTicketHistory(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getFloat(5), rs.getInt(6), rs.getString(7),rs.getString(8), rs.getInt(9),rs.getString(10));
			tickets.add(bth);
		}
		rs.close();
		pstmt.close();
		con.close();
		return tickets;
	}

	
	public List<BookedTicketHistory> retrieveBookedTicketHistoryInfo() throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("select * from booked_ticket_history");
		
		List<BookedTicketHistory> tickets = new ArrayList<BookedTicketHistory>();
		
		while(rs.next()){
			//System.out.println("BookedTicketHistory [reservation_id=" + rs.getInt(1) + ", user_id=" + rs.getInt(2) + ", seat_no=" + rs.getInt(3) + ", date_of_booking=" + rs.getTimestamp(4) + ", cost=" + rs.getFloat(5)+ ", flight_id=" + rs.getInt(6)+ ", ticket_status=" + rs.getString(7) + "]");
			BookedTicketHistory bth = new BookedTicketHistory(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getFloat(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
			tickets.add(bth);
		}
		rs.close();
		stmt.close();
		con.close();
		return tickets;
	}
	

}
