'''
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
'''
n = int(input())
arr=[]
for i in range(n):
    arr.append(input())

for i in range(len(arr)):
    count = 1
    score = 0
    for j in range(len(arr[i])):
        if arr[i][j] == "O":
            score += count
            count += 1
        else:
            count = 1
    print(score)

