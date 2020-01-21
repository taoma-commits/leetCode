/*
Runtime: 48 ms, faster than 31.95% of Java online submissions for Distribute Candies.
Memory Usage: 52 MB, less than 5.26% of Java online submissions for Distribute Candies.
*/


class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int can : candies) set.add(can);
        return Math.min(set.size(), candies.length / 2);
    }
}




/*
Runtime: 32 ms, faster than 92.86% of Java online submissions for Distribute Candies.
Memory Usage: 52.4 MB, less than 5.26% of Java online submissions for Distribute Candies.
*/

// optimization: stop traversing array once the size of set is larger than the half size of array
class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int can : candies){
            if(set.size() >= candies.length/2)
                return candies.length/2;
            set.add(can);
        }
        return set.size();
    }
}
