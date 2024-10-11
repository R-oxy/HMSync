import './DashMenu.css';
import DashMenuItems from './DashMenuItems';


function DashMenu() {
    const icons = [
        { id: 1, faName: 'fa-home', name: 'Dashboard' },
        { id: 2, faName: 'fa-h-square', name: 'Hotels' },
        { id: 3, faName: 'fa-exchange', name: 'Transactions' },
        { id: 4, faName: 'fa-male', name: 'House keeping' },
        { id: 5, faName: 'fa-taxi', name: 'Cab facilities' }
    ];

    return (
        <aside className="Dash-menu">
            {/* Icons */}
            {icons.map((x) => {
                return (
                    <DashMenuItems
                        key={x.id}
                        faName={x.faName}
                        name={x.name}
                    />);
            })}
            
        </aside>

    );
}

export default DashMenu;