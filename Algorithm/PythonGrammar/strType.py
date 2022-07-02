s = 'kakao Cloud School Dia'
print(s)
print(type(s))
print(s[3:10]) #:=~로 생각
#s[start:stop:step]
print(s[::-1]) #역순
print('kakao Cloud School \'Dia\'') #kakao Cloud School 'Dia'
print(s.lower())
print(s.upper())
print(s.find('Cloud')) #6
print(s.index('Cloud'))#6
print(s.find('CEO'))#-1
#print(s.index('CEO'))#Error
print(s.count('o')) #4

#문제) 0~10000까지 8의 개수 세기
print("###############")
print(str(list(range(0,10000))).count('8')) #4000

print("###############")
print('   .!!  hello world!     '.strip(' .!')) #hello world

print("###############")
print('   .!!  hello world!     '.replace(' ','').replace('.','').replace('!','')) #helloworld

print(s.split(' ')) #['kakao', 'Cloud', 'School', 'Dia']
print('!'.join(['kakao', 'Cloud', 'School', 'Dia'])) #kakao!Cloud!School!Dia
print(s.isalnum()) #False
print('123'.isalnum()) #True
print(s.isalpha()) #True
print('123'.isalpha()) #False
print(s.isascii()) #True
print('123'.isascii()) #True

print("###############")
ruleTable = str.maketrans('ol','01')
print(s.translate(ruleTable)) #kaka0 C10ud Sch001 Dia

