/*
Runtime: 3 ms, faster than 39.71% of Java online submissions for Intersection of Two Arrays.
Memory Usage: 43 MB, less than 6.75% of Java online submissions for Intersection of Two Arrays.
*/

/*
* Idea: convert arrays to hash sets, then use build-in methdo retainAll().
* Note that given arrays may contain duplicates.
* Time complexity: O(m + n)
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (Integer num : nums1) set1.add(num);
        for (Integer num : nums2) set2.add(num);
        set1.retainAll(set2);
        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
}


/*
* A natural extension: find the intersection if both arrays are sorted.
*/

/*
Runtime: 3 ms
Memory Usage: 45.1 MB
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i, j;
        i = j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] output = new int[set.size()];
        int idx = 0;
        for (int s : set) output[idx++] = s;
        return output;
    }
}
