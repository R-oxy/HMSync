import { Link } from "react-router-dom";

function NotFound() {
    return (
        <div className="NotFound">
            <h1 className="Error-code">Error 404: Page Not Found!</h1>
            <div className="Error-paragraph">

                <p>It appears on your screen, it means that the page you’re looking for has either been moved, deleted, or never existed in the first place.</p>
                <p>Don’t worry; this happens to the best of us!</p>
                <p>
                    Here are a few options to help you navigate:
                </p>

                <ul className="Error-options">
                    <li>
                        Check the URL for any typos or mistakes and retry the link.
                    </li>
                    <li>
                        Return to the &nbsp;
                        <Link to={'/'}>
                            homepage
                        </Link> &nbsp;
                        to find your way back.
                    </li>
                    <li>
                        Incase of server downtime, please be patient as we rectify this issue
                    </li>
                </ul>
            </div>
        </div>
    );
}

export default NotFound;