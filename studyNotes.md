#### Dynamical programming
two key attributes
1. optimal substructure: optimal solution to its sub-problems -> optimal solution
2. overlapping sub-problems: the space of sub-problems is small, recursive algorithm solves the same sub-problems over and over.

##### Examples
- Fibonacci numbers
- Knapsack 
- Dijkstra's algorithm for shortest path.


#### Divide and conquer
1. optimal substructure
2. non-overlapping sub-problems

##### Examples
- merge sort
- quick sort



### Two Sum (easy)

- python dictionary: distinct keys
- hash-based search: trade off space for speed
  * time complexity: near O(1) unless collision
  * space complexity: O(n)
  * warning:
  ```
  key in dictionary.keys()
  ```
  has time complexity O(n) because ```dictionary.keys()``` is a list.
- one-pass hash table   

### Add Two Numbers (median)

### Longest Mountain (median)

#### Trick: set two variables. Fix one variable and run a while loop on the other.
