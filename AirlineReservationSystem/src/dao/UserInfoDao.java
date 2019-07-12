package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import resource.DataBase;
import bean.UserInfo;

public class UserInfoDao {
	public int storeUserInfo(UserInfo user) throws Exception{
		Connection con = DataBase.getDbConnection();
		//System.out.println("Established Connection!!!");
		
		PreparedStatement pstmt = con.prepareStatement("insert into user_info values (user_info_sequence.nextval,?,?,?,?,?)");
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getEmail());
		pstmt.setInt(3, user.getPhone());
		pstmt.setString(4, user.getPassword());
		pstmt.setString(5,user.getType());
		
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
		
		PreparedStatement pstmt = con.prepareStatement("update user_info set name = ?,email = ?, phone = ?, password = ?, type = ? where user_id = ?");
		pstmt.setInt(6, user.getUserId());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(1, user.getName());
		pstmt.setInt(3, user.getPhone());
		pstmt.setString(4, user.getPassword());
		pstmt.setString(5,user.getType());

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
			UserInfo user = new UserInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			users.add(user);
		}
		rs.close();
		stmt.close();
		con.close();
		return users;
	}
}
