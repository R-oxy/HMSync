import { Suspense } from 'react';

import { Outlet } from 'react-router-dom';
import './HomePage.css';
import DashMenu from './Menu/DashMenu';
import DashHeader from './Header/DashHeader';
import ErrorPage from '../../ErrorPage/ErrorPage';
import Favicon from "react-favicon";

function HomePage() {
  const apiPrefix = process.env.DATA_API_URL;
  return (
    <ErrorPage fallback={"Error retrieving information"}>
      <Suspense fallback={<p>Retrieving data...</p>}>

        <div className="HomePage">
          {/* <Favicon url={'../../assets/favicon.ico'} /> */}
          <div className="Homepage-landing">
            <DashMenu />
            <div className="Homepage-body">
              <DashHeader />

              <>
                <Outlet context={apiPrefix} />
              </>
            </div>
          </div>
        </div>
      </Suspense>
    </ErrorPage>
  );
};

export default HomePage;