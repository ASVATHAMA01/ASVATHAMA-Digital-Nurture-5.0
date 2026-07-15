import React from 'react';

class EventExamples extends React.Component {

    constructor(props) {
        super(props);
        this.state = { count: 0, message: '' };
    }

    increment() {
        this.setState({ count: this.state.count + 1 });
    }

    sayHello() {
        this.setState({ message: 'Hello! Welcome to React Events.' });
    }

    decrement() {
        this.setState({ count: this.state.count - 1 });
    }

    sayWelcome(msg) {
        this.setState({ message: msg });
    }

    onPress(e) {
        alert('I was clicked');
    }

    render() {
        return (
            <div>
                <h2>Counter: {this.state.count}</h2>

                <button onClick={() => { this.increment(); this.sayHello(); }}>Increment</button>
                <button onClick={() => this.decrement()}>Decrement</button>

                <p>{this.state.message}</p>

                <button onClick={() => this.sayWelcome('welcome')}>Say Welcome</button>

                <button onClick={(e) => this.onPress(e)}>OnPress</button>
            </div>
        );
    }
}

export default EventExamples;
