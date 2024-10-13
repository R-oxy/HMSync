import DashHeader from "./Header/DashHeader";
import DashBody from "./Body/DashBody";
import DashMenu from "./Menu/DashMenu";
import './Dashboard.css';
import { useNavigate, useOutletContext } from "react-router-dom";
import { useEffect } from "react";

function Dashboard() {
  return (
    <div className="Dashboard">

        <DashMenu />
      <div className="Dashboard-body">
      <DashHeader />
        <DashBody />
      </div>
    </div>
  );

}

export default Dashboard;