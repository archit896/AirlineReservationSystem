import React, { Component } from 'react';
import axios from 'axios';
import FlightSearch from './FlightSchedule/FlightSearch'
import {Link} from 'react-router-dom';
import Logout from './Logout'
import Navbar from './NavbarIndex'


class Dashboard extends Component {

    constructor(props){
        super(props);
        this.state = {}
    }

    render(){
        if(sessionStorage.getItem("login")==0){
            return(
                <div>
                    <Navbar></Navbar>
                    <br/><br/>
                    <FlightSearch></FlightSearch>
                </div>
            )
        }else{
            return(
                <div>
                    <Link to="home">You are already Login!!!</Link>
                </div>
            )
        }
    }

}

export default Dashboard;