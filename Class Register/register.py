import xml.etree.ElementTree as ET
import urllib.request
import requests
import os
from twilio.rest import TwilioRestClient
import time
import xmltodict

def check_open():
#	test = 'http://courses.illinois.edu/cisapp/explorer/schedule/2017/spring/CS/446.xml?mode=detail'
#	testold = urllib.request.urlopen(test)
#	r = requests.get(test)
#	xml = r.text
#	print(xml)
#	try:
#		root = ET.fromstring(xml)
#	except ET.PArseError:
#		print("Class doesn't exist :(")
#	
#	print("~~~~~~~~~~~~~~~~~~~~~~~~~~")
#	
#	avail = root.find('detailedSections').text
#	print(avail)
#
#	#print("avaiable is : ", avail)
#	for child in root:
#		print(child.tag, child.attrib)
	url = 'https://courses.illinois.edu/schedule/2017/spring/CS/446'
	test = '<root>' + urllib.request.urlopen(url).read() + '</root>'
	tree = ET.fromstring(test)
	for child in tree:
		print(child.tag, child.attrib)
	

if __name__ == "__main__":
	account_sid = "AC1c064a57e5bce07dffd39737eb4abd84"
	auth_token = "ab516005ad8bb7eace0f406d5eae50a0"
	twilio_number = "+12247231121"
	phone_number = "+18472746771"

	machineLearning = 'https://courses.illinois.edu/schedule/2017/spring/CS/446'
	parallelProgramming = 'https://courses.illinois.edu/schedule/2017/spring/CS/484'
	distributedSystem = 'https://courses.illinois.edu/schedule/2017/spring/CS/425'
	
	client = TwilioRestClient(account_sid, auth_token)

	#ML_old = urllib.request.urlopen(machineLearning)
	#PP_old = urllib.request.urlopen(parallelProgramming)
	#DS_old = urllib.request.urlopen(distributedSystem)
	check_open()

	#mins = 0

	

	#client.messages.create(from_= twilio_number, to=phone_number, body='Hello from Twilio!')

	#print(testold.read())
	#ret = ML_old.read()
	#print(ret)
	
#	while True:
#		print(">>>>>>>>>>>>>>>>>>>>>>>>>>>", mins)
#		time.sleep(60)
#		mins += 1
#
#		print(ML_old)
#		ML_old = urllib.request.urlopen(machineLearning)

#		if mins == 1:
#			ML_new = urllib.request.urlopen(machineLearning)
#			PP_new = urllib.request.urlopen(parallelProgramming)
#			DS_new = urllib.request.urlopen(distributedSystem)
#
#			mins = 0
#			if ML_old != ML_new:
#				client.messages.create(from_= twilio_number, to=phone_number, body='Machine Learning updates : https://courses.illinois.edu/schedule/2017/spring/CS/446')
#			if PP_new != PP_old:
#				client.messages.create(from_=twilio_number, to=phone_number, body='Parallel Programing updates : https://courses.illinois.edu/schedule/2017/spring/CS/484')	
#			if DS_old != DS_new:
#				client.messages.create(from_=twilio_number, to=phone_number, body='Distributed System updates : https://courses.illinois.edu/schedule/2017/spring/CS/425')
#
#			ML_old = ML_new
#			PP_old = PP_new
#			DS_old = DS_new	
#

