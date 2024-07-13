import './index.css'
import { NetWorthCard } from '../../components/dashboard/NetWorthCard';
import { TotalCashCard } from '../../components/dashboard/TotalCashCard';
import { TotalSavingCard} from '../../components/dashboard/TotalSavingCard';
import { TotalInvestmentCard} from '../../components/dashboard/TotalInvestmentCard'
import { TotalIncomeCard } from '../../components/dashboard/TotalIncomeCard';
import { TotalExpenseCard } from '../../components/dashboard/TotalExpensesCard';
import { TotalIncomeTrendCard } from '../../components/dashboard/TotalIncomeTrendCard';
import { TotalExpenseTrendCard } from '../../components/dashboard/TotalExpenseTrendCard';

function Index() {
    return (
        <>  
            <div className='index-content'>
                <h1 className='overview-header'>Account Overview</h1>
                <div className='card_row_1'>
                    <div className='card-left net_worth_card'>
                        <NetWorthCard />
                    </div>
                    <div className='card total_cash_card'>
                        <TotalCashCard />
                    </div>
                    <div className='card total_saving_card'>
                        <TotalSavingCard />
                    </div>
                    <div className='card total_investment_card'>
                        <TotalInvestmentCard />
                    </div>
                </div>
                <div className='card_row_2'>
                    <div className='card-left total-income'>
                        <TotalIncomeCard />
                    </div>
                    <div className='card total-expense'>
                        <TotalExpenseCard />
                    </div>
                </div>
                <div className='card_row_3'>
                    <div className='total-income-trend'>
                        <TotalIncomeTrendCard />
                    </div>
                    <div className='card total-expense-trend'>
                        <TotalExpenseTrendCard />
                    </div>
                </div>
            </div>
        </>
    )
}

export default Index;