import React, { Component } from 'react';
import axios from 'axios';

class AirportsRetrieveSingle extends Component {

    constructor(props){
        super(props);
        this.state = {airport:"", id:0};
    }

    loadData = () => {
        axios.get("http://localhost:8080/Airline/pkmkb/airports/retrieve?airportId="+this.state.id).
        then(result => this.setState({airport : result.data}),e => console.log(e));
    }

    handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
        }

    render(){
        return(
            <div>
                <h2>Employee details by ID</h2>
                ID : <input type="text" name="id" onChange={this.handleChange}/> <br/>
                <input value="Get Info" onClick={this.loadData} type="button"/> <br/>
                Name : {this.state.airport.airportName} <br/>
                Location : {this.state.airport.location} <br/>
            </div>
        );
    }

}
export default AirportsRetrieveSingle