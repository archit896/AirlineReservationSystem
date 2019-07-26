import React, { Component } from 'react';
import axios from 'axios';
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
import {Link} from 'react-router-dom';
import Navbar from './NavbarHome'

class Login extends Component{
    constructor(props){
        super(props);
        this.state = {updateName:false, updateEmail:false, updatePhone:false, updateAge:false, 
        updateGender:false,updateSecQues:false,updateSecAns:false, name:sessionStorage.getItem("name"),
         email:sessionStorage.getItem("email"), phone:sessionStorage.getItem("phone"),
         password:sessionStorage.getItem("password"), type:sessionStorage.getItem("type"),
         age:sessionStorage.getItem("age"), gender:sessionStorage.getItem("gender"),
         secQues:sessionStorage.getItem("secQues"), secAns:sessionStorage.getItem("secAns"),
        userId:sessionStorage.getItem("userId") };
    }


    startUpdate = (event) => {
        this.setState({[event.target.name]:true})
    }

    handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
    }

    update = () => {
        axios.put("http://localhost:8080/Airline/pkmkb/user/update", this.state).then(result => console.log(result), e => console.log(e));
        sessionStorage.setItem("name", this.state.name);
        sessionStorage.setItem("email", this.state.email);
        sessionStorage.setItem("phone", this.state.phone);
        sessionStorage.setItem("type", this.state.type);
        sessionStorage.setItem("age", this.state.age);
        sessionStorage.setItem("gender", this.state.gender);
        sessionStorage.setItem("secQues", this.state.secQues);
        sessionStorage.setItem("secAns", this.state.secAns);
        this.setState({updateName:false});
        this.setState({updateAge:false});
        this.setState({updateEmail:false});
        this.setState({updateGender:false});
        this.setState({updatePhone:false});
        this.setState({updateSecAns:false});
        this.setState({updateSecQues:false});        
    }

    render(){
        if(sessionStorage.getItem("login")==1){
            var profile = <div>
            <Navbar></Navbar>
            <div><br/><br/>
        <MDBContainer align="center">
        <MDBCard>
        <MDBCardBody>
            <MDBCardTitle><MDBIcon icon="user"/> User ID : {sessionStorage.getItem("userId")} </MDBCardTitle>
            <MDBCardTitle> Name : {sessionStorage.getItem("name")}
                <div style={this.state.updateName ? {} : { display: 'none'}}>
                    <MDBInput                             
                        label="Type your new Name"
                        group
                        type="text"
                        validate
                        error="wrong"
                        success="right"
                        name="name"
                        onChange={this.handleChange}/>
                    <MDBBtn onClick={this.update}>Update Name</MDBBtn>
                </div>
                <div style={this.state.updateName ? { display: 'none'} : {}}>
                    <MDBBtn name="updateName" onClick={this.startUpdate}>Update Name</MDBBtn>
                </div>
            </MDBCardTitle>
            <MDBCardTitle> Email : {sessionStorage.getItem("email")}
                <div style={this.state.updateEmail ? {} : { display: 'none'}}>
                    <MDBInput                             
                        label="Type your new Email"
                        group
                        type="email"
                        validate
                        error="wrong"
                        success="right"
                        name="email"
                        onChange={this.handleChange}/>
                    <MDBBtn onClick={this.update}>Update Email</MDBBtn>
                </div>
                <div style={this.state.updateEmail ? { display: 'none'} : {}}>
                    <MDBBtn name="updateEmail" onClick={this.startUpdate}>Update Email</MDBBtn>
                </div>
            </MDBCardTitle>
            <MDBCardTitle> Phone Number : {sessionStorage.getItem("phone")}
                <div style={this.state.updatePhone ? {} : { display: 'none'}}>
                    <MDBInput                             
                        label="Type your new Phone Number"
                        group
                        type="number"
                        validate
                        error="wrong"
                        success="right"
                        name="phone"
                        onChange={this.handleChange}/>
                    <MDBBtn onClick={this.update}>Update Phone</MDBBtn>
                </div>
                <div style={this.state.updatePhone ? { display: 'none'} : {}}>
                    <MDBBtn name="updatePhone" onClick={this.startUpdate}>Update Phone Number</MDBBtn>
                </div>
            </MDBCardTitle>
            <MDBCardTitle> Type : {sessionStorage.getItem("type")}</MDBCardTitle><br/>
            <MDBCardTitle> Age : {sessionStorage.getItem("age")}
                <div style={this.state.updateAge ? {} : { display: 'none'}}>
                    <MDBInput                             
                        label="Type your new Age"
                        group
                        type="number"
                        validate
                        error="wrong"
                        success="right"
                        name="age"
                        onChange={this.handleChange}/>
                    <MDBBtn onClick={this.update}>Update Age</MDBBtn>
                </div>
                <div style={this.state.updateAge ? { display: 'none'} : {}}>
                    <MDBBtn name="updateAge" onClick={this.startUpdate}>Update Age</MDBBtn>
                </div>
            </MDBCardTitle>
            <MDBCardTitle> Gender : {sessionStorage.getItem("gender")}
                <div style={this.state.updateGender ? {} : { display: 'none'}}>
                    <select className="browser-default custom-select" name="gender" onChange={this.handleChange} >
                        <option>Choose Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="transgender">TransGender</option>
                    </select>
                    <MDBBtn onClick={this.update}>Update Gender</MDBBtn>
                </div>
                <div style={this.state.updateGender ? { display: 'none'} : {}}>
                    <MDBBtn name="updateGender" onClick={this.startUpdate}>Update Gender</MDBBtn>
                </div>
            </MDBCardTitle>
            <MDBCardTitle> Security Question : {sessionStorage.getItem("secQues")}
                <div style={this.state.updateSecQues ? {} : { display: 'none'}}>
                    <MDBInput                             
                        label="Type your new Security Question"
                        group
                        type="text"
                        validate
                        error="wrong"
                        success="right"
                        name="secQues"
                        onChange={this.handleChange}/>
                    <MDBBtn onClick={this.update}>Update Security Question</MDBBtn>
                </div>
                <div style={this.state.updateSecQues ? { display: 'none'} : {}}>
                    <MDBBtn name="updateSecQues" onClick={this.startUpdate}>Update Security Question</MDBBtn>
                </div>
            </MDBCardTitle>
            <MDBCardTitle> Security Answer : {sessionStorage.getItem("secAns")}
                <div style={this.state.updateSecAns ? {} : { display: 'none'}}>
                    <MDBInput                             
                        label="Type your new Security Answer"
                        group
                        type="text"
                        validate
                        error="wrong"
                        success="right"
                        name="secAns"
                        onChange={this.handleChange}/>
                    <MDBBtn onClick={this.update}>Update Security Answer</MDBBtn>
                </div>
                <div style={this.state.updateSecAns ? { display: 'none'} : {}}>
                    <MDBBtn name="updateSecAns" onClick={this.startUpdate}>Update Security Answer</MDBBtn>
                </div>
            </MDBCardTitle>
        </MDBCardBody>
         </MDBCard>
         </MDBContainer><br/>
            </div>
        </div>
        }else{
            var profile = <div>
            <Link to="login">You need to Login</Link>
        </div>
        }
        return(
            <div>{profile}</div>
        );
    }
}
export default Login;