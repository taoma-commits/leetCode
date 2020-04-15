class Solution {
  private boolean[] visited;
  private boolean[] marked;
  private List<List<Integer>> adj = new ArrayList<>();

  private boolean dfs(int v) {
    visited[v] = true;
    for (int w : adj.get(v)) {
      if (visited[w]) {
        return false;
      }
      if (!marked[w]) {
        if (!dfs(w)) {
          return false;
        }
      }
    }
    visited[v] = false;
    marked[v] = true;
    return true;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    visited = new boolean[numCourses];
    marked = new boolean[numCourses];
    for (int v = 0; v < numCourses; v++) {
      adj.add(new ArrayList<Integer>());
    }
    for (int[] E : prerequisites) {
      adj.get(E[1]).add(E[0]);
    }
    for (int v = 0; v < numCourses; v++) {
      if (!marked[v]) {
        if (!dfs(v)) {
          return false;
        }
      }
    }
    return true;
  }
}

/**
 * performance: 3 ms < 99%, 40 MB < 90%
 * notes: Topological sort, BFS on ADG.
 * to-do: BFS and indegree 
 * time complexity: O(V + E)
 * space complexity: O(2V + E)
 */
