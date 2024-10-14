import { useState, useEffect } from 'react';
import { Outlet, useNavigate, useParams } from 'react-router-dom';
import './HomePage.css';
import DashMenu from './Menu/DashMenu';
import DashHeader from './Header/DashHeader';


function HomePage() {
  return (

    <div className="HomePage">
      <div className="Homepage-landing">
        <DashMenu />
        <div className="Homepage-body">
          <DashHeader />
          <>
            <Outlet />
          </>
        </div>
      </div>
    </div>
  );
};

export default HomePage;