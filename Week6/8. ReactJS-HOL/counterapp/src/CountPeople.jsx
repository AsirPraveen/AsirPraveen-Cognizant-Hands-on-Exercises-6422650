import React from 'react';

class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 0,
      exitCount: 0
    };

    this.UpdateEntry = this.UpdateEntry.bind(this);
    this.UpdateExit = this.UpdateExit.bind(this);
  }

  UpdateEntry() {
    this.setState(prevState => ({
      entryCount: prevState.entryCount + 1
    }));
  }

  UpdateExit() {
    this.setState(prevState => ({
      exitCount: prevState.exitCount + 1
    }));
  }

  render() {
    const buttonStyle = {
      backgroundColor: 'green',
      color: 'white',
      border: 'none',
      padding: '8px 15px',
      cursor: 'pointer',
      fontSize: '16px',
      borderRadius: '4px',
    };

    const containerStyle = {
      textAlign: 'center',
      marginTop: '50px',
      fontFamily: 'Arial, sans-serif',
    };

    const rowStyle = {
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      gap: '10px',
      marginBottom: '20px',
    };

    const countTextStyle = {
      fontSize: '18px',
      fontWeight: 'bold',
      color: 'green',
      minWidth: '140px',
      textAlign: 'left',
    };

    return (
      <div style={containerStyle}>
        <div style={rowStyle}>
          <button onClick={this.UpdateEntry} style={buttonStyle}>
            Login
          </button>
          <span style={countTextStyle}>People Entered: {this.state.entryCount}</span>
        </div>

        <div style={rowStyle}>
          <button onClick={this.UpdateExit} style={buttonStyle}>
            Exit
          </button>
          <span style={countTextStyle}>People Exited: {this.state.exitCount}</span>
        </div>
      </div>
    );
  }
}

export default CountPeople;
