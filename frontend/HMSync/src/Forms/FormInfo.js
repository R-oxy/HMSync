function FormInfo({ options, props, label }) {
    return (
        <>
            {
                Object.entries(options).map(([key, value]) => {

                    if (value === label) {
                        return (
                            <h3 className="label-main" key={value}>{props[value]}</h3>
                        );
                    } else
                    return (
                        <div className="label-additional " key={value} >
                            <h4 className="wrap-class">{`${key}: `}</h4>
                            &nbsp;
                            <p className="wrap-class">{` ${props[value]}`}</p>
                        </div>
                    );
                })
            }
        </>
    );
}

export default FormInfo;