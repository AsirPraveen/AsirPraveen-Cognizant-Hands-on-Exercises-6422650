import React from 'react';
import CurrencyConverter from './components/CurrencyConverter';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 5
    };

    this.handleIncrement = this.handleIncrement.bind(this);
    this.handleDecrement = this.handleDecrement.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.sayMessage = this.sayMessage.bind(this);
    this.handleSyntheticClick = this.handleSyntheticClick.bind(this);
  }

  handleIncrement() {
    this.setState(prev => ({ count: prev.count + 1 }));
    this.sayHello();
  }

  handleDecrement() {
    this.setState(prev => ({ count: prev.count - 1 }));
  }

  sayHello() {
    alert("Hello! Welcome Member");
  }

  sayMessage(msg) {
    alert(msg);
  }

  handleSyntheticClick(e) {
    e.preventDefault();
    alert("I was clicked");
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>{this.state.count}</h2>
        <button onClick={this.handleIncrement}>Increment</button>
        <button onClick={this.handleDecrement}>Decrement</button>
        <button onClick={() => this.sayMessage("welcome")}>Say welcome</button>
        <button onClick={this.handleSyntheticClick}>Click on me</button>

        <br /><br />

        {/* Currency Converter Component */}
        <CurrencyConverter />
      </div>
    );
  }
}

export default App;
