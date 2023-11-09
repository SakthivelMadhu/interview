from app.models import Destination, Itinerary, Expense
import unittest
from app import app, db

class TestModels(unittest.TestCase):
    def setUp(self):

    def tearDown(self):

    def test_create_destination(self):
        destination = Destination(name='Test Destination', description='Test Description', location='Test Location')
        db.session.add(destination)
        db.session.commit()

        result = Destination.query.filter_by(name='Test Destination').first()
        self.assertIsNotNone(result)
