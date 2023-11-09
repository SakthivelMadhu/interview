from flask import render_template, request, redirect, url_for
from app import app, db
from app.models import Destination, Itinerary, Expense

# Route for displaying all destinations
@app.route('/')
def index():
    destinations = Destination.query.all()
    return render_template('index.html', destinations=destinations)

# Route for adding a new destination
@app.route('/add_destination', methods=['POST'])
def add_destination():
    name = request.form.get('name')
    description = request.form.get('description')
    location = request.form.get('location')

    new_destination = Destination(name=name, description=description, location=location)
    db.session.add(new_destination)
    db.session.commit()

    return redirect(url_for('index'))

# Route for displaying details of a destination
@app.route('/destination/<int:destination_id>')
def view_destination(destination_id):
    destination = Destination.query.get_or_404(destination_id)
    return render_template('destination.html', destination=destination)

# Route for adding a new activity to an itinerary
@app.route('/add_activity/<int:destination_id>', methods=['POST'])
def add_activity(destination_id):
    activity = request.form.get('activity')

    new_activity = Itinerary(activity=activity, destination_id=destination_id)
    db.session.add(new_activity)
    db.session.commit()

    return redirect(url_for('view_destination', destination_id=destination_id))

# Route for recording an expense
@app.route('/add_expense/<int:destination_id>', methods=['POST'])
def add_expense(destination_id):
    description = request.form.get('description')
    amount = float(request.form.get('amount'))
    category = request.form.get('category')

    new_expense = Expense(description=description, amount=amount, category=category, destination_id=destination_id)
    db.session.add(new_expense)
    db.session.commit()

    return redirect(url_for('view_destination', destination_id=destination_id))
