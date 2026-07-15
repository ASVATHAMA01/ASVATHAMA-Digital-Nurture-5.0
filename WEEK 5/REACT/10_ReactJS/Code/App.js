import React from 'react';

function App() {

  const offices = [
    { name: 'Prestige Tech Park', rent: 55000, address: 'Outer Ring Road, Bangalore' },
    { name: 'DLF Cybercity', rent: 75000, address: 'DLF Phase 2, Gurgaon' },
    { name: 'Mindspace', rent: 48000, address: 'Hitech City, Hyderabad' },
    { name: 'World Trade Center', rent: 90000, address: 'Cuffe Parade, Mumbai' },
    { name: 'Tidel Park', rent: 42000, address: 'Taramani, Chennai' }
  ];

  return (
    <div>
      <h1>Office Space Rental</h1>
      <img src="https://via.placeholder.com/400x200?text=Office+Space" alt="office" />

      {offices.map((office, i) => (
        <div key={i} style={{ border: '1px solid black', margin: '10px', padding: '10px' }}>
          <h3>{office.name}</h3>
          <p>Rent: <span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
            Rs. {office.rent}
          </span></p>
          <p>Address: {office.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
