#### Dynamical programming
Two key attributes
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

#### XOR logic operation
exclusive or = addition modulo 2

#### Bitwise operators
- bitwise OR |
- bitwise AND &
- bitwise XOR ^
- bitwise Complement ~

##### Examples
```
a = 5 = 0101
b = 7 = 0111
a | b = 0111 = 7
a & b = 0101 = 5
a ^ b = 0010 = 2
~ a = 1010 = 10
```
##### Bitwise XOR properties
* ```a ^ 0 = 0```
* ```a ^ a = 0```
* Commutativity ```a ^ b = b ^ a ```
* Associativity ```(a ^ b) ^ c = a ^ (b ^ c)```

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
