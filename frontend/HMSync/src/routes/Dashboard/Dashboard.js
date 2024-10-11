import DashHeader from "./Header/DashHeader";
import DashBody from "./Body/DashBody";
import DashMenu from "./Menu/DashMenu";
import './Dashboard.css';

function Dashboard() {
  return (
    <div className="Dashboard">

      <DashHeader />
      <div className="Dashboard-body">
        <DashMenu />
        <DashBody />
      </div>
      {/* 
    <DashFooter /> */}
    </div>
  );

}

export default Dashboard;