import { useOutletContext } from "react-router-dom";
import Forms from "../../Forms/Forms";

function Staff() {
    const apiPrefix = useOutletContext();
    const identifier = 'staffId';
    const label = 'firstName';
    const suffixUrl = `${apiPrefix}YDHfCIizOy0f/data`;
    const qKey = 'StaffData';
    const topInfo = {
        'First Name': 'firstName',
        'Staff Id': 'staffId'
    };
    const options = {
        'First Name': 'firstName',
        'Last Name': 'lastName',
        'Staff Id': 'staffId',
        'Phone Number': 'phoneNumber',
        'Job Title': 'jobTitle',
        'Department': 'department',
        'Shift Type': 'shiftType',
        'Clock-in': 'clockInTime',
        'Clock-out': 'clockOutTime',
        'Performance Review': 'performanceReview',
        'Assignment': 'assignment'
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

export default Staff;