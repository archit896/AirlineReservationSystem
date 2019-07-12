package main;

import java.util.*;
import java.text.SimpleDateFormat;

import dao.AirportsDao;
import dao.BookedTicketHistoryDao;
import dao.FlightCostDao;
import dao.FlightScheduleDao;
import dao.PlaneInfoDao;
import dao.TransactionsDao;
import dao.UserInfoDao;
import bean.Airports;
import bean.BookedTicketHistory;
import bean.FlightCost;
import bean.FlightSchedule;
import bean.PlaneInfo;
import bean.Transactions;
import bean.UserInfo;

public class test {
	public static void main(String[] args) throws Exception{
		Airports airport1 = new Airports(1, "Airport1", "Delhi");
		Airports airport2 = new Airports(2, "Airport2", "Delhi");
		Airports airport3 = new Airports(3, "Airport1", "Bengalore");
		Airports airport4 = new Airports(4, "Airport2", "Bengalore");
		Airports airport5 = new Airports(5, "asd", "asdf");
		
		AirportsDao ad = new AirportsDao();
		
		/*ad.storeAirportsInfo(airport1);
		ad.storeAirportsInfo(airport2);
		ad.storeAirportsInfo(airport3);
		ad.storeAirportsInfo(airport4);
		ad.storeAirportsInfo(airport5);
		ad.deleteAirportsInfo(5);
		ad.updateAirportsInfoViaId(airport4);
		ad.retrieveAirportsInfo();*/
		
		PlaneInfo plane1 = new PlaneInfo(1,"domestic1", "indigo");
		PlaneInfo plane2 = new PlaneInfo(2,"domestic2", "indigo");
		PlaneInfo plane3 = new PlaneInfo(3,"domestic1", "spicejet");
		PlaneInfo plane4 = new PlaneInfo(4,"international1", "etihad");
		PlaneInfo plane5 = new PlaneInfo(4,"international1", "etihad1");

		PlaneInfoDao pid = new PlaneInfoDao();

		/*pid.storePlaneInfo(plane1);
		pid.storePlaneInfo(plane2);
		pid.storePlaneInfo(plane3);
		pid.storePlaneInfo(plane4);
		pid.storePlaneInfo(plane5);
		pid.deletePlaneInfo(5);
		pid.updatePlaneInfoViaId(plane1);
		
		List<PlaneInfo> planes = pid.retrievePlaneInfo();
		for(PlaneInfo plane:planes){
			System.out.println(plane);
		}
		*/
		
		
		FlightCost cost1 = new FlightCost();
		cost1.setCostId(1);
		cost1.setPlaneId(1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss");
		Date validFrom = sdf.parse("15-Jul-2019 08.00.00");
		cost1.setValidFrom(validFrom);
		Date validTo = sdf.parse("20-Jul-2019 08.00.00");
		cost1.setValidTo(validTo);
		cost1.setCost(5000f);
		
		FlightCost cost2 = new FlightCost();
		cost2.setCostId(2);
		cost2.setPlaneId(2);
		Date validFrom2 = sdf.parse("16-Jul-2019 08.00.00");
		cost2.setValidFrom(validFrom2);
		Date validTo2 = sdf.parse("21-Jul-2019 08.00.00");
		cost2.setValidTo(validTo2);
		cost2.setCost(4000f);
		
		FlightCost cost3 = new FlightCost();
		cost3.setCostId(3);
		cost3.setPlaneId(3);
		Date validFrom3 = sdf.parse("17-Jul-2019 08.00.00");
		cost3.setValidFrom(validFrom3);
		Date validTo3 = sdf.parse("22-Jul-2019 08.00.00");
		cost3.setValidTo(validTo3);
		cost3.setCost(6000f);
		
		FlightCost cost4 = new FlightCost();
		
		cost4.setCostId(4);
		cost4.setPlaneId(4);
		Date validFrom4 = sdf.parse("18-Jul-2019 08.00.00");
		cost4.setValidFrom(validFrom4);
		Date validTo4 = sdf.parse("23-Jul-2019 08.00.00");
		cost4.setValidTo(validTo4);
		cost4.setCost(5500f);
		
		FlightCost cost5 = new FlightCost();
		cost5.setCostId(5);
		cost5.setPlaneId(4);
		Date validFrom5 = sdf.parse("18-Jul-2019 08.00.00");
		cost5.setValidFrom(validFrom5);
		Date validTo5 = sdf.parse("23-Jul-2019 08.00.00");
		cost5.setValidTo(validTo5);
		cost5.setCost(5500f);
		
		
		FlightCostDao fcd = new FlightCostDao();
		
		/*fcd.storeFlightCostInfo(cost1);
		fcd.storeFlightCostInfo(cost2);
		fcd.storeFlightCostInfo(cost3);
		fcd.storeFlightCostInfo(cost4);
		fcd.storeFlightCostInfo(cost5);
		fcd.deleteFlightCostInfo(5);
		fcd.updateFlightCostInfoViaId(cost1);
		
		List<FlightCost> costs = fcd.retrieveFlightCostInfo();
		
		for(FlightCost cost:costs){
			System.out.println(cost);
		}*/
		
		Date depart = sdf.parse("18-Jul-2019 10.00.00");
		Date arrival = sdf.parse("18-Jul-2019 12.00.00");
		FlightSchedule flight1 = new FlightSchedule(1,1,depart,arrival,1,0,1,3,"booking",150);
		FlightSchedule flight2 = new FlightSchedule(2,1,depart,arrival,1,0,2,4,"booking",150);
		FlightSchedule flight3 = new FlightSchedule(3,2,depart,arrival,2,0,4,2,"booking",100);
		FlightSchedule flight4 = new FlightSchedule(4,3,depart,arrival,3,0,3,1,"booking",170);
		FlightSchedule flight5 = new FlightSchedule(5,4,depart,arrival,4,0,1,3,"booking",160);
		
		FlightScheduleDao fsd = new FlightScheduleDao();
		
		/*fsd.storeFlightScheduleInfo(flight1);
		fsd.storeFlightScheduleInfo(flight2);
		fsd.storeFlightScheduleInfo(flight3);
		fsd.storeFlightScheduleInfo(flight4);
		fsd.storeFlightScheduleInfo(flight5);
		fsd.deleteFlightScheduleInfo(2);
		fsd.updateFlightScheduleInfoViaId(flight4);
		
		List<FlightSchedule> flights = fsd.retrieveFlightScheduleInfo();
		for(FlightSchedule flight : flights){
			System.out.println(flight);
		}*/
		
		UserInfo user1 = new UserInfo(1,"Archit", "asd@asd.com", 1234567890, "asd", "admin");
		UserInfo user2 = new UserInfo(2,"Bikesh", "asde@asd.com", 1234447890, "asd", "admin");
		UserInfo user3 = new UserInfo(3,"Archit", "asdw@asd.com", 1234567890, "asd", "customer");
		UserInfo user4 = new UserInfo(4,"Archit", "asdr@asd.com", 1234567890, "asd", "staff");
		UserInfo user5 = new UserInfo(5,"Archit", "asdt@asd.com", 1234567890, "asd", "staff");
		
		UserInfoDao ud = new UserInfoDao();
		
		/*ud.storeUserInfo(user1);
		ud.storeUserInfo(user2);
		ud.storeUserInfo(user3);
		ud.storeUserInfo(user4);
		ud.storeUserInfo(user5);
		ud.deleteUserInfo(5);rusw
		ud.updateUserInfoViaId(user1);
		
		List<UserInfo> users = ud.retrieveUserInfo();
		for(UserInfo user:users){
			System.out.println(user);
		}*/
		
		BookedTicketHistory ticket1 = new BookedTicketHistory(1, 1, 12, depart, 5000.00f, 1, "booked");
		BookedTicketHistory ticket2 = new BookedTicketHistory(2, 1, 13, depart, 5400.00f, 5, "edited");
		BookedTicketHistory ticket3 = new BookedTicketHistory(3, 2, 14, depart, 5200.00f, 3, "cancelled");
		BookedTicketHistory ticket4 = new BookedTicketHistory(4, 3, 15, depart, 5500.00f, 4, "booked");
		BookedTicketHistory ticket5 = new BookedTicketHistory(5, 4, 16, depart, 5800.00f, 1, "booked");
		
		BookedTicketHistoryDao bthd = new BookedTicketHistoryDao();
		
		/*bthd.storeBookedTicketHistoryInfo(ticket1);
		bthd.storeBookedTicketHistoryInfo(ticket2);
		bthd.storeBookedTicketHistoryInfo(ticket3);
		bthd.storeBookedTicketHistoryInfo(ticket4);
		bthd.storeBookedTicketHistoryInfo(ticket5);
		bthd.deleteBookedTicketHistoryInfo(5);
		bthd.updateFlightScheduleInfoViaId(ticket1);
		List<BookedTicketHistory> tickets = bthd.retrieveFlightScheduleInfo();
		for(BookedTicketHistory ticket:tickets){
			System.out.println(ticket);
		}*/
		
		Transactions bill1 = new Transactions(1,1,"booked", 5000.00f, depart);
		Transactions bill2 = new Transactions(2,2,"booked", 5000.00f, depart);
		Transactions bill3 = new Transactions(3,3,"booked", 5000.00f, depart);
		Transactions bill4 = new Transactions(4,4,"booked", 5000.00f, depart);
		Transactions bill5 = new Transactions(5,1,"booked", 5000.00f, depart);
		
		TransactionsDao td = new TransactionsDao();
		
		/*td.storeTransactionsInfo(bill1);
		td.storeTransactionsInfo(bill2);
		td.storeTransactionsInfo(bill3);
		td.storeTransactionsInfo(bill4);
		td.storeTransactionsInfo(bill5);
		td.deleteTransactionsInfo(5);
		td.updateTransactionsInfoViaId(bill1);
		List<Transactions> bills = td.retrieveFlightCostInfo();
		for(Transactions bill:bills){
			System.out.println(bill);
		}*/
	}
}