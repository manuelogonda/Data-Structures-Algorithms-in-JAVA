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
}
