package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import service.BookedTicketHistoryService;
import bean.BookedTicketHistory;

@Path("history")
public class BookedTicketHistoryRest {
	
	BookedTicketHistoryService bths = new BookedTicketHistoryService();
	
	@POST
	@Path("store")
	@Consumes(MediaType.APPLICATION_JSON)
	public String storeHistory(BookedTicketHistory bth){
		String result = "";
		
		try {
			result = bths.storeBookedTicketHistoryInfoService(bth);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@DELETE
	@Path("delete")
	public String deleteHistory(@QueryParam("reservationId") int reservationId){
		String result = "";
		
		try {
			result = bths.deleteBookedTicketHistoryInfoService(reservationId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateHistory(BookedTicketHistory bth){
		String result = "";
		
		try {
			result = bths.updateBookedTicketHistoryInfoViaIdService(bth);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@PUT
	@Path("cancelTicket/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String cancelTicket(@PathParam("id") int id){
		String result = "";
		try {
			result = bths.cancelTicketService(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@GET
	@Path("retrieveAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookedTicketHistory> retrieveAll(){
		List<BookedTicketHistory> tickets = new ArrayList<BookedTicketHistory>();
		
		try {
			tickets = bths.retrieveBookedTicketHistoryInfoService();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return tickets;
	}

	@GET
	@Path("retrieve/{reservationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookedTicketHistory> retriveBookedTicketHistoryRest(@PathParam("reservationId") int reservationId)
	{List<BookedTicketHistory> listOfBookedTicketHistory = new ArrayList<BookedTicketHistory>();
        try {
            listOfBookedTicketHistory= bths.retrieveBookedTicketHistoryInfoService(reservationId);
     } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
     }
     return listOfBookedTicketHistory;
}

}
