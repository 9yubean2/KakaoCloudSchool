nums = [2,7,11,15]
target = 9
# for i in range(len(nums)):
#     for j in range(i+1,len(nums)):
#         if nums[i] + nums[j] == target:
#             print([i,j])

nums_map = {}
for i,num in enumerate(nums):
    nums_map[num] = i

for i,num in enumerate(nums):
    if target - num in nums_map and i != nums_map[target-num]:
        print([i, nums_map[target-num]])


'''
0 2
1 7
2 11
3 15
'''

