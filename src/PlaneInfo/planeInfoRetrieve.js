import React,{Component} from 'react';
import axios from'axios';

class PlaneInfoRetrieve extends Component{
    constructor(props){
        super(props);
        this.state={planeInfo:[]}
    }
 loadData=()=>{
 axios.get("http://143.199.166.101:8080/AirlineSeatReservationSystem/airline/planeInfo/retrieve").
 then(result=>this.setState({planeInfo:result.data.planeInfo}),
e =>console.log(e));
 }


    render(){
        let EmpRc= this.state.planeInfo.map(ele=>
        <tbody>
        <tr key={ele.id}>
        <td>{ele.planeId}</td>
        <td>{ele.planeType}</td>
        <td>{ele.planeVendor}</td>
        </tr>
        </tbody>
        )
        return(
            <div>
                <h1>Airports details</h1>
                <input type="button" value="load airports info" onClick={this.loadData}/>
                <table border="1">
                     <thead>
                          
                              <th>Plane Id</th>
                              <th>Plane Type</th>
                              <th>Plane Vendor</th>
                              
                              </thead>
                              {EmpRc}
                              </table>
            </div>
        )
    }
}
export default PlaneInfoRetrieve;