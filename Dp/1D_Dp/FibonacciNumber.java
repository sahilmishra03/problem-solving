class Solution1 {
    public int fib(int n) {
        // Memoization
        int[] ls = new int[n + 1];

        return func(n,ls);
    }

    public int func(int n,int[] ls) {
        if (n <= 1) {
            return n;
        }

        if (ls[n] != 0) {
            return ls[n];
        }
        
        int ans = func(n - 1,ls) + func(n - 2,ls);
        ls[n] = ans;
        return ans;
    }
}

class Solution {
    public int fib(int n) {
        // Tabulation
        if(n<=1){
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}