#	335. Self Crossing:
#	You are given an array x of n positive numbers, You start at point (0,0) and moves x[0] metres to the north,
#	then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other
#	words, after each move your direction changes counter-clockwise.
#	Write a one-pass algorithm with O(1) extra space to determine, if your path cross itself, or not 

import sys
import copy
import string


class Solution(object):
    def isSelfCrossing(self, x):
    #    """
    #    :type x: List[int]
    #    :rtype: bool
    #    """
    	length = len(x)
    	if length < 4:
    		return False

    	check = True
    	if x[2] < x[0] and x[3] < x[1]:
    		print("~~~~~going inner ~~~~~~~")
    		if length == 4:
    			return False
    		check = True
    	elif x[2] > x[0] and x[3] > x[1]:
    		print("~~~~~ going outer ~~~~~~")
    		if length == 4:
    			return False
    		check = False
    	else:
    		return True

    	if check == True:	# case going inner 
    		min_x = min(x[1], x[3])
    		min_y = min(x[0], x[2])
    		for i in range(4,length):
    			if i % 2 == 0:	# even idx 
    				if x[i] >= min_y:
    					return True
    				min_y = x[i]
    			else:
    				if x[i] >= min_x:
    					return True
    				min_x = x[i]

    	else:	# case going outer
    		max_x = max(x[1], x[3])
    		max_y = max(x[0], x[2])
    		for i in range(4, length):
    			if i % 2 == 0:	# even idx 
    				if x[i] <= max_y:
    					return True
    				max_y = x[i]
    			else:
    				if x[i] <= max_x:
    					return True
    				max_x = x[i]
    	return False

        

if  __name__ == "__main__":
	x = [1,2,3,4]
	sol = Solution()

	if(sol.isSelfCrossing(x)):
		print("True, self crossing")
	else:
		print("False, not self crossing")