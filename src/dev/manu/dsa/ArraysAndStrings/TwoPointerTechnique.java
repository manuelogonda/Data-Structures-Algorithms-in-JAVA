package dev.manu.dsa.ArraysAndStrings;

import java.util.Arrays;

public class TwoPointerTechnique {
   public static void main(String[] args) {
        int nums[] = {2,3,4,5,6,7,8,12,14,20,30,32,35};
        int target = 12;
//        System.out.println(pairSumTarget(nums, target));
//       System.out.println(countPairsAddToTarget(nums,target));
//       System.out.println(Arrays.toString(reversedArray(nums)));
       System.out.println(checkArraySorted(nums));
   }
//   Two Pointers
//    A. Left and Right pointers moving towards each other
//    1 Checks whether an array sorted has a pair that add to the target
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

//    2. Counts how many pairs are available that add to the target
    public static int countPairsAddToTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int pairs = 0;
        while(left < right){
            int CurrentCount = arr[left] + arr[right];
            if(CurrentCount == target){
                pairs++;
                left++;
                right--;
            }else {
                if(CurrentCount < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return pairs;
    }
//    3. Reverse an array without creating another
    public static int[] reversedArray(int[] arr){
        int left = 0;
        int right = arr.length -1 ;
        while(left < right){
               int temp = arr[left];
               arr[left] = arr[right];
               arr[right] = temp;

               right--;
               left++;
        }
        return arr;
    }
//    4. Check If Array Is Sorted
    public static boolean checkArraySorted(int[] arr) {
       int left = 0;
       int right = arr.length - 1;
       while(left < right) {
           if(arr[left] > arr[left + 1]) {
               return false;
           }
           left++;
       }
       return true;
    }


}
