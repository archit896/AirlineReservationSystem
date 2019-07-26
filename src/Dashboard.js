import React, { Component } from 'react';
import axios from 'axios';
import FlightSearch from './FlightSchedule/FlightSearch';
import {Link} from 'react-router-dom';
import Logout from './Logout';
import Navbar from './NavbarHome';


class Dashboard extends Component {

    constructor(props){
        super(props);
        this.state = {}
    }

    render(){
        if(sessionStorage.getItem("type")=="customer"){
            var dashboard = <div></div>
        }
        if(sessionStorage.getItem("login")==1){
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
                    <Link to="">You need to Login!!!</Link>
                </div>
            )
        }
    }

}

export default Dashboard;