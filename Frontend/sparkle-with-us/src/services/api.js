// import axios from 'axios';

// const api = axios.create({
//     baseURL: 'http://localhost:8080/api',
// });

// export const login = (credentials) => api.post('/login', credentials);


// import axios from 'axios';

// const api = axios.create({
//     baseURL: 'http://localhost:8080/admin', // Replace with your backend URL
//     headers: {
//         'Content-Type': 'application/json',
//     },
// });

// export const login = (credentials) => api.post('/login', credentials);


// import axios from 'axios';

// const api = axios.create({
//   baseURL: 'http://localhost:8080/api',
// });

//export const login = (credentials) => api.post('/login', credentials);
// export const getBooks = () => api.get('/books');
// export const getCart = () => api.get('/cart');
// export const removeFromCart = (id) => api.delete(/cart/${id});
// export const getOrders = () => api.get('/orders');
// export const getPayments = () => api.get('/payments');

import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api', // Ensure this is your correct backend URL
    headers: {
        'Content-Type': 'application/json',
    },
});

// Function to handle login
export const login = (credentials) => {
    return api.post('/login', credentials)
        .then(response => response) // Return the response if successful
        .catch(error => {
            // If the error has a response, throw it to handle in the component
            if (error.response) {
                throw error.response;
            }
            // Handle other errors (e.g., network errors)
            throw new Error('Network error');
        });
};
