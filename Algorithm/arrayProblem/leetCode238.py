#Input:
nums = [1,2,3,4]
#Output: [24,12,8,6]
out = []
p=1

for i in range(0,len(nums)):
    out.append(p)
    p = p* nums[i]
p = 1

for i in range(len(nums)-1,0-1,-1):
    out[i] = out[i] * p
    p = p * nums[i]

print(out)

