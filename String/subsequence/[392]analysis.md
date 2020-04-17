# Analysis of Algorithms for Problem 392

* $S =$ the length of input string s
* $T =$ the length of input string t
## Time complexity of two solutions

* Solution 1: $O(S + T)$
* Solution 2: $O(T + S\lg(r))$ where $r =$ the length of the longest index list i.e. the largest number of duplicates of a letter in t.
  - $r \leq T$: the worst case time complexity is $O(T + S\lg(T))$.

## Amortized analysis
Suppose there are $n$ input string $s_1,\cdots, s_n$ and $S$ is the length of the longest among them. Assume that $T >> S$.
* Solution 1: $n(S + T)= nS(1 + T/S)$     
* Solution 2: $T + n S\lg(T) = nS(T/(nS) + lg(T))$

Conclusion: if $T >> S$, solution 2 is superior.
