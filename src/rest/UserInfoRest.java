package rest;

//import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import service.UserInfoService;
import bean.QuesAns;
import bean.Universal;
import bean.UserInfo;

@Path("user")
public class UserInfoRest {
	List<Universal> users;
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo login(UserInfo user){
		
		UserInfo user1 = new UserInfo();
		
		try {
			UserInfoService uis = new UserInfoService();
			user1 = uis.loginService(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user1;
	}
	
	@GET
	@Path("retrieveAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserInfo> retrieveAllUser(){
		List<UserInfo> users = null;
		try {
			UserInfoService uis = new UserInfoService();
			users = uis.retrieveUserInfoService();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}
	

	
	@GET
	@Path("vieww/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Universal> viewUserAll(@PathParam("userId") int userId){
		
		System.out.println("I Came Here "+userId);
		try {
			UserInfoService uis = new UserInfoService();
			users = uis.viewUsersAllService(userId);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return users;
	}
	
	@GET
	@Path("ticket/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Universal> viewTicketAll(@PathParam("userId") int userId){
		
		System.out.println("I Came Here "+userId);
		try {
			UserInfoService uis = new UserInfoService();
			users = uis.viewTicketAllService(userId);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return users;
	}
	
	@GET
	@Path("forgotPassword")
	@Produces(MediaType.APPLICATION_JSON)
	public QuesAns getSecurityQuesAnsRest(@QueryParam("email") String email){
		QuesAns qa = new QuesAns();
		
		try {
			UserInfoService uis = new UserInfoService();
			qa.setQues(uis.getSecurityQuesService(email));;
			qa.setAns(uis.getSecurityAnsService(email));;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return qa;
	}
	
	@POST
	@Path("store")
	@Consumes(MediaType.APPLICATION_JSON)
	public String storeUser(UserInfo user){
		String result = "";
		
		try {
			UserInfoService uis = new UserInfoService();
			result = uis.storeUserInfoService(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateUser(UserInfo user){
		String result = "";
		
		try {
			UserInfoService uis = new UserInfoService();
			result = uis.updateUserInfoViaIdService(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@PUT
	@Path("updatePassword")
	public String changePassword(@QueryParam("email") String email, @QueryParam("password") String password){
		String result = "";
		UserInfo user = new UserInfo();
		user.setEmail(email);
		user.setPassword(password);
		
		try {
			UserInfoService uis = new UserInfoService();
			result = uis.updatePasswordViaEmailService(user);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}
}
