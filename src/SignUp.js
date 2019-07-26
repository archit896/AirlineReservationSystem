import React, { Component } from 'react';
import axios from 'axios';
import { MDBDropdown, MDBDropdownToggle, MDBDropdownMenu, MDBDropdownItem } from "mdbreact";
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


class SignUp extends Component{
    constructor(props){
        super(props);
        this.state = {name:"", email:"", phone:0, password:"", type:"", age:0, gender:"", secQues:"", secAns:""};
    }

    storeInfo = () => {
        event.preventDefault();        
        console.log(this.state);
        axios.post("http://localhost:8080/Airline/pkmkb/user/store", this.state).
        then(result => console.log(result),e => console.log(e));
        this.props.history.push("");
    }

    handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
    }

    render(){
        return(
                
            <MDBContainer>
              <MDBRow>
                <MDBCol md="6">
                  <MDBCard>
                    <MDBCardBody>
                      <MDBCardHeader className="form-header deep-blue-gradient rounded">
                        <h3 className="my-3">
                          <MDBIcon icon="lock" /> Sign Up:
                        </h3>
                      </MDBCardHeader>
                      <form onSubmit={this.storeInfo}>
                        <div className="grey-text">
                          <MDBInput
                            label="Type your Name"
                            icon="user"
                            group
                            type="text"
                            validate
                            error="wrong"
                            success="right"
                            name="name"
                            onChange={this.handleChange}
                          />
                          <MDBInput
                            label="Type your email"
                            icon="envelope"
                            group
                            type="email"
                            validate
                            error="wrong"
                            success="right"
                            name="email"
                            onChange={this.handleChange}
                          />
                          <MDBInput
                            label="Type your Phone Number"
                            icon="phone"
                            group
                            type="text"
                            validate
                            error="wrong"
                            success="right"
                            name="phone"
                            onChange={this.handleChange}
                          />
                          <MDBInput
                            label="Type your password"
                            icon="lock"
                            group
                            type="password"
                            name="password"
                            onChange={this.handleChange}
                            validate
                          />
                            <select className="browser-default custom-select" name="type" onChange={this.handleChange} >
                                <option>Choose Type</option>
                                <option value="customer">Customer</option>
                                <option value="staff">Staff</option>
                                <option value="admin">Admin</option>
                            </select>
                            <MDBInput
                            label="Type your Age"
                            icon="hashtag"
                            group
                            type="text"
                            validate
                            error="wrong"
                            success="right"
                            name="age"
                            onChange={this.handleChange}
                          />
                          <select className="browser-default custom-select" name="gender" onChange={this.handleChange} >
                                <option>Choose Gender</option>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="transgender">TransGender</option>
                            </select>
                            <MDBInput
                            label="Type your Security Question"
                            icon="question"
                            group
                            type="text"
                            validate
                            error="wrong"
                            success="right"
                            name="secQues"
                            onChange={this.handleChange}
                          />
                          <MDBInput
                            label="Type your Security Answer"
                            icon="lightbulb"
                            group
                            type="text"
                            validate
                            error="wrong"
                            success="right"
                            name="secAns"
                            onChange={this.handleChange}
                          />
                        </div>

                      <div className="text-center mt-4">
                        <MDBBtn
                          color="light-blue"
                          className="mb-3"
                          type="submit"
                        >
                          SingUP
                        </MDBBtn>
                      </div>
                      </form>
                    </MDBCardBody>
                  </MDBCard>
                </MDBCol>
              </MDBRow>
            </MDBContainer>
        );
    }
}
export default SignUp;