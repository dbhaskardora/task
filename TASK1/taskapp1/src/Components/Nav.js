import React from 'react'
import './Nav.css'
const Nav = () => {
    return (
      <header className="navbar">
        <h1>Online Banking System</h1>
        <nav>
          <ul>
            <li><a href="#home">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li><a href="#register">Register</a></li>
          </ul>
        </nav>
      </header>
    );
  }

export default Nav
