package dev.manu.dsa.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum {
    static void main() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        NumArr narr = new NumArr(arr);
        System.out.println(narr.rangeSum(2,5));
//        PrefixSum ps = new PrefixSum(arr);
//        System.out.println(ps.rangeSum(2, 5));
//        System.out.println(ps.rangeSum(0, 3));
    }
    private int[] prefix;
    //O(n) constructor
    public PrefixSum(int[] arr) {
        int n = arr.length;
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
    }
    //O(1) query
    public int rangeSum(int low, int high) {
        return prefix[high + 1] + prefix[low];
    }

    //advanced sub-array sum
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefix = 0, result = 0;
        for (int num : nums) {
            prefix += num;
            result += count.getOrDefault(prefix - k, 0);
            count.merge(prefix, 1, Integer::sum);
        }
        return result;
    }

    public static class NumArr {
        private int[] prefix;
        public NumArr(int[] arr) {
            int n = arr.length;
            this.prefix = new int[n + 1];
            for (int i = 0; i < n; i++) {
                this.prefix[i + 1] = prefix[i] + arr[i];
            }
        }
        public int rangeSum(int low, int high) {
            return prefix[high + 1] - prefix[low];
        }
    }
}
