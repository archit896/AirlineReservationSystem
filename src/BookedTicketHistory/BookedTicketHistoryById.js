import React, { Component } from 'react';
import axios from 'axios';

class BookedTicketHistoryRetrieveById extends Component {

    constructor(props){
        super(props);
        this.state = {bookedTicketHistory:[], id:0};
    }

    loadData = () => {
        event.preventDefault();
        console.log(this.state.id);
        axios.get("http://localhost:8080/Airline/pkmkb/history/retrieve/"+this.state.id).
        then(result => this.setState({bookedTicketHistory : result.data.bookedTicketHistory}),e => console.log(e));
    }

    handleChange = (event) => {
        this.setState({[event.target.name] : event.target.value});
    }

    render(){
     
        
        return(
            <div>
                <h2>ticket history by ID</h2>
                Reservation ID : <input type="text" name="id" onChange={this.handleChange}/> <br/>
                <input value="Get Info" onClick={this.loadData} type="button"/> <br/>
                Reservation ID:{this.state.bookedTicketHistory.reservationId}<br/>
                        User ID:{this.state.bookedTicketHistory.userId}<br/>
                        Seat number:{this.state.bookedTicketHistory.seatNo}<br/>
                        Date Of Booking:{this.state.bookedTicketHistory.dateOfBooking}<br/>
                        Cost :{this.state.bookedTicketHistory.cost}<br/>
                        Flight ID:{this.state.bookedTicketHistory.flightId}<br/>
                     Ticket Status:{this.state.bookedTicketHistory.ticketStatus}<br/>
                    
                        Name:{this.state.bookedTicketHistory.name}<br/>
                        Age:{this.state.bookedTicketHistory.age}<br/>
                        Gender:{this.state.bookedTicketHistory.gender}<br/>
    
                        </div>
                        )
    }

}
export default BookedTicketHistoryRetrieveById