import React from 'react';
import './Style.css';
import { Link } from 'react-router-dom';


const Header = () => {
  return (
    <header className="header">
      <img src={require('../images/images.png')} alt="Salon Logo" className="logo" />
      <nav>
        <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/services">Services</Link></li>
        <li><Link to="/stylists">Stylists</Link></li>
        <li><Link to="/booking">Book Appointment</Link></li>
        <li><Link to="/about-us">About Us</Link></li>
        <li><Link to="/contact-us">Contact Us</Link></li>
        <li><Link to="/reviews">Reviews</Link></li>
        <li><Link to="/login">Login</Link></li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
