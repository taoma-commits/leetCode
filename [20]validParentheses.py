# Runtime: 24 ms, faster than 94.61% of Python3 online submissions for Valid Parentheses.
# Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Valid Parentheses.


class Solution:
    def isValid(self, s: str) -> bool:
        map = {')':'(', ']':'[', '}':'{'}
        stack = [];
        for char in s:
            if char in map:
                top = stack.pop() if stack else '#'
                if top != map[char]:
                    return False
            else:
                stack.append(char)
        return not stack
