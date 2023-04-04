import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Link } from 'react-router-dom';

export default function Payment() {

    const navigate = useNavigate();

    const [payment, setPayment] = useState({
        amount: "",
        creditCardNumber: "",
    });

    const [errorMessage, setErrorMessage] = useState(null);

    const handleSubmit = (event) => {
        event.preventDefault();
        fetch("http://localhost:8081/payment/add", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payment)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Failed to add credit card");
                } else {
                    navigate('../success')
                }
                // handle successful response here
            })
            .catch(error => {
                console.error(error);
                setErrorMessage("Failed to add payment. Maybe credit card number hasn't been created. Please try again.");
            });
    };

    const handleChange = (event) => {
        const { name, value } = event.target;
        setPayment(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    return (
        <div className="payment">
            <h2>Enter total amount</h2>
            <form className="card-form">
                {errorMessage && <p className="error-message">{errorMessage}</p>}
                <div className="card-input">
                    <div className="part">
                        <label>Card Number</label>
                        <input type="text" name='creditCardNumber' value={payment.creditCardNumber} onChange={handleChange} placeholder="Enter" />
                    </div>
                    <div className="part">
                        <label>Total amount:</label>
                        <input type="text" name='amount' value={payment.amount} onChange={handleChange} placeholder="Enter" />
                    </div>
                </div>
                <div className="button">
                    <Link to='/add-credit-card'><button>Add credit card </button></Link>
                    <button onClick={handleSubmit}>Check out</button>
                </div>
            </form>
        </div>
    )
}