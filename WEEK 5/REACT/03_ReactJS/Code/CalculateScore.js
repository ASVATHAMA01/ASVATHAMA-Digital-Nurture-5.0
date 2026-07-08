import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
    var avg = props.total / props.goal * 100;

    return (
        <div className="container">
            <h1>Student Score Calculator</h1>
            <p>Name: {props.name}</p>
            <p>School: {props.school}</p>
            <p>Total: {props.total}</p>
            <p>Goal: {props.goal}</p>
            <p>Average Score: {avg.toFixed(2)}%</p>
        </div>
    );
}

export default CalculateScore;
