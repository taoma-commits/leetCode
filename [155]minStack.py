# Runtime: 72 ms, faster than 33.40% of Python3 online submissions for Min Stack.
# Memory Usage: 16.2 MB, less than 100.00% of Python3 online submissions for Min Stack.
# @stack
# Note: solution trade off speed for space. In Java, integer underflow. 
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.min = float('inf')
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x - self.min)
        if x < self.min:
            self.min = x

    def pop(self) -> None:
        if not self.stack:
            return
        tmp = self.stack.pop()
        if tmp < 0:
            self.min -= tmp

    def top(self) -> int:
        if not self.stack:
            return
        tmp = self.stack[-1]
        if tmp < 0:
            return self.min
        else:
            return self.min + tmp

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
