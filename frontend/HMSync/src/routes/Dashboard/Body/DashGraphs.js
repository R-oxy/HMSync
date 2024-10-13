import { LineChart } from "@mui/x-charts/LineChart";
import { useEffect, useState } from "react";

function DashGraphs() {

    const [dimensions, setDimensions] = useState({ width: 0, height: 0 });

    useEffect(() => {
        const {width, height} = document.querySelector('.display-container-bottom').getBoundingClientRect();
        setDimensions({ width, height });
    }, []);

    return (
        <LineChart
        xAxis={[
            /* x - axis coordinates */
            {data: [1, 2, 3, 5, 8, 10]}
        ]}
        series={[
            {
                curve: 'monotoneX',
                /* y - axis coordinates */
                data: [2, 5.5, 2, 8.5, 1.5, 5],
                /* color of the line graph */
                color: 'var(--background-color-30)',
            },
        ]}
        /* conversion to integers */
        width={Math.floor(dimensions.width)}
        height={Math.floor(dimensions.height)}
        grid={{ vertical: true, horizontal: true }}
        />
    );

}

export default DashGraphs;

