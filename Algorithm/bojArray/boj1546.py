n = int(input())
arr = list(map(int,input().split()))
M = max(arr)

for i in range(len(arr)):
    arr[i] = arr[i]/M*100

sum = 0
for score in arr:
    sum += score
print(sum/n)
