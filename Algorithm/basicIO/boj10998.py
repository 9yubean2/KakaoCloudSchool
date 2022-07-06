# a,b = input().split()
# result = int(a)*int(b)
# print(result)

# 사칙연산 boj 10869
a,b = input().split()
results = []
results.append(int(a)+int(b))
results.append(int(a)-int(b))
results.append(int(a)*int(b))
results.append('{0:.0f}'.format(int(a)//int(b))) #몫연산은 //이거로 하기
results.append(int(a)%int(b))
for result in results:
    print(result)
