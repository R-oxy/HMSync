import React from "react";
import ReactDOM from 'react-dom/client';
import HomePage from './routes/HomePage/HomePage';
import './index.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Login from "./routes/Login/Login";
import Dashboard from "./routes/Dashboard/Dashboard";


/* Might need to use context to confirm if user is logged in or not */


const router = createBrowserRouter([
  /* Error pages placeholder */

  {
    path: '/',
    element: <HomePage />,
    errorElement: <div>This are not the links you are looking for</div>,

    children: [
      {
        path: 'login',
        element: <Login />
      },
      {
        path: 'dashboard',
        element: <Dashboard />
      }
    ]
  },
  


]);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);