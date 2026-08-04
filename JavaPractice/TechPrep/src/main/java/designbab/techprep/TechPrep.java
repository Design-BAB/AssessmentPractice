package designbab.techprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class TechPrep {
    
    public boolean isAnagram(String firstWord, String secondWord) {
        HashMap<Character, Integer> myMap1 = new HashMap();
        HashMap<Character, Integer> myMap2 = new HashMap();
        if (firstWord.length() != secondWord.length()) return false;
        for (int i = 0; i < firstWord.length(); i++) {
            if (myMap1.containsKey(firstWord.charAt(i))) {
                int newVal = myMap1.get(firstWord.charAt(i));
                newVal++;
                myMap1.put(firstWord.charAt(i), newVal);
            } else {
                myMap1.put(firstWord.charAt(i), 1);
            }
        }
        for (int i = 0; i < secondWord.length(); i++) {
            if (myMap2.containsKey(secondWord.charAt(i))) {
                int newVal = myMap2.get(secondWord.charAt(i));
                newVal++;
                myMap2.put(secondWord.charAt(i), newVal);
            } else {
                myMap2.put(secondWord.charAt(i), 1);
            }
        }
        return myMap1.equals(myMap2);
    }
    
    public String twoSum(int[] nums, int target) {
      ArrayList<Integer> result = new ArrayList();
      int begin = 0;
      int end = nums.length - 1;
      while (begin < end) {
          var sumTest = nums[begin] + nums[end];
          if (sumTest == target) {
              result.add(begin + 1);
              result.add(end + 1);
              return result.toString();
          } else if (sumTest > target) {
              end = end - 1;
          } else if (sumTest < target) {
              begin++;
          }
      }
      return result.toString();
    }
    
    public boolean isValid(String input) {
        if (input.length() % 2 != 0) return false;
        Stack<Character> myStack = new Stack();
        for (int i = 0; i < input.length(); i++) {
            myStack.push(input.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            var testChar = myStack.pop();
            if (testChar == ')') {
                if (input.charAt(i) != '(') return false;
            }
            if (testChar == '}') {
                if (input.charAt(i) != '{') return false;
            }
            if (testChar == ']') {
                if (input.charAt(i) != '[') return false;
            }
        }
        return myStack.isEmpty();
    }
    
    public int search(int[] nums, int target){
        int begin = 0;
        int end = nums.length;
        int mid = end / 2;
        while (begin < end) {
            mid = begin + end;
            mid = mid / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            }
        }
        return -1;
    }
    
    void main() {
        System.out.println(isAnagram("anagram", "nagaram")); // expected: true
        System.out.println(isAnagram("rat", "car"));         // expected: false
        System.out.println(isAnagram("listen", "silent"));   // expected: true
        
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9)); // expected: [1, 2]
        System.out.println(twoSum(new int[]{2, 3, 4}, 6));      // expected: [1, 3]
        System.out.println(twoSum(new int[]{-1, 0}, -1));       // expected: [1, 2
        
        System.out.println(isValid("()"));     // expected: true
        System.out.println(isValid("(]"));     // expected: false
        System.out.println(isValid("([)]"));   // expected: false
        System.out.println(isValid("(((((())))))"));
        
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9)); // expected: 4
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2)); // expected: -1
        System.out.println(search(new int[]{5}, 5));                  // expected: 0
        System.out.println("Hello World!");
    }
    
}
