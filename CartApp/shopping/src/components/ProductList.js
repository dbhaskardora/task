import React from 'react';
import { useDispatch } from 'react-redux';
import { addToCart } from '../redux/actions/cartActions';

const ProductList = ({ products }) => {
  const dispatch = useDispatch();

  const handleAddToCart = (product) => {
    dispatch(addToCart(product));
  };

  return (
    <div>
      <h2><u>Products</u></h2>


      {/* <div className="product-list">
        {products.map(product => (
          <div key={product.id} className="product-item">
            {/* <img src={product.image} alt={product.name} /> 
            <h3>{product.name}</h3>
            <p>${product.price}</p>
            <button onClick={() => handleAddToCart(product)}>Add to Cart</button>
          </div>
        ))}
      </div> */}
       <div>
        {products.map(product => (
          <h1 key={product.id}>
              {/* <img src={product.image} alt={product.name} width="100" /> */}
            {product.name} - ${product.price} - {product.image}
            <button onClick={() => handleAddToCart(product)}>Add to Cart</button>
          </h1>
        ))}
      </div> 
    </div>
  );
};

export default ProductList;
