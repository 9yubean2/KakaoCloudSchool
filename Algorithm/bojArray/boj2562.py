arr = []
for i in range(9):
    arr.append(int(input()))

print(max(arr))
for i in range(len(arr)):
    if arr[i] == max(arr):
        print(i+1)
