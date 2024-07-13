import Navbar from "./components/nav_bar/Navbar";
import Category from "./pages/categories/category";
import Index from "./pages/index/index";
import Transactions from "./pages/transaction/Transactions";
import { Route, Routes} from "react-router-dom";


function App() {
    return (
        <>
            <Navbar />
            <div className="container">
                <Routes>
                    <Route path="/" element={<Index />} />
                    <Route path="/transaction" element={<Transactions />} />
                    <Route path="/categories" element={<Category />} />        
                </Routes>
            </div>
        </>
    )
}

export default App;