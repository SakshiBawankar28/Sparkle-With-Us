// import React, { useState } from 'react';
// import { useNavigate } from 'react-router-dom';
// import { login } from '../services/api'; // Import the Axios function
// import './css/Login.css';

import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './css/Login.css';

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/admin/login', {
        email,
        password
      }, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
  
      if (response.status === 200) {
        // Handle successful login
        navigate('/AdminDashboard');
      } else {
        setError('Unexpected response from server.');
      }
    } catch (err) {
      if (err.response) {
        setError(`Login failed: ${err.response.data.message || 'Please check your credentials.'}`);
      } else if (err.request) {
        setError('No response from server.');
      } else {
        setError('Error in request setup.');
      }
      console.error('Login error:', err);
    }
  };
  
  

  return (
    <div className="login-container">
      <h2>Login</h2>
      {error && <p className="error-message">{error}</p>} {/* Display error message if exists */}
      <form onSubmit={handleLogin}>
        <div className="form-group">
          <label>Email:</label>
          <input 
            type="email" 
            name="email" 
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required 
          />
        </div>
        <div className="form-group">
          <label>Password:</label>
          <input 
            type="password" 
            name="password" 
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required 
          />
        </div>
        <button type="submit">Submit</button>
        <button
          type="button"
          onClick={() => navigate('/register')}
          className="register-button"
        >
          Register
        </button>
      </form>
    </div>
  );
}

export default Login;




// import React, { useState } from 'react';
// import axios from 'axios';
// import { useNavigate } from 'react-router-dom';
// import 'bootstrap/dist/css/bootstrap.min.css';
// import './css/Login.css';

// function Login() {
//   const [email, setEmail] = useState('');
//   const [password, setPassword] = useState('');
//   const [error, setError] = useState(null);
//   const navigate = useNavigate();

//   const handleLogin = async (e) => {
//     e.preventDefault();
//     try {
//       const response = await axios.post('http://localhost:8080/login', null, {
//         params: { email, password}
//       });

//       if (response.status === 200) {
//         const { redirectUrl } = response.data;
//         if (redirectUrl) {
//           navigate(redirectUrl);
//         } else {
//           setError('Unexpected response from server.');
//         }
//       }
//     } catch (err) {
//       setError('Login failed. Please check your credentials.');
//       console.error('Login error:', err);
//     }
//   };

//   return (
//     <div className="login-container">
//       <h2>Login</h2>
//       <form onSubmit={handleLogin}>
//         <div className="form-group">
//           <label htmlFor="email">Email:</label>
//           <input
//             type="email"
//             id="email"
//             className="form-control"
//             value={email}
//             onChange={(e) => setEmail(e.target.value)}
//             required
//           />
//         </div>
//         <div className="form-group">
//           <label htmlFor="password">Password:</label>
//           <input
//             type="password"
//             id="password"
//             className="form-control"
//             value={password}
//             onChange={(e) => setPassword(e.target.value)}
//             required
//           />
//         </div>
//         <button type="submit" className="btn btn-primary">Login</button>
//         {error && <p className="text-danger mt-2">{error}</p>}
//       </form>
//       <div className="mt-3">
//         <a href="/register" className="btn btn-secondary">New to The Bookshelf? Register</a>
//       </div>
//     </div>
//   );
// }

// export default Login;
