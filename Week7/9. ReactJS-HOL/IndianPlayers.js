import React from 'react';

export const OddPlayers = ({ players: [first, , third, , fifth] }) => {
  return (
    <ul>
      <li>First: {first.name}</li>
      <li>Third: {third.name}</li>
      <li>Fifth: {fifth.name}</li>
    </ul>
  );
};

export const EvenPlayers = ({ players: [, second, , fourth, , sixth] }) => {
  return (
    <ul>
      <li>Second: {second.name}</li>
      <li>Fourth: {fourth.name}</li>
      <li>Sixth: {sixth.name}</li>
    </ul>
  );
};

export const ListofIndianPlayers = ({ IndianPlayers }) => {
  return (
    <ul>
      {IndianPlayers.map((player, index) => (
        <li key={index}>{player}</li>
      ))}
    </ul>
  );
};
