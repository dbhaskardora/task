import React from 'react';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

const Navbar = () => {
  const cartItems = useSelector(state => state.cart.items);
  const itemCount = cartItems.length;

  return (
    <nav className='nav'>
      <Link to="/">Home</Link>
      <Link to="/cart">
        Cart <span>({itemCount})</span>
      </Link>
    </nav>
  );
}

export default Navbar
