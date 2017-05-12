from sense_hat import SenseHat
from time import sleep

"""
Author - Madric HOTTINGER & Rémi GIDON
"""

sense = SenseHat()

def transition():
    """
    transition from empty screen to white screen
    """
    t = 0.1
    w = [250, 250, 250]
    b = [0, 0, 0]

    matrix0 = [
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        w, w, w, w, w, w, w, w
    ]

    matrix1 = [
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w
    ]

    matrix2 = [
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w
    ]

    matrix3 = [
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w
    ]

    matrix4 = [
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w
    ]

    matrix5 = [
        b, b, b, b, b, b, b, b,
        b, b, b, b, b, b, b, b,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w
    ]

    matrix6 = [
        b, b, b, b, b, b, b, b,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w
    ]

    matrix7 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w
    ]

    sense.set_pixels(matrix0)
    sleep(t)
    sense.set_pixels(matrix1)
    sleep(t)
    sense.set_pixels(matrix2)
    sleep(t)
    sense.set_pixels(matrix3)
    sleep(t)
    sense.set_pixels(matrix4)
    sleep(t)
    sense.set_pixels(matrix5)
    sleep(t)
    sense.set_pixels(matrix6)
    sleep(t)
    sense.set_pixels(matrix7)
    sleep(t)
    sleep(2)
    sense.clear()
#endOfTransition


def smile():
    """
    Smiling function
    """
    t = 0.2
    angles = [0, 90, 180, 270, 0, 90, 180, 270, 0, 90, 180, 270, 0, 90, 180, 270, 0]
    b1 = [50, 50, 255]
    b2 = [0, 0, 0]
    w = [250, 250, 250]

    matrix0 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w
    ]

    matrix1 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix2 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix3 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix4 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix5 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix6 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix7 = [
        w, w, w, w, w, w, w, w,
        b2, b1, b2, b2, b2, b2, b1, b2,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix8 = [
        b2, b2, b1, b1, b1, b1, b2, b2,
        b2, b1, b2, b2, b2, b2, b1, b2,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    transition()

    sense.set_pixels(matrix0)
    sleep(t)
    sense.set_pixels(matrix1)
    sleep(t)
    sense.set_pixels(matrix2)
    sleep(t)
    sense.set_pixels(matrix3)
    sleep(t)
    sense.set_pixels(matrix4)
    sleep(t)
    sense.set_pixels(matrix5)
    sleep(t)
    sense.set_pixels(matrix6)
    sleep(t)
    sense.set_pixels(matrix7)
    sleep(t)
    sense.set_pixels(matrix8)
    sleep(t)
    for r in angles:
        sense.set_rotation(r)
        sleep(t)
    sleep(2)
    sense.clear()
#endOfSmile


def angry():
    """
    Smiling function
    """
    t = 0.2

    angles = [0, 270, 0, 90, 0, 270, 0, 90, 0]
    b1 = [250, 250, 0]
    b2 = [0, 0, 0]
    w = [250, 250, 250]

    matrix0 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w
    ]

    matrix1 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix2 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix3 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix4 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix5 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix6 = [
        w, w, w, w, w, w, w, w,
        w, w, w, w, w, w, w, w,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix7 = [
        w, w, w, w, w, w, w, w,
        b2, b1, b2, b2, b2, b2, b1, b2,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    matrix8 = [
        b2, b2, b1, b1, b1, b1, b2, b2,
        b2, b1, b2, b2, b2, b2, b1, b2,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b1, b2, b2, b1, b1, b2, b2, b1,
        b1, b2, b1, b2, b2, b1, b2, b1,
        b1, b2, b2, b2, b2, b2, b2, b1,
        b2, b1, b1, b1, b1, b1, b1, b2
    ]

    transition()

    sense.set_pixels(matrix0)
    sleep(t)
    sense.set_pixels(matrix1)
    sleep(t)
    sense.set_pixels(matrix2)
    sleep(t)
    sense.set_pixels(matrix3)
    sleep(t)
    sense.set_pixels(matrix4)
    sleep(t)
    sense.set_pixels(matrix5)
    sleep(t)
    sense.set_pixels(matrix6)
    sleep(t)
    sense.set_pixels(matrix7)
    sleep(t)
    sense.set_pixels(matrix8)
    sleep(t)
    for r in angles:
        sense.set_rotation(r)
        sleep(0.5)
    sleep(2)
    sense.clear()
#endOfAngry

def hungry():
    """
    hungry function
    """
    sense.show_letter("H",text_colour=[255, 0, 0])
    sleep(1)
    sense.show_letter("U",text_colour=[250, 250, 0])
    sleep(1)
    sense.show_letter("N",text_colour=[255, 0, 0])
    sleep(1)
    sense.show_letter("G",text_colour=[250, 250, 0])
    sleep(1)
    sense.show_letter("R",text_colour=[255, 0, 0])
    sleep(1)
    sense.show_letter("Y",text_colour=[250, 250, 0])
    sleep(1)
    sense.show_letter("!",text_colour=[255, 0, 0], back_colour=[250, 250, 0])
    sleep(1)
    sense.clear()
#endOfHungry

"""
FIN DES FONCTIONS
TESTS DE CES DERNIERES
"""


def print_face(face_code):
    if face_code == "SMILE":
        smile()
    elif face_code == "ANGRY":
        angry()
    elif face_code == "HUNGRY":
        hungry()
    return 1
