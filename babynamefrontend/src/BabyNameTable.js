import React, { Component } from 'react';
import './App.css';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import axios from 'axios';

class BabyNameTable extends Component {

  constructor(props){
    super(props);
    this.state = ({
      ip:this.props.ip,
      port:this.props.port,
      dataInputSource:this.props.dataInput
    });
  }

  postBaby = () => {
    var length = document.getElementById('lengthInput').value;
    var name = document.getElementById('nameInput').value;

    axios.post(this.state.ip + this.state.port + "/babyname/create", {
      "name":name,
      "length":length
    }).then((res) => window.location.reload());
  }

  createDeleteButton = (cell, rows) => {
    return <button id={rows.mid} className="btn btn-danger" onClick={() => this.deleteBaby(rows.id)}>Delete</button>;
}

deleteBaby = (event) => {
  var url = this.state.ip + this.state.port + "/babyname/delete/" + event;
  axios.delete(url).then((res) => {window.location.reload()});
}

  render() {
    return (
      <div className="App">
      <BootstrapTable data={this.state.dataInputSource} className="table table-striped" search scrollable>
        <TableHeaderColumn width={"100px"} dataField="id" isKey dataSort dataAlign='center'>ID</TableHeaderColumn>
        <TableHeaderColumn dataField="name" dataSort dataAlign='center'>Name</TableHeaderColumn>
        <TableHeaderColumn dataField='button' dataFormat={this.createDeleteButton} dataAlign='center'></TableHeaderColumn>
      </BootstrapTable>
      <input type="number" id="lengthInput" className="form-control" placeholder="Name Length"/><br/><br/>
      <input type="text" id="nameInput" className="form-control" placeholder="Name"/><br/><br/>
      <button className="btn btn-primary" id="AddButton" onClick={this.postBaby}>Add Name</button>
      </div>
    );
  }
}

export default BabyNameTable;
