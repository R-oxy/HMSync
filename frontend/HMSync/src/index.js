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
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import Forms from "./Forms/Forms";


/* Authentication */
const store = createStore({
  authName: '_auth',
  authType: "cookie",
  cookieDomain: window.location.hostname,
  cookieSecure: false/* window.location.protocol === 'http:' */ //once its deployed
})

/* Queries */
const queryClient = new QueryClient();

/* Router */
const router = createBrowserRouter([
  {
    path: '/',
    element: <RequireAuth fallbackPath={"/login"}>
      <HomePage />
    </RequireAuth>,
    
    /* Error pages placeholder */
    errorElement: <div>This are not the links you are looking for</div>,
    children: [
      /* Homepage */
      {
        path: 'dashboard?',
        element: <Dashboard />,
      },
      /* 
        Routes that utilize
          -forms
          -display
          -dropdown feature
        with POST Interactions
      */
      {
        path: 'Event-management',
        element: <Forms></Forms>
      },
      {
        path: 'Reservations',
        element: <Forms></Forms>
      },
      /*
       Routes that utilize
          -display
          -dropdown feature
      */
     {
        path: 'Transactions',
        element: <Forms></Forms>
      },
      {
        path: 'Staff',
        element: <Forms></Forms>
      },
      {
        path: 'Rooms',
        element: <Forms></Forms>
      },
      {
        path: 'Inventory-management',
        element: <Forms></Forms>
      },
      {
        path: 'Reviews',
        element: <Forms></Forms>
      },

      /* 
        Routes that only utilize display
      */
        {
          path: 'Clients',
          element: <Forms></Forms>
        },
        {
          path: 'Room-service',
          element: <Forms></Forms>
        },
        {
          path: 'Housekeeping',
          element: <Forms></Forms>
        },
    ]
  },
  /* Login route */
  {
    path: '/login',
    element: <Login />
  },
]);

/* Insert App into DOM */
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AuthProvider store={store}>
      <QueryClientProvider client={queryClient}>
        <RouterProvider router={router} />
      </QueryClientProvider>
    </AuthProvider>
  </React.StrictMode>
);