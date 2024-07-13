import React, { useEffect, useState } from 'react'
import Select from 'react-select'
import "./Card.css";
import { showCurrentMonthExpenses, showLastMonthExpenses, showCurrentYearExpenses } from '../../services/EmployeeService';

export const TotalExpenseCard = () => {
    const options = [
        { value: "currentMonth", label: "Current Month"},
        { value: "lastMonth", label: "Last Month"},
        { value: "currentYear", label: "Current Year"},
        { value: "lastYear", label: "Last Year" },
        { value: "allTime", label: "All Time"},
    ];

    const customStyles = {
        control: (styles) => ({...styles, 
          backgroundColor: '#f3f4f6',
          width: '145px',
          fontSize: '13px'}),
        menu: (styles) => ({...styles, 
          backgroundColor: '#f3f4f6',
          width: '145px',
          fontSize: '13px'}),
      };

    const [selectedOption, setSelectedOption] = useState(options[0]);
    
    const handleChange = (selectedOption) => {
        console.log('handleChange', selectedOption);
        setSelectedOption(selectedOption);
        getTotalIncome();
    }

    const [totalExpense, setTotalExpense] = useState([])

    useEffect(() => {
        getTotalExpense();
    }, [selectedOption])

    function getTotalExpense() {
        switch(selectedOption.value) {
            case "currentMonth":
                showCurrentMonthExpenses().then((response) => {
                    setTotalExpense(response.data);
                }).catch(error => {
                    console.error(error);
                })
                break;
            case "lastMonth":
                showLastMonthExpenses().then((response) => {
                    setTotalExpense(response.data);
                }).catch(error => {
                    console.error(error);
                })
                break;
            case "currentYear":
                showCurrentYearExpenses().then((response) => {
                    setTotalExpense(response.data);
                }).catch(error => {
                    console.error(error);
                })
                break;
        }
    }
    
    return (
        <div className='big-card-container'>
            <h1 className='card-title'> Total Expense </h1>
            <p className='card-description'> $ {totalExpense} </p>
            <Select className='select-options' options={options} defaultValue={selectedOption} onChange={handleChange} isSearchable={false} styles={customStyles}/>
        </div>
    )
}
