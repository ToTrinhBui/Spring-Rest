import React, { useEffect, useState } from "react";
import axios from 'axios';

export default function Main() {
    const [items, setItems] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [errorMessage, setErrorMessage] = useState(null);

    useEffect(() => {
        axios.get('http://localhost:8083')
            .then(response => setItems(response.data))
            .catch(error =>
                console.error(error)
            );
    }, []);

    function handleSearchTermChange(event) {
        setSearchTerm(event.target.value);
    }

    function handleSubmit(event) {
        event.preventDefault();
        axios.get(`http://localhost:8083?keyword=${searchTerm}`)
            .then(response => {
                setItems(response.data);
                setErrorMessage(null);
            })
            .catch(error => {
                console.error(error);
                setErrorMessage("Items not found");
                setItems([]);
            });
    }

    function handleClick() {
        window.location.reload();
    }

    return (
        <div className="container">
            <h2>Check inventory</h2>

            <form onSubmit={handleSubmit}>
                <div className="search">
                    <img src="../images/search.png" alt="search-icon" />
                    <input id="search-term-input" type="text" value={searchTerm} onChange={handleSearchTermChange} placeholder="Enter" />
                </div>
                <button type="submit">Search</button>
                <button onClick={handleClick}>Reload</button>
            </form>

            {errorMessage && <div className="error-message">{errorMessage}</div>}

            {items.length > 0 && (
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        {items.map(item => (
                            <tr key={item.id}>
                                <td>{item.id}</td>
                                <td>{item.name}</td>
                                <td>{item.quantity}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    )
}