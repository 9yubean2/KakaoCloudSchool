arr = []
score = [0,0,0,0]

for i in range(5):
    tmp=0
    score = list(map(int,input().split()))

    for j in range(len(score)):
        tmp += int(score[j])
    arr.append(tmp)

for i in range(5):
    if arr[i] == max(arr):
        print("{} {}".format(i+1,arr[i]))
