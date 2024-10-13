import './DashMenu.css';
import DashMenuItems from './DashMenuItems';


function DashMenu() {
    const icons = [
        { id: 1, faName: 'fa-home', name: 'Dashboard', dir: "/dashboard" },
        { id: 2, faName: 'fa-h-square', name: 'Hotels', dir: "/dashboard/hotels" },
        { id: 3, faName: 'fa-exchange', name: 'Transactions', dir: "/dashboard/transactions" },
        { id: 4, faName: 'fa-male', name: 'House keeping', dir: "/dashboard/house-keeping" },
        { id: 5, faName: 'fa-taxi', name: 'Cab facilities', dir: "/dashboard/facilities" }
    ];

    return (
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

    );
}

export default DashMenu;