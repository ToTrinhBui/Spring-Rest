import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function CreditCard() {
    const [cardData, setCardData] = useState({
        cardholderName: "",
        cardType: "",
        cardNumber: "",
        cvc: "",
        expirationMonth: "",
        expirationYear: ""
    });

    const [errorMessage, setErrorMessage] = useState(null);

    const navigate = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();
        fetch("http://localhost:8081/credit-cards/add", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cardData)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Failed to add credit card");
                } else {
                    navigate(`/`);
                }
            })
            .catch(error => {
                console.error(error);
                setErrorMessage("Failed to add credit card. Maybe credit card number has been used. Please try again.");
            });
    };

    const handleChange = (event) => {
        const { name, value } = event.target;
        setCardData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    return (
        <div className="credit-card">
            <h2>Enter your credit card information</h2>
            <form className="card-form">
                {errorMessage && <p className="error-message">{errorMessage}</p>}
                <div className="card-input">
                    <div className="part">
                        <label>Cardholder Name:</label>
                        <input type="text" name='cardholderName' value={cardData.cardholderName} onChange={handleChange} placeholder="Enter" />
                    </div>
                    <div className="part">
                        <label>Card Type:</label>
                        <input type="text" name='cardType' value={cardData.cardType} onChange={handleChange} placeholder="Enter" />
                    </div>
                    <div className="part">
                        <label>Card Number:</label>
                        <input type="text" name='cardNumber' value={cardData.cardNumber} onChange={handleChange} placeholder="Enter" />
                    </div>
                    <div className="part">
                        <label>cvc:</label>
                        <input type="text" name='cvc' value={cardData.cvc} onChange={handleChange} placeholder="Enter" />
                    </div>
                    <div className="part">
                        <label>Expiration Month:</label>
                        <input type="text" name='expirationMonth' value={cardData.expirationMonth} onChange={handleChange} placeholder="Enter" />
                    </div>
                    <div className="part">
                        <label>Expiration Year:</label>
                        <input type="text" name='expirationYear' value={cardData.expirationYear} onChange={handleChange} placeholder="Enter" />
                    </div>
                </div>
                <button onClick={handleSubmit}>Continue</button>
            </form>
        </div>
    )
}