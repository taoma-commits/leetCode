# Algorithms and Data Structures

***
## Sorting Algorithms
***
### Elementary sorting algorithms

* selection sort:
* bubble sort: $O(n^2)$, best-case $O(n)$
* insertion sort: stable, best-case $O(n)$
***

### Merge-sort

> **Proposition.** Merge-sort uses at most $N \lg N$ compares and $6N\lg N$ array
accesses to sort any array of size $N$.

Proof. \[C(N) \leq C(\lfloor N/2\rfloor) + C(\lceil N/2\rceil) + N, C(1) = 0.\]
Roughly $C(N) = 2C(N/2) + N$, $C(1) = 0$. Recursion formula can be written as
\[\begin{aligned}
C(N)/N &= C(N/2)/(N/2) + 1 = C(N/4)/(N/4) + 2 \\
&=\cdots = C(N/2^{\lg N})/ (N/2^{\lg N}) + \lg N \\
&=\lg N.
\end{aligned}\]

#### Bottom-up merge-sort
Non-recursive implementation of merge-sort: pass through array, merging subarrays of size 1. Repeat for subarrays of size 2, 4, 8, 16, ....
***

### Quicksort

Pseudo-code

    - randomly shuffle array;
    - set lo = 0; hi = N;
    - Partition(lo, hi)
        compare arr[lo] with arr[i]
        compare arr[lo] with ar[j]
    - recursion: quicksort(lo, j), quicksort(j, hi)


* Equal keys: stop at keys that are equal to partition key. Avoid worst-case quicksort.

> **Porposition.** The average number of compares $C_N$ to quicksort an array of $N$ **distinct** keys is $\sim 2N\ln N$.

Proof. $C_0 = C_1 = 0$. For $N < 2$,
\[C_N = (N + 1) + \frac{1}{N}\left((C_0 + C_{N-1}) + (C_1 + C_{N - 2}) + \cdots + (C_{N-1} +C_0)\right).\]
The partition keys are at $0$ to $N - 1$. Solve the general term
\[C_N =  2(N+1)\sum_{i = 3}^{N + 1} \sim 2(N + 1)\int_3^{N+1}\frac{1}{x}\,dx \sim 2(N+1)\ln N.\]

* Worst-case: array in ascending or descending order $\sim \frac{1}{2}N^2$.
* Quicksort NOT stable:

#### Quick-select
> **Selection algorithm:** given an array of $N$ items, find the $k$-th largest item.

##### Quick-select pseudo code:

    - random shuffle array;
    - Set lo = 0, hi = N - 1;
    - Partition array: partition index j;
    -   if k > j, lo = j + 1;
        if k < j, hi = j - 1;
        if k == j, return item at j;

> **Proposition.** Quick-select takes linear time on average.

Proof. Rough count of number of compares is
\[N + N/2 + \cdots + 1 \sim 2N. \]

#### 3-way quicksort (duplicate keys)

***
### Bucket sort


***
## Priority Queue
***

### Priority queue API

### Heap
> Heap-ordered binary tree: parent's key no smaller than children's keys
* Height of $N$ nodes heap is $\lfloor \lg N\rfloor$: let $n$ be the height of the tree,
    $$\sum_{i = 0}^{n-1} 2^i = 2^n - 1.$$  
* Array representation
    * the root is ```arr[1]```, not ```arr[1]```.
    * the index of the parent of ```arr[k]``` is ```k / 2```:
      the most-left node of the i-th row has index $2^i$.
    * the indices of the two children of ```arr[k]``` are ```2*k``` and ```2*k + 1```.

### Heapsort
    - start with an array in arbitrary order;
    - make each sub-tree in heap order bottom-up;
    - switch the max with the last key in array representation of the heap;
    - delete the last key from the heap, sink max to retain heap order;
    - repeat until the heap is empty;
* Time complexity of heap sort
    - heap construction: $< 2N$ compares and switches:
      the bottom-up process iterates through keys once.
    - heap sort: $< 2N\lg(N)$ compares and switches.
