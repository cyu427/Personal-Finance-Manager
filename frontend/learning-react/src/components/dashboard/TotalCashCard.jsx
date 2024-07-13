import React, { useEffect, useState } from 'react'
import "./Card.css";
import { showTotalCash } from '../../services/EmployeeService';

export const TotalCashCard = () => {

    const [totalCash, setTotalCash] = useState([])

    useEffect(() => {
        getTotalCash();
    }, [])

    function getTotalCash() {
        showTotalCash().then((response) => {
            setTotalCash(response.data);
        }).catch(error => {
            console.error(error);
        })
    }
    
    return (
        <div className='card-container'>
            <h1 className='card-title'> Total Cash </h1>
            <p className='card-description'> $ {totalCash} </p>
        </div>
    )
}
