/*
This is essentially finding shortest path on graph.
All the solutions are variations of Dijkstra's algorithm.
In the first solution, each time the end is met, all the
neighbors of previous nodes are visited. 
*/

class Solution {
  public int jump(int[] nums) {
    int steps = 0;
    int max = 0;
    int maxNext = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      maxNext = Math.max(nums[i] + i, maxNext);
      if (i == max) {
        steps++;
        max = maxNext;
      }
    }
    return steps;
  }
}

/*
* performance: 2 ms < 95%
* time complexity: O(n)
* space complexity: O(1)
* notes:
      1. greedy algorithm finds the global optimum: from one widest step to the next one includes
        all other possibilities.
      2. i < nums.length - 1 avoids comparison end = Math.max(reach, nums.length - 1) and the algorithm
        returns steps not steps - 1. As a consequence, the algorithm is 1 ms faster.
*/

class Solution {
    public int jump(int[] nums) {
        int curr = nums.length - 1;
        int steps = 0;
        while (curr > 0) {
            for (int j = 0; j < curr; j++) {
                if (nums[j] + j >= curr) {
                    curr = j;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}

/*
* performance: 128 ms, 35 MB.
* notes:
      1. same idea, algorithm runs backwards.
      2. time complexity: O(n^2), worst secenario [1, 1, 1, 1, 1].
*/

class Solution {
  public int jump(int[] nums) {
    int n = nums.length;
    int[] distTo = new int[n];
    Arrays.fill(distTo, n);
    distTo[0] = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
        distTo[j] = Math.min(distTo[i] + 1, distTo[j]);
      }
    }
    return distTo[n - 1];
  }
}

/* performance: 530 ms 
* notes: topological sort algorithm for shortest paths on DAGs. 
*/
