package dev.manu.dsa.ArraysAndStrings;

import java.util.Arrays;

public class TwoPointerTechnique {
   public static void main(String[] args) {
        int nums[] = {2,4,5,6,7,8,12,20,30,32,35};
        int target = 6;
        System.out.println(pairSumTarget(nums, target));
   }

    public static boolean pairSumTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
        int currentSum = arr[left] + arr[right];
            if (currentSum == target) return true;
            if (currentSum < target) left++;
            else right--;
        }
        return false;
    }
}
