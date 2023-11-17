# app/routes.py
from flask import render_template, request, jsonify
from . import app, db
from .models import Destination, Itinerary, Expense

@app.route('/destinations', methods=['GET'])
def get_destinations():
    destinations = Destination.query.all()
    return jsonify([{'id': dest.id, 'name': dest.name, 'description': dest.description, 'location': dest.location} for dest in destinations])


# Error handling
@app.errorhandler(404)
def not_found_error(error):
    return jsonify({'error': 'Not found'}), 404

@app.errorhandler(500)
def internal_error(error):
    db.session.rollback()
    return jsonify({'error': 'Internal server error'}), 500
