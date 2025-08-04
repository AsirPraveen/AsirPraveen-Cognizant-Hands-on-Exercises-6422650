import React from 'react';

const imageUrl = process.env.PUBLIC_URL + "/cognizant.jpg";

const officeList = [
  { Name: "DBS", Rent: 50000, Address: "Chennai" },
  { Name: "WeWork", Rent: 75000, Address: "Bangalore" },
  { Name: "Innov8", Rent: 40000, Address: "Delhi" }
];
const App = () => {
  const heading = "Office Space";

  const getRentColor = (rent) => {
    return {
      color: rent <= 60000 ? 'red' : 'green',
      fontWeight: 'bold'
    };
  };
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>{heading}, at Affordable Range</h1>
      {officeList.map((item, index) => (
        <div key={index} style={{ marginBottom: '30px' }}>
          <img src={imageUrl} width="25%" height="25%" alt="Office Space" />
          <h2>Name: {item.Name}</h2>
          <h3 style={getRentColor(item.Rent)}>Rent: Rs. {item.Rent}</h3>
          <h3>Address: {item.Address}</h3>
        </div>
      ))}
    </div>
  );
};
export default App;
