import { useOutletContext } from "react-router-dom";
import Forms from "../../Forms/Forms";

function EventManagement() {
    const apiPrefix = useOutletContext();
    const identifier = 'eventId';
    const label = 'eventName';
    const suffixUrl = `${apiPrefix}s6cu422sE_PE/data`;
    const qKey = '';
    const topInfo = {
        "Event Name": "eventName",
        "Event ID": "eventId",
    };
    const options = {
        "Event Name": "eventName",
        "Event ID": "eventId",
        "Event Type": "eventType",
        "Event Date": "eventDate",
        "Event Status": "eventStatus",
        "Event Venue": "eventVenue"
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

export default EventManagement;