* Pros: the **only in-place** sorting algorithm with $2N\lg(N)$ worst-case.
        Merge sort is not in-place; quick sort has $N^2$ worst-case.
* Cons:
    - not stable: does not preserve the starting order of equal keys.
                  long-distance exchanges break the stability.
    - long-distance exchanges: poor use of cache while sorting super long array.
    - longer inner loop than quick sort: 2 compares.  

***
## Symbol Table
***
### Binary search tree (BST)
> A *binary search tree* is a binary  tree in symmetric order i.e. every node's key is
> * larger than all keys in its left subtree
> * smaller than all keys in its right subtree  

A node consists of four fields: key, value, pointers to the left and right subtrees.

#### Symbol table implementation
* Search: less go left; greater go right; equal search hit.
* Insert: less go left; greater go right; null insert.
* Get:
* Put:

#### Depth of BST
* Many BSTs correspond to the same set of keys.

> **Proposition**. If $N$ distinct keys are inserted into a BST in random order,
the expected number of compares for a search/insert is $\sim 2\ln N$.

Pf. 1-1 correspondence with quicksort partitioning

***
## Graphs
***

### Digraphs

Implementation: adjacency-lists representation.

| representation | space | insertion | edge query | iterate edges pointing from v | iterate edges pointing to v |
|:-----:|:-:|:-:|:-:|:-:|:-:|
|list of edges|E|1|E|E|E|E|
|adjacency matrix|$V^2$|1|1|V|V|
|adjacency-lists|V+E|E|outdeg(v)|outdeg(v)|V+E|


### DFS and BFS
DFS and BFS are both digraph algorithms.
Both DFS and BFS have methods
* method ```hasPathTo(int v)```: whether v is connected to source vertex.
* method ```pathTo(int v)```: return a path from v to source vertex.

#### DFS

* simple preprocessing code than BFS.
* the path is NOT necessarily a geodesic.
* implementation of ```pathTo(int v)``` replies on ```Stack```.

#### BFS

* the path to source is always shortest.  
* the preprocessing uses ```Queue```.

***
#### Connected components
Use DFS instead of BFS for simpler code.
* Compare DFS implementation with the Union and Find.

##### Application I: program control-flow analysis
* Digraph representation of program:
  - vertex: straight-line program;
  - edge: if statement or loop;
* Dead code elimination: reachability.
* Infinite loop detection: is exit reachable.

##### Application II: garbage collection
* Mark-sweep algorithm: ??
***
#### Topological sort
* DAG: directed acyclic graph.
* Topological sort: can you redraw a DAG so that every arrow points upwards?
* Solution: DFS + postorder stack.
  - push a vertex into stack if it is done.
* Proof of correctness: for an edge $v \rightarrow w$ if we are currently at v
  there are 3 cases as follows.
    - w is done before v.
    - w is not visited therefore will be done before v.
    - w is visited but not returned to. (impossible in DAG)

  So every vertex pointed by an edge from v is done before v is done. Proved.

> Alternate solution to Topological sort: BFS + in-degree
    - Scan all vertices and record their in-degree's in an array.
    - Add all vertices of zero in-degree to a queue.
    - Dequeue vertex v from the queue, decrement the in-degree of all neighbors by 1. Enqueue neighbors whose in-degree became zero after decrement.
    - Repeat last step until queue is empty.

***
#### Kosaraju-Sharir alogrithm for strong connected-components
Two-pass algorithm:

  - reverse the graph to $G^R$;
  - compute topological order in $G^R$ by DFS;
  - run DFS in $G$ follow the topological order obtained in the last step. Each DFS finds a strong component.
##### Proof of correctness
**Lemma.** Let $C$ be a strong component of a digraph $G$, and $v$ be a vertex not in $C$. If there is an edge $e$ from $v$ to a vertex in $C$, then $v$ appears before every vertex in $C$ in the reverse post-order of $G$.

