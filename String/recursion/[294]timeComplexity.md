# LeetCode Problem 294 Flip Game II

## Solution

```   
class Solution {
    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }

    public boolean canWin(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                boolean canOppWin = canWin(arr);
                arr[i] = '+';
                arr[i + 1] = '+';
                if (!canOppWin) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

## Proof

For a string to play flip game on, there is an associated decision tree determined by the string.
Stratify the vertices of this tree by their maximum distance from leave in their branches. A leaf is in stratum zero. A vertex whose descendants are all leave is in stratum one and so on.

Label a vertex that is not a leaf by "G" if from there win can be guaranteed if play wisely and label it by "NG" if otherwise. Clearly all vertices in stratum 1 should be labeled as "G".

#### Claim
If no move guarantees to win at one vertex of the decision tree, then every following move of your opponent guarantees win.

Prove the claim by induction.
Consider a vertex in stratum 2 labeled "NG". We claim that all its children are labeled "G". Otherwise, there is a child in stratum 1 of the vertex labeled "NG". A contradiction.

If the claim is true for vertices in strata from 1 to k - 1, then it is true for vertices in stratum k. Suppose not, then a vertex $v$ in stratum k is labeled "NG" and has a child $vc$ in stratum k - 1 labeled "NG". By the induction hypothesis, all the children of $vc$ are labeled "G". As a consequence, move towards $vc$ from $v$ guarantees win. This contradicts the assumption that $v$ is labeled "NG". The end of the proof.

## Time Complexity

Even in the worst case where the root labeled "NG", the algorithm does not cover all the vertices of the decision tree associated to the given string.

We falsely assume the algorithm runs through every vertices to get an upper bound of the time complexity.
The number of '+' in a given string is at most n = the length of the string. 
