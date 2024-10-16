import { useOutletContext } from "react-router-dom";
import Forms from "../../Forms/Forms";

function Reviews() {
    const apiPrefix = useOutletContext();
    const identifier = 'reviewId';
    const label = 'firstName';
    const suffixUrl = `${apiPrefix}U9ZjKllm-bqR/data`;
    const qKey = 'ReviewData';
    const topInfo = {
        "First Name": "firstName",
        "Review ID": "reviewId",
    };
    const options = {
        "First Name": "firstName",
        "Last Name": "lastName",
        "Email": "email",
        "Review ID": "reviewId",
        "Phone Number": "phoneNumber",
        "Room Number": "roomNumber",
        "Review": "review",
        "Rating": "rating"
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

export default Reviews;