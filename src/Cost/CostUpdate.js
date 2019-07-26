import React, { Component } from 'react';
import axios from 'axios';

class CostUpdate extends Component{
    constructor(props){
        super(props);
        this.state = {planeId : 0, validFrom : "", validTo : "", cost : 0.0};
    }

    updateInfo = () => {
        event.preventDefault();        
        console.log(this.state);
        axios.post("http://localhost:8080/Airline/pkmkb/cost/update", this.state).
        then(result => console.log(result),e => console.log(e));
    }

    handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
    }

    render(){
        return(
            <div>
                <h2>Cost Store Info</h2>
                <form onSubmit={this.storeInfo} >
                    <label>Plane ID : </label><input type="text" name="planeId" value={this.}onChange={this.handleChange} /><br/>
                    <label>Valid From : </label><input type="date" name="validFrom" onChange={this.handleChange}/><br/>
                    <label>Valid To : </label><input type="date" name="validTo" onChange={this.handleChange}/><br/>
                    <label>Cost : </label><input type="text" name="cost" onChange={this.handleChange}/><br/>    
                    <input type="submit" value="Store" />
                </form>
            </div>
        );
    }
}
export default CostStore;