import React from 'react';
import ListofPlayers from './components/ListofPlayers';
import { OddPlayers, EvenPlayers, ListofIndianPlayers } from './components/IndianPlayers';

function App() {
  const flag = false;

  const players = [
    { name: 'Rohit', score: 175 },
    { name: 'Gill', score: 96 },
    { name: 'Virat', score: 120 },
    { name: 'Iyer', score: 21 },
    { name: 'Rahul', score: 61 },
    { name: 'Hardik', score: 88 },
    { name: 'Jadeja', score: 71 },
    { name: 'Kuldeep', score: 33 },
    { name: 'Siraj', score: 22 },
    { name: 'Shami', score: 42 },
    { name: 'Bumrah', score: 19 }
  ];

  const IndianTeam = [
    { name: 'Sachin1' },
    { name: 'Dhoni2' },
    { name: 'Virat3' },
    { name: 'Rohit4' },
    { name: 'Yuvaraj5' },
    { name: 'Raina6' }
  ];

  const T20Players = ['Mr. First Player', 'Mr. Second Player', 'Mr. Third Player'];
  const RanjiTrophyPlayers = ['Mr. Fourth Player', 'Mr. Fifth Player', 'Mr. Sixth Player'];
  const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

  if (flag) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListofPlayers players={players} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <ul>
          {players
            .filter((item) => item.score < 70)
            .map((item, index) => (
              <li key={index}>
                Mr. {item.name} <span>{item.score}</span>
              </li>
            ))}
        </ul>
      </div>
    );
  } else {
    return (
      <div>
        <h1>Indian Team</h1>
        <h2>Odd Players</h2>
        <OddPlayers players={IndianTeam} />
        <hr />
        <h2>Even Players</h2>
        <EvenPlayers players={IndianTeam} />
        <hr />
        <h2>List of Indian Players Merged:</h2>
        <ListofIndianPlayers IndianPlayers={IndianPlayers} />
      </div>
    );
  }
}

export default App;
