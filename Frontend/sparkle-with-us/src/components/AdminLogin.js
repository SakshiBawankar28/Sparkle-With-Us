import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login } from '../services/api';

const AdminLogin = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [loading, setLoading] = useState(false); // To handle loading state
    const [error, setError] = useState(''); // To handle error messages
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        setLoading(true); // Set loading to true
        setError(''); // Clear any previous error messages
        try {
            const response = await login({ email, password });
            console.log('Login response:', response); // Log response for debugging

            if (response.status === 200) {
                navigate('/AdminDashboard'); // Redirect to the admin dashboard on successful login
            } else {
                setError('Invalid credentials!'); // Set error message
            }
        } catch (error) {
            console.error('Login error:', error); // Log error for debugging

            if (error.status === 401) {
                setError('Invalid credentials!'); // Set error message for 401 Unauthorized
            } else if (error.message === 'Network error') {
                setError('Network error. Please try again later.');
            } else {
                setError('Something went wrong. Please try again later.');
            }
        } finally {
            setLoading(false); // Set loading to false after request is completed
        }
    };

    return (
        <div className="login-form">
            <h2>Admin Login</h2>
            {error && <p className="error-message">{error}</p>} {/* Display error message if any */}
            <form onSubmit={handleLogin}>
                <input 
                    type="email" 
                    value={email} 
                    onChange={(e) => setEmail(e.target.value)} 
                    placeholder="Email" 
                    required 
                    disabled={loading} // Disable input during loading
                />
                <input 
                    type="password" 
                    value={password} 
                    onChange={(e) => setPassword(e.target.value)} 
                    placeholder="Password" 
                    required 
                    disabled={loading} // Disable input during loading
                />
                <button type="submit" disabled={loading}>
                    {loading ? 'Logging in...' : 'Login'}
                </button>
            </form>
        </div>
    );
};

export default AdminLogin;
