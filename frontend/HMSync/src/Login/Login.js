/* Login Page */
import { useState } from 'react';
import './Login.css';
import loginPageImg from '../assets/LoginPage/Login-page.png';
import logo from '../assets/HMSync-Logo.png';

function Login() {
  return (
    <div className="Login">
      {/* background, Image */}
      <img src={loginPageImg} alt="Image here" />
      <div className="Login-white Login-container">
        {/* <div className="Container-background"> */}

        <img src={logo} alt="Logo" />
        <h1 className="Login-header">
          <p>
            Sign in
          </p>
        </h1>
        <div className="Login-credentials">

          <form action="" className="Login-input">
            {/* Username, Password, submit button */}

            <label htmlFor="credential-username">
              <span>

                Username
              </span>
              <input type="text" id="credential-username" name="Username" />
            </label>

            <label htmlFor="credential-password">
              <span>

                Password
              </span>
              <input type="password" id="credential-password" name="Password" />
            </label>

            <input type="button" value="Sign in" className="Credential-submit" />
          </form>
        </div>
        {/* </div> */}
      </div>
    </div>
  );
}

export default Login;