import { useOutletContext } from "react-router-dom";
import Forms from "../../Forms/Forms";

function Transactions() {
    const apiPrefix = useOutletContext();
    const identifier = 'transactionId';
    const label = 'transactionType';
    const suffixUrl = `${apiPrefix}sj4GQY5nNp1G/data`;
    const qKey = 'TransactionData';
    const topInfo = {
        "Transaction Type": "transactionType",
        "Transaction ID": "transactionId",
    };
    const options = {
        "Transaction Type": "transactionType",
        "Transaction ID": "transactionId",
        "Receipt ID": "ReceiptId",
        "Client ID": "clientId",
        "Client Name": "clientName",
        "Transaction Form": "TransactionForm"
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

export default Transactions;