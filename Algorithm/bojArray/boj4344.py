T = int(input())
arr = []
for _ in range(T):
    arr.append(list(map(int,input().split())))
for i in range(len(arr)):
    sum,aver,count = 0,0,0
    n = arr[i][0]
    for j in range(n):
        sum += arr[i][j+1]
    aver = sum/n
    for k in range(n):
        if arr[i][k+1] > aver:
            count += 1
    print('{0:.3f}%'.format(count/n*100))
