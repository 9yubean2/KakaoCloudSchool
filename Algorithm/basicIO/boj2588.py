#a, b = map(int, input().split('\\n'))
import sys

# data = [int(sys.stdin.readline()) for i in range(2)]
# results = 0
# for i in range(3):
#     a = int(str(data[0]))
#     b = int(str(data[1])[-1-i])
#     tmp = str(a*b)
#     print(tmp)
#     if i == 0:
#         result = int(tmp)
#     elif i == 1:
#         result = int(f'{tmp:0<5}')
#     else:
#         result = int(f'{tmp:0<6}')
#     results += result
# print(results)
a = int(input())
b = int(input())
n3 = a * ((b%100)%10)
n4 = a * ((b%100)//10)
n5 = a * ((b//100))
n6 = n3 + n4*10 + n5*100
print(n3,n4,n5,n6,sep="\n")