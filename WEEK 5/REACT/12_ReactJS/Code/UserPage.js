import React from 'react';

function UserPage() {
    return (
        <div>
            <h2>Welcome User!</h2>
            <p>Book your tickets below:</p>
            <ul>
                <li>Flight AI-101 | Chennai to Mumbai | 10:00 AM <button>Book</button></li>
                <li>Flight AI-202 | Mumbai to Delhi | 2:00 PM <button>Book</button></li>
                <li>Flight AI-303 | Delhi to Bangalore | 6:00 PM <button>Book</button></li>
            </ul>
        </div>
    );
}

export default UserPage;
