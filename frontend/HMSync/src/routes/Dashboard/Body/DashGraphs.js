import { LineChart } from "@mui/x-charts/LineChart";
import { useQuery } from "@tanstack/react-query";
import { useEffect, useState } from "react";

function DashGraphs() {

    const { isPending, isError, data, error} = useQuery({
        queryKey: ['graphs'],
        queryFn: async () => {
            const graphUrl = 'https://api.json-generator.com/templates/ptybu4NGyh7h/data';
            const response = await fetch(graphUrl, {
                headers: {
                    Authorization: "Bearer pfjgp2naaesz5aoyq3tnikav3j6d64qbqclw98vs"
                }

            });
            return await response.json();
        }
        }
    );

    if (isPending) {
        return(<span>Loading...</span>)
    }
    
    if (isError) {
        return(<div>Err</div>)
    }

    return (
        <LineChart
        xAxis={[
            /* x - axis coordinates */
            {
                data: data[0].months/* [1, 2, 3, 5, 8, 10] */,
                label: 'months'
            }
        ]}
        series={[
            {
                curve: 'monotoneX',
                /* y - axis coordinates */
                data: data[0].bookings  /* [2, 5.5, 2, 8.5, 1.5, 5] */,
                /* color of the line graph */
                color: 'var(--background-color-30)',
                label: 'bookings'
            }
        ]}
        grid={{ vertical: true, horizontal: true }}
        /* loading={true} */
        />
    );

}

export default DashGraphs;

