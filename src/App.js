import React, { Component } from 'react';
import logo from './logo.svg';
//import './App.css';
import {Route,Switch} from 'react-router-dom'

import AirportsRetrieve from './Airports/AirportsRetrieve'
import AirportsRetrieveSingle from './Airports/AirportsRetrieveSingle'
import AirportStore from './Airports/AirportStore'
import AirportsDelete from './Airports/AirportsDelete'
import Login from './Login'
import Dashboard from './Dashboard'
import CostRetrieve from './Cost/CostRetrieve'
import CostStore from  './Cost/CostStore'
import SignUp from './SignUp'
import ForgotPassword from './ForgotPassword'
import Cq from './childParent'
import FlightSearch from './FlightSchedule/FlightSearch'
import Book from './FlightSchedule/Book'
import {
  MDBContainer,
} from "mdbreact";
import Footer from './Footer'
import Navbar from './NavbarIndex'
import BookView from './BookedTicketHistory/BookedTicketHistoryById'
import DNL from './DashboardNotLogin'
import Logout from './Logout'
import Profile from './Profile'
import ViewTicket from './BookedTicketHistory/ViewTickets'
import CancelTicket from './BookedTicketHistory/Cancel'

class App extends Component {

  constructor(props){
    super(props);
    sessionStorage.setItem("login",0);
  }
  render() {

    return (
      <div>
        <Switch>
          <Route path="/home" component={Dashboard} ></Route>
          <Route path="/search" component={DNL} ></Route>
          <Route path="/signup" component={SignUp} ></Route>
          <Route path="/login" component={Login} ></Route>
          <Route path="/logout" component={Logout}></Route>
          <Route path="/forgotPassword" component={ForgotPassword} ></Route>
          <Route path="/book/:id/:seats" component={Book} ></Route>
          <Route path="/profile" component={Profile}></Route>
          <Route path="/view" component={ViewTicket}></Route>
          <Route path="/cancel/:id" component={CancelTicket}></Route>
          <Route path="/" component={DNL} ></Route>
        </Switch>
      <br/><br/><br/>
      <Footer></Footer>

      </div>
      
    );
  }
}

export default App;
