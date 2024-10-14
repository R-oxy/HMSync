import { Link } from "react-router-dom";


function DashMenuItems({ faName, name, dir }) {

    /* use */
    return (
        <Link to={dir}>
            {/* Side menu options */}
            <div className="menu-item">
                <i className={`fa ${faName} fa-2x menu-icon`} />
                <h2 className="menu-collapse">{name}</h2>
            </div>
        </Link>
    );
}

export default DashMenuItems;