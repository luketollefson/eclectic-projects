import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import cat from './cat.jpg';
import cat2 from './cat2.jpg';

function changeImage() {
  document.images["jsbutton"].src={cat2};
  return true;
}

class App extends Component {
  

  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <p className="App-intro">
          To get started, edit yeye <code>src/App.js</code> and save to reload.
        </p>
        <a href="#" onMouseOver="return changeImage()" >
          <img name="jsbutton" src={cat} width="110" height="110" border="0" alt="js button"></img>
        </a>
      </div>
    );
  }
}

export default App;
