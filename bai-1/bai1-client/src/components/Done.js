import React from "react";
import { Link } from 'react-router-dom';

export default function Done() {
    return (
        <div className="done">
            <h1>Done</h1>
            <Link to='/'><button>Retourner</button></Link>
        </div>
    )
}