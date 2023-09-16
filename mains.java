// Given two strings ransomNote and magazine, return true if ransomNote 
// can be constructed by using the letters from magazine and false otherwise.
// Each letter in magazine can only be used once in ransomNote.

import java.util.*;
public class mains{
    public static void main(String[] args){
        
        String ran = "abcc";
        String mag = "abccd";
        // String s1 = "abc";
        // String s2 = "ad";
        System.out.println(check(mag,ran));
    }
    public static boolean check(String s1 , String s2){
        HashMap<Character , Integer> ans = new HashMap<>();

        for(char c : s1.toCharArray()){
            ans.put(c , ans.getOrDefault(c, 0) + 1);
        }
        for(char c : s2.toCharArray()){
            if(!ans.containsKey(c) || ans.get(c) == 0){
                return false;
            }
            ans.put(c , ans.get(c) - 1);
        }
        return true;
    }
}