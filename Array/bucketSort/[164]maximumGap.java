class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        if (min == max) {
            return 0;
        }

        int n = nums.length;
        int w = (int) Math.ceil((double)(max - min) / (n - 1)); // note 1
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        for (int num : nums) {
            int idx = (num - min) / w;
            bucketMin[idx] = Math.min(num, bucketMin[idx]);
            bucketMax[idx] = Math.max(num, bucketMax[idx]);
        }

        int last = min;
        int maxGap = 0;
        for (int i = 0; i < n; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(bucketMin[i] - last, maxGap);
            last = bucketMax[i];
        }
        return maxGap;
    }
}

/*
* performance: 4 ms < 75%, 44.8 MB < 5%.
* notes:
        1. the width of bucket w must be <= possible maximum gap. In particular, (max - min + 1) / (n - 1) does NOT work
          because if n = 2 then average width is rounded up by 1!
        2. b
* companies: Amazon
*/
