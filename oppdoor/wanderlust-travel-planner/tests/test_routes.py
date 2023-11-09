from app import app, db
from app.models import Destination, Itinerary, Expense
import unittest

class TestRoutes(unittest.TestCase):
    def setUp(self):
        app.config['TESTING'] = True
        app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///:memory:'
        self.app = app.test_client()
        db.create_all()

    def tearDown(self):
        db.session.remove()
        db.drop_all()

    def test_add_destination(self):
        response = self.app.post('/add_destination', data=dict(
            name='Test Destination',
            description='Test Description',
            location='Test Location'
        ), follow_redirects=True)

        self.assertEqual(response.status_code, 200)
        self.assertIn(b'Test Destination', response.data)

    # Add more route tests as needed
