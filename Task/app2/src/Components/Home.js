import React from 'react'
import { Link } from 'react-router-dom';


const Home= () => {
    return (
        <div>
      <div className='d-flex justify-content-center align-items-center vh-100'>
        <h1 className='bg-warning rounded-0 text-decoration-none'>Welcome to My Homepage</h1>
        
      
        <Link to="/"><button type='submit' className='btn btn-primary'>Logut</button></Link> 
       </div>
       </div>
    );
  };
export default Home
