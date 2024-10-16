import { useOutletContext } from "react-router-dom";
import Forms from "../../Forms/Forms";

function Rooms() {
    const apiPrefix = useOutletContext();
    const identifier = 'roomId';
    const label = 'roomNumber';
    const suffixUrl = `${apiPrefix}mBkE8Be45iKR/data`;
    const qKey = 'RoomData';
    const topInfo = {
        "Room Number": "roomNumber",
        "Room ID": "roomId"
    };
    const options = {
        "Room Number": "roomNumber",
        "Room ID": "roomId",
        "Room Category": "roomCategory",
        "Room Type": "roomType",
        "Floor Number": "floorNumber",
        "Number of Beds": "numberOfBeds",
        "Room Amenities": "roomAmenities",
        "Special Features": "specialFeatures",
        "Occupancy Status": "occupancyStatus"
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

export default Rooms;