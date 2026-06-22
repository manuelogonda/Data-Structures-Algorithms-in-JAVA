package dev.manu.dsa;

import java.util.*;


public class StacksAndQueues {
    static void main() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        int top = stack.peek();
        int removed = stack.pop();
        boolean empty = stack.isEmpty();

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(10);
        int front = queue.poll();

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(5);
        deque.addLast(20);
        deque.removeFirst();
        deque.removeLast();

// By default, Java initializes a Min-Heap (smallest numbers come out first)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(40);
        minHeap.offer(10);
        minHeap.offer(30);

        System.out.println(minHeap.poll());
    }
//    A. Stacks
//    1. Balanced Brackets
public static boolean isBalanced(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    // Map closing brackets to their matching open complements
    Map<Character, Character> mapping = new HashMap<>();
    mapping.put(')', '(');
    mapping.put('}', '{');
    mapping.put(']', '[');

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        // If it's an opening bracket, push it onto our stack
        if (ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
        }
        // If it's a closing bracket
        else if (mapping.containsKey(ch)) {
            if (stack.isEmpty() || stack.peek() != mapping.get(ch)) {
                return false;
            }
            stack.pop();
        }
    }
    return stack.isEmpty();
}

//monotonic stack
public static int[] nextGreater(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
        // While stack is not empty and current value is greater than our top-indexed value
        while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
            int targetIdx = stack.pop(); // Found the next greater element for this index
            result[targetIdx] = arr[i];
        }
        stack.push(i);
    }
    return result;
}


    class MinStack {
        private Deque<Integer> mainStack;
        private Deque<Integer> minStack;

        public MinStack() {
            mainStack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            mainStack.push(val);

            // The new min is either the current value or the old min from the top of the minStack
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            mainStack.pop();
            minStack.pop(); // Pop both synchronously to keep history perfectly aligned
        }

        public int top() {
            return mainStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices of the days

        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current temperature is warmer
            // than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // The number of days to wait
            }
            stack.push(i);
        }

        return result;
    }

}
