package dev.manu.dsa.ArraysAndStrings;

import java.util.Arrays;

public class TwoPointerTechnique {
   public static void main(String[] args) {
        int nums[] = {2,3,4,4,4,4,5,5,5,6,6,6,7,8,12,14,20,30,32,35};
        int nums2[] = {2,4,6,7,8,10};
        int target = 164;
//        System.out.println(pairSumTarget(nums, target));
//       System.out.println(countPairsAddToTarget(nums,target));
//       System.out.println(Arrays.toString(reversedArray(nums)));
//       System.out.println(checkArraySorted(nums));
//       System.out.println(checkArraySortedAll(nums2));
//       System.out.println(Arrays.toString(removeValue(nums, target)));
//       System.out.println("The duplicate value is " + findDuplicate(nums));
//       System.out.println(twoSquaresEqualToTarget(nums2, target));
       System.out.println("The smallest positive  missing is " + getSmallestPositiveMissing(nums2));
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

    public static boolean checkArraySortedAll(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if(arr[left] > arr[left + 1] && arr[left] < arr[left + 1]) {
                return false;
            }
            left++;
        }
        return true;
    }

//    5 Sum of Squares Equals Target
    public static boolean twoSquaresEqualToTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int currentSumofSquares = arr[left] * arr[left] + arr[right] * arr[right];
            if(currentSumofSquares == target) {
                return true;
            }else{
                if(currentSumofSquares < target) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return false;
    }

//    6.Minimum Difference Pair
//    public static int minDiffPair(int[] arr) {
//       int left = 0;
//       int right = arr.length - 1;
//       while(left < right) {
//           int currentDiff =  arr[right] - arr[left];
//           if(currentDiff > 0){
//               return new int arr[] {arr[left], arr[right]};
//           }else if(currentDiff < 0){
//               left++;
//           }else{
//               right--;
//           }
//       }
//       return new int arr[] {-1,-1}
//    }

// B. Slow and fast pointer
//    1. Remove Specific Element In-Place
    public static int[]  removeValue(int[] arr,int value) {
       int slow = 0;
       for(int fast = 0; fast < arr.length; fast++){
           if(arr[fast] != value){
               arr[slow] = arr[fast];
               slow++;
           }
       }
        return Arrays.copyOfRange(arr, 0, slow);
    }

//    2. Find Smallest Positive Integer Not in Array

    public static int getSmallestPositiveMissing(int[] arr) {
       int slow = 0;
       for(int fast = 1; fast < arr.length; fast++){
           int missing = 0;
           if(arr[fast] == arr[slow]){
               slow++;
               return arr[slow];
           }else{
               if(arr[slow] > arr[fast]){
                   slow++;
                   missing =  arr[slow];
                   return missing;
               }else{
                   return arr[slow];
               }
           }
       }
       return  -1;
    }
//    3. Find Duplicate in sorted array
        public static int findDuplicate(int[] arr) {
        int i = 0;
           while(i < arr.length) {
               int missingValue = arr[i];
               int correctIndex = missingValue - 1;
               if(missingValue > 0 && missingValue <= arr.length && arr[i] != arr[correctIndex]){
                   int temp = arr[i];
                   arr[i] = arr[correctIndex];
                   arr[correctIndex] = temp;
               }else{
                   i++;
               }
           }

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != j + 1) {
                    return j + 1;
                }
            }
        return arr.length + 1;
        }
}

