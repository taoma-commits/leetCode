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

#### Data structure: linked list
- single-linked list: next
- double-linked list: next and previous

Python doesn't have a predefined data type for linked list. To implement linked lists, one has to create data type like ListNode. For a complete reference see [here](https://stackabuse.com/python-linked-lists/ "Python linked lists").

#### Recursion
exception handling: catch NoneType ListNode.  

### Longest Mountain (median)

#### Trick: set two variables. Fix one variable and run a while loop on the other.
