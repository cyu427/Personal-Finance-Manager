import axios from "axios"

const REST_API_BASE_URL_CATEGORY = 'http://localhost:8080/api/finance/categories';
const REST_API_BASE_URL_TRANSACTIONS = 'http://localhost:8080/api/finance/transactions';
const REST_API_BASE_URL_DASHBOARD = 'http://localhost:8080/api/finance/dashboard';

export const showNetWorth = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getAllIncome');
export const showTotalCash = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getTotalCash');
export const showTotalSaving = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getAllSaving');
export const showTotalInvestment = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getAllInvestment');

export const showCurrentMonthIncome = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getCurrentMonthIncome');
export const showLastMonthIncome = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getLastMonthIncome');
export const showCurrentYearIncome = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getCurrentYearIncome');
export const showJanIncome = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getJanIncome');

export const showCurrentMonthExpenses = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getCurrentMonthExpense');
export const showLastMonthExpenses = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getLastMonthExpense');
export const showCurrentYearExpenses = () => axios.get(REST_API_BASE_URL_DASHBOARD + '/getCurrentYearExpense');
