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
  

class FlightSearch extends Component{
    constructor(props){
        super(props);
        this.state = {flights:[], length:0, flight:"", origin:"", destination:"", date:"", seats:0, single:undefined};
    }

    loadData = () => {
        event.preventDefault();        
        axios.get("http://localhost:8080/Airline/pkmkb/flightSchedule/search/"+this.state.origin
        +"/"+this.state.destination+"/"+this.state.date+"/"+this.state.seats).
        then(result => {
        if(result.data.flights.length == undefined){
            console.log(result.data);
            this.setState({flight:result.data.flights, single:true});          
        }else{
            this.setState({flights:result.data.flights, single:false, length:result.data.flights.length});
        }},e => console.log(e));
    }

    handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
    }

    render(){

        if(sessionStorage.getItem("login")==1){
        if(this.state.single){
            var airportsRec =  <div>
                                    <MDBCard>
                                      <MDBCardBody>
                                        <MDBCardTitle><MDBIcon icon="plane"/>  {this.state.flight.planeVendor}</MDBCardTitle>
                                        <MDBCardText>
                                        <table border="0" align="center">
                                        <thead>
                                            <th>ID</th>
                                            <th>Origin</th>
                                            <th>From</th>
                                            <th>Destination</th>
                                            <th>To</th>
                                            <th>Departure</th>
                                            <th>Arrival</th>
                                            <th>Seats Available</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td> {this.state.flight.flightId}</td>
                                                <td> {this.state.flight.airportNameOrigin}</td>
                                                <td>{this.state.flight.locationOrigin}</td>
                                                <td> {this.state.flight.airportNameDestination}</td>
                                                <td> {this.state.flight.locationDestination}</td>
                                                <td> {this.state.flight.departureTime}</td>
                                                <td> {this.state.flight.arrivalTime}</td>
                                                <td> {this.state.flight.seatsAvailable}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                        </MDBCardText>
                                        <MDBCardTitle><MDBIcon icon="rupee-sign"/>{this.state.flight.cost}</MDBCardTitle>
                                        <MDBBtn color="black"><Link to={{pathname:`/book/${this.state.flight.flightId}/${this.state.seats}`}} style={{ color: '#FFF' }}>Book</Link></MDBBtn>
                                      </MDBCardBody>
                                    </MDBCard><br/>
                                </div>
                         
                           
        }else {

            var airportsRec = this.state.flights.map(ele =>  

                <div>
                <MDBCard>
                  <MDBCardBody>
                    <MDBCardTitle><MDBIcon icon="plane"/>  {ele.planeVendor}</MDBCardTitle>
                    <MDBCardText>
                    <table border="0" align="center" >
                    <thead>
                        <th>ID</th>
                        <th>Origin</th>
                        <th>From</th>
                        <th>Destination</th>
                        <th>To</th>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Seats Available</th>
                    </thead>
                    <tbody>
                        <tr>
                        <td>{ele.flightId}</td>
                        <td>{ele.airportNameOrigin}</td>
                        <td>{ele.locationOrigin}</td>
                        <td>{ele.airportNameDestination}</td>
                        <td>{ele.locationDestination}</td>
                        <td>{ele.departureTime}</td>
                        <td>{ele.arrivalTime}</td>
                        <td>{ele.seatsAvailable}</td>
                        </tr>
                    </tbody>
                </table>
                    </MDBCardText>
                    <MDBCardTitle><MDBIcon icon="rupee-sign"/>{ele.cost}</MDBCardTitle>
                    <MDBBtn color="black"><Link to={{pathname:`/book/${ele.flightId}/${this.state.seats}`}} style={{ color: '#FFF' }}>Book</Link></MDBBtn>
                  </MDBCardBody>
                </MDBCard><br/>
            </div>  
            );

        }}else{if(this.state.single){
            var airportsRec =  <div>
                                    <MDBCard>
                                      <MDBCardBody>
                                        <MDBCardTitle><MDBIcon icon="plane"/>  {this.state.flight.planeVendor}</MDBCardTitle>
                                        <MDBCardText>
                                        <table border="0" align="center">
                                        <thead>
                                            <th>ID</th>
                                            <th>Origin</th>
                                            <th>From</th>
                                            <th>Destination</th>
                                            <th>To</th>
                                            <th>Departure</th>
                                            <th>Arrival</th>
                                            <th>Seats Available</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td> {this.state.flight.flightId}</td>
                                                <td> {this.state.flight.airportNameOrigin}</td>
                                                <td>{this.state.flight.locationOrigin}</td>
                                                <td> {this.state.flight.airportNameDestination}</td>
                                                <td> {this.state.flight.locationDestination}</td>
                                                <td> {this.state.flight.departureTime}</td>
                                                <td> {this.state.flight.arrivalTime}</td>
                                                <td> {this.state.flight.seatsAvailable}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                        </MDBCardText>
                                        <MDBCardTitle><MDBIcon icon="rupee-sign"/>{this.state.flight.cost}</MDBCardTitle>
                                      </MDBCardBody>
                                    </MDBCard><br/>
                                </div>
                         
                           
        }else {

            var airportsRec = this.state.flights.map(ele =>  

                <div>
                <MDBCard>
                  <MDBCardBody>
                    <MDBCardTitle><MDBIcon icon="plane"/>  {ele.planeVendor}</MDBCardTitle>
                    <MDBCardText>
                    <table border="0" align="center" >
                    <thead>
                        <th>ID</th>
                        <th>Origin</th>
                        <th>From</th>
                        <th>Destination</th>
                        <th>To</th>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Seats Available</th>
                    </thead>
                    <tbody>
                        <tr>
                        <td>{ele.flightId}</td>
                        <td>{ele.airportNameOrigin}</td>
                        <td>{ele.locationOrigin}</td>
                        <td>{ele.airportNameDestination}</td>
                        <td>{ele.locationDestination}</td>
                        <td>{ele.departureTime}</td>
                        <td>{ele.arrivalTime}</td>
                        <td>{ele.seatsAvailable}</td>
                        </tr>
                    </tbody>
                </table>
                    </MDBCardText>
                    <MDBCardTitle><MDBIcon icon="rupee-sign"/>{ele.cost}</MDBCardTitle>
                  </MDBCardBody>
                </MDBCard><br/>
            </div>  
            );

        }

        }
        return(
            <div>
            <MDBContainer>
              <MDBRow>
                <MDBCol>
                  <MDBCard>
                    <MDBCardBody>
                      <MDBCardHeader className="form-header deep-blue-gradient rounded">
                        <h3 className="my-3">
                          <MDBIcon icon="plane" /> Flight Search:
                        </h3>
                      </MDBCardHeader>
                      <form onSubmit={this.loadData}>
                        <div className="grey-text">
                        <MDBIcon icon="plane-departure" />
                            <select className="browser-default custom-select" name="origin" onChange={this.handleChange} >
                                <option>From..</option>
                                <option value="Delhi">Delhi</option>
                                <option value="Mumbai">Mumbai</option>
                                <option value="Banglore">Banglore</option>
                                <option value="Chennai">Chennai</option>
                            </select>
                            <MDBIcon icon="plane-arrival" />
                            <select className="browser-default custom-select" name="destination" onChange={this.handleChange} >
                                <option>To..</option>
                                <option value="Delhi">Delhi</option>
                                <option value="Mumbai">Mumbai</option>
                                <option value="Banglore">Banglore</option>
                                <option value="Chennai">Chennai</option>
                            </select>
                          <MDBInput
                            label="Type Date in DD-MM-YY"
                            icon="calendar"
                            group
                            type="text"
                            name="date"
                            onChange={this.handleChange}
                            validate
                          />
                          <MDBInput
                            label="Seats"
                            icon="chair"
                            group
                            type="number"
                            name="seats"
                            onChange={this.handleChange}
                            validate
                          />
                        </div>

                      <div className="text-center mt-4">
                        <MDBBtn
                          color="light-blue"
                          className="mb-3"
                          type="submit"
                        >
                          Search
                        </MDBBtn>
                      </div>
                      </form><br/><br/>
                      <MDBCardText>
                      <div className="font-weight-light text-center">
                      {airportsRec}
                      <Link to="">You need to Login!!!</Link>
                  </div>
                    </MDBCardText>

                    </MDBCardBody>
                  </MDBCard>
                </MDBCol>
              </MDBRow>
            </MDBContainer>
            </div>
        );
    }
}
export default FlightSearch;