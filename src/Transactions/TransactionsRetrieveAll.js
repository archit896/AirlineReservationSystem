import React, { Component } from 'react';
import axios from 'axios';

class TransactionsRetrieveAll extends Component {

    constructor(props){
        super(props);
        this.state = {transactions:[]};
    }

    loadData = () => {
        axios.get("http://localhost:8080/Airline/pkmkb/transaction/retrieveAll").
        then(result => this.setState({transactions : result.data.transactions}),e => console.log(e));
    }

    render(){
        let transactionsRec = this.state.transactions.map(ele =>      
            <tbody  key={ele.transactionId.toString()}>
                <tr>
                    <td>{ele.transactionId}</td>
                    <td>{ele.reservationId}</td>
                    <td>{ele.status}</td>
                    
                    <td>{ele.cost}</td>
                    <td>{ele.transactionDate}</td>
                </tr>
            </tbody>
        )

        return(
            <div>
                
                <h2>Transaction Details</h2>
                <input type="button" value="Load transaction details" onClick={this.loadData} />
                <table border="1">
                    <thead>
                        <th>Transaction Id</th>
                        <th>Reservation Id</th>
                        <th>Status</th>
                        <th>Cost</th>
                        <th>Transaction Date</th>
                    </thead>
                        {transactionsRec}
                </table>
            </div>
        )
    }
}

export default TransactionsRetrieveAll;