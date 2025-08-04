import React from 'react';

class CurrencyConverter extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currency: ''
    };

    this.handleAmountChange = this.handleAmountChange.bind(this);
    this.handleCurrencyChange = this.handleCurrencyChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleAmountChange(event) {
    this.setState({ amount: event.target.value });
  }

  handleCurrencyChange(event) {
    this.setState({ currency: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const { amount, currency } = this.state;
    const rate = 80;

    if (currency.toLowerCase() === 'euro') {
      const converted = amount * rate;
      alert(Converting to ${currency} Amount is ${converted});
    } else {
      alert(Currency "${currency}" not supported for conversion);
    }
  }

  render() {
    return (
      <div>
        <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <label>
            Amount:
            <input
              type="text"
              value={this.state.amount}
              onChange={this.handleAmountChange}
            />
          </label>
          <br /><br />
          <label>
            Currency:
            <textarea
              value={this.state.currency}
              onChange={this.handleCurrencyChange}
            />
          </label>
          <br /><br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConverter;
