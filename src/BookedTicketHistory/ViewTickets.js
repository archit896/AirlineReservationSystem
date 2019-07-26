import React, { Component } from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';
import {
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBModalFooter,
    MDBIcon,
    MDBCardHeader,
    MDBBtn,
    MDBInput
  } from "mdbreact";
  import { MDBCardImage, MDBCardTitle, MDBCardText } from 'mdbreact';
  import Navbar from '../NavbarHome'

class ViewTicket extends Component{
    constructor(props){
        super(props);
        this.state={tickets:[], ticket:"", single:undefined, length:0, seat:0};
    }

    componentWillMount(){
        axios.get("http://localhost:8080/Airline/pkmkb/user/ticket/"+sessionStorage.getItem("userId")).
        then(result => {
            if(result.data.universal.length == undefined){
                console.log(result.data);
                this.setState({ticket:result.data.universal, single:true});          
            }else{
                console.log(result.data);
                this.setState({tickets:result.data.universal, single:false, length:result.data.universal.length});
            }},e => console.log(e));
            console.log(this.state.single);
    }

    handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
    }

    cancelTicket = (event) => {
        console.log(event.target.id);
        this.onCancel();        
        axios.put("http://localhost:8080/Airline/pkmkb/history/cancelTicket/"+event.target.id).
        then(result => console.log(result),e => console.log(e));       
        this.onCancel();
    }

    onCancel = () => {
        axios.get("http://localhost:8080/Airline/pkmkb/user/ticket/"+sessionStorage.getItem("userId")).
        then(result => {
            if(result.data.universal.length == undefined){
                console.log(result.data);
                this.setState({ticket:result.data.universal, single:true});          
            }else{
                console.log(result.data);
                this.setState({tickets:result.data.universal, single:false, length:result.data.universal.length});
            }},e => console.log(e));
            console.log(this.state.single);
    }



    render(){
        if(sessionStorage.getItem("login")==1){
            if(this.state.single){
                var airportsRec =  <div>
                                        <MDBCard>
                                          <MDBCardBody>
                                            <MDBCardTitle><MDBIcon icon="plane"/>  {this.state.ticket.planeVendor}</MDBCardTitle>
                                            <MDBCardText>
                                            <table border="0" align="center">
                                            <thead>
                                                <th>ID</th>
                                                <th>From</th>
                                                <th>To</th>
                                                <th>Name</th>
                                                <th>Gender/Age</th>
                                                <th>Departure</th>
                                                <th>Arrival</th>
                                                <th>Seats No.</th>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td> {this.state.ticket.reservationId}</td>
                                                    <td> {this.state.ticket.locationOrigin}</td>
                                                    <td> {this.state.ticket.locationDestination}</td>
                                                    <td> {this.state.ticket.userName}</td>
                                                    <td> {this.state.ticket.userGender}/{this.state.ticket.userAge}</td>
                                                    <td> {this.state.ticket.departureTime}</td>
                                                    <td> {this.state.ticket.arrivalTime}</td>
                                                    <td> {this.state.ticket.seatNo}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                            </MDBCardText>
                                            <MDBCardTitle>Status :  {this.state.ticket.ticketStatus}</MDBCardTitle>
                                            <MDBCardTitle><MDBIcon icon="rupee-sign"/>{this.state.ticket.cost}</MDBCardTitle>
                                            <MDBBtn color="black"style={this.state.ticket.ticketStatus=="booked" ? {} : { display: 'none'}}><Link to={{pathname:`/cancel/${this.state.ticket.reservationId}`}} style={{color: '#FFF' }} >Cancel</Link></MDBBtn>
                                          </MDBCardBody>
                                        </MDBCard><br/>
                                    </div>
            }else {
    
                var airportsRec = this.state.tickets.map(ele =>  
                    
                                    <div>
                                    <MDBCard>
                                      <MDBCardBody>
                                        <MDBCardTitle><MDBIcon icon="plane"/>  {ele.planeVendor}</MDBCardTitle>
                                        <MDBCardText>
                                        <table border="0" align="center" >
                                        <thead>
                                            <th>ID</th>
                                            <th>From</th>
                                            <th>To</th>
                                            <th>Name</th>
                                            <th>Gender/Age</th>
                                            <th>Departure</th>
                                            <th>Arrival</th>
                                            <th>Seats No.</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                            <td> {ele.reservationId}</td>
                                            <td> {ele.locationOrigin}</td>
                                            <td> {ele.locationDestination}</td>
                                            <td> {ele.userName}</td>
                                            <td> {ele.userGender}/{this.state.ticket.userAge}</td>
                                            <td> {ele.departureTime}</td>
                                            <td> {ele.arrivalTime}</td>
                                            <td> {ele.seatNo}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                        </MDBCardText>
                                        <MDBCardTitle>Status :  {ele.ticketStatus}</MDBCardTitle>
                                        <MDBCardTitle><MDBIcon icon="rupee-sign"/>{ele.cost}</MDBCardTitle>
                                        <MDBBtn color="black" style={ele.ticketStatus=="booked" ? {} : { display: 'none'}} onClick={this.cancelTicket} id={ele.reservationId} >Cancel</MDBBtn>
                                      </MDBCardBody>
                                    </MDBCard><br/>
                </div>   )  
            }}else{
                var airportsRec =  <div>
                                        <Link to="login">You need to Login</Link>
                                    </div>
                             
                               
            }
        return(
            <div>
                <Navbar></Navbar>
                <br/><br/>
                <MDBContainer>
                {airportsRec}
                </MDBContainer>
            </div>
        );
    }
}
export default ViewTicket;