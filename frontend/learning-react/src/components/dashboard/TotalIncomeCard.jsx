import React, { useEffect, useState } from 'react'
import Select from 'react-select'
import "./Card.css";
import { showCurrentMonthIncome, showLastMonthIncome, showCurrentYearIncome } from '../../services/EmployeeService';

export const TotalIncomeCard = () => {
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

    const [totalIncome, setTotalIncome] = useState([])

    useEffect(() => {
        getTotalIncome();
    }, [selectedOption])

    function getTotalIncome() {
        switch(selectedOption.value) {
            case "currentMonth":
                showCurrentMonthIncome().then((response) => {
                    setTotalIncome(response.data);
                }).catch(error => {
                    console.error(error);
                })
                break;
            case "lastMonth":
                showLastMonthIncome().then((response) => {
                    setTotalIncome(response.data);
                }).catch(error => {
                    console.error(error);
                })
                break;
            case "currentYear":
                showCurrentYearIncome().then((response) => {
                    setTotalIncome(response.data);
                }).catch(error => {
                    console.error(error);
                })
                break;
        }
    }
    
    return (
        <div className='big-card-container'>
            <h1 className='card-title'> Total Income </h1>
            <p className='card-description'> $ {totalIncome} </p>
            <Select className='select-options' options={options} defaultValue={selectedOption} onChange={handleChange} isSearchable={false} styles={customStyles}/>
        </div>
    )
}
