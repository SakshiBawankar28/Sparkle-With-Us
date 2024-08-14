import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './css/Style.css';

const StylistRegister = () => {
  const [stylist, setStylist] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    phoneNo: '',
    dob: '',
    specialization: '',
    availability: ''
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setStylist({ ...stylist, [e.target.name]: e.target.value });
  };

  const handleRegister = (e) => {
    e.preventDefault();
    axios.post('/api/stylist/register', stylist)
      .then(response => {
        navigate('/stylistlogin');
      })
      .catch(error => {
        console.error("There was an error registering!", error);
      });
  };

  return (
    <div className="register-form">
      <h2>Stylist Register</h2>
      <form onSubmit={handleRegister}>
        <input type="text" name="firstName" placeholder="First Name" onChange={handleChange} required />
        <input type="text" name="lastName" placeholder="Last Name" onChange={handleChange} required />
        <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
        <input type="password" name="password" placeholder="Password" onChange={handleChange} required />
        <input type="text" name="phoneNo" placeholder="Phone Number" onChange={handleChange} required />
        <input type="date" name="dob" placeholder="Date of Birth" onChange={handleChange} required />
        <select name="specialization" onChange={handleChange} required>
          <option value="">Select Specialization</option>
          <option value="HAIRCUTS">HAIRCUTS</option>
          <option value="NAIL_ARTIST">NAIL ARTIST</option>
          <option value="WAXING_SPECIALIST">WAXING SPECIALIST</option>
          <option value="MAKEUP_ARTIST">MAKEUP ARTIST</option>
        </select>
        <input 
          type="text" 
          name="availability" 
          placeholder="Availability (e.g., Mon-Fri, 9am-5pm)" 
          onChange={handleChange} 
          required 
        />
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default StylistRegister;
