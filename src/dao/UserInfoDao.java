package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.Timestamp;

import resource.DataBase;
import bean.Universal;
import bean.UserInfo;

public class UserInfoDao {
	public int storeUserInfo(UserInfo user) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("insert into user_info values (user_info_sequence.nextval,?,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getEmail());
		pstmt.setInt(3, user.getPhone());
		pstmt.setString(4, user.getPassword());
		pstmt.setString(5,user.getType());
		pstmt.setInt(6, user.getAge());
		pstmt.setString(7, user.getGender());
		pstmt.setString(8, user.getSecQues());
		pstmt.setString(9, user.getSecAns());
		
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
	
	public int deleteUserInfo(int userId) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");

		PreparedStatement pstmt = con.prepareStatement("delete from user_info where user_id = ?");
		pstmt.setInt(1, userId);
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
	
	public int updateUserInfoViaId(UserInfo user) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("update user_info set name = ?,email = ?, phone = ?, type=?, age = ?, gender = ?, sec_ques = ?, sec_ans = ? where user_id = ?");
		pstmt.setInt(9, user.getUserId());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(1, user.getName());
		pstmt.setInt(3, user.getPhone());
		
		pstmt.setString(4,user.getType());
		pstmt.setInt(5, user.getAge());
		pstmt.setString(6, user.getGender());
		pstmt.setString(7, user.getSecQues());
		pstmt.setString(8, user.getSecAns());

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
	
	public int updatePasswordViaEmail(UserInfo user) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("update user_info set password = ? where email = ?");
		pstmt.setString(2, user.getEmail());
		pstmt.setString(1, user.getPassword());

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
	
	public List<UserInfo> retrieveUserInfo() throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("select * from user_info");
		
		List<UserInfo> users = new ArrayList<UserInfo>();
		
		while(rs.next()){
			//System.out.println("UserInfo [user_id=" + rs.getInt(1) + ", name=" + rs.getString(2) + ", email=" + rs.getString(3) + ", phone=" + rs.getInt(4) + ", password=" + rs.getString(5) + ", type=" + rs.getString(6) + "]");
			UserInfo user = new UserInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
			users.add(user);
		}
		rs.close();
		stmt.close();
		con.close();
		return users;
	}
	
	public UserInfo login(UserInfo user) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		PreparedStatement pstmt = con.prepareStatement("select * from user_info where email = ? and password = ?");
		pstmt.setString(1, user.getEmail());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		UserInfo user1 = new UserInfo();
		
