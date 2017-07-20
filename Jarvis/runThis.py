## July 7, 2017
## Chongxin Luo
## Main program execution file

import speech_recognition as sr
import pyttsx3
import Jarvis

# initialize jarvis voice
r = sr.Recognizer()
# engine = pyttsx3.init()
# engine.setProperty('rate', 150)
# voices = engine.getProperty('voices')
# engine.setProperty('voice', voices[1].id)

J = Jarvis.Jarvis()

# waiting for queue loop
while True:
    print("waiting loop starts ")
    with sr.Microphone() as source:
        audio = r.listen(source)
        print(r.recognize_google(audio))
        if r.recognize_google(audio) == "hey Jarvis":
            J.speechRec()
