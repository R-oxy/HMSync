import logo from '../../../assets/HMSync-Logo-Black.png';
import './DashHeader.css';
import avatar from '../../../assets/account-avatar.png'
import { Link, useNavigate, useOutletContext } from 'react-router-dom';
import { useEffect, useState } from 'react';
import useSignOut from 'react-auth-kit/hooks/useSignOut';
import useAuthUser from 'react-auth-kit/hooks/useAuthUser';

function DashHeader() {
    const navigate = useNavigate();
    const [flexSet, setFlexSet] = useState('none');
    const [displaySet, setDisplaySet] = useState('none');
    const signOut = useSignOut();
    const auth = useAuthUser();

    const changeflex = () => {
        setFlexSet(flexSet == 'flex' ? 'none' : 'flex');
    }

    const changeDisplay = () => {
        setDisplaySet(displaySet == 'initial' ? 'none': 'initial');
    }
    const logoutFunc = () => {
        signOut();
        navigate('/login');
        
    };

    const linkCSS = {
        position: 'absolute',
        height: '100%',
        width: '100%',
    };
    return (
        <header className="Dash-header">
            {/* Logo, search bar, notifications, avatar */}
            {/* Logo */}
            <div className="header-logo">
                <img src={logo} alt="Logo" />
                <Link to="/dashboard" style={linkCSS}>
                </Link>
                {/* link to redirect back to homepage */}
            </div>



            <div className="header-avatar-notifications">
                {/* Notifications */}

                <div className="header-notifications" onClick={changeDisplay}>
                    <i className="fa fa-bell fa-2xl" aria-label="Notifications"></i>
                    {/* Bell icon inside here */}
                    <div className="notification-tag" style={{display: displaySet}}>
                        <p>No new notifications</p>
                    </div>
                    {/* Link to new notifications */}
                </div>
                <div className="header-avatar" onClick={changeflex} >
                    <img src={avatar} alt="account avatar" />
                    {/* Avatar */}
                    <div className="logout-tag" style={{display: flexSet}}>
                        <p>{`${auth.username}`}{/* Millicent Bystander */}</p>
                        <p>Settings</p>
                        <p>Account</p>
                        <button onClick={logoutFunc}>logout</button>
                    </div>
                    {/* OnClick, drop down account options */}
                </div>
            </div>

        </header>
    );
}

export default DashHeader;