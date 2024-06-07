import React from 'react'
import Course from './Course';

const Courselist = ({ courses }) => {
    return (
      <div className="course-list">
        {courses.map(course => (
          <Course key={course.id} {...course} />
        ))}
      </div>
    );
  };
  

export default Courselist
