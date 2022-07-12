A = int(input())
B = int(input())
C = int(input())
mul = str(A*B*C)
for i in range(10):
    print(mul.count('{}'.format(i)))


# str(list(range(0,10000))).count('8')
