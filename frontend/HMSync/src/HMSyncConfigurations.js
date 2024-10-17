import createStore from "react-auth-kit/createStore";
import { QueryClient } from "@tanstack/react-query";
import { createBrowserRouter } from 'react-router-dom';
import RequireAuth from "@auth-kit/react-router/RequireAuth";
import HomePage from './routes/HomePage/HomePage';
import Dashboard from "./routes/Dashboard/Dashboard";
import Login from "./routes/Login/Login";
import Clients from "./routes/Clients/Clients";
import Staff from "./routes/Staff/Staff";
import Rooms from "./routes/Rooms/Rooms";
import Reviews from "./routes/Reviews/Reviews";
import Inventory from "./routes/Inventory/Inventory";
import HouseKeeping from "./routes/HouseKeeping/HouseKeeping";
import Transactions from "./routes/Transactions/Transactions";
import Reservations from "./routes/Reservations/Reservations";
import EventManagement from "./routes/EventManagement/EventManagement";
import NotFound from "./NotFound";
import createRefresh from "react-auth-kit/createRefresh";

/* Routing setup */
export const router = createBrowserRouter([
    {
        path: '/',
        element: <RequireAuth fallbackPath={"/login"}>
            <HomePage />
        </RequireAuth>,
        errorElement: <NotFound />,

        children: [
            /* Homepage */
            {
                path: 'dashboard?',
                element: <Dashboard />,
            },
            // Completed routes
            {
                path: 'Event-management',
                element: <EventManagement />
            },
            {
                path: 'Reservations',
                element: <Reservations />
            },
            {
                path: 'Transactions',
                element: <Transactions />
            },

            {
                path: 'Housekeeping',
                element: <HouseKeeping />
            },
            {
                path: 'Inventory-management',
                element: <Inventory />
            },
            {
                path: 'Reviews',
                element: <Reviews />
            },
            {
                path: 'Rooms',
                element: <Rooms />
            },
            {
                path: 'Clients',
                element: <Clients />
            },
            {
                path: 'Staff',
                element: <Staff />
            },
        ]
    },
    /* Login route */
    {
        path: '/login',
        element: <Login />
    },
    /* Test individual components */
    {
        path: '*',
        element: <NotFound />
    }
]);


/* Authentication */
export const store = createStore({
    authName: '_auth',
    authType: "cookie",
    cookieDomain: window.location.hostname,
    cookieSecure: false/* window.location.protocol === 'http:' */ //once its deployed
  })
  
  /* Queries */
export const queryClient = new QueryClient();

/* export {router, store, queryClient}; */
/* const refreshApiUrl = `${process.env.API_PREFIX}/auth-refresh-token`;
export const refresh = createRefresh({
    interval: 600,
    refreshApiCallback: async (param) => {
        try {
            const response = await fetch(refreshApiUrl, {
                headers: {
                    'Authorization': `Bearer ${param.authToken}`
                }

            })
            const returnData = await response.json();

            console.log("Refreshing");
            return ({
                isSuccess: true,
                newAuthToken: returnData[x] //refresh_token key
                newAuthTokenExpireIn: 600
                newRefreshTokenExpiresIn: 600
            });
        }
    }
}); */