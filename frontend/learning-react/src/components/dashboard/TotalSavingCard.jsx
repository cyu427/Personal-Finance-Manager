import React, { useEffect, useState } from 'react'
import "./Card.css";
import { showTotalSaving } from '../../services/EmployeeService';

export const TotalSavingCard = () => {

    const [totalSaving, setTotalSaving] = useState([])

    useEffect(() => {
        getTotalSaving();
    }, [])

    function getTotalSaving() {
        showTotalSaving().then((response) => {
            setTotalSaving(response.data);
        }).catch(error => {
            console.error(error);
        })
    }
    
    return (
        <div className='card-container'>
            <h1 className='card-title'> Total Saving </h1>
            <p className='card-description'> $ {totalSaving} </p>
        </div>
    )
}
