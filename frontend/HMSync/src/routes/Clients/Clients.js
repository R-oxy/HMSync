import { useOutletContext } from "react-router-dom";
import Forms from "../../Forms/Forms";

function Clients() {
    const apiPrefix = useOutletContext();
    const identifier = 'userId';
    const label = 'firstName';
    const suffixUrl = `${apiPrefix}ya3EAyOLE7Yw${'/data'}`;
    const qKey = 'ClientData';
    const topInfo = {
        "First Name": 'firstName',
        'Id': 'userId'
    };
    const options = {
        'First Name': 'firstName',
        'Last Name': 'lastName',
        'Id': 'userId',
        'Gender': 'gender',
        'Email': 'email',
        'Phone Number': 'phoneNumber',
        'Identification Number': 'identificationNumber'
    };

    return (
        <Forms
            identifier={identifier}
            topInfo={topInfo}
            options={options}
            label={label}
            apiUrl={suffixUrl}
            qKey={qKey}
        />
    );
}

{/* <Forms
        identifier={'userId'}
          topInfo={{
            ["First Name"]: clients["First Name"],
            ['Id']: clients["Id"]
          }}
          options={clients}
          label={'firstName'}
          apiUrl={`${apiPrefix}ya3EAyOLE7Yw${'/data'}`}
          qKey={'ClientData'}
        /> */}

export default Clients;