name = 'Dia'
age = 25
s = 'Name is %s %d years old' #%용법은 사용하지 않는다.(오래된 문법)
print(s%(name,age)) #Name is Dia 25 years old
print('Name is {} {} years old'.format(name,age))
print('Name is {0} {1} years old'.format(name,age))
print('Name is {} {} years old'.format('9yubean',age)) #Name is 9yubean 25 years old
print('Name is {name_} {age_} years old'.format(name_='!!!',age_=11)) #Name is !!! 11 years old

print("###########f print#########")
print(f'My name is {name}')      #My name is Dia
print(f'My name is {name:4}')    #My name is Dia
print(f'My name is {name:<15}')  #My name is Dia
print(f'My name is {name:>15}')  #My name is             Dia
print(f'My name is {name:^15}')  #My name is       Dia
print(f'My name is {name:!^15}') #My name is !!!!!!Dia!!!!!!
print(f'My name is {name:0<15}') #My name is Dia000000000000
print(f'My name is {name:#>15}') #My name is ############Dia

print('{0:.3f}'.format(2.1)) #2.100 소수점 3자리에 맞춰서 출력
