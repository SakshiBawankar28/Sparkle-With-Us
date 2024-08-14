import React, { useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import './css/Style.css';

const StylistLogin = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    axios.post('/api/stylist/login', { email, password })
      .then(response => {
        navigate('/services');
      })
      .catch(error => {
        console.error("There was an error logging in!", error);
      });
  };

  return (
    <div className="login-form">
      <h2>Stylist Login</h2>
      <form onSubmit={handleLogin}>
        <input 
          type="email" 
          placeholder="Email" 
          value={email} 
          onChange={(e) => setEmail(e.target.value)} 
          required 
        />
        <input 
          type="password" 
          placeholder="Password" 
          value={password} 
          onChange={(e) => setPassword(e.target.value)} 
          required 
        />
        <button type="submit">Submit</button>
        <Link to="/stylistregister">
          <button type="button" className="register-btn">Stylist Register</button>
        </Link>
      </form>
    </div>
  );
};

export default StylistLogin;
