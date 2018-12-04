import React, { Component } from 'react';
import './App.css';
import ReactDOM from 'react-dom';
import BabyNameTable from './BabyNameTable.js';
import axios from 'axios';

class App extends Component {

  constructor(props){
    super(props);
    this.state = ({
      ip:"http://localhost:",
      port:8081
    });

    this.populateTable = this.populateTable.bind(this);
  }

  componentDidMount = () => {
    this.populateTable();
  }

  async populateTable(){
  await axios.get(this.state.ip + this.state.port + "/babyname/getall").then((res) => {
    ReactDOM.render(<BabyNameTable ip={this.state.ip} port={this.state.port} dataInput={res.data}/>, document.getElementById('BabyTable'));
  });
};

  render() {
    return (
      <div className="App">
      <h1>Baby Name Generator!</h1>
      <div id="BabyTable">

      </div>

      </div>
    );
  }
}

export default App;
