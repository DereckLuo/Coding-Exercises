## July 7, 2017
## Chongxin Luo
## Jarvis main program

import speech_recognition as sr
import pyttsx3
import datetime

class Jarvis:
    name = ""
    date = ""
    engine = pyttsx3.init()

    # self initialize function
    def __init__(self):
        self.date = datetime.datetime.now().date()
        self.name = "Jarvis"
        self.engine = pyttsx3.init()
        self.engine.setProperty('rate', 160)
        voices = self.engine.getProperty('voices')
        self.engine.setProperty('voice', voices[1].id)

    # greeting function
    def greeting(self):
        cur_hour = datetime.datetime.now().time().hour
        time_phrase = ""
        if cur_hour >= 4 <= 11:
            time_phrase = "Morning"
        elif cur_hour > 11 <= 16:
            time_phrase = "Afternoon"
        elif cur_hour > 16 <= 21:
            time_phrase = "Evening"
        else:
            time_phrase = "Night"
        print("Good " + time_phrase + " Dereck, What can I do for you?")
        self.voiceRespond("Good " + time_phrase + " Dereck, What can I do for you?")

    # voice respond function
    def voiceRespond(self, sentence):
        self.engine.say(sentence)
        self.engine.runAndWait()

    # speechRec function
    def speechRec(self):
        self.greeting()
