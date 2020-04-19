class Solution {
  public String getHint(String secret, String guess) {
    int a = 0;
    int b = 0;
    int[] mapS = new int[10];
    int[] mapG = new int[10];
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        a++;
      } else {
        mapS[secret.charAt(i) - '0']++;
        mapG[guess.charAt(i) - '0']++;
      }
    }
    for (int i = 0; i < 10; i++) {
      b += Math.min(mapS[i], mapG[i]);
    }
    return a + "A" + b + "B";
  }
}

/**
 * performance: 6 ms < 74%, 39 MB < 5.55%
 * time complexity: O(n)
 * space complexity: O(n)
 */
