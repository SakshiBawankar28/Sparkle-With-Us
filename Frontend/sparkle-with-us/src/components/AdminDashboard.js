import React from 'react';
import { Link } from 'react-router-dom';

const AdminDashboard = () => {
    return (
        <div>
            <h2>Admin Dashboard</h2>
            <ul>
                <li><Link to="/customers">Manage Customers</Link></li>
                <li><Link to="/stylists">Manage Stylists</Link></li>
                <li><Link to="/bookings">Manage Bookings</Link></li>
                <li><Link to="/services">Manage Services</Link></li>
            </ul>
        </div>
    );
};

export default AdminDashboard;
