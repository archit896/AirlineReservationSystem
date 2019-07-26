package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import resource.DataBase;
import bean.PlaneInfo;

public class PlaneInfoDao {
		public int storePlaneInfo(PlaneInfo plane) throws Exception{
			Connection con = DataBase.getDbConnection();
			//System.out.println("Established Connection!!!");
			
			PreparedStatement pstmt = con.prepareStatement("insert into plane_info values (plane_info_sequence.nextval,?,?)");
			pstmt.setString(1, plane.getPlaneType());
			pstmt.setString(2, plane.getPlaneVendor());

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
		
		public int deletePlaneInfo(int planeId) throws Exception{
			Connection con = DataBase.getDbConnection();
			//System.out.println("Established Connection!!!");

			PreparedStatement pstmt = con.prepareStatement("delete from plane_info where plane_id = ?");
			pstmt.setInt(1, planeId);
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
		
		public int updatePlaneInfoViaId(PlaneInfo plane) throws Exception{
			Connection con = DataBase.getDbConnection();
			//System.out.println("Established Connection!!!");
			
			PreparedStatement pstmt = con.prepareStatement("update plane_info set plane_type = ?,plane_vendor = ? where plane_id = ?");
			pstmt.setString(1, plane.getPlaneType());
			pstmt.setString(2, plane.getPlaneVendor());
			pstmt.setInt(3, plane.getPlaneId());

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
		
		public List<PlaneInfo> retrievePlaneInfo() throws Exception{
			Connection con = DataBase.getDbConnection();
			//System.out.println("Connection Established!!!");
			
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from plane_info");
			
			List<PlaneInfo> planes = new ArrayList<PlaneInfo>();
			
			while(rs.next()){
				//System.out.println("PlaneInfo [plane_id=" + rs.getInt(1) + ", plane_type=" + rs.getString(2) + ", plane_vendor=" + rs.getString(3) + "]");
				PlaneInfo plane = new PlaneInfo(rs.getInt(1), rs.getString(2), rs.getString(3));
				planes.add(plane);
			}
			rs.close();
			stmt.close();
			con.close();
			return planes;
		}
		
		public PlaneInfo retrievePlane(int planeId) throws Exception{
			Connection con = DataBase.getDbConnection();
			//System.out.println("Connection Established!!!");
			
			PreparedStatement pstmt = con.prepareStatement("select * from plane_info where plane_id = ?");
			pstmt.setInt(1, planeId);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			PlaneInfo plane = new PlaneInfo(rs.getInt(1), rs.getString(2), rs.getString(3));
			rs.close();
			pstmt.close();
			con.close();
			return plane;
		}
}