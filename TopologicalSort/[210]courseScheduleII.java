class Solution {
  boolean[] marked;
  boolean[] activated;
  List<List<Integer>> adj = new ArrayList<>();
  Deque<Integer> stack = new ArrayDeque<>();

  private boolean dfs(int v) {
    activated[v] = true;
    for (int w : adj.get(v)) {
      if (activated[w]) {
        return false;
      }
      if (!marked[w]) {
        if (!dfs(w)) {
          return false;
        }
      }
    }
    activated[v] = false;
    marked[v] = true;
    stack.push(v);
    return true;
  }
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    marked = new boolean[numCourses];
    activated = new boolean[numCourses];
    int[] res = new int[numCourses];
    for (int v = 0; v < numCourses; v++) {
      adj.add(new ArrayList<Integer>());
    }
    for (int[] E : prerequisites) {
      adj.get(E[1]).add(E[0]);
    }

    for (int v = 0; v < numCourses; v++) {
      if (!marked[v]) {
        if (!dfs(v)) {
          return new int[0];
        }
      }
    }
    int i = 0;
    while (!stack.isEmpty()) {
      res[i++] = stack.pop();
    }
    return res;
  }
}

/**
 * performance: 4 ms < 98%, 41 MB < 94%
 * notes: topolgal sort.
 * to-do: BFS + indegree  
 * time complexity: O(V + E)
 * space complexity: O(3V + E)
 */
