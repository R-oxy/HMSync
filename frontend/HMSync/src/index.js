import React from "react";
import ReactDOM from 'react-dom/client';
import './index.css';
import { RouterProvider } from 'react-router-dom';
import createStore from "react-auth-kit/createStore";
import AuthProvider from "react-auth-kit";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import router from "./Router";


/* Authentication */
const store = createStore({
  authName: '_auth',
  authType: "cookie",
  cookieDomain: window.location.hostname,
  cookieSecure: false/* window.location.protocol === 'http:' */ //once its deployed
})

/* Queries */
const queryClient = new QueryClient();


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