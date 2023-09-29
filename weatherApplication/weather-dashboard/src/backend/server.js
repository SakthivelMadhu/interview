const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql');
const app = express();

// Use body-parser middleware to parse incoming requests
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Create MySQL connection
const db = mysql.createConnection({
  host: 'localhost',  // Change as per your MySQL server configuration
  user: 'root',       // Change if using a different MySQL user
  password: 'Sakthivel1402!', // Change to your MySQL password
  database: 'weather_db' // Create a database named 'weather_db'
});

// Connect to MySQL
db.connect((err) => {
  if (err) throw err;
  console.log('Connected to MySQL');
});

// Create API routes (example)
app.get('/api/reports', (req, res) => {
  db.query('SELECT * FROM reports', (error, results) => {
    if (error) throw error;
    res.json(results);
  });
});

app.post('/api/reports', (req, res) => {
  const { report } = req.body;
  db.query('INSERT INTO reports SET ?', report, (error, results) => {
    if (error) throw error;
    res.json({ message: 'Report added successfully' });
  });
});

// Start the server
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
