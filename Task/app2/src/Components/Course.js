import React from 'react'

const Course = ({ name, description, instructor }) => {
    return (
      <div className="course-card">
        <h3>{name}</h3>
        <p>{description}</p>
        <p>Instructor: {instructor}</p>
      </div>
    );
  };

export default Course
