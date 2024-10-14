import { useEffect, useLayoutEffect, useState } from "react";
import './Forms.css';
import { useLocation } from "react-router-dom";
import { useQuery } from "@tanstack/react-query";
import DisplayForms from "./DisplayForms";


function Forms({ topSection, bottomSection }) {
    const { pathname } = useLocation();
    const noDisplayRoutes = ['/Clients', '/Room-service', '/HouseKeeping'];
    const display = (noDisplayRoutes.includes(pathname) ?
        { show: 'display-off', 'flex-grow': 0.55 } :
        { show: '', 'flex-grow': 0 }
    );

    const [displayProps, setDisplayProps] = useState({});
    const [displayId, setDisplayId] = useState('');


    const { isPending, isError, data, error } = useQuery({
        queryKey: ['fillerData'],
        queryFn: async () => {
            const fillerDataUrl = "https://api.json-generator.com/templates/YDHfCIizOy0f/data";
            const response = await fetch(fillerDataUrl, {
                headers: {
                    Authorization: "Bearer pfjgp2naaesz5aoyq3tnikav3j6d64qbqclw98vs"
                }
            });
            return await response.json();
        }
    });

    if (isPending) {
        return (<span>Loading...</span>)
    }
    
    if (isError) {
        console.log(error);
        return (<div>Err</div>)
    }

    
    return (
        <div className="Forms">
            {/* Search bar */}
            {/* <label htmlFor="" className="form-search">
            <input type="search" name="" id="" />
            </label> */}
            {/* Page Name */}
            <div className="Forms-options" style={{ flexGrow: display['flex-grow'] }}>
                {data.map((x) => {
                    return (
                        <DisplayForms key={x.Id} props={x} states={{displayId, setDisplayId, displayProps, setDisplayProps}}/>
                    )
                })}
            </div>
            <div className={`Forms-create-display ${display.show} ${displayProps.Id ? "show-Drawer" : 'hide-Drawer'}`}>
                {bottomSection}
            </div>
        </div>
    )
}

export default Forms;

/* 
--------- TO-Do's ---------
1. Include search bar
2. highlight on hover 
 */