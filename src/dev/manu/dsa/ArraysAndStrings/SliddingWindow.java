package dev.manu.dsa.ArraysAndStrings;

public class SliddingWindow {
    static void main() {
        int arr[] = {10,20,30,40,50};
        int target = 60;
        System.out.println(maxSubArray(arr,target));
    }
    public static int maxSubArray(int[] arr,int target) {
        int n = arr.length - 1;
        if(n < target) return - 1;
        int windowSum = 0;

        for(int i = 0; i< target; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;

        for(int right = target; right< n; right++){
            windowSum += arr[right] - arr[right - target];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
