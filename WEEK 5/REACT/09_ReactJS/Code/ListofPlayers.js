import React from 'react';

function ListofPlayers() {

    const players = [
        { name: 'Rohit Sharma', score: 85 },
        { name: 'Virat Kohli', score: 92 },
        { name: 'KL Rahul', score: 60 },
        { name: 'Suryakumar Yadav', score: 78 },
        { name: 'Hardik Pandya', score: 55 },
        { name: 'Ravindra Jadeja', score: 45 },
        { name: 'MS Dhoni', score: 88 },
        { name: 'Bhuvneshwar Kumar', score: 30 },
        { name: 'Mohammed Shami', score: 65 },
        { name: 'Jasprit Bumrah', score: 40 },
        { name: 'Kuldeep Yadav', score: 72 }
    ];

    const lowScorers = players.filter(p => p.score < 70);

    return (
        <div>
            <h2>All Players</h2>
            {players.map((p, i) => (
                <p key={i}>{p.name} - {p.score}</p>
            ))}

            <h2>Players with score below 70</h2>
            {lowScorers.map((p, i) => (
                <p key={i}>{p.name} - {p.score}</p>
            ))}
        </div>
    );
}

export default ListofPlayers;
