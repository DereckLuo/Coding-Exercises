import xml.etree.ElementTree as ET
import requests
from time import sleep
from twilio.rest import TwilioRestClient
import datetime
import os
from pytz import timezone

#course = {'department': 'ECE', 'number': 448, 'crn': 36055}
course = {'department': 'CS', 'number': 412, 'crn': 63462}

def sendText(message):
    account_sid = "AC1c064a57e5bce07dffd39737eb4abd84"
    auth_token = "ab516005ad8bb7eace0f406d5eae50a0"
    twilio_number = "+12247231121"
    phone_number = "+18472746771"

    client = TwilioRestClient(account_sid, auth_token)

    client.messages.create(from_= twilio_number, to=phone_number, body= str(message))


def check_open():
    url = 'http://courses.illinois.edu/cisapp/explorer/schedule/2017/spring/{}/{}/{}.xml'.format(course['department'], course['number'], course['crn'])
    r = requests.get(url)
    xml = r.text

    # For testing with localXML #
    # with open('test.xml', 'r') as xml:
    #     xml = xml.read()

    try:
        root = ET.fromstring(xml)
    except ET.ParseError:
        print ("Class doesn't exist :(")
        return
    avail = root.find('enrollmentStatus').text
    if avail == "Closed" or avail == "UNKNOWN":
        return 0
    else:
        return 1

if __name__ == '__main__':
    open('log.txt', 'w').close()
    course_open = 0
    f = open('log.txt', 'r+')
    logtext = ''
    while 1:
        print ('RUNNNING')
        prelog = datetime.datetime.now(timezone('US/Central')).strftime("%m/%d %I:%M:%S %p: ")
        if check_open():
            if course_open == 0:
                logtext = "{}Opened\n".format(prelog)
                sendText("Your class is opened!")
                #sendEmail("Your class has opened.")
                #sleep(5)
                #sendEmail(str(course['crn']))
                course_open = 1
        else:
            logtext = "{}Closed\n".format(prelog)
            if course_open == 1:
                sendText("Your class has closed!")
                #sendEmail("Your class has closed")
            course_open = 0
        f.write(logtext)
        f.flush()
        os.fsync(f.fileno())
        sleep(300)
    f.close()
