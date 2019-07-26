import React, { Component } from 'react';
import axios from 'axios';

class FlightScheduleRetrieveAll extends Component {

    constructor(props){
        super(props);
        this.state = {flightSchedule:[]};
    }

    loadData = () => {
        axios.get("http://localhost:8080/Airline/pkmkb/flightSchedule/retrieve").
        then(result => this.setState({flightSchedule : result.data.flightSchedule}),e => console.log(e));
    }

    render(){
        let flightScheduleRec = this.state.flightSchedule.map(ele =>      
            <tbody  key={ele.flightId.toString()}>
                <tr>
                    <td>{ele.flightId}</td>
                    <td>{ele.planeId}</td>
                    <td>{ele.departureTime}</td>
                    <td>{ele.arrivalTime}</td>
                    <td>{ele.costId}</td>
                    <td>{ele.delayMinutes}</td>
                    <td>{ele.origin}</td>
                    <td>{ele.destination}</td>
                    <td>{ele.flightStatus}</td>
                    <td>{ele.seatsAvailable}</td>

                </tr>
            </tbody>
        )

        return(
            <div>
                
                <h2>Flight Cost</h2>
                <input type="button" value="Load Flight Schedule" onClick={this.loadData} />
                <table border="1">
                    <thead>
                        <th>Flight ID</th>
                        <th>Plane ID</th>
                        <th>Departure Time</th>
                        <th>Arrival Time</th>
                        <th>Cost Id</th>
                        <th>Delay Minutes</th>
                        <th>Origin</th>
                        <th>Destination</th>
                        <th>Flight Status</th>
                        <th>Seat Available</th>
                    </thead>
                        {flightScheduleRec}
                </table>
            </div>
        )
    }
}

export default FlightScheduleRetrieveAll;