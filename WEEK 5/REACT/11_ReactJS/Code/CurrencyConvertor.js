import React from 'react';

class CurrencyConvertor extends React.Component {

    constructor(props) {
        super(props);
        this.state = { rupees: '', euro: '' };
    }

    handleSubmit() {
        var result = (this.state.rupees / 89.5).toFixed(2);
        this.setState({ euro: result });
    }

    render() {
        return (
            <div>
                <h2>Currency Convertor</h2>
                <input
                    type="number"
                    placeholder="Enter amount in INR"
                    value={this.state.rupees}
                    onChange={(e) => this.setState({ rupees: e.target.value })}
                />
                <button onClick={() => this.handleSubmit()}>Convert</button>
                {this.state.euro && <p>{this.state.rupees} INR = {this.state.euro} Euro</p>}
            </div>
        );
    }
}

export default CurrencyConvertor;
