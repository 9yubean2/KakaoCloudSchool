# Input:
nums = [1,4,3,2]

sum = 0
result = []
nums.sort()

for n in nums:
    result.append(n)
    if len(result) == 2:
        #print(result)
        sum += min(result)
        result = []
print(sum)
# Output: 4