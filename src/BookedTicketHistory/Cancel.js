import React, { Component } from 'react';
import {Route,Switch,withRouter} from 'react-router-dom'
import axios from 'axios';

class CancelTicket extends Component {
    
        constructor(props){
            super(props);
            this.state = {reservationId:props.match.params.id, ticket:""}
        }
    
        componentWillMount(){
            axios.put("http://localhost:8080/Airline/pkmkb/history/cancelTicket/"+this.state.reservationId).this(result => console.log(result.data), e => console.log(e))
            //axios.delete("http://localhost:8080/Airline/pkmkb/history/delete?reservationId="+this.state.reservationId).
            //this(result => alert(result.data),e=>console.log(e))
            this.props.history.push("view");
        
        }
    
        render(){
            return(
                <div>
                    {this.state.reservationId}
                </div>
            )
        }
    
    }
    
    export default withRouter(CancelTicket);