from app.models import Destination, Itinerary, Expense
import unittest

class TestModels(unittest.TestCase):
    def setUp(self):
        # Set up any necessary configurations or database connections

    def tearDown(self):
        # Clean up any resources after each test

    def test_create_destination(self):
        destination = Destination(name='Test Destination', description='Test Description', location='Test Location')
        db.session.add(destination)
        db.session.commit()

        result = Destination.query.filter_by(name='Test Destination').first()
        self.assertIsNotNone(result)
