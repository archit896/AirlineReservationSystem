import React,{Component} from 'react';
import axios from'axios';
class PlaneInfoUpdate extends Component{
    constructor(props){
        super(props);
        this.state={planeId:0,planeType:"",planeVendor:"",msg:""}
    }
 updateRecord=(event)=>{
     event.preventDefault();
     console.log(this.state);
 axios.put("http://localhost:8080/AirlineSeatReservationSystem/airline/planeInfo/update",this.state).
 then(result=>this.setState({msg:result.data}),e =>console.log(e));
 }
changeValue=(event)=>{
    let name=event.target.name;
    let value=event.target.value;
    this.setState({[name]:value})
}

    render(){
        
        
        return(
            <div>
                <h1>Upadate Plane Info</h1>
                
                <form onSubmit={this.updateRecord}>
                <label>Insert Plane Id</label>
                <input type="text" name="planeId" onChange={this.changeValue}/><br/>
                <label>Insert Plane Type</label>
                <input type="text" name="planeType" onChange={this.changeValue}/><br/>
                <label>Insert Plane Vendor</label>
                <input type="text" name="planeVendor" onChange={this.changeValue}/><br/>
                <input type="submit" value="submit"/><br/>
                
                </form>
            {this.state.msg}
            
            </div>
        )
    }
}
export default PlaneInfoUpdate;