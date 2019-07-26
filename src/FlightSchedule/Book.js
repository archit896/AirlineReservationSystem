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

class Book extends Component{
    constructor(props){
        super(props);
        this.state = {name1:"", age1:0, gender1:"", name2:"", age2:0, gender2:"",
         flightId : props.match.params.id, flight:"", seats:props.match.params.seats,
          showBookingComponent:false, showBookingButton:true}     
    }


    componentWillMount(){
        axios.get("http://localhost:8080/Airline/pkmkb/flightSchedule/searchById/"+this.state.flightId).
        then(result => this.setState({flight:result.data.flights}),e => console.log(e));
    }
    
    handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
    }

    book = () => {
        this.setState({showBookingComponent:true});
    }

    bookTicket = () => {
        event.preventDefault();        
        console.log("Booking Ticket")
        if(this.state.seats == 1){
            var text = '{"age":"'+this.state.age1+'","cost":"'+this.state.flight.cost+'","flightId":"'+this.state.flight.flightId+'","seatNo":"0","ticketStatus":"booked","userId":"'+sessionStorage.getItem("userId")+'","gender":"'+this.state.gender1+'","name":"'+this.state.name1+'"}';
            var obj = JSON.parse(text);
            console.log(obj);
            axios.post("http://localhost:8080/Airline/pkmkb/history/store",obj).
            then(result => console.log(result),e => console.log(e));
        }else if(this.state.seats == 2){
            var text = '{"age":"'+this.state.age1+'","cost":"'+this.state.flight.cost+'","flightId":"'+this.state.flight.flightId+'","seatNo":"0","ticketStatus":"booked","userId":"'+sessionStorage.getItem("userId")+'","gender":"'+this.state.gender1+'","name":"'+this.state.name1+'"}';
            var obj = JSON.parse(text);
            console.log(obj);
            axios.post("http://localhost:8080/Airline/pkmkb/history/store",obj).
            then(result => console.log(result),e => console.log(e));
            var text1 = '{"age":"'+this.state.age2+'","cost":"'+this.state.flight.cost+'","flightId":"'+this.state.flight.flightId+'","seatNo":"0","ticketStatus":"booked","userId":"'+sessionStorage.getItem("userId")+'","gender":"'+this.state.gender2+'","name":"'+this.state.name2+'"}';
            var obj1 = JSON.parse(text1);
            console.log(obj);
            axios.post("http://localhost:8080/Airline/pkmkb/history/store",obj1).
            then(result => console.log(result),e => console.log(e));
        }
        this.props.history.push("/home")
    }
    back = () => {
      this.props.history.push("/home")
    }
    
    render(){
        if(this.state.showBookingComponent){
        if(this.state.seats == 1){
            var bookingForm =  <div>
                                         <br/><br/>
                                        
                                         <MDBContainer>
                                           <MDBRow>
                                             <MDBCol>
                                               <MDBCard>
                                                 <MDBCardBody>
                                                   <MDBCardHeader className="form-header deep-blue rounded">
                                                     <h3 className="my-3">
                                                       <MDBIcon icon="user" /> Passenger Details:
                                                     </h3>
                                                   </MDBCardHeader>
                                                   <br/><br/>
                                                   <form onSubmit={this.bookTicket}>
                                                     <div className="grey-text">
                                                       <MDBInput
                                                         label="Type your Name"
                                                         icon="user"
                                                         group
                                                         type="text"
                                                         validate
                                                         error="wrong"
                                                         success="right"
                                                         name="name1"
                                                         onChange={this.handleChange}
                                                       />
                                                       <MDBInput
                                                         label="Type your Age"
                                                         icon="hashtag"
                                                         group
                                                         type="number"
                                                         name="age1"
                                                         onChange={this.handleChange}
                                                         validate
                                                       />
                                                       <select className="browser-default custom-select" name="gender1" onChange={this.handleChange} >
                                                       <option>Choose Gender</option>
                                                       <option value="male">Male</option>
                                                       <option value="female">Female</option>
                                                       <option value="transgender">TransGender</option>
                                                   </select>
                                                     </div>
                             
                                                   <div className="text-center mt-4">
                                                     <MDBBtn
                                                       color="light-blue"
                                                       className="mb-3"
                                                       type="submit"
                                                     >
                                                       Book
                                                     </MDBBtn>
                                                   </div>
                                                   </form>
                                                 </MDBCardBody>
                                               </MDBCard>
                                             </MDBCol>
                                           </MDBRow>
                                         </MDBContainer>
                                       </div>
        }else if(this.state.seats == 2){
            var bookingForm =
                                <div>
                                <br/><br/>
                               
                                <MDBContainer>
                                  <MDBRow>
                                    <MDBCol>
                                      <MDBCard>
                                        <MDBCardBody>
                                          <MDBCardHeader className="form-header deep-blue rounded">
                                            <h3 className="my-3">
                                              <MDBIcon icon="user" /> Passengers Details:
                                            </h3>
                                          </MDBCardHeader>
                                          <form onSubmit={this.bookTicket}>
                                            <div className="grey-text"><br/><br/>
                                                Passenger 1 Details: 
                                              <MDBInput
                                                label="Type your Name"
                                                icon="user"
                                                group
                                                type="text"
                                                validate
                                                error="wrong"
                                                success="right"
                                                name="name1"
                                                onChange={this.handleChange}
                                              />
                                              <MDBInput
                                                label="Type your Age"
                                                icon="hashtag"
                                                group
                                                type="number"
                                                name="age1"
                                                onChange={this.handleChange}
                                                validate
                                              />
                                              <select className="browser-default custom-select" name="gender1" onChange={this.handleChange} >
                                              <option>Choose Gender</option>
                                              <option value="male">Male</option>
                                              <option value="female">Female</option>
                                              <option value="transgender">TransGender</option>
                                          </select><br/><br/>
                                          Passenger 2 Details: 
                                              <MDBInput
                                                label="Type your Name"
                                                icon="user"
                                                group
                                                type="text"
                                                validate
                                                error="wrong"
                                                success="right"
                                                name="name2"
                                                onChange={this.handleChange}
                                              />
                                              <MDBInput
                                                label="Type your Age"
                                                icon="hashtag"
                                                group
                                                type="number"
                                                name="age2"
                                                onChange={this.handleChange}
                                                validate
                                              />
                                              <select className="browser-default custom-select" name="gender2" onChange={this.handleChange} >
                                              <option>Choose Gender</option>
                                              <option value="male">Male</option>
                                              <option value="female">Female</option>
                                              <option value="transgender">TransGender</option>
                                          </select>
                                            </div>
                    
                                          <div className="text-center mt-4">
                                            <MDBBtn
                                              color="light-blue"
                                              className="mb-3"
                                              type="submit"
                                            >
                                              Book
                                            </MDBBtn>
                                          </div>
                                          </form>
                                        </MDBCardBody>
                                      </MDBCard>
                                    </MDBCol>
                                  </MDBRow>
                                </MDBContainer>
                              </div>
        }else{
            var bookingForm =   <div>No Family Booking Allowed!!</div> 
            this.setState({showBookingButton:false}) 
        }}else{}
        return(
 <div>
<div style={this.state.showBookingComponent ? {display: 'none' } : {}}>
                <MDBContainer align="center"><br/>
                <MDBCardTitle>Your Selected Flight</MDBCardTitle>
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
                <MDBBtn color="black" onClick={this.book}>Confirm Booking</MDBBtn>
                <MDBBtn color="black" onClick={this.back}>Back</MDBBtn>
              </MDBCardBody>
            </MDBCard><br/>
            </MDBContainer></div>
            <div style={this.state.showBookingComponent ? {} : { display: 'none' }}>
                        {bookingForm}

                </div>
                </div>
        )
    }
}
export default Book;