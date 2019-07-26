import React,{Component} from 'react';
import axios from'axios';
class PlaneInfoById extends Component{
    constructor(props){
        super(props);
        this.state={planeInfo:"",planeId:0}
    }
 loadData=(event)=>{
     event.preventDefault();
     console.log(this.state.planeId);
 axios.get("http://localhost:8080/AirlineSeatReservationSystem/airline/planeInfo/retrieveId/"+this.state.planeId).
 then(result=>this.setState({planeInfo:result.data.planeInfo}),e =>console.log(e));
 }
changeValue=(event)=>{
    let name=event.target.name;
    let value=event.target.value;
    this.setState({[name]:value})
}

    render(){
        
        
        return(
            <div>
                <h1>Plane Info  retrieve by id</h1>
                <form onSubmit={this.loadData}>
                <label>Insert Plane Id</label>
                <input type="text" name="planeId" onChange={this.changeValue}/>
                <input type="submit" value="rerieve"/>
                
                </form>
                Id is{this.state.planeInfo.planeId}<br/>
                type is {this.state.planeInfo.planeType}<br/>
                Vendor is{this.state.planeInfo.planeVendor}<br/>
            
            </div>
        )
    }
}
export default PlaneInfoById;