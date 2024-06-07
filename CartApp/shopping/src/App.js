
import './App.css';

import React from 'react';
import { Provider } from 'react-redux';
import ProductList from './components/ProductList';
import ShoppingCart from './components/ShoppingCart';
import store from './redux/store';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
// import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Navbar from './components/Navbar';





const products = [
  { id: 1, name: 'Product 1', price: 100 },
  { id: 2, name: 'Product 2', price: 200 },
  { id: 3, name: 'Product 3', price: 300 },
  
];

// const App = () => {
//   return (
//     <Provider store={store}>
//       <div className="App">
//         <h1>Shopping Cart</h1>
//         <ProductList products={products} />
//         <ShoppingCart/>
//       </div>
//     </Provider>
//   );
// };

const App = () => {
  return (
    <Provider store={store}>
      <Router>
        <Navbar/>
        <div className="App">
         <Routes>
            <Route path="/" element={<ProductList products={products} />} />
            <Route path="/cart" element={<ShoppingCart />} />
            </Routes>
        </div>
      </Router>
    </Provider>
  );
};

export default App;
