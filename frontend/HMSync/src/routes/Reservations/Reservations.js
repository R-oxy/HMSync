import { useOutletContext } from "react-router-dom";
import Forms from "../../Forms/Forms";

function Reservations() {
    const apiPrefix = useOutletContext();
    const identifier = 'bookingId';
    const label = 'firstName';
    const suffixUrl = `${apiPrefix}-l07WhaBojom/data`;
    const qKey = 'ReservationData';
    const topInfo = {
        "First Name": "firstName",
        "Booking ID": "bookingId",
    };
    const options = {
        "First Name": "firstName",
        "Last Name": "lastName",
        "Email": "email",
        "Phone Number": "phoneNumber",
        "Identification Number": "identificationNumber",
        "Booking ID": "bookingId",
        "User ID": "userId",
        "Identification Document": "identificationDocument",
        "Room Number": "roomNumber",
        "Reservation Date": "reservationDate",
        "Check-In Date": "checkInDate",
        "Check-Out Date": "checkOutDate",
        "Room Pricing": "roomPricing",
        "Booking Confirmation": "bookingConfirmation"
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

export default Reservations;