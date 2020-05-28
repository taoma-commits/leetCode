***
# I. Sorting Algorithms
***
## I.1 Compare-based Sorting Algorithms

In a *compare-based sorting algorithm*, one can access information only through compares. 

* Model of computation: decision tree
* Cost modle: the number of compares

> **Proposition.** Any compare-based sorting algorithm must use at least $\lg (N!) \sim N\lg(N)$ compares in the worst-case.

Proof. The height of decision tree is the worst-case number of compares. :coffee:

***
### Elementary sorting algorithms

* bubble sort: iterate through array. Compare two successive items and swap if not in order. Repeat until no swap in the last run. 
    * stable 
    * worst-case $O(n^2)$ 
    * best-case $O(n)$
* selection sort: iterate through array. At each index find the min in the rest items and swap. 
    * not stable
    * $O(n^2)$
* insertion sort: in iteration i, swap a[i] with each larger entry to its left (sink down).
    * stable 
    * best-case $O(n)$
    * worst-case $O(n^2)$
* shell sort: h-sort the array (insertion sort with stride h). 
    * not stable
    * complexity: unknown 
    
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
:coffee: 

### Bottom-up merge-sort
Non-recursive implementation of merge-sort: pass through array, merging subarrays of size 1. Repeat for subarrays of size 2, 4, 8, 16, ....

***
### Quicksort

**Pseudo-code**

    - randomly shuffle array;
    - set lo = 0; hi = N;
    - scan i from left to right so long as a[i] < a[lo];
    - scan j from right to left so long as a[j] > a[lo];
    - exchange a[i] with a[j];
    - repeat until i and j cross. Swap a[lo] and a[j];
    - recursion: quicksort(lo, j), quicksort(j, hi)


* Equal keys: both pointers stop at keys that are equal to partition key.
   * Costs more exchanges.
   * If the pointers do not stop at keys equal to partitioning item, then in the worst case in which all keys are equal, the first     pointer would run through the entire array and the partition is out-of-balance. 
   * Instead, the partition is in the middle if the algorithm stop at equal keys in the worst case. 

* Worst-case: array in ascending or descending order. Every partition is out-of-balance. Time complexity $\sim \frac{1}{2}N^2$.
* Quicksort NOT stable.

> **Porposition.** The average number of compares $C_N$ to quicksort an array of $N$ **distinct** keys is $\sim 2N\ln N$.

Proof. $C_0 = C_1 = 0$. For $N < 2$,
\[C_N = (N + 1) + \frac{1}{N}\left((C_0 + C_{N-1}) + (C_1 + C_{N - 2}) + \cdots + (C_{N-1} +C_0)\right).\]
The partition keys are at $0$ to $N - 1$. Solve the general term
\[C_N =  2(N+1)\sum_{i = 3}^{N + 1} \sim 2(N + 1)\int_3^{N+1}\frac{1}{x}\,dx \sim 2(N+1)\ln N.\] :coffee:

### Quick-select

> **Selection algorithm** given an array of $N$ items, find the $k$-th largest item. 

**Pseudo-code**

    - Random shuffle array;
    - Set lo = 0, hi = N - 1;
    - Partition array: partition index j;
    -   if k > j, lo = j + 1;
        if k < j, hi = j - 1;
        if k == j, return item at j;
    - Repeat in one subarray depending on j.
    

> **Proposition.** Quick-select takes linear time on average.

Proof. Rough count of number of compares is
\[N + N/2 + \cdots + 1 \sim 2N. \]

### Dijkstra 3-way quicksort 

**Pseudo-code**

    - Random  shuffle array;
    - Set lo = lt = 0, hi = N;
    - Scan i from left to right
         if a[i] < a[lo], swap a[lt] with a[i]; increment both lt and i;
         if a[i] > a[lo], swap a[gt] with a[i]; decrement gt;
         if a[i] == a[lo], increment i;
    - Stop if i > gt;
    
    
***
## I.2 Non-comparision Sorting Algorithms
*** 
### Bucket sort

***
### Counting sort

***
# II. Priority Queue
***

## II.1 Priority queue API

***
## II.2 Heap
> Heap-ordered binary tree: parent's key **no smaller than** children's keys.
* Heap allows duplicates.
* Height of $N$ nodes heap is $\lfloor \lg N\rfloor$: let $n$ be the height of the tree,
    $$\sum_{i = 0}^{n-1} 2^i = 2^n - 1.$$  
