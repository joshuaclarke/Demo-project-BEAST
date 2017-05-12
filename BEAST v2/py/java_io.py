import time
import sys
import json

"""
Author - Rémi GIDON
"""

from rps import rock_paper_scissor
from smiley import print_face
from message import show_message

class EventManager:

    @staticmethod
    def dispatch(event):
		if event['event'] == 1:
            answer = print_face(event['payload'])
        elif event['event'] == 2:
            show_message(event['payload'])
            answer = 1
        elif event['event'] == 3:
            answer = rock_paper_scissor()	
        return json.dumps({"event":event['event'],"payload":event['payload'],"answer":'1'})


def read():
    s = sys.stdin.readline().strip()
    return s

def write(content):
    sys.stdout.write(content + '\n')
    sys.stdout.flush()

def listen():
    s = read()
    while 1:
        event = json.loads(s);
        if event['event'] == 0:
            break
        output = EventManager.dispatch(event);
        write(output)
        s = read()
        time.sleep(0.1)


listen()
"""
a = EventManager.dispatch(json.loads('{"event":1,"payload":"SMILE"}'))
print(a)
"""