class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        rev = 0
        while x != 0:
            if x<0:
                pop = -x % 10
                if rev < - (2 ** 31 / 10) or (rev == - (2 ** 31 / 10) and pop > 8):
                    return 0
                rev = rev * 10 - pop
                x = - (- x / 10)
            else:
                pop = x % 10
                if rev > 2 ** 31 / 10 or (rev == 2 ** 31 / 10 and pop > 7):
                    return 0
                rev = rev * 10 + pop
                x /= 10
        return rev


solution = Solution()
print solution.reverse(-1463847412)
