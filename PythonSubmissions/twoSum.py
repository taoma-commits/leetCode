class Solution(object):

    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            for key in dict:
                if key == complement:
                    return [dict[key], i]
            dict[nums[i]] = i

solution = Solution()

print Solution.twoSum(solution, [3,3], 6)
