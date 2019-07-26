import React, { Component } from 'react';
import axios from 'axios';

class BookedTicketHistoryRetrieveAll extends Component {

    constructor(props){
        super(props);
        this.state = { bookedTicketHistory:[]};
    }

    loadData = () => {
        axios.get("http://localhost:8080/Airline/pkmkb/history/retrieveAll").
        then(result => this.setState({ bookedTicketHistory : result.data. bookedTicketHistory}),e => console.log(e));
    }

    render(){
        let  bookedTicketHistoryRec = this.state. bookedTicketHistory.map(ele =>      
            <tbody  key={ele.reservationId.toString()}>
                <tr>
                    <td>{ele.reservationId}</td>
                    <td>{ele.userId}</td>
                    <td>{ele.seatNo}</td>
                    <td>{ele.dateOfBooking}</td>
                    <td>{ele.cost}</td>
                    <td>{ele.flightId}</td>
                    <td>{ele.ticketStatus}</td>
                    <td>{ele.name}</td>
                    <td>{ele.age}</td>
                    <td>{ele.gender}</td>

                </tr>
            </tbody>
        )

        return(
            <div>
                
                <h2>Booked Ticket History</h2>
                <input type="button" value="Load Booked Ticket History" onClick={this.loadData} />
                <table border="1">
                    <thead>
                        <th>Reservation ID</th>
                        <th>User ID</th>
                        <th>Seat Number</th>
                     
                        <th>Date Of Booking</th>
                        <th>cost</th>
                        <th>Flight ID</th>
                        <th>Ticket Status</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                    </thead>
                        {bookedTicketHistoryRec}
                </table>
            </div>
        )
    }
}

export default BookedTicketHistoryRetrieveAll;