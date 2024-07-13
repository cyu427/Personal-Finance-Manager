import React, { useEffect, useState } from 'react'
import Select from 'react-select'
import "./Card.css";
import { Bar, Doughnut, Line } from 'react-chartjs-2';
import { showCurrentMonthIncome, showLastMonthIncome, showJanIncome } from '../../services/EmployeeService';

export const TotalExpenseTrendCard = () => {
    const options = [
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

    const [totalIncomeJan, setTotalIncomeJan] = useState([])
    const [totalIncomeFeb, setTotalIncomeFeb] = useState([])
    const [totalIncomeMar, setTotalIncomeMar] = useState([])

    useEffect(() => {
      getTotalIncomeTrend();
    }, [selectedOption])

    function getTotalIncomeTrend() {
        showJanIncome().then((response) => {
            setTotalIncomeJan(response.data);
        }).catch(error => {
            console.error(error);
        })

        showLastMonthIncome().then((response) => {
            setTotalIncomeFeb(response.data);
        }).catch(error => {
            console.error(error);
        })

        showCurrentMonthIncome().then((response) => {
            setTotalIncomeMar(response.data);
        }).catch(error => {
            console.error(error);
        })        
    }
    
    return (
        <div className='graph-card-container'>
            <h1 className='card-title'> Total Expense Trend </h1>
            <div className='line-chart'>
            <Line
              data={{
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [
                  {
                    label: "Expense",
                    data: [totalIncomeJan, totalIncomeFeb, totalIncomeMar],
                    backgroundColor: "#064FF0",
                    borderColor: "green"
                  },
                ],
              }}
            />
            </div>

            <Select className='graph-select-options' options={options} defaultValue={selectedOption} onChange={handleChange} isSearchable={false} styles={customStyles}/>
        </div>
    )
}
