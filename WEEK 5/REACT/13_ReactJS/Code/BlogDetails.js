import React from 'react';

function BlogDetails({ show }) {

    const blogs = [
        { id: 1, title: 'React Hooks Guide', date: '01-Jan-2024' },
        { id: 2, title: 'Understanding Redux', date: '15-Feb-2024' },
        { id: 3, title: 'CSS in JS', date: '10-Mar-2024' }
    ];

    return show && (
        <div>
            <h2>Blog Details</h2>
            {blogs.map(b => (
                <p key={b.id}>{b.title} - {b.date}</p>
            ))}
        </div>
    );
}

export default BlogDetails;
