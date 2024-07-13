import React, { useEffect, useState } from 'react'
import "./Card.css";
import { showNetWorth } from '../../services/EmployeeService';

export const NetWorthCard = () => {

    const [netWorth, setNetWorth] = useState([])

    useEffect(() => {
        getNetWorth();
    }, [])

    function getNetWorth() {
        showNetWorth().then((response) => {
            setNetWorth(response.data);
        }).catch(error => {
            console.error(error);
        })
    }
    
    return (
        <div className='card-container'>
            <h1 className='card-title'> Net Worth </h1>
            <p className='card-description'> $ {netWorth} </p>
        </div>
    )
}
