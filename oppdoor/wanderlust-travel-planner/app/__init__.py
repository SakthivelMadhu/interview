from flask import Flask
from flask_sqlalchemy import SQLAlchemy

# Initialize Flask application
app = Flask(__name__)

# Load configurations from config.py
app.config.from_object('app.config.Config')

# Initialize SQLAlchemy
db = SQLAlchemy(app)

# Import routes
from app import routes
