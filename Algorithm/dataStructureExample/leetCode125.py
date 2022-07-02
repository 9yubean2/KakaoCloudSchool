# import re
#
#
# def isPalindrome(self, s:str)->bool:
#     s = s.lower()
#     #정규식으로 불필요한 문자 필터링
#     s = re.sub('[^a-z0-9]','',s)
#
#     return s == s[::-1] #역순으로 슬라이싱
#
# isPalindrome("A man, a plan, a canal: Panama")
import re

s= input()
s = s.lower()
#정규식으로 불필요한 문자 필터링
s = re.sub('[^a-z0-9]','',s)

print (s == s[::-1]) #역순으로 슬라이싱
