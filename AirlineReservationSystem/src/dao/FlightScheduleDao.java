package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import bean.FlightSchedule;
import resource.DataBase;

public class FlightScheduleDao {
	public int storeFlightScheduleInfo(FlightSchedule fs) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("insert into flight_schedule values (flight_schedule_sequence.nextval,?,?,?,?,?,?,?,?,?)");
		pstmt.setInt(1, fs.getPlaneId());
		Timestamp departureTime = new Timestamp(fs.getDepartureTime().getTime());
		pstmt.setTimestamp(2, departureTime);
		Timestamp arrivalTime = new Timestamp(fs.getArrivalTime().getTime());
		pstmt.setTimestamp(3, arrivalTime);
		pstmt.setInt(4, fs.getCostId());
		pstmt.setInt(5, fs.getDelayMinutes());
		pstmt.setInt(6, fs.getOrigin());
		pstmt.setInt(7, fs.getDestination());
		pstmt.setString(8, fs.getFlightStatus());
		pstmt.setInt(9, fs.getSeatsAvailable());
		
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
	
	public int deleteFlightScheduleInfo(int flightId) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");

		PreparedStatement pstmt = con.prepareStatement("delete from flight_schedule where flight_id = ?");
		pstmt.setInt(1, flightId);
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
	
	public int updateFlightScheduleInfoViaId(FlightSchedule fs) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("update flight_schedule set plane_id = ?, departure_time = ?, arrival_time = ?, cost_id = ?, delay_minutes = ?, origin = ?, destination = ?, flight_status = ?, seats_available = ? where flight_id = ?");
		pstmt.setInt(10, fs.getFlightId());
		pstmt.setInt(1, fs.getPlaneId());
		Timestamp departureTime = new Timestamp(fs.getDepartureTime().getTime());
		pstmt.setTimestamp(2, departureTime);
		Timestamp arrivalTime = new Timestamp(fs.getArrivalTime().getTime());
		pstmt.setTimestamp(3, arrivalTime);
		pstmt.setInt(4, fs.getCostId());
		pstmt.setInt(5, fs.getDelayMinutes());
		pstmt.setInt(6, fs.getOrigin());
		pstmt.setInt(7, fs.getDestination());
		pstmt.setString(8, fs.getFlightStatus());
		pstmt.setInt(9, fs.getSeatsAvailable());
		
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
	
	public List<FlightSchedule> retrieveFlightScheduleInfo() throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("select * from flight_schedule");
		
		List<FlightSchedule> flights = new ArrayList<FlightSchedule>();
		
		while(rs.next()){
			//System.out.println("FlightSchedule [flight_id=" + rs.getInt(1) + ", plane_id=" + rs.getInt(2) + ", departure_time=" + rs.getTimestamp(3) + ", arrival_time=" + rs.getTimestamp(4) + ", cost_id=" + rs.getInt(5)+ ", delay_minutes=" + rs.getInt(6)+ ", origin=" + rs.getInt(7)+ ", destination=" + rs.getInt(8)+ ", flight_status=" + rs.getString(9)+ ", seats_available=" + rs.getInt(10) + "]");
			FlightSchedule flight = new FlightSchedule(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10));
			flights.add(flight);
		}
		rs.close();
		stmt.close();
		con.close();
		return flights;
	}
	
}
