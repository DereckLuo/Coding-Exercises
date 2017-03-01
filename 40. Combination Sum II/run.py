##	40. Combination Sum II
 #	Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where 
 #	the candidate numbers sums to T
 #	Each number in C may only be used once in the combination
 #	Note:
 #		All numbers (including target) will be positive integers
 #		The solution set must not contain duplicate combinations
 #	For example, given candidate set [10,2,3,7,6,1,5] and target 8
 #	A solution set is : 
 #	[ [1,7], [1,2,5], [2,6], [1,1,6]]

import math 
import sys
import string 
import copy


class Solution(object):

 #       """
 #       :type candidates: List[int]
 #       :type target: int
 #       :rtype: List[List[int]]
 #       """
	
	ret = []
	dic = {}

	def __init__(self):
		ret = []
		dic = {}

	def combinationSum2(self, candidates, target):
		sub_list = []
		self.sumhelp(candidates, target, sub_list, 0, 0)
		return self.ret


	def sumhelp(self, candidates, target, sub_list, total, idx):
		#print(sub_list)
		length = len(candidates)
		for i in range(idx, length):
			new_total = total + candidates[i]
			if new_total == target:
				# check for duplicates 
				new_list = copy.copy(sub_list)
				new_list.append(candidates[i])
				new_list = sorted(new_list)
				key = ""
				for j in new_list:
					key += str(j)
				if key not in self.dic:
					self.dic[key] = 1
					self.ret.append(new_list)
			elif new_total < target:
				new_list = copy.copy(sub_list)
				new_list.append(candidates[i])
				self.sumhelp(candidates, target, new_list, new_total, i+1)







# main function
if __name__ == "__main__":
	candidates = [10,1,2,7,6,1,5,2,4]
	target = 8
	sol = Solution()
	sol.combinationSum2(candidates, target)
	print(sol.ret)