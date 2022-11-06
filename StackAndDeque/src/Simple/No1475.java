package Simple;

import java.util.ArrayDeque;
import java.util.Deque;

public class No1475 {

}
class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        ans[len-1] = prices[len-1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = len-1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() > prices[i]) {
                deque.pop();
            }
            ans[i] = deque.isEmpty() ? prices[i] : prices[i] - deque.peek();
            deque.push(prices[i]);
        }
        return ans;
    }
}