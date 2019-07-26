import React, { Component } from 'react';
import axios from 'axios';

class FlightScheduleStore extends Component{
    constructor(props){
        super(props);
        this.state = {planeId : 0, departureTime:"",arrivalTime:"",costId:0,delayMinutes:0,
        origin:0,destination:0,flightStatus:"",seatsAvailable:0};
    }

    storeInfo = () => {
        event.preventDefault();        
        console.log(this.state);
        axios.post("http://localhost:8080/Airline/pkmkb/flightSchedule/insert/"+this.state.departureTime
    +"/"+this.state.arrivalTime,this.state).
        then(result => console.log(result),e => console.log(e));
    }

    handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
    }

    render(){
        return(
            <div>
                <h2>Flight schedule Store Info</h2>
                <form onSubmit={this.storeInfo} >
                    <label>Plane ID : </label><input type="text" name="planeId"  onChange={this.handleChange} /><br/>
                    
                    <label>Cost Id: </label><input type="text" name="costId" onChange={this.handleChange}/><br/>
                    <label>Delay Minutes : </label><input type="text" name="delayMinutes" onChange={this.handleChange}/><br/>
                    <label>Origin : </label><input type="text" name="origin" onChange={this.handleChange}/><br/>
                    <label>Destination : </label><input type="text" name="destination" onChange={this.handleChange}/><br/>
                    <label>flightStatus : </label><input type="text" name="flightStatus" onChange={this.handleChange}/><br/>
                    <label>Seats Available : </label><input type="text" name="seatsAvailable" onChange={this.handleChange}/><br/> 


                    <label>Departure Time </label><input type="text" name="departureTime" 
                    placeholder="dd-MMM-yyyy hh.mm.ss" onChange={this.handleChange}/><br/>
                    <label>Arrival Time : </label><input type="text" name="arrivalTime" 
                    placeholder="dd-MMM-yyyy hh.mm.ss" onChange={this.handleChange}/><br/> 

                    <input type="submit" value="Store" />
                </form>
            </div>
        );
    }
}
export default FlightScheduleStore;