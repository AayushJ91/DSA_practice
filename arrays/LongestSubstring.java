//Problem: lenght of longest substring without duplicate
//link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Source: LeetCode (3)
//Topics: Sliding Window
//Diff: Med
//Time:
//space:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstring {
    static int naive(String s) {
        int n = s.length();
        int res = 0, len = 0;
        int start = 0, last = 0;
        ArrayList<Character> ch = new ArrayList<>();
        while (start<=n && last < n){
            if (ch.contains(s.charAt(last))) {
                start++;
                last = start;
                ch.clear();
                len = 0;
            }else {
                ch.add(s.charAt(last));
                last++;
                len++;
            }
            System.out.println(ch);
            System.out.println(len);
            res = Math.max(res, len);
            System.out.println(res);
            System.out.println();
        }
        return res;
    }
    static int optimistic(String s) {
        int n = s.length();
        int res = 0, len = 0;
        int start = 0, last = 0;
        ArrayList<Character> ch = new ArrayList<>();
        while (start <= last && last < n){
            if (ch.contains(s.charAt(last))) {
                ch.removeFirst();
                start++;
                len--;
            }else {
                ch.add(s.charAt(last));
                len++;
                last++;
            }
            System.out.println(ch);
            System.out.println();
            res = Math.max(res, len);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(optimistic(""));
    }
}
