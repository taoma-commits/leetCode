##### 4/4/20
* what is the difference between backtracking and DFS?

[In this stackoverflow thread](https://stackoverflow.com/questions/1294720/whats-the-difference-between-backtracking-and-depth-first-search)
Backtracking is a more general purpose algorithm. Depth-First search is a specific form of backtracking related to searching tree structures. From Wikipedia:
>One starts at the root (selecting some node as the root in the graph case) and explores as far as possible along each branch before backtracking.

It uses backtracking as part of its means of working with a tree, but is limited to a tree structure.
Backtracking, though, can be used on any type of structure where portions of the domain can be eliminated - whether or not it is a logical tree.

Example of Backtracking algorithm: Eight queens puzzle.  

##### 4/6/20

* Quadratic algorithm does not scale with technology.

Scale with technology: the increase of computational power and memory of computer are proportional. The rough model of growth is after certain amount of time, computers become 10x faster and have 10x much memory. An algorithm scales with technology if the running time of a 10x larger problem in a 10x faster computer is the same as current one. A quadratic algorithm doesn't scale with technology.

* Compare Union & Find with DFS implementation of connected components

##### 4/8/20
* Manacher's algorithm

##### 4/9/20
* KMP algorithm

##### 4/10/20
* Backtracking and stack  

##### 4/23/20
* The Sieve of Eratosthenes

Time complexity of counting primes less than n by the sieve of Eratosthenes: n * log(log(n))

##### 4/27/20
[In stackoverflow thread:](https://stackoverflow.com/questions/769963/javas-l-number-long-specification)

>There are specific suffixes for long (e.g. 39832L), float (e.g. 2.4f) and double (e.g. -7.832d).
If there is no suffix, and it is an integral type (e.g. 5623), it is assumed to be an int. If it is not an integral type (e.g. 3.14159), it is assumed to be a double.
In all other cases (byte, short, char), you need the cast as there is no specific suffix.

* Floyd's algorithm 
