//Problem: Sub Array sum equals k
//link: https://leetcode.com/problems/subarray-sum-equals-k/
//Source: LeetCode-560
//Topics:
//Diff: Med
//Time:
//space:

import java.util.HashMap;

class SubArraySum {
    static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        HashMap<Integer, Integer> idx = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            idx.put(i, sum);
        }
        int total = idx.get(n - 1);
        if (total == k) {
            res++;
        }
        int diff, end = n - 1, fro = 0;
        while (fro < n && end >= 0){
            diff = idx.get(end) - idx.get(fro);
            if (diff == k) {
                res++;
                fro++;
            } else if (diff > k) {
                fro++;
            }else {
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,-1,1};
        System.out.println(subarraySum(nums, 3));
    }
}
