import React from 'react'
import ReactDOM from 'react-dom/client'
import Graph from './Graph.jsx'
import Index from './pages/index/index.jsx'
import App from './App.jsx'
import { BrowserRouter } from 'react-router-dom'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>,
)
