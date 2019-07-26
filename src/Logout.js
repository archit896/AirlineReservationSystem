import React, { Component } from 'react';
import {Route,Switch,withRouter} from 'react-router-dom'


class Logout extends Component {

    constructor(props){
        super(props);
        this.state = {}
    }

    componentWillMount(){
        sessionStorage.clear();
        sessionStorage.setItem("login",0);
        this.props.history.push("");        
    }

    render(){
        return(
            <div>
            </div>
        )
    }

}

export default withRouter(Logout);