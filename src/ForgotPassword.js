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

class ForgotPassword extends Component{
    constructor(props){
        super(props);
        this.state = {secQues:"", secAns:"", email:"", ans:"",
         showQAComponent:false, showEmailComponent:true, showPassComponent:false, pass:"", cpass:"", msg:""};
    }

    handleChange= () => {
        this.setState({[event.target.name] : event.target.value});        
    }

    loadQA = () => {
        event.preventDefault();
        axios.get("http://localhost:8080/Airline/pkmkb/user/forgotPassword?email="+this.state.email).
        then(result => this.setState({
            secQues:result.data.ques, secAns:result.data.ans, showQAComponent:true, showEmailComponent:false})
            ,e => console.log(e));
    }

    checkAns = () => {
        event.preventDefault();
        if(this.state.secAns == this.state.ans.toString()){
            this.setState({showPassComponent:true, showQAComponent:false});
        }        
    }

    checkPass = () => {
        event.preventDefault();
        if(this.state.pass == this.state.cpass){
            axios.put("http://localhost:8080/Airline/pkmkb/user/updatePassword?email="+this.state.email+"&password="+this.state.pass).
            then(result => {if(result.data == "Success"){
                this.props.history.push("");                
            }else{
                this.setState({msg:result.data});
            }},e => console.log(e));
        }else{
            this.setState({msg:"Passwords do not match!!"})
        }
    }

    render(){
        return(
            <div>
            <MDBContainer>
              <MDBRow>
                <MDBCol md="6">
                  <MDBCard>
                    <MDBCardBody>
                      <MDBCardHeader className="form-header deep-blue-gradient rounded">
                        <h3 className="my-3">
                          <MDBIcon icon="lock" /> Forgot Passowrd:
                        </h3>
                        </MDBCardHeader>

                <a style={this.state.showEmailComponent ? {} : { display: 'none' }}>
                    <form onSubmit={this.loadQA} >
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
                        </div>
                      <div className="text-center mt-4">
                        <MDBBtn
                          color="light-blue"
                          className="mb-3"
                          type="submit"
                        >
                          Get Question
                        </MDBBtn>
                      </div>
                      </form>
                </a>
                <a style={this.state.showQAComponent ? {} : { display: 'none' }} >
                <MDBCardHeader className="form-header deep-blue ">
                        <h3 className="my-3">
                          <MDBIcon icon="question" /> Question : {this.state.secQues}
                        </h3>
                        </MDBCardHeader>
                    <form onSubmit={this.checkAns} >
                        <div className="grey-text">
                          <MDBInput
                            label="Type your Answer"
                            icon="lightbulb"
                            group
                            type="text"
                            validate
                            error="wrong"
                            success="right"
                            name="ans"
                            onChange={this.handleChange}
                          />
                        </div>
                      <div className="text-center mt-4">
                        <MDBBtn
                          color="light-blue"
                          className="mb-3"
                          type="submit"
                        >
                          Verify
                        </MDBBtn>
                      </div>
                      </form>
                </a>
                <a style={this.state.showPassComponent ? {} : { display: 'none' }}>
                    <form onSubmit={this.checkPass} >
                        <div className="grey-text">
                          <MDBInput
                            label="Type your Password"
                            icon="lock"
                            group
                            type="password"
                            validate
                            error="wrong"
                            success="right"
                            name="pass"
                            onChange={this.handleChange}
                          />
                          <MDBInput
                            label="Confirm Password"
                            icon="exclamation-triangle"
                            group
                            type="password"
                            validate
                            error="wrong"
                            success="right"
                            name="cpass"
                            onChange={this.handleChange}
                          />
                        </div>
                      <div className="text-center mt-4">
                        <MDBBtn
                          color="light-blue"
                          className="mb-3"
                          type="submit"
                        >
                          Chenge Password
                        </MDBBtn>
                      </div>
                      </form>
                </a>
                    <MDBModalFooter>
                        <div className="font-weight-light">
                          <p>{this.state.msg}</p>
                        </div>
                    </MDBModalFooter>
                </MDBCardBody>
                  </MDBCard>
                </MDBCol>
              </MDBRow>
            </MDBContainer>
            </div>
        )
    }
}
export default ForgotPassword;