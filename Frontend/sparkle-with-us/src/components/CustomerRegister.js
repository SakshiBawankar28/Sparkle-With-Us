import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './css/Style.css';

const CustomerRegister = () => {
  const [customer, setCustomer] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    phoneNo: '',
    dob: '',
    gender: '',
    address: ''
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setCustomer({ ...customer, [e.target.name]: e.target.value });
  };

  const handleRegister = (e) => {
    e.preventDefault();
    axios.post('/api/customer/register', customer)
      .then(response => {
        navigate('/customerlogin');
      })
      .catch(error => {
        console.error("There was an error registering!", error);
      });
  };

  return (
    <div className="register-form">
      <h2>Customer Register</h2>
      <form onSubmit={handleRegister}>
        <input type="text" name="firstName" placeholder="First Name" onChange={handleChange} required />
        <input type="text" name="lastName" placeholder="Last Name" onChange={handleChange} required />
        <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
        <input type="password" name="password" placeholder="Password" onChange={handleChange} required />
        <input type="text" name="phoneNo" placeholder="Phone Number" onChange={handleChange} required />
        <input type="date" name="dob" placeholder="Date of Birth" onChange={handleChange} required />
        <select name="gender" onChange={handleChange} required>
          <option value="">Select Gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
        </select>
        <textarea name="address" placeholder="Address" onChange={handleChange} required></textarea>
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default CustomerRegister;
