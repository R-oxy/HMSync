import { useState } from "react";

function DisplayForms({props, states}) {
    const label = 'Name';
    const options = ['Name', 'Id', 'Gender', 'Arrears', 'Check-in', 'Check-out'];

    const [count, setCount] = useState(0);

    const setClicked = () => {
        /* Show info drawer */
        if (states.displayId === '' || states.displayId !== props.Id) {
            states.setDisplayId(props.Id);
            states.setDisplayProps(props);
            setCount(count + 1);
            /* hide display drawer on second click */
        } else if (count > 0 && states.displayId === props.Id) {
            states.setDisplayId('');
            states.setDisplayProps({});
            setCount(0);
        }
        
    };
    return (
        <div className="Forms-DisplayOnly" onClick={setClicked}>
            {
                options.map((x) => {
                    if (x === label) {
                        return (
                            <h3 className="label-main" key={x}>{props[x]}</h3>
                        );
                    } else {
                        return (
                            <div className="label-additional " key={x} >
                                <h4 className="wrap-class">{`${x}: `}</h4>
                                &nbsp;
                                <p className="wrap-class">{` ${props[x]}`}</p>
                            </div>
                        );
                    }
                })
            }


        </div>
    );
}

export default DisplayForms;