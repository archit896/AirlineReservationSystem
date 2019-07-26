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
import {Link} from 'react-router-dom';
import Navbar from './NavbarIndex'

class Login extends Component {
    
      constructor(props){
        super(props);
        this.state = {email : "", password : ""};
      }
    
      validateForm(){
        return this.state.email.length > 0 && this.state.password.length > 0;
      }
    
      handleChange = (event) => {
        console.log(event.target.name + "|" + event.target.value);
        this.setState({[event.target.name] : event.target.value});
      }
    
      checkValue = (event) => {
        event.preventDefault();
        axios.post("http://localhost:8080/Airline/pkmkb/user/login", this.state).
        then(result =>{ if(result.data.userId != 0){
          sessionStorage.setItem("userId", result.data.userId);
          sessionStorage.setItem("name", result.data.name);
          sessionStorage.setItem("email", result.data.email);
          sessionStorage.setItem("phone", result.data.phone);
          sessionStorage.setItem("type", result.data.type);
          sessionStorage.setItem("age", result.data.age);
          sessionStorage.setItem("gender", result.data.gender);
          sessionStorage.setItem("secQues", result.data.secQues);
          sessionStorage.setItem("secAns", result.data.secAns);
          sessionStorage.setItem("password", result.data.password);          
          sessionStorage.setItem("login",1);
          this.props.history.push("home");
        }else{
          console.log("Wrong Credentials!!!");
        }},e => console.log(e));
      }
    
      render(){
        return(
          <div>
            <Navbar></Navbar>
            <br/><br/>
           
            <MDBContainer>
              <MDBRow>
                <MDBCol>
                  <MDBCard>
                    <MDBCardBody>
                      <MDBCardHeader className="form-header deep-blue-gradient rounded">
                        <h3 className="my-3">
                          <MDBIcon icon="lock" /> Login:
                        </h3>
                      </MDBCardHeader>
                      <form onSubmit={this.checkValue}>
                        <div className="grey-text">
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
                            label="Type your password"
                            icon="lock"
                            group
                            type="password"
                            name="password"
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
                          Login
                        </MDBBtn>
                      </div>
                      </form>
                      <MDBModalFooter>
                        <div className="font-weight-light">
                          <p>Not a member?<Link to="signup" >Sign Up</Link></p>
                          <p><Link to="forgotPassword">Forgot Password?</Link></p>
                        </div>
                      </MDBModalFooter>
                    </MDBCardBody>
                  </MDBCard>
                </MDBCol>
              </MDBRow>
            </MDBContainer>
          </div>
        );
      }
    }
    export default Login;