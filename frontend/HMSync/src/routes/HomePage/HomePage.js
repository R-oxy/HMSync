import { useState, useEffect } from 'react';
import { Outlet, useNavigate, useParams } from 'react-router-dom';
import './HomePage.css';

function HomePage() {
  return (
    
    <div className="HomePage">
      <Outlet />
    </div>
  );
};

export default HomePage;