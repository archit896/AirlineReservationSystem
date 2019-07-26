import React, { Component } from 'react';
import axios from 'axios';

class FlightScheduleRetrieveById extends Component {

    constructor(props){
        super(props);
        this.state = {flightSchedule:[], id:0};
    }

    loadData = () => {
        event.preventDefault();
        console.log(this.state.id);
        axios.get("http://localhost:8080/Airline/pkmkb/flightSchedule/retrieveId?flightId="+this.state.id).
        then(result => this.setState({flightSchedule : result.data.flightSchedule}),e => console.log(e));
    }

    handleChange = (event) => {
        this.setState({[event.target.name] : event.target.value});
    }

    render(){
     
        
        return(
            <div>
                <h2>Flight Schedule by ID</h2>
                Flight ID : <input type="text" name="id" onChange={this.handleChange}/> <br/>
                <input value="Get Info" onClick={this.loadData} type="button"/> <br/>
                Flight ID:{this.state.flightSchedule.flightId}<br/>
                        Plane ID:{this.state.flightSchedule.planeId}<br/>
                        Departure Time:{this.state.flightSchedule.departureTime}<br/>
                        Arrival Time:{this.state.flightSchedule.arrivalTime}<br/>
                        Cost Id:{this.state.flightSchedule.costId}<br/>
                        Delay Minutes:{this.state.flightSchedule.delayMinutes}<br/>
                        Origin:{this.state.flightSchedule.origin}<br/>
                    
                        Destination:{this.state.flightSchedule.destination}<br/>
                        Flight Status:{this.state.flightSchedule.flightStatus}<br/>
                        Seat Available:{this.state.flightSchedule.seatsAvailable}<br/>
    
                        </div>
                        )
    }

}
export default FlightScheduleRetrieveById