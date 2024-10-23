import { useEffect, useLayoutEffect, useState } from "react";
import './Forms.css';
import { useLocation } from "react-router-dom";
import { useQuery } from "@tanstack/react-query";
import DisplayForms from "./DisplayForms";
import FormInfo from "./FormInfo";
import FormInput from "./FormInput";
import NotFound from "../NotFound";


function Forms({ topInfo, options, label, apiUrl, qkey, identifier }) {
    const { pathname } = useLocation();
    const noDisplayRoutes = ['/Clients', '/Room-service', '/HouseKeeping'];


    const [displayProps, setDisplayProps] = useState({});
    const [displayId, setDisplayId] = useState('');
    const [prevId, setPrevId] = useState('');
    const [action, setAction] = useState('');
    const [deleteState, setDeleteState] = useState('lighten');
    const [deletionItems, setDeletionItems] = useState([]);
    const [returnItems, setReturnItems] = useState([]);

    // HTTP method setting on click
    const setMode = (x) => {
        if (action === x) {
            setAction('');

        } else if (displayId === '' && (x === 'POST' || x === 'DELETE')) {
            setAction(x);
        } else if (displayId !== '' && x === 'UPDATE') {
            setAction(x);
        }
    };

    // Query function
    const { isPending, isError, data, error } = useQuery({
        queryKey: [qkey],
        queryFn: async () => {
            const response = await fetch(apiUrl, {
                headers: {
                    Authorization: `Bearer ${process.env.BEARER_TOKEN}`
                }
            });
            return await response.json();
        }
    });

    const runDelete = () => {
        /* React mutation deletion */
        if (deletionItems.length > 0) {
            setReturnItems(...deletionItems);
        }
        
        alert('deleted entries');
        setDeletionItems([]);
    };


    useEffect(() => {
        setDeleteState(action === 'DELETE' ? 'darken' : 'lighten');
        if (deletionItems === undefined) {
            setDeletionItems([]);
        }
    })


    if (isPending) {
        return (<span>Loading...</span>)
    }

    if (isError) {
        console.log(error);
        return (<NotFound />);
    }

    return (
        <>
            <div className="Form-actions">
                <button className="button-action" id="" onClick={() => { setMode('POST') }}>Add new entry</button>
                <button className="button-action" id="" onClick={() => { setMode('UPDATE') }}>Update entry</button>
                <button className="button-action" id={deleteState} onClick={() => {
                    setMode('DELETE');
                    /* DELETE items function here */
                    setDeletionItems([]);
                    }}>Delete entry</button>
            </div>
            <div className={`delete-drawer ${action === 'DELETE' ? 'show-delete-drawer' : 'hide-delete-drawer'}`}>
                <h3>{deletionItems !== undefined && deletionItems.length > 0 ? "Deleting Items:" : "Select entries to delete"} </h3>
                <p>
                    {deletionItems !== undefined ? deletionItems.toString() : ''}
                </p>
                {deletionItems === undefined || deletionItems.length < 1 ? "": <button className="button-action" type="button" onClick={runDelete}>Delete entries</button>}
            </div>
            <div className="Forms">
                {/* Search bar */}
                {/* <label htmlFor="" className="form-search">
            <input type="search" name="" id="" />
            </label> */}
                {/* Page Name */}
                <div className="Forms-options">
                    {/* Info displayed on the top section */}
                    {data.map((x) => {
                        

                            return (
                                <DisplayForms
                                identifier={identifier} /* id */
                                key={x[identifier]}
                                props={x} /* current object data */
                                states={{ displayId, setDisplayId, displayProps, setDisplayProps, deletionItems, setDeletionItems, action }}
                                options={topInfo} /* Display options of current data */
                                label={label} /* Which of the top options should be displayed */
                                />
                            )
                        
                    })}
                </div>
                {/* Extra information Display drawer */}
                <div className={`Forms-create-display ${(displayProps[identifier] || (action == ('POST' || 'UPDATE'))) ? "show-Drawer" : 'hide-Drawer'}`}>
                    <div className="FormInfo">
                        {
                            action === 'POST' || action === 'UPDATE'

                                ?

                                <FormInput
                                    options={options}
                                    currentObject={displayProps}
                                    httpMethod={action}
                                    setMethod={setAction}
                                    identifier={identifier}
                                />

                                :

                                <FormInfo
                                    options={options}
                                    props={displayProps}
                                />
                        }
                    </div>

                </div>
            </div>
        </>
    )
}

export default Forms;

/* 
--------- TO-Do's ---------
1. Include search bar 
 */