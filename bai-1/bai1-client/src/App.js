import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import CreditCard from "./components/CreditCard";
import Payment from './components/Payment';
import Done from './components/Done';

function App() {
  return (
    <div className="App">
      <div className="container">
        <Router>
          <Routes>
            <Route path="/add-credit-card" element={<CreditCard />} />
            <Route exact path="/" element={<Payment />} />
            <Route path="/success" element={<Done />} />
          </Routes>
        </Router>
      </div>
    </div>
  );
}

export default App;
