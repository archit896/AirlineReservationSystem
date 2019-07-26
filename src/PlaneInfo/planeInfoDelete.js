import React,{Component} from 'react';
import axios from'axios';
class PlaneInfoDelete extends Component{
    constructor(props){
        super(props);
        this.state={planeId:0,msg:""}
    }
 deleteRecord=(event)=>{
     event.preventDefault();
     console.log(this.state);
 axios.delete("http://localhost:8080/AirlineSeatReservationSystem/airline/planeInfo/delete/"+this.state.planeId).
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
                <h1>Plane Info  delete by id</h1>
                
                <form onSubmit={this.deleteRecord}>
                <label>Insert Plane Id</label>
                <input type="text" name="planeId" onChange={this.changeValue}/><br/>
                <input type="submit" value="submit"/><br/>
                
                </form>
                {this.state.msg};
            
            </div>
        )
    }
}
export default PlaneInfoDelete;