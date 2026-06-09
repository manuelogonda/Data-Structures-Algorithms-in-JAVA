package dev.manu.dsa.ArraysAndStrings;

import java.util.Arrays;

public class TwoPointerTechnique {
   public static void main(String[] args) {
        int nums[] = {2,3,4,4,4,4,5,5,5,6,6,6,7,8,12,14,20,30,32,35};
        int nums2[] = {2,4,6,7,8,10};
        int target = 164;
       char[] s = {'h','e','l','l','o'};
       int nums3[] = {0, 1, 0,2,0, 3,5,0,10, 12};
//       System.out.println(Arrays.toString(twoSum(nums2,6)));
//       System.out.println(Arrays.toString(removeDuplicates(nums)));
//       System.out.println(Arrays.toString(moveZeroesEnd(nums3)));
//       System.out.println(reverseString(s));
//       System.out.println(reverseStringBuilder("manu"));
//       System.out.println(reverseTwoPointer("Emmanuel"));
       System.out.println(isPalidrome("silent"));

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


//    Section 3: Worked Examples
//    1. Two Sum — Sorted Array problem: Given a 1-indexed sorted array and a target, return the indices of two numbers that sum to the target.
     public static int[] twoSum(int[] arr, int target) {
       int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int currSum = arr[left] + arr[right];
            if(currSum == target) return new int[] {left+1, right+1};
            else if(currSum < target) left++;
            else right--;
        }
        return new int[] {-1, -1};
     }
//    Complexity Analysis:  Time: O(n)  |  Space: O(1)

//    2: Remove Duplicates from Sorted Array problem : Modify a sorted array in-place to remove duplicates. Return the count of unique elements.
    public static int[] removeDuplicates(int[] nums) {
       int slow = 0;
       for(int fast = 1; fast < nums.length; fast++){
           if(nums[slow] != nums[fast]) {
               slow++;
               nums[slow] = nums[fast];
           }
       }
       return nums;
    }
//    3: Move Zeroes to End Problem: Move all zeroes to the end of the array while maintaining the relative order of non-zero elements.
    public static int[] moveZeroesEnd(int[] arr) {
       int slow = 0;
       for(int fast = 0; fast < arr.length; fast++){
           if(arr[fast] != 0){
               arr[slow] =  arr[fast];
               slow++;
           }
       }
        while (slow < arr.length) {
            arr[slow] = 0;
            slow++;
        }
       return arr;
    }

//    4: Reverse a char array
    public static char[] reverseString(char[] arr) {
       int left = 0;
       int right = arr.length - 1;
       while(left < right){
           char temp = arr[left];
           arr[left] = arr[right];
           arr[right] = temp;
           left++;
           right--;
       }
       return arr;
    }

    public static String reverseStringBuilder(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }

//    Reverse a String, convert to char array then use two pointer to convert
    public static String reverseTwoPointer(String s) {
       char[] arr = s.toCharArray();
       int left = 0;
       int right = arr.length - 1;

       while(left < right){
           char temp = arr[left];;
           arr[left] = arr[right];
           arr[right] = temp;
           left++;
           right--;
       }
       return new String(arr);
    }

//    5: Valid Palindrome, Check if a string is a palindrome, considering only alphanumeric characters and ignoring case.
    public static boolean isPalidrome(String s) {
       int left = 0;
       int right = s.length() - 1;
       while (left < right){
           while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
           while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
           if (Character.toLowerCase(s.charAt(left)) !=
                   Character.toLowerCase(s.charAt(right))) return false;
           left++;
           right--;
       }
       return true;
    }

}

