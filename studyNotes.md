# Part I. Primitive Data Type

## ```int```
* The default value of ```int``` is 0.
  1. initialize ```int[]```, default elements are 0.
  2. can NOT initialize ```int ``` without assign value.

## ```short```

## ```long```

## ```float```

## ```double```

## ```boolean```

## ```char```

* test whether two characters are equal: ```==``` because ```char``` is primitive data type!

* ```int x = (char) A```,
then x is the ASCII code of character A.
* Get ```int``` value of a decimal digit character by ```int y = x -'0'```
This is because the ASCII codes of characters '0', '1', ..., '9' are ten consecutive numbers in ascending order.
* ```char``` type automatically casted into ```int``` when involved in arithmetic operations and indexing.
An important trick: hash letters to ```int[] hash = new int[26]```
by ```char - 'a'```.
* single quotes ```' '``` define characters. Double quotes ```" "``` define strings!


## ```byte```

## ```void```

## Arithmetic operators

## Bitwise operations

# Part II. Non-primitive Data Type

## String

* String is **immutable** in Java.

* double quotes ```""``` define strings. Single quotes ```''``` define characters!
* get the character at index i: ```str.charAt(i)```
* get substring: ```str.substring(start_idx, end_idx)```
* get index of a substring or character:            
  - ```str.indexOf(substr, int fromIndex)```
  - ```str.indexOf(char, int fromIndex)```
  - if such substr or char does not exist, return -1.

* convert a string to array of char's:              ```str.toCharArray()```
* convert an array of char's to a string: ```String str = new String(arr)```

* compare two strings: ```(boolean) str1.equals(str2)```
  **Note that ```String``` is non-primitive so ```==``` doesn't work!**
* split string ```str``` into an array of **strings** (not characters): ```String[] arr = str.split(char)```
  **Note that two successive splitters create an empty string!**
* find prefix: ```(boolean) (str).startsWith(prefix)```

#### String builder

data type: ```StringBuilder```: because String type is immutable, we need StringBuilder to modify a string.

* initialize ```StringBuilder sb = new StringBuilder();```
 - initialize string builder from string: ```StringBuilder sb = new StringBuilder(str);```

* append ```sb.append(char or string)```
* length ```sb.length()```
* insert ``` ```
* replace ```sb.replace(int start, int end, String str)```
* to string ```sb.toString()```


## Array

* Array sorting: ```Arrays.sort(arr, start_idx, end_idx + 1)```

* Array slicing:
```int[] slice = Arrays.copyOfRange(arr, start_idx, end_idx)```
* Array filling: ```Arrays.fill(arr, value)```
* Array sum:
    - ```IntStream.of(arr).sum()```
    - ```Arrays.stream(arr).sum()``` overloaded for ```long``` and ```double``` arrays


### List class
* append element e to the end:
  ```list.add(E e)```
* insert e at index i: ```list.add(int i, E e)```   
*

#### ArrayList class

1.  


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
