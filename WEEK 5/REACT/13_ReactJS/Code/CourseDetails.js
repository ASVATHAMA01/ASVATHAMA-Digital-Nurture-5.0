import React from 'react';

function CourseDetails({ show }) {

    const courses = [
        { id: 1, name: 'React JS', duration: '3 months' },
        { id: 2, name: 'Spring Boot', duration: '2 months' },
        { id: 3, name: 'Angular', duration: '2 months' }
    ];

    return (
        <div>
            {show ? (
                <div>
                    <h2>Course Details</h2>
                    {courses.map(c => (
                        <p key={c.id}>{c.name} - {c.duration}</p>
                    ))}
                </div>
            ) : (
                <p>Course Details are hidden.</p>
            )}
        </div>
    );
}

export default CourseDetails;
