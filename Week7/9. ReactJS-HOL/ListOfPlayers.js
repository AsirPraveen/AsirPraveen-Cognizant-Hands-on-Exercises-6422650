import React from 'react';

const ListofPlayers = ({ players }) => (
  <ul>
    {players.map((item, index) => (
      <li key={index}>
        Mr. {item.name} <span>{item.score}</span>
      </li>
    ))}
  </ul>
);
export default ListofPlayers;
