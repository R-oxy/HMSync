import { useMutation } from "@tanstack/react-query";
import { useState } from "react";

function FormInput({ currentObject, options = [], httpMethod, setMethod, identifier }) {
    const [newData, setNewData] = useState({});

    /* const dataModification = useMutation({
        mutationFn: async (newSubmission) => {
            const response = await fetch(apiUrl, {
                method: httpMethod,
                body: JSON.stringify(newSubmission)
            });

            return await response.json();
        }
    }); */

    const handleSubmit = (e) => {
        e.preventDefault();
        const returnData = { ...currentObject };

        for (const value of Object.values(options)) {
            if (newData[value]) {
                returnData[value] = newData[value];
            }
        }
        setNewData({ ...returnData });
        // dataModification.mutate(newData);
        setMethod('');
        console.log(newData);
    }





    const handeInput = (event, identifier) => {
        setNewData({
            ...newData,
            [identifier]: event
        });
    };


    return (<div className="Form-input-container">
            <h4>{`${httpMethod == "UPDATE" ? 'Updating Id: ' + currentObject[identifier] : 'New Entry'}`}</h4>
        <form className="FormInput" onSubmit={handleSubmit}>
            {/* TItle label */}
            {/* Number of entries == number of object keys */}

            {
                Object.entries(options).map(
                    ([key, value]) => {
                        if (value !== identifier) {

                            return (<label key={key} htmlFor={key}>
                                {key}: &nbsp;
                                <input
                                    type="text"
                                    name={key}
                                    id={key}
                                    onChange={(e) => handeInput(e.target.value, value)}
                                    />
                            </label>)
                        }
                    }
                )
            }
            <input type="submit" value="Submit" className="FormInput-click" />

        </form>
            </div>
    );
}

export default FormInput;