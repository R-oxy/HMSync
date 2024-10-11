function DashMenuItems({ faName, name }) {
    return (
        <div className="menu-item">

            <i className={`fa ${faName} fa-2x menu-icon`}>
                {/* Add a link to redirect ot the correct route */}
            </i>
            <h2 className="menu-collapse">{name}</h2>

        </div>
    );
}

export default DashMenuItems;