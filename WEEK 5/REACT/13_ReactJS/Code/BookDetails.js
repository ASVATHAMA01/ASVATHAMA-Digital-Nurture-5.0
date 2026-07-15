import React from 'react';

function BookDetails({ show }) {
    if (!show) return null;

    const books = [
        { id: 1, title: 'Clean Code', author: 'Robert Martin' },
        { id: 2, title: 'The Pragmatic Programmer', author: 'Andrew Hunt' },
        { id: 3, title: 'You Dont Know JS', author: 'Kyle Simpson' }
    ];

    return (
        <div>
            <h2>Book Details</h2>
            {books.map(b => (
                <p key={b.id}>{b.title} by {b.author}</p>
            ))}
        </div>
    );
}

export default BookDetails;
