from yelp.client import Client
from yelp.oauth1_authenticator import Oauth1Authenticator 



import string
def get_search_parameters():
	params = {
		'term': 'bar',
		'limit': 20,
		'radius_filter': 500,
	}
	return params
	
def get_results(address,params):
	auth = Oauth1Authenticator(
	    consumer_key="lEHzmjqmy6cjXJoiILlTDg",
	    consumer_secret="FBKZnlKGfje4UHH4bxbxxFvfgm0",
	    token="eFHphgjM9_a681JvNvIR6JKU7_Qam7EU",
	    token_secret="2OF0XLzLcXWy0IWNeH3E3S-3tps"
	)
	
	client = Client(auth)

	response = client.search(str(address), **params)

	for business in response.businesses:
		print(business.name, business.phone)

	
        

                
if __name__ == "__main__":

	address = input("Enter your address: ")
	params = get_search_parameters()
	results =get_results(address,params)
