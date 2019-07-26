import React, { Component } from 'react';
import axios from 'axios';

class CostRetrieve extends Component {

    constructor(props){
        super(props);
        this.state = {costs:[]};
    }

    loadData = () => {
        axios.get("http://localhost:8080/Airline/pkmkb/cost/retrieveAll").
        then(result => this.setState({costs : result.data.flightCost}),e => console.log(e));
    }

    render(){
        let costRec = this.state.costs.map(ele =>      
            <tbody  key={ele.costId.toString()}>
                <tr>
                    <td>{ele.costId}</td>
                    <td>{ele.planeId}</td>
                    <td>{ele.validFrom}</td>
                    <td>{ele.validTo}</td>
                    <td>{ele.cost}</td>
                </tr>
            </tbody>
        );

        return(
            <div>
                <h2>Costs</h2>
                <input type="button" value="Load Costs" onClick={this.loadData} />
                <table border="1">
                    <thead>
                        <th>CostId</th>
                        <th>PlaneId</th>
                        <th>Valid From</th>
                        <th>Valid To</th>
                        <th>Cost</th>
                    </thead>
                        {costRec}
                </table>
            </div>
        );
    }
}

export default CostRetrieve;