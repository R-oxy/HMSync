import React from "react";
import ReactDOM from 'react-dom/client';
import HomePage from './routes/HomePage/HomePage';
import './index.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Login from "./routes/Login/Login";
import Dashboard from "./routes/Dashboard/Dashboard";
import createStore from "react-auth-kit/createStore";
import AuthProvider from "react-auth-kit";
import RequireAuth from "@auth-kit/react-router/RequireAuth";



/* Might need to use context to confirm if user is logged in or not */
const store = createStore({
  authName: '_auth',
  authType: "cookie",
  cookieDomain: window.location.hostname,
  cookieSecure: false/* window.location.protocol === 'http:' */
})



const router = createBrowserRouter([
  /* Error pages placeholder */

  {
    path: '/',
    element: <RequireAuth fallbackPath={"/login"}>
      <HomePage />
      </RequireAuth>,
    errorElement: <div>This are not the links you are looking for</div>,
    
    children: [
      {
        path: 'dashboard?',
        element: <Dashboard />,
    },
    
  ]
},
{
  path: '/login',
  element: <Login />
},



]);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AuthProvider store={store}>
      <RouterProvider router={router} />
    </AuthProvider>
  </React.StrictMode>
);