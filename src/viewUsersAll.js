import React,{Component} from 'react';
import axios from'axios';

class ViewUsersAll extends Component{
    constructor(props){
        super(props);
        this.state={userDetails:[] ,userDetail:"" , userId:0,single:undefined};
    }
 loadData=(event)=>{
     event.preventDefault();
     console.log(this.state.userId);
 axios.get("http://localhost:8080/Airline/pkmkb/user/vieww/"+this.state.userId).
 then(result=>
        {    if(result.data.universal.length == undefined){
                 console.log(result.data);
              this.setState({userDetail:result.data.universal,single:true});
                       }else{
                      console.log(result.data);
                     this.setState({userDetails:result.data.universal ,single:false,});
                      }
                    },e =>console.log(e));
 }

changeValue=(event)=>{
    let name=event.target.name;
    let value=event.target.value;
    this.setState({[name]:value});
};

    render(){ 
        if(this.state.single){
        var usersRec =  <table border="1">
                                <thead>
                                    <th>User Id</th>
                                    <th>User Account Name</th>
                                    <th>User Email</th>
                                    <th>Password</th>
                                    <th>Type</th>
                                    <th>User Age</th>
                                    <th>User Gender</th>
                                    <th>Security Question</th>
                                    <th>Security Answer</th>

                                   

                                    <th>Plane Id</th>
                                    <th>Plane Type</th>
                                    <th>Plane Vendor</th>

                                    
                                     <th>Cost Id</th>
                                     
                                     <th>Valid From</th>
                                      <th>Valid To</th>
                                      <th>Flight Cost</th>

                                      <th>Flight ID</th>
                                 
                                      <th>Departure Time</th>
                                      <th>Arrival Time</th>
                      
                                     <th>Delay Minutes</th>

                                     <th>Airports Name Origin</th>
                                     <th>Airports Location Origin</th>
                                     <th>Airports Name Destination</th>
                                     <th>Airports Location Destination</th>

                                    <th>Flight Status</th>
                                     <th>Seat Available</th>
                                     <th>Reservation ID</th>
                                   
                                <th>Seat Number</th>
                     
                                <th>Date Of Booking</th>
                                      <th>cost Paid</th>
                              
                                   <th>Ticket Status</th>
                                       <th>Name</th>
                                     <th>Age</th>
                                      <th>Gender</th>
                                      <th>Transaction Id</th>
                      
                                     <th>Status</th>
                                        <th>Transaction (updated)Cost</th>
                                     <th>Transaction Date</th>


                              

                                 
                                </thead>

                             
                                <tbody>
                                    <tr>
                                        <td>{this.state.userDetail.userId}</td>
                                        <td> {this.state.userDetail.userName}</td>
                                        <td> {this.state.userDetail.email}</td>
                                        <td>{this.state.userDetail.password}</td>
                                        <td> {this.state.userDetail.type}</td>
                                        <td> {this.state.userDetail.userAge}</td>
                                        <td> {this.state.userDetail.userGender}</td>
                                        <td> {this.state.userDetail.secQues}</td>
                                        <td> {this.state.userDetail.secAns}</td>

                                        <td> {this.state.userDetail.planeId}</td>
                                        <td> {this.state.userDetail.planeType}</td>
                                        <td> {this.state.userDetail.planeVendor}</td>

                                        
                                        <td> {this.state.userDetail.costId}</td>
                                        <td> {this.state.userDetail.validFrom}</td>
                                        
                                        <td> {this.state.userDetail.validTo }</td>
                                        <td> {this.state.userDetail.cost}</td>

                                        <td>{this.state.userDetail.flightId}</td>
                                        <td> {this.state.userDetail.departureTime}</td>
                                        <td> {this.state.userDetail.arrivalTime}</td>
                                        <td>{this.state.userDetail.delayMinutes}</td>

                                        <td> {this.state.userDetail.airportNameOrigin}</td>
                                        <td> {this.state.userDetail.locationOrigin}</td>
                                        <td> {this.state.userDetail.airportNameDestination}</td>
                                        <td> {this.state.userDetail.locationDestination}</td>
                                        <td> {this.state.userDetail.flightStatus}</td>
                                        
                                        <td> {this.state.userDetail.seatsAvailable}</td>



                                        <td> {this.state.userDetail.reservationId}</td>
                                        <td> {this.state.userDetail.seatNo}</td>
                                        <td> {this.state.userDetail.dateOfBooking}</td>
                                        <td> {this.state.userDetail.bookedTicketHistoryCost}</td>
                                        
                                        <td> {this.state.userDetail.ticketStatus}</td>
                                        <td> {this.state.userDetail.name}</td>
                                        <td> {this.state.userDetail.age}</td>
                                        <td> {this.state.userDetail.gender}</td>
                                        
                                        <td> {this.state.userDetail.transactionId}</td>
                                        <td> {this.state.userDetail.status}</td>
                                        <td> {this.state.userDetail.transactionCost}</td>
                                        <td> {this.state.userDetail.transactionDate}</td>
                                        
                                    </tr>
                                </tbody>
                            </table>
    }else {
        var usersRec = this.state.userDetails.map(ele => 
            <table border="1" key={ele.userId.toString()} >
             <thead>
                                    <th>User Id</th>
                                    <th>User Account Name</th>
                                    <th>User Email</th>
                                    <th>Password</th>
                                    <th>Type</th>
                                    <th>User Age</th>
                                    <th>User Gender</th>
                                    <th>Security Question</th>
                                    <th>Security Answer</th>

                                   

                                    <th>Plane Id</th>
                                    <th>Plane Type</th>
                                    <th>Plane Vendor</th>

                                    
                                     <th>Cost Id</th>
                                     
                                     <th>Valid From</th>
                                      <th>Valid To</th>
                                      <th>Flight Cost</th>

                                      <th>Flight ID</th>
                                 
                                      <th>Departure Time</th>
                                      <th>Arrival Time</th>
                      
                                     <th>Delay Minutes</th>

                                     <th>Airports Name Origin</th>
                                     <th>Airports Location Origin</th>
                                     <th>Airports Name Destination</th>
                                     <th>Airports Location Destination</th>

                                    <th>Flight Status</th>
                                     <th>Seat Available</th>
                                     <th>Reservation ID</th>
                                   
                                <th>Seat Number</th>
                     
                                <th>Date Of Booking</th>
                                      <th>cost Paid</th>
                              
                                   <th>Ticket Status</th>
                                       <th>Name</th>
                                     <th>Age</th>
                                      <th>Gender</th>
                                      <th>Transaction Id</th>
                      
                                     <th>Status</th>
                                        <th>Transaction (updated)Cost</th>
                                     <th>Transaction Date</th>


                              

                                 
                                </thead>

                             
                                <tbody>
                                    <tr>
                                        <td>{ele.userId}</td>
                                        <td> {ele.userName}</td>
                                        <td> {ele.email}</td>
                                        <td>{ele.password}</td>
                                        <td> {ele.type}</td>
                                        <td> {ele.userAge}</td>
                                        <td> {ele.userGender}</td>
                                        <td> {ele.secQues}</td>
                                        <td> {ele.secAns}</td>

                                        <td> {ele.planeId}</td>
                                        <td> {ele.planeType}</td>
                                        <td> {ele.planeVendor}</td>

                                        
                                        <td> {ele.costId}</td>
                                        <td> {ele.validFrom}</td>
                                        
                                        <td> {ele.validTo }</td>
                                        <td> {ele.cost}</td>

                                        <td>{ele.flightId}</td>
                                        <td> {ele.departureTime}</td>
                                        <td> {ele.arrivalTime}</td>
                                        <td>{ele.delayMinutes}</td>

                                        <td> {ele.airportNameOrigin}</td>
                                        <td> {ele.locationOrigin}</td>
                                        <td> {ele.airportNameDestination}</td>
                                        <td> {ele.locationDestination}</td>
                                        <td> {ele.flightStatus}</td>
                                        
                                        <td> {ele.seatsAvailable}</td>



                                        <td> {ele.reservationId}</td>
                                        <td> {ele.seatNo}</td>
                                        <td> {ele.dateOfBooking}</td>
                                        <td> {ele.bookedTicketHistoryCost}</td>
                                        
                                        <td> {ele.ticketStatus}</td>
                                        <td> {ele.name}</td>
                                        <td> {ele.age}</td>
                                        <td> {ele.gender}</td>
                                        
                                        <td> {ele.transactionId}</td>
                                        <td> {ele.status}</td>
                                        <td> {ele.transactionCost}</td>
                                        <td> {ele.transactionDate}</td>
                                        
                                    </tr>
                                </tbody>
                            </table>
        );
    }
        
        
        return(
            <div>
                <h1>User info  retrieve by id</h1>
                
                <label>Insert User Id</label>
                <input type="text" name="userId" onChange={this.changeValue}/>
                <input type="submit" value="rerieve" onClick={this.loadData} />
                
               {usersRec}
            </div>
        );
    }
}
export default ViewUsersAll ;