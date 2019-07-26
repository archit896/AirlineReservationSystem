import React, { Component } from 'react';
import axios from 'axios';

class TransactionRetreiveById extends Component {

    constructor(props){
        super(props);
        this.state = {transactions:[], id:0};
    }

    loadData = () => {
        event.preventDefault();
        console.log(this.state.id);
        axios.get("http://localhost:8080/Airline/pkmkb/transaction/retrieve?transactionId="+this.state.id).
        then(result => this.setState({transactions : result.data}),e => console.log(e));
    }

    handleChange = (event) => {
        this.setState({[event.target.name] : event.target.value});
    }

    render(){
     
        
        return(
            <div>
                <h2>Transactionshistory by ID</h2>
                Transactions ID : <input type="text" name="id" onChange={this.handleChange}/> <br/>
                <input value="Get Info" onClick={this.loadData} type="button"/> <br/>
                Transactions ID:{this.state.transactions.transactionId}<br/>
                        Reservation ID:{this.state.transactions.reservationId}<br/>
                        status:{this.state.transactions.status}<br/>
                       
                        Cost :{this.state.transactions.cost}<br/>
                        Transaction Date:{this.state.transactions.transactionDate}<br/>
                      
    
                        </div>
                        )
    }

}
export default TransactionRetreiveById