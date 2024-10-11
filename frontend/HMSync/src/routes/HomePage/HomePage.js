import { useState, useEffect } from 'react';
import { Outlet, useNavigate } from 'react-router-dom';
import './HomePage.css';

function HomePage() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    // Check if the JWT is set, if not default to false and request either the session token or full on login 
    if (isLoggedIn) {
      navigate('login');
    } else {
      navigate('dashboard');
    }
  },  [isLoggedIn]);
  
  return (
    
    <div className="HomePage">
      <Outlet context={{
        isLoggedIn, setIsLoggedIn
      }} />
    </div>
  );
};

export default HomePage;