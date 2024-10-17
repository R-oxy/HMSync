import { useQuery } from '@tanstack/react-query';
import { useState, useEffect } from 'react';
import useSignIn from 'react-auth-kit/hooks/useSignIn';
import { useNavigate, useOutletContext } from 'react-router-dom';

// Recreate the login form with JWT / cookie based authentication
// Current implementations only utilize placeholders

function LoginForm() {
  const [formData, setFormData] = useState({ username: '', password: '' });
  const [isDisabled, setIsDisabled] = useState(true);
  const navigate = useNavigate();
  const signIn = useSignIn();
  const apiUrl = `${process.env.API_PREFIX}/auth/authenticate`;

  /* Fetch request here */
  
  console.log();
  const handleInput =  async (e) => {
    /* handle submission of input */
    e.preventDefault();

    const response = await fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": 'application/json'
      },
      body: JSON.stringify({
        email: formData.username,
        password: formData.password
      })
    });


    if (!response.ok){
      /* Implement an error message till any of the states change */
      throw new Error(`Response status: ${response.status}`);
    }

    const json = await response.json();
      if (signIn({
        auth: {
          token: json.access_token,
          type: 'Bearer',
        },
        isUsingRefreshToken: true,
        userState: {username: formData.username},
      })) {
        navigate('/');
    }
    else {
      alert("Error");
  }
}
    
    
    

  useEffect(() => {
    setIsDisabled(
      formData.username.length < 1 || formData.password.length < 1 ?
        true : false
    )

  }, [formData])

  return (
    <form action="" className="Login-input">
      {/* Username, Password, submit button */}

      <label htmlFor="credential-username">
        <span>

          Username
        </span>
        <input
          type="text"
          id="credential-username"
          name="Username"
          onChange={
            (e) => setFormData({ ...formData, username: e.target.value })
          } />
      </label>

      <label htmlFor="credential-password">
        <span>

          Password
        </span>
        <input
          type="password"
          id="credential-password"
          name="Password"
          onChange={
            (e) => setFormData({ ...formData, password: e.target.value })
          } />
      </label>

      <input
        onClick={handleInput}
        type="submit"
        value="Sign in"
        className="Credential-submit"
        disabled={isDisabled}
      />
    </form>
  );

}

export default LoginForm;