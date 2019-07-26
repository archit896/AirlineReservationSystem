package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;



import bean.FlightSchedule;
import bean.Flights;
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
	public List<FlightSchedule> retrieveFlightScheduleInfo(int flightId) throws Exception{
		List<FlightSchedule> flights = new ArrayList<FlightSchedule>();
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		PreparedStatement pstmt = con.prepareStatement("select * from flight_schedule where flight_Id=?");
		pstmt.setInt(1,flightId);
		ResultSet rs = pstmt.executeQuery();
		
		
		
		while(rs.next()){
			//System.out.println("FlightSchedule [flight_id=" + rs.getInt(1) + ", plane_id=" + rs.getInt(2) + ", departure_time=" + rs.getTimestamp(3) + ", arrival_time=" + rs.getTimestamp(4) + ", cost_id=" + rs.getInt(5)+ ", delay_minutes=" + rs.getInt(6)+ ", origin=" + rs.getInt(7)+ ", destination=" + rs.getInt(8)+ ", flight_status=" + rs.getString(9)+ ", seats_available=" + rs.getInt(10) + "]");
			FlightSchedule flight = new FlightSchedule(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10));
			flights.add(flight);
		}
		rs.close();
		pstmt.close();
		con.close();
		return flights;
	}
	
	public List<Flights> searchFlights(String origin, String destination, java.util.Date date, int seats) throws Exception{
		List<Flights> flights = new ArrayList<Flights>();
		
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		PreparedStatement pstmt = con.prepareStatement("select * from "
				+ "(select * from flight_schedule "
				+ "where "
				+ "origin in (select airport_id from airports where location = ?) "
				+ "and destination in (select airport_id from airports  where location = ?) "
				+ "and to_char(departure_time,'dd-MM-yy')=to_char(?, 'dd-MM-yy') "
				+ "and seats_available >= ?) fs "
				+ "join flight_cost fc on fs.cost_id = fc.cost_id "
				+ "join plane_info pi on fs.plane_id = pi.plane_id "
				+ "join airports a on a.airport_id = fs.origin "
				+ "join airports ai on ai.airport_id = fs.destination");	
		pstmt.setString(1, origin);
		pstmt.setString(2, destination);
		Date d = new Date(date.getTime());
		pstmt.setDate(3, d);
		pstmt.setInt(4, seats);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			Flights flight = new Flights();
			flight.setFlightId(rs.getInt(1));
			flight.setPlaneId(rs.getInt(2));
			flight.setDepartureTime(rs.getTimestamp(3));
			flight.setArrivalTime(rs.getTimestamp(4));
			flight.setCostId(rs.getInt(5));
			flight.setDelayMinutes(rs.getInt(6));
			flight.setOrigin(rs.getInt(7));
			flight.setDestination(rs.getInt(8));
			flight.setFlightStatus(rs.getString(9));
			flight.setSeatsAvailable(rs.getInt(10));
			flight.setValidFrom(rs.getTimestamp(13));
			flight.setValidTo(rs.getTimestamp(14));
			flight.setCost(rs.getFloat(15));
			flight.setPlaneType(rs.getString(17));
			flight.setPlaneVendor(rs.getString(18));
			flight.setAirportNameOrigin(rs.getString(20));
			flight.setLocationOrigin(rs.getString(21));
			flight.setAirportNameDestination(rs.getString(23));
			flight.setLocationDestination(rs.getString(24));
			
			flights.add(flight);
		}
		
		return flights;
	}
	
	public List<Flights> searchFlightsById(int id) throws Exception{
		List<Flights> flights = new ArrayList<Flights>();
		
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		PreparedStatement pstmt = con.prepareStatement("select * from "
				+ "flight_schedule fs "
				+ "join flight_cost fc on fs.cost_id = fc.cost_id "
				+ "join plane_info pi on fs.plane_id = pi.plane_id "
				+ "join airports a on a.airport_id = fs.origin "
				+ "join airports ai on ai.airport_id = fs.destination where fs.flight_id = ?");	
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			Flights flight = new Flights();
			flight.setFlightId(rs.getInt(1));
			flight.setPlaneId(rs.getInt(2));
			flight.setDepartureTime(rs.getTimestamp(3));
			flight.setArrivalTime(rs.getTimestamp(4));
			flight.setCostId(rs.getInt(5));
			flight.setDelayMinutes(rs.getInt(6));
			flight.setOrigin(rs.getInt(7));
			flight.setDestination(rs.getInt(8));
			flight.setFlightStatus(rs.getString(9));
			flight.setSeatsAvailable(rs.getInt(10));
			flight.setValidFrom(rs.getTimestamp(13));
			flight.setValidTo(rs.getTimestamp(14));
			flight.setCost(rs.getFloat(15));
			flight.setPlaneType(rs.getString(17));
			flight.setPlaneVendor(rs.getString(18));
			flight.setAirportNameOrigin(rs.getString(20));
			flight.setLocationOrigin(rs.getString(21));
			flight.setAirportNameDestination(rs.getString(23));
			flight.setLocationDestination(rs.getString(24));
			
			flights.add(flight);
		}
		
		return flights;
	}
	
}
