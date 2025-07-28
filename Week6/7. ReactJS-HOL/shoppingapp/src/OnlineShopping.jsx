import React from 'react';
import { Cart } from './Cart';

export class OnlineShopping extends React.Component {
  render() {
    const cartItems = [
      { itemname: 'Laptop', price: 80000 },
      { itemname: 'TV', price: 120000 },
      { itemname: 'Washing Machine', price: 50000 },
      { itemname: 'Mobile', price: 30000 },
      { itemname: 'Fridge', price: 70000 }
    ];

    return (
      <div className="mydiv" style={{ padding: '20px' }}>
        <h1>Items Ordered:</h1>
        <Cart items={cartItems} />
      </div>
    );
  }
}
