package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import bean.FlightCost;
import resource.DataBase;

public class FlightCostDao {
	public int storeFlightCostInfo(FlightCost cost) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		PreparedStatement pstmt = con.prepareStatement("insert into flight_cost values (flight_cost_sequence.nextval,?,?,?,?)");
		pstmt.setInt(1,  cost.getPlaneId());
		Timestamp validFrom = new Timestamp(cost.getValidFrom().getTime());
		pstmt.setTimestamp(2, validFrom);
		Timestamp validTo = new Timestamp(cost.getValidTo().getTime());
		pstmt.setTimestamp(3, validTo);
		pstmt.setFloat(4,  cost.getCost());
		
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
	
	public int deleteFlightCostInfo(int costId) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");

		PreparedStatement pstmt = con.prepareStatement("delete from flight_cost where cost_id = ?");
		pstmt.setInt(1, costId);
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
	
	public int updateFlightCostInfoViaId(FlightCost cost) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("update flight_cost set plane_id = ?, valid_from = ?, valid_to = ?, cost = ? where cost_id = ?");
		pstmt.setInt(5, cost.getCostId());
		pstmt.setInt(1,  cost.getPlaneId());
		Timestamp validFrom = new Timestamp(cost.getValidFrom().getTime());
		pstmt.setTimestamp(2, validFrom);
		Timestamp validTo = new Timestamp(cost.getValidTo().getTime());
		pstmt.setTimestamp(3, validTo);
		pstmt.setFloat(4,  cost.getCost());
		
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
	
	public List<FlightCost> retrieveFlightCostInfo() throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("select * from flight_cost");
		
		List<FlightCost> costs = new ArrayList<FlightCost>();
		
		while(rs.next()){
			//System.out.println("FlightCost [cost_id=" + rs.getInt(1) + ", plane_id=" + rs.getInt(2) + ", valid_from=" + rs.getTimestamp(3) + ", valid_to=" + rs.getTimestamp(4) + ", cost=" + rs.getFloat(5)+ "]");
			FlightCost cost = new FlightCost(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getFloat(5));
			costs.add(cost);
		}
		rs.close();
		stmt.close();
		con.close();
		return costs;
	}
}
