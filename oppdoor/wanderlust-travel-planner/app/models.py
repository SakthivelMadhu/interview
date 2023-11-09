from app import db

class Destination(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    description = db.Column(db.String(200), nullable=False)
    location = db.Column(db.String(100), nullable=False)

    def __repr__(self):
        return f"Destination(id={self.id}, name={self.name}, location={self.location})"

class Itinerary(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    activity = db.Column(db.String(200), nullable=False)
    destination_id = db.Column(db.Integer, db.ForeignKey('destination.id'), nullable=False)
    destination = db.relationship('Destination', backref=db.backref('itineraries', lazy=True))

    def __repr__(self):
        return f"Itinerary(id={self.id}, activity={self.activity}, destination={self.destination})"

class Expense(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    description = db.Column(db.String(200), nullable=False)
    amount = db.Column(db.Float, nullable=False)
    category = db.Column(db.String(50), nullable=False)
    destination_id = db.Column(db.Integer, db.ForeignKey('destination.id'), nullable=False)
    destination = db.relationship('Destination', backref=db.backref('expenses', lazy=True))

    def __repr__(self):
        return f"Expense(id={self.id}, description={self.description}, amount={self.amount}, category={self.category}, destination={self.destination})"
