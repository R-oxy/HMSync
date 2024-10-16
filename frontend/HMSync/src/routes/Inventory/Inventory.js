import { useOutletContext } from "react-router-dom";
import Forms from "../../Forms/Forms";

function Inventory() {
    const apiPrefix = useOutletContext();
    const identifier = 'inventoryItemId';
    const label = 'itemName';
    const suffixUrl = `${apiPrefix}byKTbzGvgPfw/data`;
    const qKey = 'InventoryData';
    const topInfo = {
        "Item Name": "itemName",
        "Item ID": "inventoryItemId",
    };
    const options = {
        "Item Name": "itemName",
        "Item ID": "inventoryItemId",
        "Item Description": "itemDescription",
        "Supplier": "supplier",
        "Availability Status": "availabilityStatus",
        "Quantity Available": "quantityAvailable"
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

export default Inventory;