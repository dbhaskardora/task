import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { removeFromCart, clearCart } from '../redux/actions/cartActions';

const ShoppingCart = () => {
  const dispatch = useDispatch();
  const items = useSelector(state => state.cart.items);

  const handleRemoveFromCart = (id) => {
    dispatch(removeFromCart(id));
  };

  const handleClearCart = () => {
    dispatch(clearCart());
  };

  return (
    <div>
      <h2>Shopping Cart</h2>
      {items.length === 0 ? (
        <p>No items in cart</p>
      ) : (
        <ul>
          {items.map(item => (
            <li key={item.id}>
               {/* <img src={item.image} alt={item.name} /> */}
              {item.name} - ${item.price}
              <button onClick={() => handleRemoveFromCart(item.id)}>Remove</button>
            </li>
          ))}
        </ul>
      )}
      {items.length > 0 && <button onClick={handleClearCart}>Clear Cart</button>}
    </div>
  );
};

export default ShoppingCart;
