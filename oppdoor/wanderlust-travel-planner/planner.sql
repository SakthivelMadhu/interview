-- Inserting sample destinations
INSERT INTO destination (name, description, location) VALUES 
    ('Paris', 'The City of Lights', 'France'),
    ('New York City', 'The Big Apple', 'USA'),
    ('Tokyo', 'The Capital of Japan', 'Japan');

-- Inserting sample itineraries
INSERT INTO itinerary (activity, destination_id) VALUES 
    ('Visit Eiffel Tower', 1),
    ('Explore Louvre Museum', 1),
    ('Walk in Central Park', 2),
    ('Visit Statue of Liberty', 2),
    ('Visit Tokyo Disneyland', 3),
    ('Explore Shibuya Crossing', 3);

-- Inserting sample expenses
INSERT INTO expense (description, amount, category, destination_id) VALUES 
    ('Flight to Paris', 1000.00, 'Travel', 1),
    ('Hotel in Paris', 500.00, 'Accommodation', 1),
    ('Dinner at Le Jules Verne', 200.00, 'Food', 1),
    ('Broadway Show Tickets', 150.00, 'Entertainment', 2),
    ('Hotel in New York', 600.00, 'Accommodation', 2),
    ('Sushi Dinner', 100.00, 'Food', 3),
    ('Souvenirs', 50.00, 'Shopping', 3);
