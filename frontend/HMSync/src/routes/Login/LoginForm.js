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
  const token = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJpYXQiOjE3Mjg3NzA0MzUsImV4cCI6MTc2MDMwNjQzNSwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoianJvY2tldEBleGFtcGxlLmNvbSIsIkdpdmVuTmFtZSI6Ik1pbGxpY2VudCIsIlN1cm5hbWUiOiJCeXN0YW5kZXIifQ.bhiYlqMTDmfZBnrSb3KZHhel_3vl2GG44Vblt9zBoPA';

  const handleInput = (e) => {
    /* handle submission of input */
    e.preventDefault();

    /* Fetch request here */

    /* validate token inside fetch request
      currently done by placeholder */
    
    if (signIn({
      auth: {
        token: token,
        type: 'Bearer',
      },
      isUsingRefreshToken: true,
      userState: {username: formData.username},
    })) {
      navigate('/');
    } else {
      alert('Yikes')
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