**Proof of Lemma**  Suppose $w\in C$ appears before $v$ in the reverse post-order, then $v$ is done before $w$ in DFS. Because $v$ is not reachable from $w$ (otherwise $v\in C$), $v$ is done before the DFS **visits** $w$. The existence of $e$ implies every vertex in $C$ should be done before $v$ is done which contradicts the assumption that $v$ is done before $w \in C$.

**Proof of correctness** A strong component $C$ of a digraph $G$ is also a strong component of the reverse digraph $G^R$. By the Lemma if there is an edge $e$ from a vertex in $C$ to $v$ in $G$, then $v$ appears before every vertex in $C$ in the reverse post-order of $G^R$.

Let $v$ be the first element in the reverse post-order of $G^R$, then DFS visits every vertex in the strong component $C$ containing $v$ and no other vertices. (Because any reachable vertex from $v$ that is not in $C$ should appear before $v$). Correctness proved.

##### Analysis of the K-S algorithm
* time complexity: $O(V + E)$
* space complexity: save the reverse graph $G^R$; $O(V + E)$.


***
## Strings
***
#### Manacher's algorithm
##### Main problems
Find the number of palindromic substrings or the longest palindromic substring of a given string.
Given string ```S``` of length ```n```, transform ```S``` to string ```T``` of length ```2n + 3``` by separating two consecutive characters by a single ```'#'```
and padding front and end of the result by a ```'^'``` and a ```'$'```.
Define ```P[i]``` as the radius of the largest odd-length palindromic substring centered at index ```i```.

      - Set P[0] = 0 and R = 0 + P[0] the right bound of current palindrome.
      - Current center at c and current right bound R.
            - Set P[i] to the smaller one of the P[i_mirror] and R - i if i < R.
            - Otherwise, P[i] = 0.
            - Central expand P[i].
            - If P[i] + i > R, set center = i and R = P[i] + i.
##### An example
```
S = "abba"
T = "^#a#b#b#a#$"
```
The right bound ```R = i + P[i]```. Before
| index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|:-----:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:--:|
|   T   | ^ | # | a | # | b | # | b | # | a | # | $  |
|   P   | 0 | 0 | 1 | 0 | 1 | 4 | 1 | 0 | 0 | 0 | 0  |


***
#### KMP algorithm
##### Main problem
Searches for occurrences of a "word" ```W``` within a main text string ```S```.
##### Partial-match table
For a string ```W``` of length ```n``` define ```T(i)``` to be the length of the longest possible proper prefix of W which is also a proper suffix of the substring ending at ```W[i - 1]```.

Let ```m``` be the position within ```S``` where the prospective match for ```W``` begins. Let ```i``` be the index of word ```W```.
If the algorithm reaches index ```i``` and finds
a mismatch ```W[i] != S[m + i]```, then restart the matching process by setting  ```m = m + i - T(i)``` and ```i = 0```.
##### An example

| index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
|:-----:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|   W   | A | B | C | D | A | B | D |   |
|   T   | -1| 0 | 0 | 0 | -1| 0 | 2 | 0 |

***
### Trie
A *trie* is used to store strings. Each Trie node represents a string (a prefix). Each node might have several children nodes while the paths to different children nodes represent different characters. And the strings the child nodes represent will be the origin string represented by the node itself plus the character on the path.

The root node is associated with the empty string.

All the descendants of a node have a common prefix of the string associated with that node.
#### Trie representations
* ```array```: the children of a Trie node is an array of Trie nodes.
The size of the array is 26.  
  - fast access but waste space.

* ```HashMap```: the children of a Trie node is a ```HashMap<character, TrieNode>```.
  - slower but space-saving and more flexible.
#### Trie operations
* Insertion

* Search
  - Search prefix

  - Search word: a TrieNode contains a boolean isWord. In insertion process, set the isWord of the last TrieNode to true.

***
## Miscellany
***
### Boyer–Moore majority vote algorithm
