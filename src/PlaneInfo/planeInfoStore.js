import React,{Component} from 'react';
import axios from'axios';
class PlaneInfoStore extends Component{
    constructor(props){
        super(props);
        this.state={planeId:0,planeType:"",planeVendor:""}
    }
storePlaneInfo=(event)=>{
    event.preventDefault();
    console.log(this.state);
 axios.post("http://localhost:8080/AirlineSeatReservationSystem/airline/planeInfo/insert",this.state).
 then(result=>console.log(result),
error =>console.log(error));
 }

    changeValue=(event)=>{
  let name=event.target.name;
  let value=event.target.value;
  this.setState({[name]:value});

    }
    render(){
       
        
        return(
            <div>
              <h2>Storing Plane Information</h2>
              <form onSubmit={this.storePlaneInfo}>
                  <label>PlaneId</label><input type="text" name="planeId" onChange={this.changeValue}/><br/>
                  <label>Plane Type</label><input type="text" name="planeType" onChange={this.changeValue}/><br/>
                  <label>Plane Vendor</label><input type="text" name="planeVendor" onChange={this.changeValue}/><br/>
                  <input type="submit" value="storeRecord" onClick={this.storePlaneInfo}/>
                  </form>


            </div>
        )
    }
}
export default PlaneInfoStore;