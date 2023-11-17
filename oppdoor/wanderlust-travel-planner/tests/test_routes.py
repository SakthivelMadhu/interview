# tests/test_routes.py
import json
import unittest
from app import app, db
from app.models import Destination

class TestRoutes(unittest.TestCase):

    def setUp(self):
        app.config['TESTING'] = True
        app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///:memory:'
        self.app = app.test_client()
        db.create_all()

    def tearDown(self):
        db.session.remove()
        db.drop_all()

    def test_get_destinations(self):
        # Add test destinations to the database
        dest1 = Destination(name='Paris', description='City of Lights', location='France')
        dest2 = Destination(name='Tokyo', description='Vibrant Metropolis', location='Japan')
        db.session.add_all([dest1, dest2])
        db.session.commit()

        # Send a GET request to the /destinations endpoint
        response = self.app.get('/destinations')

        # Check if the response status code is 200 OK
        self.assertEqual(response.status_code, 200)

        # Parse the JSON response
        data = json.loads(response.get_data(as_text=True))

        # Check if the response contains the expected destinations
        self.assertEqual(len(data), 2)
        self.assertEqual(data[0]['name'], 'Paris')
        self.assertEqual(data[1]['name'], 'Tokyo')

if __name__ == '__main__':
    unittest.main()
