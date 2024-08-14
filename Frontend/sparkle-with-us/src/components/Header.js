// import React from 'react';
// import { Link } from 'react-router-dom';
// // import './Style.css';
// import './css/Style.css';


// const Header = () => {
//   return (
//     <header className="header">
//       <img src={require('../images/images.png')} alt="Salon Logo" className="logo" />
//       <nav className="navbar">
//         <ul>
//           <li><Link to="/">Home</Link></li>
//           <li><Link to="/aboutus">About Us</Link></li>
//           <li><Link to="/services">Services</Link></li>
//           <li><Link to="/contactus">Contact Us</Link></li>
//           <li><Link to="/login">Login</Link></li>
//         </ul>
//       </nav>
//     </header>
//   );
// }

// export default Header;


import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './css/Style.css';

const Header = () => {
  const [showLoginMenu, setShowLoginMenu] = useState(false);

  const toggleLoginMenu = () => {
    setShowLoginMenu(!showLoginMenu);
  };

  return (
    <header className="header">
      <img src={require('../images/images.png')} alt="Salon Logo" className="logo" />
      <nav className="navbar">
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/aboutus">About Us</Link></li>
          <li><Link to="/services">Services</Link></li>
          <li><Link to="/contactus">Contact Us</Link></li>
          <li onClick={toggleLoginMenu} className="login-menu">
            Login
            {showLoginMenu && (
              <ul className="login-dropdown">
                <li><Link to="/customerlogin">Customer Login</Link></li>
                <li><Link to="/stylistlogin">Stylist Login</Link></li>
                <li><Link to="/adminlogin">Admin Login</Link></li>
              </ul>
            )}
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
