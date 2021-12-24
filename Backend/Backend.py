
# sudo pip3 install Flask-PyMongo
# sudo pip3 install pymongo[srv]
# sudo pip3 install flask-socketio
# sudo pip3 install eventlet


# from flask import Flask, render_template,  request, escape
# from flask_socketio import SocketIO, emit
# from flask_pymongo import PyMongo
# from bson.json_util import dumps, loads
from bson.decimal128 import Decimal128, create_decimal128_context
from decimal import *
from flask import Flask, render_template,  request, escape, jsonify, url_for
from flask_socketio import SocketIO, emit
from flask_pymongo import PyMongo
from bson.json_util import dumps, loads
from pymongo import MongoClient
from bson.objectid import ObjectId

app = Flask(__name__)
app.config['SECRET_KEY'] = 'someSecretKey123'
app.config['DEBUG'] = True

socketio = SocketIO(app)
users = {}

app.config["MONGO_URI"] = "mongodb+srv://backend:backend@cluster0.rxm7h.mongodb.net/sample_airbnb?retryWrites=true&w=majority" # replace the URI with your own connection
mongo = PyMongo(app)


@app.route('/')
def init():                            # this is a comment. You can create your own function name
    return 'Homepage'


@app.route("/getalllistings")
def getalllistings():
    listings = mongo.db.listingsAndReviews.find({}).limit(1)
    resp = dumps(listings)
    return resp

@app.route("/getlistingsbyname/<name>")
def getlistingsbyname(name):
    return dumps(mongo.db.listingsAndReviews.find({'name': name}).limit(5))


@app.route("/getSearchedListing/<accommodates>/<bedrooms>/<beds>/<minimum_nights>/<maximum_nights>/<bathrooms>", methods = ["GET", "POST"])
def getSearchedListing(accommodates,bedrooms,beds,minimum_nights,maximum_nights,bathrooms):

    myList = {"accommodates": int(accommodates), "bedrooms": int(bedrooms), "beds": int(beds), "minimum_nights": minimum_nights, "maximum_nights": maximum_nights, "bathrooms": Decimal128(bathrooms)}

    listings = mongo.db.listingsAndReviews.find(myList)

    return dumps(list(listings))


@app.route("/searchbybedroom/<bedrooms>", methods = ["GET", "POST"])
def searchbybedroom(bedrooms):

    myList = {"bedrooms": int(bedrooms)}
    listings = mongo.db.listingsAndReviews.find(myList)
    return dumps(list(listings))


@app.route("/adduser", methods=['POST'])
def adduser():
    _json = request.json
    # print(_json, flush=True)
    _Firstname = _json['Firstname']
    _Lastname = _json['Lastname']
    _Booking = _json['Booking']

    if _Booking and _Firstname and _Lastname and request.method == 'POST':
        id = mongo.db.airbnb_user_300307958.insert_one(
            {'Booking':_Booking, 'Firstname': _Firstname , 'Lastname': _Lastname})
        resp = jsonify("user added successfully")
        resp.status_code = 200
        return resp


@app.route("/finduser/<Firstname>")
def finduser(Firstname):
    return dumps(mongo.db.airbnb_user_300307958.find_one({'Firstname': Firstname}))

if __name__ == '__main__':
    socketio.run(app,host = '0.0.0.0')  # here, we are using socketio instaead of app because it has more features
