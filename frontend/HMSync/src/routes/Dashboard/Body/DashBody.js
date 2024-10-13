import './DashBody.css';
import DashGraphs from './DashGraphs';
import DashInfo from './DashInfo';


function DashBody() {
    const topData = [
        {id: 1, topic: "Today Bookings", value: "1578", percentage: '20%', definition: 'annual period' },
        {id: 2, topic: "Total Amount", value: "$2,254", percentage: '82%', definition: 'average annual income' },
        {id: 3, topic: "Total Annual Revenue", value: "$12,345", percentage: '96%', definition: 'average annual revenue' },
        {id: 4, topic: "Total Customers", value: "203", percentage: '83%', definition: 'average customer count' },
    ]
    return (
        <div className="Dash-body">
            <div className="display-top">
                <div className="display-container-top">
                    {topData.map((x) => {
                        return (
                        <DashInfo
                        key={x.id}
                        {...x}
                        />
                    );
                    })}
                </div>
            </div>
            <div className="display-bottom">
                <div className="display-container-bottom">
                <DashGraphs />
                </div>

            </div>
        </div>
    );
}

export default DashBody;