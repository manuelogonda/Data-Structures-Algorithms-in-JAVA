package dev.manu.dsa.ArraysAndStrings;

import java.util.Scanner;

public class StringOperations {
    static void main() {
        System.out.println(MyStringBuilders());
        String[] langs1 = {"Java","GO","Rust","Python","C#","TypeScript","JavaScript"};
        System.out.println("The joined words are " + joinStrings(langs1));
        System.out.println("Is it a palidrome " + checkIfPalindrome("Silent"));
    }
    public static String MyStringBuilders() {
        StringBuilder sb = new StringBuilder();
        String[] langs = {"Java","GO","Rust","Python","C#","TypeScript"};
        for(String lang : langs) {
            sb.append(lang).append(" ");
        }
        String result = sb.toString().trim();
        return result;
    }
    //join words
    public static String joinStrings(String[] words){
        StringBuilder sb= new StringBuilder();
        for(String word : words){
            sb.append(word).append(",");
        }
        return sb.toString();
    }
    //check palindromes
    public static boolean checkIfPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
