import React, { Component } from 'react';
import axios from 'axios';

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
                <h2>Forgot Password</h2>
                <MDBContainer>
              <MDBRow>
                <MDBCol md="6">
                  <MDBCard>
                    <MDBCardBody>
                      <MDBCardHeader className="form-header deep-blue-gradient rounded">
                        <h3 className="my-3">
                          <MDBIcon icon="question" /> Forgot Password:
                        </h3>
                      </MDBCardHeader>
                    </MDBCardBody>
                  </MDBCard>
                </MDBCol>
              </MDBRow>
            </MDBContainer>
        <a style={this.state.showEmailComponent ? {} : { display: 'none' }}>
                <MDBContainer>
                <MDBRow>
                  <MDBCol md="6">
                    <MDBCard>
                      <MDBCardBody>
                        <MDBCardHeader className="form-header deep-blue-gradient rounded">
                          <h3 className="my-3">
                            <MDBIcon icon="envelope" /> Email:
                          </h3>
                        </MDBCardHeader>
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
                            onClick={this.loadQA}
                          >Get Question
                          </MDBBtn>
                        </div>
                      </MDBCardBody>
                    </MDBCard>
                  </MDBCol>
                </MDBRow>
              </MDBContainer>
                </a>
                <a style={this.state.showQAComponent ? {} : { display: 'none' }} >
                <MDBContainer>
                <MDBRow>
                  <MDBCol md="6">
                    <MDBCard>
                      <MDBCardBody>
                        <MDBCardHeader className="form-header deep-blue-gradient rounded">
                          <h3 className="my-3">
                            <MDBIcon icon="question" /> {this.state.secQues}:
                          </h3>
                        </MDBCardHeader>
                          <div className="grey-text">
                            <MDBInput
                              label="Type your Answer"
                              icon="envelope"
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
                            onClick={this.checkAns}
                          >Verify
                          </MDBBtn>
                        </div>
                      </MDBCardBody>
                    </MDBCard>
                  </MDBCol>
                </MDBRow>
              </MDBContainer>
                </a>
                <a style={this.state.showPassComponent ? {} : { display: 'none' }}>
                    Password : <input type="password" name="pass" onChange={this.handleChange} /><br/>
                    Confirm Password : <input type="password" name="cpass" onChange={this.handleChange}/><br/>
                    <input value="Submit" onClick={this.checkPass} type="button" /><br/>
                    {this.state.msg}
                </a>
            </div>
        )
    }
}
export default ForgotPassword;