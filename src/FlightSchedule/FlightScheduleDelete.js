import React, { Component } from 'react';
import axios from 'axios';

class FlightScheduleStoreDelete extends Component{

    constructor(props){
        super(props);
        this.state = {id:0, msg : ""};
    }

    loadData = () => {
        axios.delete("http://localhost:8080/Airline/pkmkb/flightSchedule/delete?flightId="+this.state.id).
        then(result => this.setState({msg : result.data}),e => console.log(e));
    }

    handleChange = (event) => {
        this.setState({[event.target.name] : event.target.value});
    }

    render(){
        return(
            <div>
                <h2>Delete Flight Schedule details by ID</h2>
                ID : <input type="text" name="id" onChange={this.handleChange}/> <br/>
                <input value="Delete" onClick={this.loadData} type="button"/> <br/>
                {this.state.msg}
            </div>
        );
    }
}
export default FlightScheduleStoreDelete;