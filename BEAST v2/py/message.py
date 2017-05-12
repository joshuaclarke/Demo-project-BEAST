from sense_hat import SenseHat

"""
Author - Rémi GIDON
"""

sense = sense_hat.SenseHat()

def show_message(message):
    sense.show_message(message)
    sense.clear()