import logo from '../../../assets/HMSync-Logo-Black.png';
import './DashHeader.css';
import avatar from '../../../assets/account-avatar.png'

function DashHeader() {
    return (
        <header className="Dash-header">
            {/* Logo, search bar, notifications, avatar */}
            {/* Logo */}
            <div className="header-logo">
                <img src={logo} alt="Logo" />
                {/* link to redirect back to homepage */}
            </div>


            <div className="header-avatar-notifications">
                {/* Notifications */}

                <div className="header-notifications">
                    <i className="fa fa-bell fa-2xl" aria-label="Notifications"></i>
                    {/* Bell icon inside here */}
                    {/* Link to new notifications */}
                </div>
                <div className="header-avatar">
                    <img src={avatar} alt="account avatar" />
                    {/* Avatar */}
                    {/* OnClick, drop down account options */}
                </div>
            </div>

        </header>
    );
}

export default DashHeader;