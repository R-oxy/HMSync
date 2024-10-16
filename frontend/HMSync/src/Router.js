import { createBrowserRouter } from 'react-router-dom';
import RequireAuth from "@auth-kit/react-router/RequireAuth";
import HomePage from './routes/HomePage/HomePage';
import Dashboard from "./routes/Dashboard/Dashboard";
import Login from "./routes/Login/Login";
import Forms from "./Forms/Forms";
import ErrorPage from "./ErrorPage/ErrorPage";
import Clients from "./routes/Clients/Clients";
import Staff from "./routes/Staff/Staff";
import Rooms from "./routes/Rooms/Rooms";
import Reviews from "./routes/Reviews/Reviews";
import Inventory from "./routes/Inventory/Inventory";
import HouseKeeping from "./routes/HouseKeeping/HouseKeeping";
import Transactions from "./routes/Transactions/Transactions";
import Reservations from "./routes/Reservations/Reservations";
import EventManagement from "./routes/EventManagement/EventManagement";


const router = createBrowserRouter([
    {
      path: '/',
      element: <RequireAuth fallbackPath={"/login"}>
        <HomePage />
      </RequireAuth>,
  
      /* Error pages placeholder */
      errorElement: <ErrorPage />,
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
         path: 'Room-service',
         element: <Forms></Forms>
       },
       // Completed routes
        {
          path: 'Event-management',
          element: <EventManagement/>
        },
        /*
        Routes that utilize
        -display
        -dropdown feature
        */
       {
         path: 'Reservations',
         element: <Reservations/>
       },
        {
          path: 'Transactions',
          element: <Transactions/>
        },
        
        {
          path: 'Housekeeping',
          element: <HouseKeeping/>
        },
        {
          path: 'Inventory-management',
          element: <Inventory/>
        },
        {
          path: 'Reviews',
          element: <Reviews/>
        },
        {
          path: 'Rooms',
          element: <Rooms/>
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
  ]);

  export default router;