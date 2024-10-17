import { useEffect, useState } from "react";
import FormInfo from "./FormInfo";

function DisplayForms({ props, states, options, label, identifier }) {



    const [count, setCount] = useState(0);
    const [darken, setDarken] = useState('');

    useEffect(() => {
        setDarken(states.displayProps[identifier] == props[identifier] ? 'darken' : '');
    }, [darken, states])

    const setClicked = () => {
        /* Show info drawer */
        if (states.displayId === '' || states.displayId !== props[identifier]) {
            states.setDisplayId(props[identifier]);
            states.setDisplayProps(props);
            setCount(count + 1);

            /* hide display drawer on second click */
        } else if (count > 0 && states.displayId === props[identifier]) {
            states.setDisplayId('');
            states.setDisplayProps({});
            setCount(0);

        }
    };
    return (
        <div className={`Forms-DisplayOnly ${darken}`} onClick={setClicked}>


            <FormInfo
                options={options}
                props={props}
                label={label}
            />
        </div>
    );
}

export default DisplayForms;