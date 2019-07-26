import React, { Component } from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'

class Child1 extends Component{
    constructor(props){
        super(props);
        this.state = {child1 : "Child1 Message", parentMsg:this.props.msg};
        this.props.msg2(this.state.child1);
    }
    render(){

        localStorage.setItem("obj", "Archit");

        return(
            <div>
                Child1 | {this.props.msg}
            </div>
        )
    }
}

class Child2 extends Component{
    constructor(props){
        super(props);
        this.state = {child1:this.props.msg};
    }
    render(){
    
        let obj = localStorage.getItem("obj");
        return(
            
            <div>
                Child2 | {this.props.msg} | {obj}
            </div>
        )
    }
}

class App extends Component{
    constructor(props){
        super(props);
        this.state = {name : "Parent Message", child1 : ""}
    }

    callback = (data) => {
        this.setState({child1:data});
    }

    render(){
        return(
            <div>
                <h2>Main</h2>
                {this.state.child1}
                <Child1 msg={this.state.name} msg2={this.callback}></Child1>
                <Child2 msg={this.state.child1} ></Child2>
            </div>
        )
    }
}
export default App;