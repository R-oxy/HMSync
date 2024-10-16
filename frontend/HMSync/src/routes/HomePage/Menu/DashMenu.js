import './DashMenu.css';
import DashMenuItems from './DashMenuItems';


function DashMenu() {
    const icons = [
        { id: 1, faName: 'fa-home', name: 'Dashboard', dir: "/Dashboard" },
        { id: 2, faName: 'fa-id-card', name: 'Staff', dir: "/Staff" },
        { id: 3, faName: 'fa-bed', name: 'Rooms', dir: "/Rooms" },
        { id: 4, faName: 'fa-user', name: 'Clients', dir: "/Clients" },
        { id: 5, faName: 'fa-star-half', name: 'Reviews', dir: "/Reviews" },
        { id: 6, faName: 'fa-book', name: 'Inventory', dir: "/Inventory-management" },
        { id: 7, faName: 'fa-id-badge', name: 'Housekeeping', dir: "/Housekeeping" },
        { id: 8, faName: 'fa-exchange', name: 'Transactions', dir: "/Transactions" },
        { id: 9, faName: 'fa-user-plus', name: 'Reservations', dir: "/Reservations" },
        { id: 10, faName: 'fa-tag', name: 'Room Service', dir: "/Room-service" },
        { id: 11, faName: 'fa-calendar', name: 'Event Management', dir: "/Event-management" },
        /*
         */
    ];

    return (
        <div className="menu-container">
            <div className="dash-menu-container">

                <aside className="Dash-menu">
                    {/* Icons */}
                    {icons.map((x) => {
                        return (
                            <DashMenuItems
                                key={x.id}
                                faName={x.faName}
                                name={x.name}
                                dir={x.dir}
                            />);
                    })}

                </aside>
            </div>
        </div>


    );
}

export default DashMenu;