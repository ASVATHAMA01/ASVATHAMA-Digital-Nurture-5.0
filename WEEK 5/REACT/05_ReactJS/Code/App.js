import React from 'react';
import CohortDetails from './Components/CohortDetails';

function App() {
  return (
    <div>
      <h1>Cohort Dashboard</h1>
      <CohortDetails name="React Cohort 1" status="ongoing" startDate="01-Jan-2024" endDate="30-Jun-2024" />
      <CohortDetails name="Angular Cohort 1" status="completed" startDate="01-Jul-2023" endDate="31-Dec-2023" />
      <CohortDetails name="Java Cohort 1" status="ongoing" startDate="01-Mar-2024" endDate="31-Aug-2024" />
    </div>
  );
}

export default App;
