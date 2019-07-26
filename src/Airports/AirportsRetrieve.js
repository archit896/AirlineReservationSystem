import React, { Component } from 'react';
import axios from 'axios';

class AirportsRetrieve extends Component {

    constructor(props){
        super(props);
        this.state = {airports:[]};
    }

    loadData = () => {
        axios.get("http://localhost:8080/Airline/pkmkb/airports/retrieveAll").
        then(result => this.setState({airports : result.data.airports}),e => console.log(e));
    }

    render(){
        let airportsRec = this.state.airports.map(ele =>      
            <tbody  key={ele.airportId.toString()}>
                <tr>
                    <td>{ele.airportId}</td>
                    <td>{ele.airportName}</td>
                    <td>{ele.location}</td>
                </tr>
            </tbody>
        );

        return(
            <div>
                <h2>Airports</h2>
                <input type="button" value="Load Airports" onClick={this.loadData} />
                <table border="1">
                    <thead>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Location</th>
                    </thead>
                        {airportsRec}
                </table>
            </div>
        );
    }
}

export default AirportsRetrieve;