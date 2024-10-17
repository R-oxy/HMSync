import React from "react";
import ReactDOM from 'react-dom/client';
import './index.css';
import { RouterProvider } from 'react-router-dom';

import AuthProvider from "react-auth-kit";
import { QueryClientProvider } from "@tanstack/react-query";
import {router, store, queryClient } from "./HMSyncConfigurations";




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