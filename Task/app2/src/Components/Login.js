import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import Validation from "./LoginValidation";
import axios from 'axios';
// import './App.css';
function Login() {
    const [values,setValues]=useState({
        email:'',
        password:''
    })
    const navigate=useNavigate();
    const [errors, setErrors]=useState({})
    const handleInput=(event) =>{
        setValues(prev => ({...prev,[event.target.name]:[event.target.value]}))
    }
    const handleSubmit=(event) =>{
        event.preventDefault();
        setErrors(Validation(values));
        if(errors.email === "" && errors.password === ""){
            axios.post('http://localhost:8081/login', values)
            .then(res=> {
                if(res.data==="success"){
                 navigate('/home');
                alert("Successfully Login..");
                }else{
                    alert("No Record Existed.");
                }
            })
            .catch(err=> console.log(err));
        }
    }

  return (
    <div className='d-flex justify-content-center align-items-center vh-100'>
      <div className='bg-white p-4 rounded w-25'>
        <h2><u>Sign-In</u></h2>
        <form action="" onSubmit={handleSubmit}>
            <div className='mb-3'>
                <label htmlFor='email'><strong>Email</strong></label>
                <input type='email' placeholder='Enter your Email' name='email'
                onChange={handleInput} className='form-control rounded-0'/>
                {errors.email && <span className='text-danger'>{errors.email}</span>}
            </div>
            <div className='mb-3'>
                <label htmlFor='password'><strong>Password</strong></label>
                <input type='password' placeholder='Enter your Password' name='password'
                onChange={handleInput} className='form-control rounded-0'/>
                {errors.password && <span className='text-danger'>{errors.password}</span>}
            </div>
            <button type='submit' className='btn btn-success w-100'>Log In</button>
            <p>Dont have an Account:</p>
            <Link to="/signup" className='btn btn-danger border w-100 rounded-0 text-decoration-none'>
                <strong>Create Account</strong></Link>
                &nbsp;
              <div>
             <Link to="https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com%3Fhl%3Den-US&ec=GAlA8wE&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S471277560%3A1717333175685470&ddm=0" className='btn btn-primary border w-100 rounded-0 text-decoration-none'><strong>Gmail</strong></Link>
             <Link to="https://www.facebook.com/login.php/" className='btn btn-primary border w-100 rounded-0 text-decoration-none'>
              <strong>FaceBook</strong></Link></div>
        </form>
      </div>
    </div>
  )
}

export default Login
