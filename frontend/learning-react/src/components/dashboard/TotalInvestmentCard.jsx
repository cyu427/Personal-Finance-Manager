import React, { useEffect, useState } from 'react'
import "./Card.css";
import { showTotalInvestment } from '../../services/EmployeeService';

export const TotalInvestmentCard = () => {

    const [totalInvestment, setTotalInvestment] = useState([])

    useEffect(() => {
        getTotalInvestment();
    }, [])

    function getTotalInvestment() {
        showTotalInvestment().then((response) => {
            setTotalInvestment(response.data);
        }).catch(error => {
            console.error(error);
        })
    }
    
    return (
        <div className='card-container'>
            <h1 className='card-title'> Total Investment </h1>
            <p className='card-description'> $ {totalInvestment} </p>
        </div>
    )
}
