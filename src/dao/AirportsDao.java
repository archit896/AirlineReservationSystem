package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.Airports;
import resource.DataBase;

public class AirportsDao {
	public int storeAirportsInfo(Airports airport) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("insert into airports values (Airports_sequence.nextval,?,?)");
		pstmt.setString(1, airport.getAirportName());
		pstmt.setString(2, airport.getLocation());

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
	
	public int deleteAirportsInfo(int airportId) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");

		PreparedStatement pstmt = con.prepareStatement("delete from airports where airport_id = ?");
		pstmt.setInt(1, airportId);
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
	
	public int updateAirportsInfoViaId(Airports airport) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("update airports set airport_name = ?,location = ? where airport_id = ?");
		pstmt.setString(1, airport.getAirportName());
		pstmt.setString(2, airport.getLocation());
		pstmt.setInt(3, airport.getAirportId());

		int result = pstmt.executeUpdate();
		/*if(result > 0){
			System.out.println("Record successfully updated");
		}else{
			System.out.println("Error");
		}*/
		pstmt.close();
		con.close();
		return result;
	}
	
	public List<Airports> retrieveAirportsInfo() throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("select * from airports");
		
		List<Airports> airports = new ArrayList<Airports>();
		
		while(rs.next()){
			//System.out.println("Airports [airport_id=" + rs.getInt(1) + ", airport_name=" + rs.getString(2) + ", location=" + rs.getString(3) + "]");
			Airports airport  = new Airports(rs.getInt(1), rs.getString(2), rs.getString(3));
			airports.add(airport);
			
			
		}
		rs.close();
		stmt.close();
		con.close();
		return airports;
	}
	
	public Airports selectAirport(int airportId) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		PreparedStatement pstmt = con.prepareStatement("select * from airports where airport_id = ?");
		pstmt.setInt(1, airportId);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		Airports airport  = new Airports(rs.getInt(1), rs.getString(2), rs.getString(3));
		
		rs.close();
		pstmt.close();
		con.close();
		return airport;
	}
	
	
	
}
