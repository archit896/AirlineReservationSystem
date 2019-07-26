package service;

import java.util.List;




import dao.BookedTicketHistoryDao;
import bean.BookedTicketHistory;

public class BookedTicketHistoryService {
	
	BookedTicketHistoryDao ui = new BookedTicketHistoryDao();
	
	public String storeBookedTicketHistoryInfoService(BookedTicketHistory p) throws Exception {
		
		int result = ui.storeBookedTicketHistoryInfo(p);
		
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}	
	}

	public  String updateBookedTicketHistoryInfoViaIdService(BookedTicketHistory p) throws Exception{
		
		int result = ui.updateBookedTicketHistoryInfoViaId(p);
		
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}
	}

	public  String deleteBookedTicketHistoryInfoService(int reservationId) throws Exception{
		
		int result = ui.deleteBookedTicketHistoryInfo(reservationId);
		
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}
	}
	public List<BookedTicketHistory> retrieveBookedTicketHistoryInfoService(int reservationId) throws Exception{

		 

	    List<BookedTicketHistory> listOfRec = ui.retrieveBookedTicketHistoryInfo(reservationId);

	    

	    if(listOfRec.size() == 0){

	            System.out.println("Error");

	            return listOfRec;

	    }else{

	            return listOfRec;

	    }

	}

	public List<BookedTicketHistory> retrieveBookedTicketHistoryInfoService() throws Exception{

	    List<BookedTicketHistory> listOfRec = ui.retrieveBookedTicketHistoryInfo();

	    if(listOfRec.size() == 0){
	            System.out.println("Error");
	            return listOfRec;
	    }else{
	            return listOfRec;
	    }
	}
	public String cancelTicketService(int id) throws Exception{
		int result = ui.cancelTicket(id);
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}
	}
}
