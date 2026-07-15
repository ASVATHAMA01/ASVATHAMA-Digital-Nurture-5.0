import React from 'react';

function IndianPlayers() {

    const players = [
        'Rohit Sharma', 'Virat Kohli', 'KL Rahul',
        'Suryakumar Yadav', 'Hardik Pandya', 'Ravindra Jadeja',
        'MS Dhoni', 'Bhuvneshwar Kumar', 'Mohammed Shami',
        'Jasprit Bumrah', 'Kuldeep Yadav'
    ];

    // destructuring into odd and even indexed players
    const oddPlayers = players.filter((p, i) => i % 2 !== 0);
    const evenPlayers = players.filter((p, i) => i % 2 === 0);

    const T20players = ['Rohit Sharma', 'Virat Kohli', 'KL Rahul'];
    const RanjiTrophyplayers = ['Prithvi Shaw', 'Shreyas Iyer', 'Ajinkya Rahane'];

    // merge using spread
    const allPlayers = [...T20players, ...RanjiTrophyplayers];

    return (
        <div>
            <h2>Odd Team Players</h2>
            {oddPlayers.map((p, i) => <p key={i}>{p}</p>)}

            <h2>Even Team Players</h2>
            {evenPlayers.map((p, i) => <p key={i}>{p}</p>)}

            <h2>T20 + Ranji Trophy Players</h2>
            {allPlayers.map((p, i) => <p key={i}>{p}</p>)}
        </div>
    );
}

export default IndianPlayers;
