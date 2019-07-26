import React, { Component } from 'react';
import axios from 'axios';

class AirportStore extends Component{
    
    constructor(props){
        super(props);
        this.state = {airportId : 0, airportName : "", location : ""};
    }

    storeInfo = () => {
        event.preventDefault();        
        console.log(this.state);
        axios.post("http://localhost:8080/Airline/pkmkb/airports/store", this.state).
        then(result => console.log(result),e => console.log(e));
    }

    handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
    }

    checkValue = (event) => {
    }

    render(){
        return(
            <div>
                <h2>Airport Store Info</h2>
                <form onSubmit={this.storeInfo} >
                    <label>Airport ID : </label><input type="text" name="airportId" onChange={this.handleChange} /><br/>
                    <label>Airport Name : </label><input type="text" name="airportName" onChange={this.handleChange}/><br/>
                    <label>Location : </label><input type="text" name="location" onChange={this.handleChange}/><br/>    
                    <input type="submit" value="Store" />
                </form>
            </div>
        );
    }
}
export default AirportStore;