		while(rs.next()){
			user1 = new UserInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
		}
		rs.close();
		pstmt.close();
		con.close();
		return user1;
	}
	
	public UserInfo selectUser(int userId) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Connection Established!!!");
		
		PreparedStatement pstmt = con.prepareStatement("select * from user_info where user_id = ?");
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		UserInfo user = new UserInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
		rs.close();
		pstmt.close();
		con.close();
		return user;
	}
	
	public List<Universal> viewUsersAll(int userId) throws Exception{
		System.out.println("Begin dao layer");
		List<Universal> listOfRec=new ArrayList<Universal>();
		Connection con = DataBase.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from( select * from user_info where user_Id=?) us join Booked_ticket_History bth on us.user_Id =bth.user_id join Transactions ts on ts.reservation_id=bth.reservation_id join flight_schedule fs on fs.flight_id=bth.flight_id join flight_cost fc on fs.cost_id = fc.cost_id join plane_info pi on fs.plane_id = pi.plane_id join airports a on a.airport_id = fs.origin join airports ai on ai.airport_id = fs.destination");
		pstmt.setInt(1, userId);
		System.out.println("Before execute method");
		ResultSet rs = pstmt.executeQuery();
		System.out.println("I Dao Layer");
		while(rs.next()){
			System.out.println("Inside while loop");
			Universal u=new Universal();
			
			u.setUserId(rs.getInt(1));
			u.setUserName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPhone(rs.getInt(4));
			u.setPassword(rs.getString(5));
			u.setType(rs.getString(6));
			u.setUserAge(rs.getInt(7));
			u.setUserGender(rs.getString(8));
			u.setSecQues(rs.getString(9));
			u.setSecAns(rs.getString(10));
			u.setReservationId(rs.getInt(11));
			
			u.setSeatNo(rs.getInt(13));
			u.setDateOfBooking(rs.getTimestamp(14));
			u.setBookedTicketHistoryCost(rs.getFloat(15));
			u.setFlightId(rs.getInt(16));
			u.setTicketStatus(rs.getString(17));
			u.setName(rs.getString(18));
			u.setAge(rs.getInt(19));
			u.setGender(rs.getString(20));
			u.setTransactionId(rs.getInt(21));
			
			u.setStatus(rs.getString(23));
			u.setTransactionCost(rs.getFloat(24));
			u.setTransactionDate(rs.getTimestamp(25));
			
		     u.setPlaneId(rs.getInt(27));
			u.setDepartureTime(rs.getTimestamp(28));
			u.setArrivalTime(rs.getTimestamp(29));
			u.setCostId(rs.getInt(30));
			u.setDelayMinutes(rs.getInt(31));
			u.setOrigin(rs.getInt(32));
			u.setDestination(rs.getInt(33));
			u.setFlightStatus(rs.getString(34));
			u.setSeatsAvailable(rs.getInt(35));
			
			u.setValidFrom(rs.getTimestamp(38));
			u.setValidTo(rs.getTimestamp(39));
			u.setCost(rs.getFloat(40));
			
			u.setPlaneType(rs.getString(42));
			u.setPlaneVendor(rs.getString(43));
			
			u.setAirportNameOrigin(rs.getString(45));
			u.setLocationOrigin(rs.getString(46));
			
			u.setAirportNameDestination(rs.getString(48));
			u.setLocationDestination(rs.getString(49));
			
			listOfRec.add(u);		
			
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return listOfRec;
		
		
	}
	
	public List<Universal> viewTicketAll(int userId) throws Exception{
		System.out.println("Begin dao layer");
		List<Universal> listOfRec=new ArrayList<Universal>();
		Connection con = DataBase.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("  select * from( select * from user_info where user_Id=?) us join Booked_ticket_History bth on us.user_Id =bth.user_id join flight_schedule fs on fs.flight_id=bth.flight_id  join  flight_cost fc on fs.cost_id = fc.cost_id  join plane_info pi on fs.plane_id = pi.plane_id  join airports a on a.airport_id = fs.origin join airports ai on ai.airport_id = fs.destination");
		pstmt.setInt(1, userId);
		System.out.println("Before execute method");
		ResultSet rs = pstmt.executeQuery();
		System.out.println("I Dao Layer");
		while(rs.next()){
			System.out.println("Inside while loop");
			Universal u=new Universal();
			
			u.setUserId(rs.getInt(1));
			u.setUserName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPhone(rs.getInt(4));
			u.setPassword(rs.getString(5));
			u.setType(rs.getString(6));
			u.setUserAge(rs.getInt(7));
			u.setUserGender(rs.getString(8));
			u.setSecQues(rs.getString(9));
			u.setSecAns(rs.getString(10));
			u.setReservationId(rs.getInt(11));
			
			u.setSeatNo(rs.getInt(13));
			u.setDateOfBooking(rs.getTimestamp(14));
			u.setBookedTicketHistoryCost(rs.getFloat(15));
			u.setFlightId(rs.getInt(16));
			u.setTicketStatus(rs.getString(17));
			u.setName(rs.getString(18));
			u.setAge(rs.getInt(19));
			u.setGender(rs.getString(20));
			
		/*	u.setTransactionId(rs.getInt(21));
			
			u.setStatus(rs.getString(23));
			u.setTransactionCost(rs.getFloat(24));
			u.setTransactionDate(rs.getTimestamp(25));*/
			
		     u.setPlaneId(rs.getInt(22));
			u.setDepartureTime(rs.getTimestamp(23));
			u.setArrivalTime(rs.getTimestamp(24));
			u.setCostId(rs.getInt(25));
			u.setDelayMinutes(rs.getInt(26));
			u.setOrigin(rs.getInt(27));
			u.setDestination(rs.getInt(28));
			u.setFlightStatus(rs.getString(29));
			u.setSeatsAvailable(rs.getInt(30));
			
			u.setValidFrom(rs.getTimestamp(33));
			u.setValidTo(rs.getTimestamp(34));
			u.setCost(rs.getFloat(35));
			
			u.setPlaneType(rs.getString(37));
			u.setPlaneVendor(rs.getString(38));
			
			u.setAirportNameOrigin(rs.getString(40));
			u.setLocationOrigin(rs.getString(41));
			
			u.setAirportNameDestination(rs.getString(43));
			u.setLocationDestination(rs.getString(44));
			
			listOfRec.add(u);		
			
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return listOfRec;
		
		
	}
	
	public String getSecurityQues(String email) throws Exception{
		Connection con = DataBase.getDbConnection();

		PreparedStatement pstmt = con.prepareStatement("select sec_ques from user_info where email = ?");
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		String ques = rs.getString(1);
		rs.close();
		pstmt.close();
		con.close();
		return ques;
	}
	public String getSecurityAns(String email) throws Exception{
		Connection con = DataBase.getDbConnection();

		PreparedStatement pstmt = con.prepareStatement("select sec_ans from user_info where email = ?");
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		String ans = rs.getString(1);
		rs.close();
		pstmt.close();
		con.close();
		return ans;
	}
	
}
