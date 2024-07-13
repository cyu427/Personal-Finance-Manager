import "./nav_style.css"

function Navbar() {

    return (
        <>
            <nav className="nav">
                <a href="/" className="site-title"> Site Name</a>
                <ul>
                    <li>
                        <a href="/" className="nav-option">Dashboard</a>
                    </li>
                    <li>
                        <a href="transaction" className="nav-option">Transation</a>
                    </li>
                    <li>
                        <a href="categories" className="nav-option">Categories</a>
                    </li>
                </ul>
            </nav>
        </>
    )
}

export default Navbar;