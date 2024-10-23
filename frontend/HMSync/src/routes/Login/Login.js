/* Login Page */
import { useEffect, useState } from 'react';
import './Login.css';
import loginPageImg from '../../assets/LoginPage/Login-page.png';
import logo from '../../assets/HMSync-Logo-Black.png';
import LoginForm from './LoginForm';
import useIsAuthenticated from 'react-auth-kit/hooks/useIsAuthenticated';
import { useNavigate } from 'react-router-dom';

function Login() {
  const isAuthenticated = useIsAuthenticated();
  const navigate = useNavigate();

  useEffect(() => {
    if (isAuthenticated) {
      navigate('/');
    }
  });
  /* Logs into the server */
  return (
    <div className="Display-container">

      <div className="Login">
        <img src={loginPageImg} alt="Image here" />
        <div className="Login-white">

          <img src={logo} alt="Logo" />
          <h1 className="Login-header">
            <p>Sign in</p>
          </h1>
          <div className="Login-credentials">
            <LoginForm />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;