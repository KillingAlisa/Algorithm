package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class No739 {
    public static void main(String[] args) {
        Solution test = new Solution();
        test.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            while (!deque.isEmpty() && temperature > temperatures[deque.peek()]) {
                int prevIndex = deque.pop();
                ans[prevIndex] = i - prevIndex;
            }
            deque.push(i);
        }
        return ans;
    }
}