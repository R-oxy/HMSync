import { useQuery, useQueryClient } from '@tanstack/react-query';
import './DashBody.css';
import DashGraphs from './DashGraphs';
import DashInfo from './DashInfo';
import LoadingPage from '../../../LoadingPage/LoadingPage';



function DashBody() {
    /* const queryClient = useQueryClient(); */
    
    const {isPending, isError, data, error} = useQuery({
        queryKey: ['analytics'],
        queryFn: async () => {
            const topDataUrl = "https://api.json-generator.com/templates/qkCOLo8LiuUU/data"
            const response = await fetch(topDataUrl, {
                headers: {
                    Authorization: `Bearer ${process.env.BEARER_TOKEN}`
                }
            });

            return await response.json();
        }
    })

    
    if (isPending) {
        return (<LoadingPage />)
    }
    
    if (isError) {
        console.log(error);
        return (<div>Err</div>)
    }

    
    // Data format {id: id, value: string, percentage: %, definition: string}
    return (
        <div className="Dash-body">
            <div className="display-top">
                <div className="display-container-top">
                    {data.map((x) => {
                        return (
                        <DashInfo
                        key={x.id}
                        {...x}
                        />
                    );
                    })}
                </div>
            </div>
            <div className="display-bottom">
                <div className="display-container-bottom">
                <DashGraphs /> 
                </div>

            </div>
        </div>
    );
}

export default DashBody;