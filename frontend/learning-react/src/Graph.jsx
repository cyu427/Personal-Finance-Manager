import { Chart as ChartJS } from 'chart.js/auto';
import { Bar, Doughnut, Line } from 'react-chartjs-2';
import sourceData from './data/sourceData.json';
import revenueData from './data/revenueData.json';

function Graph() {

  return (
    <>
      <div className="Graph">
        <div className="dataCard revenueCard">
          <Line
            data={{
              labels: revenueData.map((data) => data.label),
              datasets: [
                {
                  label: "Revenue",
                  data: revenueData.map((data) => data.revenue),
                  backgroundColor: "#064FF0",
                  borderColor: "064FF0"
                },
              ],
            }}

            options={{
              scales: {
                x: {
                  title: {
                    display: true,
                  },
                  ticks: {
                    display: false
                  }
                },
                y: {
                  title: {
                    display: true,
                    text: 'Amounts($)'
                  },
                  ticks: {
                    display: false
                  }
                }
              }
            }}

          />
        </div>

        <div className="customerCard">
          <Bar 
            data={{
              labels: sourceData.map((data) => data.label),
              datasets: [
                {
                  label: "Count",
                  data: sourceData.map((data) => data.value),
                },
              ],
            }}
          />
        </div>

        <div className="dataCard categoryCard">
          <Doughnut 
            data={{
              labels: sourceData.map((data) => data.label),
              datasets: [
                {
                  label: "Count",
                  data: sourceData.map((data) => data.value),
                },
              ],
            }}
          />
        </div>
      </div>
    </>
  )
}

export default Graph