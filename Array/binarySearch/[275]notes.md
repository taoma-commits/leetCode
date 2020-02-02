### Notes on Problem 275 H-index II

* Plot the (right) bar chart of reverse-sorted citations against indices. The index at the intersection of diagonal and the part of right side of a bar above the top of next bar is the H-index of the citations.

* H-index always exists and is always unique. Some corner cases.
  1. H-index of [100, 1000, 10000] is 3.
  2. H-index of [0, 0, 0, ... , 0] is 0.

* In the case ```citation[mid] < len - mid ```, set ```low = mid + 1``` to guarantee the convergence ```hi = lo```.

* Set initial ```hi = len``` instead of ```hi = len - 1```. This takes care of case like ```int[] citation = int []{0}```.  
