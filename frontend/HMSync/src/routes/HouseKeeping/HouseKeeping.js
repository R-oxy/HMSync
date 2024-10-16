import { useOutletContext } from "react-router-dom";
import Forms from "../../Forms/Forms";

function HouseKeeping() {
    const apiPrefix = useOutletContext();
    const identifier = 'houseKeepingId';
    const label = 'roomStatus';
    const suffixUrl = `${apiPrefix}lM1fhVvy_xng/data`;
    const qKey = 'HouseKeepingData';
    const topInfo = {
        "Room Number": "roomNumber",
        "Room Status": "roomStatus"
    };
    const options = {
        "Room Status": "roomStatus",
        "Housekeeping ID": "houseKeepingId",
        "Room Number": "roomNumber",
        "Cleaning Schedule": "cleaningSchedule",
        "Housekeeper Assigned": "houseKeeperAssigned",
        "Staff ID": "staffId"
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

export default HouseKeeping;