* Array representation
    * the root is ```arr[1]```, not ```arr[0]```.
    * the index of the parent of ```arr[k]``` is ```k / 2```:
      the most-left node of the i-th row has index $2^i$.
    * the indices of the two children of ```arr[k]``` are ```2*k``` and ```2*k + 1```.
    
***
## II.3 Heapsort

1. start with an array in arbitrary order;
2. sink-based heap construction: make each sub-tree in heap order bottom-up;
3. switch the max with the last key in array representation of the heap; 
4. delete the last key from the heap, sink max to retain heap order; 
5. repeat until the heap is empty.
    
**Computational analysis** 

> **Proposition.** Sink-based heap construction uses less than $2N$ compares and less than $N$ exchanges.

Proof. Ror each node at height k, charge k links for sinking down. Arrange the charge of links so that
each link is charged at most once. There are $N - 1$ links therefore the number of exchanges is less than $N$. 
Refer to [proof](https://algs4.cs.princeton.edu/24pq/). :coffee:

1. first pass: sink-based heap construction. $O(n)$.
2. second pass: heap sort $O(2N\lg(N))$.
    
**Pros**

Heapsort is the **only in-place** sorting algorithm with $2N\lg(N)$ worst-case. 
Merge sort is not in-place; quick sort has $N^2$ worst-case.

**Cons**
- not stable: does not preserve the starting order of equal keys.
               long-distance exchanges break the stability.
- long-distance exchanges: poor use of cache while sorting super long array.
- longer inner loop than quick sort: 2 compares.  

***
# III. Symbol Table
***
## III.1 Symbol table API 

* search: get and contains
* insert: put 
* delete: delete

If keys are comparable, can do binary search and other orderd operations.

**Odered operations**

* min/max
* floor/ceiling
* rank
* select
* ordered iteration 
* size

**Binary search implementation**

Maintain an ordered array of key-value pairs. 
The problem with binary search implementation is that the insertion cost is $O(n)$. 
To insert, need to shift all greater keys over.

***
## III.2 Binary search tree (BST)
> A *binary search tree* is a binary tree in symmetric order i.e. every node's key is
> * larger than all keys in its left subtree
> * smaller than all keys in its right subtree 

A node consists of four fields: key, value, pointers to the left and right subtrees.

> **Proposition**. If $N$ distinct keys are inserted into a BST in random order,
the expected number of compares for a search/insert is $\sim 2\ln N$.

Pf. 1-1 correspondence with quicksort partitioning

### Symbol table implementation

* Search: less go left; greater go right; equal search hit.
 * Insert: less go left; greater go right; null insert.


### Ordered operations


### Hibbard deletion

***
## III.3 Balanced search trees 

### 2-3 search trees

### red-black BSTs

***
## III 4. Tree traversal

### DFS of binary tree

* Pre-order (NLR): topological sorted.
* In-order (LNR): ascending order.
* Reverse in-order (RNL): descending order.
* post-order (LRN)

### BFS of binary tree
* level order 
***

# IV. Graphs
***
## IV.1 Digraphs

Implementation: adjacency-lists representation.

| representation | space | insertion | edge query | iterate edges pointing from v | iterate edges pointing to v |
|:-----:|:-:|:-:|:-:|:-:|:-:|
|list of edges|E|1|E|E|E|E|
|adjacency matrix|$V^2$|1|1|V|V|
|adjacency-lists|V+E|E|outdeg(v)|outdeg(v)|V+E|

***
## IV.2 DFS and BFS
DFS and BFS are both digraph algorithms.
Both DFS and BFS have methods
* method ```hasPathTo(int v)```: whether v is connected to source vertex.
* method ```pathTo(int v)```: return a path from v to source vertex.

### DFS

* simple preprocessing code than BFS.
* the path is NOT necessarily a geodesic.
* implementation of ```pathTo(int v)``` replies on ```Stack```.

### BFS

* the path to source is always shortest.  
* the preprocessing uses ```Queue```.

***
## IV.3 Connectivity

### Dynamic connectivity: Union-Find data structure

* Quick-find:
* Quick-union:
* Weighted QU:
* Weighted QU with path compression:

|algs\cost|init|union|find|
|:-------:|:--:|:---:|:--:|
|Quick-find| N | N | 1|
|Quick-union| N| (worst) N | (worst) N|
|Weighted QU| N | lg(N) | lg(N) |


### Static connectivity
Use DFS instead of BFS for simpler code.
* Compare DFS implementation with the Union and Find.

#### Application I: program control-flow analysis
* Digraph representation of program:
  - vertex: straight-line program;
  - edge: if statement or loop;
* Dead code elimination: reachability.
* Infinite loop detection: is exit reachable.

#### Application II: garbage collection
* Mark-sweep algorithm: ??
***
### Topological sort
* DAG: directed acyclic graph.
* Topological sort: can you redraw a DAG so that every arrow points upwards?
* Solution: DFS + postorder stack.
  - push a vertex into stack if it is done.
* Proof of correctness: for an edge $v \rightarrow w$ if we are currently at v
  there are 3 cases as follows.
    - w is done before v.
    - w is not visited therefore will be done before v.
    - w is visited but not returned to. (impossible in DAG)

  So every vertex pointed by an edge from v is done before v is done. :coffee:

> Alternate solution to Topological sort: BFS + in-degree
    - Scan all vertices and record their in-degree's in an array.
    - Add all vertices of zero in-degree to a queue.
    - Dequeue vertex v from the queue, decrement the in-degree of all neighbors by 1. Enqueue neighbors whose in-degree became zero after decrement.
    - Repeat last step until queue is empty.

***
### Kosaraju-Sharir alogrithm for strong connected-components
Two-pass algorithm:

  - reverse the graph to $G^R$;
  - compute topological order in $G^R$ by DFS;
  - run DFS in $G$ follow the topological order obtained in the last step. Each DFS finds a strong component.
  
**Proof of correctness**

**Lemma.** Let $C$ be a strong component of a digraph $G$, and $v$ be a vertex not in $C$. If there is an edge $e$ from $v$ to a vertex in $C$, then $v$ appears before every vertex in $C$ in the reverse post-order of $G$.

**Proof of Lemma**  Suppose $w\in C$ appears before $v$ in the reverse post-order, then $v$ is done before $w$ in DFS. Because $v$ is not reachable from $w$ (otherwise $v\in C$), $v$ is done before the DFS **visits** $w$. The existence of $e$ implies every vertex in $C$ should be done before $v$ is done which contradicts the assumption that $v$ is done before $w \in C$. :coffee:

**Proof of correctness** A strong component $C$ of a digraph $G$ is also a strong component of the reverse digraph $G^R$. By the Lemma if there is an edge $e$ from a vertex in $C$ to $v$ in $G$, then $v$ appears before every vertex in $C$ in the reverse post-order of $G^R$.

Let $v$ be the first element in the reverse post-order of $G^R$, then DFS visits every vertex in the strong component $C$ containing $v$ and no other vertices. (Because any reachable vertex from $v$ that is not in $C$ should appear before $v$). :coffee:

#### Computational analysis
* time complexity: $O(V + E)$
* space complexity: save the reverse graph $G^R$; $O(V + E)$.

***
## IV.4 Minimum spanning trees
* Tree: connected and acyclic graph
* Spanning tree: given a connected graph $G$, a spanning tree is a subgraph $S$ of $G$ so that $S$ is a tree and includes all vertices of $G$.
  - the number of edges in $S$ is $V - 1$: suppose the tree has more than $V - 1$ edges. Choose a vertex that is the end point of exactly one edge. Cut the vertex with the edge. Repeat until no such vertex to cut. The graph left by prune can not be a point by assumption. It must contains a cycle. 
  
* MST: given a connected, weighted graph $G$, the minimum spanning tree $S$ of $G$ is the spanning tree whose weight sum is minimum. $S$ is unique if edge weights are distinct.

* Note: MST only depends on the **relative order of edge weights**, not on the exact values of weights. 

> **Proposition.** In a tree, $E = V - 1$.

Proof. $E > V - 2$. Starting from a vertex walk through all edges. A edge not visited is incident to at most one vertex not visited. If $E < V - 1$, can not get to all vertices.

$E < V$. Prune the tree until every vertex is incident to more than one edge. The pruned tree is a single vertex. Otherwise, it contains a cycle. :coffee:

* Cut: a partition of vertices into two nonempty sets.
* Crossing edge: an edge connects a vertex from one set to a vertex in the other.
* Cut property: given any cut, the minimum crossing edge is in MST.

### Greedy MST algorithm

1. all edges grey at the beginning;
2. find a cut contains no black edge; color minimum crossing edge black;
3. repeat step 2 until V - 1 edges are black.

### Kruskal's algorithm

1. sort edges in ascending order of weight;
2. add edge to tree unless create a cycle;
3. stop when V - 1 edges are added.

**Visualization.** Take small edges and they coallesce together in little clusters and eventually the edges get longer and longer and they connect together the clusters. 

**Implementation.**
* cycle detection: Union-find data structure.
* sort edges (dynamic): Priority queue. 

**Computational analysis.**

* Worst-case: $O(E\log(E))$:
   * heapsort: $E\log(E)$;
   * union: amortized $V\log(V)$;
   * check connectedness: amortized $E\log(V)$.

### Prim's algorithm

1. start with vertex 0 and add the smallest edge incident to 0;
2. add to T the smallest edge with **exactly one endpoint** in MST;
3. repeat until V - 1 edges. 

**Visualization.** Usually, the new edge is close to the last edge added. But every once in a while, it gets stuck and jumps to a new place to add edges to the MST.

**Lazy implementation of Prim's algorithm.**

1. Maintain a PQ of edges with at least one endpoint in T. The priority keys are weights of edges. 
2. Pop min edge e = v-w:
   - continue pop if both v and w are marked;
   - if w is unmarked:
      * add to PQ any edge incident to w and the other vertex not in T; 
      * add edge e to T and mark w. 
3. Repeat until PQ is empty.
   
**Eager implementation of Prim's algorithm.** 

1. Maintain a PQ of vertices connected by an edge to T. The priority key of a vertex is **the weight of shortest edge** connecting the vertex to T. 
2. Pop min v. Add the associated edge e = v-w to T;
3. Update PQ by considering all edges e = v-x incident to v:
   - continue if x in T;
   - add x to PQ if not in T;
   - decrease priority of x if v-x shorter than previous priority of x.
4. Repeat until PQ is empty.

* Indexed PQ implementation... 

**Computational analysis.**
|implementation|time complexity|space complexity|good for|
|:--:|:-------------:|:---:|:---:|
|Lazy| $O(E\log(E))$ | $O(E)$ | sparse graph |
|Eager(binary heap PQ)| $O(E\log(V))$ | $O(V)$ |sparse graph $E\sim V$ | 
|Eager(array PQ)| $O(V^2)$ | $O(v)$ |dense graph $E >> V$|

### Context
* Euclidean MST: Delaunay triangulation.
* Single-link clustering: Kruskal's algorithm.

***
## IV 5. Shortest path 



***
# V. Strings
***
### Manacher's algorithm
#### Main problems
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
#### An example
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
### KMP algorithm
#### Main problem
Searches for occurrences of a "word" ```W``` within a main text string ```S```.
#### Partial-match table
For a string ```W``` of length ```n``` define ```T(i)``` to be the length of the longest possible proper prefix of W which is also a proper suffix of the substring ending at ```W[i - 1]```.

Let ```m``` be the position within ```S``` where the prospective match for ```W``` begins. Let ```i``` be the index of word ```W```.
If the algorithm reaches index ```i``` and finds
a mismatch ```W[i] != S[m + i]```, then restart the matching process by setting  ```m = m + i - T(i)``` and ```i = 0```.
#### An example

| index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
|:-----:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|   W   | A | B | C | D | A | B | D |   |
|   T   | -1| 0 | 0 | 0 | -1| 0 | 2 | 0 |

***
## Trie
A *trie* is used to store strings. Each Trie node represents a string (a prefix). Each node might have several children nodes while the paths to different children nodes represent different characters. And the strings the child nodes represent will be the origin string represented by the node itself plus the character on the path.

The root node is associated with the empty string.

All the descendants of a node have a common prefix of the string associated with that node.
### Trie representations
* ```array```: the children of a Trie node is an array of Trie nodes.
The size of the array is 26.  
  - fast access but waste space.

* ```HashMap```: the children of a Trie node is a ```HashMap<character, TrieNode>```.
  - slower but space-saving and more flexible.
### Trie operations
* Insertion

* Search
  - Search prefix

  - Search word: a TrieNode contains a boolean isWord. In insertion process, set the isWord of the last TrieNode to true.

***
## Deterministic finite automaton (DFA)



***
# Miscellany
***
## Boyer–Moore majority vote algorithm

***
## Math

### Fast exponentiation

### Bit manipulation
* ```x & (x - 1)```
* ```x & -x```

***
## Floyd's algorithm
Use fast and slow pointers to detect cycle.
***

