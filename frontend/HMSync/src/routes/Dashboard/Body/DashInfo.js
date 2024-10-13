function DashInfo({ topic, value, percentage, definition }) {
    return (
        <article className="dashboard-info">
            <div className="dashboard-info-container">
                <div style={{height: '20%'}} className="info-container">
                    <h4 className="dashboard-info-header">{topic}</h4>
                </div>

                <div style={{height: '40%'}} className="info-container">
                    <p className="dashboard-value">{value}</p>
                </div>

                <div style={{height: '30%'}} className="info-container">

                    <div className="dashboard-percentage">
                        <div style={{width: percentage}} className="dashboard-bar"></div>
                    </div>
                    <p className="dashboard-definition">*as compared to {definition}</p>
                </div>

            </div>

        </article>
    )
}

export default DashInfo;