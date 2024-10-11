import { useState, useEffect } from 'react';
import { useNavigate, useOutletContext } from 'react-router-dom';

// Recreate the login form with JWT / cookie based authentication
// Current implementations only utilize placeholders

function LoginForm() {

  const [token, setToken] = useState();
  const { isLoggedIn, setIsLoggedIn } = useOutletContext();
  const navigate = useNavigate();

  useEffect(() => {
    /* handle token setting */
    if (token) {
      setIsLoggedIn(token);
      navigate('/');
    }
  }, [token]);

  const handleInput = (e) => {
    /* handle submission of input */
    e.preventDefault();
    setToken(true);
    

  }

    return (
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

            <input onClick={handleInput} type="submit" value="Sign in" className="Credential-submit" />
          </form>
    );

}

export default LoginForm;