# from gtts import gTTS
# import os
#
# Text = "Good morning, how can I help you?"
# tts = gTTS(text = Text, lang= 'en')
# tts.save("good.mp3")
# # os.system('start good.mp3')
# os.startfile()

import pyttsx3
engine = pyttsx3.init()
engine.setProperty('rate', 150)
voices = engine.getProperty('voices')
engine.setProperty('voice', voices[1].id)
engine.say('Good Morning, what can I do for you?')
engine.runAndWait()


