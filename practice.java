// Problem:

// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You must write an algorithm with O(log n) runtime complexity.



// Solution:

class Search {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) r = m;
            else l = m + 1;
        }
        return nums[l] >= target ? l : l + 1;        
    }
}




// Problem:

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

//Input: height = [4,2,0,3,2,5]
//Output: 9
 

//Constraints:

//n == height.length
//1 <= n <= 2 * 104
//0 <= height[i] <= 105




// Solution 


public int trap(int[] height) {
    int res = 0;
    if(height==null || height.length<=2) return res;
    int lftMax = height[0], rgtMax = height[height.length-1], left = 0, right = height.length-1;
    while(left<right){
        if(height[left]>=lftMax) lftMax = height[left];
        else res += lftMax - height[left];
        if(height[right]>=rgtMax) rgtMax = height[right];
        else res += rgtMax - height[right];
        if(lftMax<rgtMax) left++;
        else right--;
    }
    return res;        
}



// Problem:


// You are playing the Bulls and Cows game with your friend.

// You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

// The number of "bulls", which are digits in the guess that are in the correct position.
// The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
// Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

// The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

 

// Example 1:

// Input: secret = "1807", guess = "7810"
// Output: "1A3B"
// Explanation: Bulls are connected with a '|' and cows are underlined:
// "1807"
//   |
// "7810"
// Example 2:

// Input: secret = "1123", guess = "0111"
// Output: "1A1B"
// Explanation: Bulls are connected with a '|' and cows are underlined:
// "1123"        "1123"
//   |      or     |
// "0111"        "0111"
// Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
 

// Constraints:

// 1 <= secret.length, guess.length <= 1000
// secret.length == guess.length
// secret and guess consist of digits only.



// Solution:


public class Solution {
    public String getHint(String secret, String guess) {
        int s, g, size = secret.length();
        int bulls = 0, cows = 0;
        int [] nums = new int [10];
        for (int i = 0; i < size; i++) {
            s = secret.charAt(i) - '0';
            g = guess.charAt(i) - '0';
            if (s == g)
                bulls ++;
            else{
                if (nums[s] < 0)
                    cows++;
                nums[s]++;
                if (nums[g] > 0)
                    cows++;
                nums[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}



